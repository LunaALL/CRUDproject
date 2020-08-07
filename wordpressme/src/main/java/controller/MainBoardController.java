package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edit.Board;
import edit.BoardDAO;
import edit.BoardDelupdateCommand;
import edit.BoardDelupdateService;
import login.AuthInfo;
import validator.WriteBoardValidator;

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
		if(board!=null) {
			board.setBdContent(board.getBdContent().replaceAll(" ","&nbsp;" ).replaceAll("<", "&lt;")
					.replaceAll(">", "&gt;").replaceAll("\r\n", "<br>") );
			
			board.setBdTitle(
					board.getBdTitle().replaceAll(" ", "&nbsp;").
					replaceAll("\r\n", "<br>").replaceAll("(?i)<script", "&lt;script")
					);
		}
		model.addAttribute("board",board);
		
		return "edit/BoardView";
		
	}
	
	
	@GetMapping("/edit/update")
	public String GetUpdate(@RequestParam(value="bdID", required = false, defaultValue = "1") int page,Model model, 
			HttpSession session) {
		
		AuthInfo info=(AuthInfo)session.getAttribute("authinfo");
		if(info==null) {
			return "member/loginform";
		}
		Board board= boardDAO.getselectpage(page);
		model.addAttribute("board", board);
		return "edit/update";
		
	}

	
	@PostMapping("/edit/updateboard")
	public String PostUpdate(@ModelAttribute("updateboard") BoardDelupdateCommand bcmd, Errors error) {
		boardDelupdateService.UpdateCommit(bcmd);	
		
		
		return "edit/noticeboardmain";
		
		
	}
	
	
	
}
