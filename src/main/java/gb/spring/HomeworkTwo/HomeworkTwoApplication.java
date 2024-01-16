package gb.spring.HomeworkTwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class HomeworkTwoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HomeworkTwoApplication.class, args);
	}
	@Bean
	UniversityRepository studentRepository() {
		return new UniversityRepository();
	}

}
