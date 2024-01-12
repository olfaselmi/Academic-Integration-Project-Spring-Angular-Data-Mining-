package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2
@EnableWebMvc
@EnableScheduling
@SpringBootApplication
@EnableSwagger2
public class PidevApplication {
	public static void main(String[] args) {
		SpringApplication.run(PidevApplication.class, args);
	}

}
