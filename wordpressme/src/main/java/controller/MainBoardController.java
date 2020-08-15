package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.cj.Session;

import edit.Board;
import edit.BoardDAO;
import edit.BoardDelupdateCommand;
import edit.BoardDelupdateService;
import login.AuthInfo;

@Controller
public class MainBoardController {
	
	private BoardDAO boardDAO;
	
	private BoardDelupdateService boardDelupdateService;
	
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	public void setBoardDelupdateService(BoardDelupdateService boardDelupdateService) {
		this.boardDelupdateService = boardDelupdateService;
	}
	
	
	

	@GetMapping("/edit/main")
	public String mainBoard(
			@RequestParam(value="pagenum", required =false, defaultValue = "1") int pagenum,
			Model model,HttpSession session) {
		AuthInfo info=(AuthInfo)session.getAttribute("authinfo");
		if(info==null) {
			return "member/loginform";
		}
		
		List<Board> result =boardDAO.getpage(pagenum);
		for(Board board : result) {
			String head=board.getBdTitle();
			String body=board.getBdContent();
			head=filterStr(head);
			body=filterStr(body);
			board.setBdTitle(head);
			board.setBdContent(body);
		}
		
		
		model.addAttribute("boards", result);
		
		return "edit/noticeboardmain";
	}
	
	
	@GetMapping("/edit/editview")
	public String clickBoard(@RequestParam(value="bdID", required = false) int page , Model model, HttpSession session) {
		AuthInfo info=(AuthInfo)session.getAttribute("authinfo");
		if(info==null) {
			return "member/loginform";
		}
		Board board= boardDAO.getselectpage(page);
		String head=board.getBdTitle();
		String body=board.getBdContent();
		head=filterStr(head);
		body=filterStr(body);
		board.setBdTitle(head);
		board.setBdContent(body);
		model.addAttribute("board",board);
		
		return "edit/BoardView";
		
	}
	
	
	@GetMapping("/edit/update")
	public String GetUpdate(@RequestParam(value="bdID", required = false) int page,Model model, 
			HttpSession session) {
		
		AuthInfo info=(AuthInfo)session.getAttribute("authinfo");
		if(info==null) {
			return "member/loginform";
		}
		System.out.println(info.getName());
		Board board= boardDAO.getselectpage(page);
		if(!info.getName().equals( board.getUserID() ) ) {
			return "edit/errorpage";
		}
		model.addAttribute("board", board);
		return "edit/update";
		
	}

	
	@PostMapping("/edit/updateboard")
	public String PostUpdate(@ModelAttribute("updatecommand") BoardDelupdateCommand board, 
			@RequestParam(value="bdID", required = false) int bdID
			,HttpSession session) {
		board.setBdID(bdID);
		String head=board.getBdTitle();
		String body=board.getBdContent();
		head=filterStr(head);
		body=filterStr(body);
		board.setBdTitle(head);
		board.setBdContent(body);
	
		boardDelupdateService.UpdateCommit(board);	
		return "redirect:/edit/main";
		
		
	}
	@GetMapping("/edit/delete")
	public String PostDelete(@RequestParam(value="bdID", required = false) int bdID,
			@RequestParam(value="name",required = false) String name,HttpSession session) {
		
		AuthInfo info=(AuthInfo)session.getAttribute("authinfo");
		if(info==null) {
			return "member/loginform";
		}
		if(!info.getName().equals(name)) {
			return "edit/errorpage";
		}

		boardDelupdateService.DeleteCommit(bdID);
		
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
