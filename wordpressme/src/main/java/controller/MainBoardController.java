package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edit.Board;
import edit.BoardDAO;

@Controller
public class MainBoardController {
	
	private BoardDAO boardDAO;
	
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}


	@GetMapping("/edit/main")
	public String mainBoard(
			@RequestParam(value="pagenum", required =false, defaultValue = "1") int pagenum,
			Model model) {
		List<Board> result =boardDAO.getpage(pagenum);
		model.addAttribute("boards", result);
		
		return "edit/noticeboardmain";
	}

}
