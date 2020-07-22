package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.HelloController;
import controller.RegisterController;

@Configuration
public class ControllerConfig {
	
	@Bean
	public HelloController helloController() {
		return new HelloController();
	}
	
	@Bean
	public RegisterController registerController() {
		return new RegisterController();
	}

}
