package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.ChangePwdController;
import controller.LoginController;
import controller.RegisterController;
import controller.WriteBoardController;
import edit.BoardWriteService;
import login.AuthService;
import member.ChangePasswordService;
import member.ChangePwdCommand;
import member.MemberRegiService;

@Configuration
public class ControllerConfig {
	
	@Autowired
	private MemberRegiService memberRegiService;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@Autowired
	private BoardWriteService boardWriteService;
	

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
		WriteBoardController ct = new WriteBoardController();
		ct.setBoardWriteService(boardWriteService);
		return ct;
	}
	
	@Bean
	public ChangePwdController changePwdController() {
		ChangePwdController ct= new ChangePwdController();
		ct.setChangePwdController(changePasswordService);
		return ct;
	}
	
	
	
	

}
