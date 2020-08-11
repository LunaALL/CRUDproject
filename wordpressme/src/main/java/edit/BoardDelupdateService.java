package edit;

public class BoardDelupdateService {
	
	BoardDAO boardDAO;

	public BoardDelupdateService(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	
	public void UpdateCommit(BoardDelupdateCommand wc) {
		boardDAO.updateboard(wc);
	}
	
	public void DeleteCommit(int bdID) {
		boardDAO.deleteBoard(bdID);
		
	}
	
	

}
