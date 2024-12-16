package springboot.security.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springboot.security.example.helper.AuditorAwareImpl;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SpringbootSecurityExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurityExampleApplication.class, args);
	}


	@Bean
	public AuditorAware<String> auditorAware(){
		return new AuditorAwareImpl();
	}


}
