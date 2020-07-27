package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.LoginController;
import controller.RegisterController;
import controller.WriteBoardController;
import login.AuthService;
import member.MemberRegiService;

@Configuration
public class ControllerConfig {
	
	@Autowired
	private MemberRegiService memberRegiService;
	
	@Autowired
	private AuthService authService;
	

	@Bean
	public RegisterController registerController() {
		RegisterController ct = new RegisterController();
		ct.setMemberRegiService(memberRegiService);
		return ct;
	}
	
	@Bean
	public LoginController loginController() {
		LoginController ct = new LoginController();
		ct.setAuthService(authService);
		return ct;
	}
	
	@Bean
	public WriteBoardController writeBoardController() {
		return new WriteBoardController();
	}
	
	

}
