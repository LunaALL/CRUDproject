package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.MemberAdminService;

@Controller
@RequestMapping("/Admin")
public class AdminController {

	private MemberAdminService memberAdminService;

	public void setMemberAdminService(MemberAdminService memberAdminService) {
		this.memberAdminService = memberAdminService;
	}

}
