package edit;

import java.time.LocalDateTime;

public class BoardWriteService {
	
	private BoardDAO boardDAO;
	
	public BoardWriteService(BoardDAO boardDAO) {
		this.boardDAO=boardDAO;
	}
	
	public long commit(BoardWriteCommand bwc) {
		Board board= new Board(bwc.getBdTitle(),bwc.getUserID(),
				LocalDateTime.now(),bwc.getBdContent());

		boardDAO.insert(board);
		return board.getBdID();
	}

}
