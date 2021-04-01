package exam.questions.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import exam.questions.starter.AppStarter;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = AppStarter.class)
public class ExamControllerTest {
	@LocalServerPort
	int localPort;
	RestTemplate restTemplate = new RestTemplate();

	/**
	 * expecting a string with 3 random numbers
	 */
	@Test
	public void getQuestionTest() {
		String result = restTemplate.getForObject("http://localhost:" + localPort + "/requestQuestion", String.class);
		boolean contains = result.contains("Please sum the numbers");
		System.out.println(result);
		assertEquals(contains, true);
	}

	/**
	 * expecting 400 status
	 */
	@Test(expected = HttpClientErrorException.class)
	public void sendAnswers() {
		ResponseEntity<String> entity = restTemplate
				.getForEntity("http://localhost:" + localPort + "/answerToQuestion?answer=0", String.class);
	}

}