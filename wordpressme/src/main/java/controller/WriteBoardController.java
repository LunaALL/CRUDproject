package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import edit.BoardWriteCommand;
import edit.BoardWriteService;
import login.AuthInfo;
import validator.WriteBoardValidator;

@Controller
@RequestMapping("/write")
public class WriteBoardController {
	
	private BoardWriteService boardWriteService;
	
	
	public void setBoardWriteService(BoardWriteService boardWriteService) {
		this.boardWriteService = boardWriteService;
	}
	
	

	@GetMapping()
	public String writeboard(HttpSession session) {
	AuthInfo info=(AuthInfo)session.getAttribute("authinfo");
	if(info==null) {
		return "member/loginform";
	}
		return "edit/noticeboard";
	}
	
	@PostMapping()
	public String postwriteboard(@ModelAttribute("writecommand") BoardWriteCommand board
		,HttpSession session, Errors errors) {
	AuthInfo info=(AuthInfo)session.getAttribute("authinfo");
	new WriteBoardValidator().validate(board, errors);
	
		board.setUserID(info.getName());
		
		
		String head=board.getBdTitle();
		String body=board.getBdContent();
		head=filterStr(head);
		body=filterStr(body);
		/*head.replaceAll(" ","&nbsp;" ).replaceAll("\\<", "&lt;").replaceAll(">", "&gt");
		body.replaceAll(" ","&nbsp;" ).replaceAll("\\<", "&lt;").replaceAll(">", "&gt;").replaceAll("\r\n", "<br>");*/
		board.setBdTitle(head);
		board.setBdContent(body);
		
		boardWriteService.commit(board);
	
		return "redirect:/edit/main";
	}
	
	public String filterStr(String str){
	    if(str.indexOf("<script>")!=-1){
	      str = str.replaceAll("<script>", "");
	    }
	    if(str.indexOf("</script>")!=-1){
	      str = str.replaceAll("</script>", "");
	    }
	    if(str.indexOf("<javascript>")!=-1){
	      str = str.replaceAll("<javascript>", "");
	    }
	    if(str.indexOf("</javascript>")!=-1){
	      str = str.replaceAll("</javascript>", "");
	    }
	    if(str.indexOf("<vbscript>")!=-1){
	      str = str.replaceAll("<vbscript>", "");
	    }
	    if(str.indexOf("</vbscript>")!=-1){
	      str = str.replaceAll("</vbscript>", "");
	    }
	    return str;
	  }

	
	
	

}
