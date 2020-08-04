package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edit.Board;
import edit.BoardDAO;
import login.AuthInfo;

@Controller
public class MainBoardController {
	
	private BoardDAO boardDAO;
	
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
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
		model.addAttribute("boards", result);
		
		return "edit/noticeboardmain";
	}
	
	
	@GetMapping("/edit/editview")
	public String clickBoard(@RequestParam(value="bdID", required = false) int page , Model model, HttpSession session) {
		AuthInfo info=(AuthInfo)session.getAttribute("authinfo");
		if(info==null) {
			return "member/loginform";
		}
		Board bd= boardDAO.getselectpage(page);
		model.addAttribute("board",bd);
		
		return "edit/BoardView";
		
	}

}
