package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javafx.collections.ListChangeListener.Change;
import login.AuthInfo;
import login.WrongPasswordException;
import member.ChangePasswordService;
import member.ChangePwdCommand;
import validator.ChangePwdCommandValidator;
/*
 * 비밀번호 변경 클래스 
 * 
 */

@Controller
@RequestMapping("/member/change")
public class ChangePwdController {

	private ChangePasswordService changePasswordService;

	public void setChangePwdController(ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}

	@GetMapping
	public String form() {
		return "member/changepwdform";
	}

	@PostMapping
	public String submit(@ModelAttribute("pwdcommand") ChangePwdCommand pwd, Errors errors, HttpSession session) {
		// 검증 절차(비밀번호 확인) 걸치고, 서비스 클래스 이용해서 비밀번호 변경
		new ChangePwdCommandValidator().validate(pwd, errors);
		if (errors.hasErrors()) {
			return "member/changepwdform";
		}
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authinfo");
		try {
			changePasswordService.changepassword(authInfo.getEmail(), pwd.getOldpassword(), pwd.getNewpassword());
			return "member/changepwd";
		} catch (WrongPasswordException e) {
			// TODO: handle exception
			errors.rejectValue("newpassword", "notmatching");
			return "member/changepwdform";
		}

	}

}
