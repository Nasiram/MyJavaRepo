package exam.questions.controller;

import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exam.questions.utils.ClientCache;
import exam.questions.utils.Questions;

@RestController
public class ExamController {

	Random random = new Random();
	@Autowired
	ClientCache clientCache;

	/**
	 * @param response
	 * @param client
	 * @return
	 */
	@GetMapping("/requestQuestion")
	public String getQuestion(HttpServletResponse response, @CookieValue(defaultValue = "NEW") String client) {
		clientCache.getClientMap().remove(client);
		System.out.println("removed client"+client);
		int randomInteger[] = new int[3];
		String clientId = String.valueOf(random.nextInt(100000));
		Cookie cookie = new Cookie("client", clientId);
		response.addCookie(cookie);
		for (int i = 0; i < 3; i++) {

			randomInteger[i] = random.nextInt(100);
		}
		clientCache.getClientMap().put(clientId, new Questions(randomInteger));
		return "Please sum the numbers "+randomInteger[0] + "," + randomInteger[1] + "," + randomInteger[2];
	}
	
	@GetMapping("/answerToQuestion")
	public ResponseEntity answerToQuestion(@CookieValue(defaultValue = "NEW") String client,@RequestParam String answer)
	{
		Questions questions = clientCache.getClientMap().get(client);
		if(questions!=null && questions.getSum()==Integer.parseInt(answer))
		{
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

}
