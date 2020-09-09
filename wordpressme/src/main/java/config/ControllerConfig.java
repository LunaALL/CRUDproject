package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.ChangePwdController;
import controller.DeleteMemController;
import controller.LoginController;
import controller.MainBoardController;
import controller.RegisterController;
import controller.WriteBoardController;
import edit.BoardDAO;
import edit.BoardDelupdateService;
import edit.BoardWriteService;
import edit.ReplyService;
import login.AuthService;
import member.ChangePasswordService;
import member.DeleteMemService;
import member.MemberDAO;
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
	
	@Autowired
	private BoardDelupdateService boardDelupdateService;
	
	@Autowired
	private DeleteMemService deleteMemService;
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private ReplyService replyService;
	

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
	
	@Bean
	public MainBoardController mainBoardController() {
		MainBoardController main = new MainBoardController();
		main.setBoardDelupdateService(boardDelupdateService);
		main.setBoardDAO(boardDAO);
		main.setMemberDAO(memberDAO);
		main.setReplyService(replyService);
		return main;
	}
	
	@Bean
	public DeleteMemController deleteMemController() {
		DeleteMemController del = new DeleteMemController();
		del.setDeleteMemService(deleteMemService);
		return del;
		
	}
	
	
	
	

}
