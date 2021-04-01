package exam.questions.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import exam.questions.utils.ClientCache;

@SpringBootApplication(scanBasePackages= {"exam.questions"})
public class AppStarter {
	
	public static void main(String[] args) {
		
		SpringApplication.run(AppStarter.class);
	}
	
	public ClientCache clientCache()
	{
		return new ClientCache();
	}

}
