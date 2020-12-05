package edit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class ReplyService {
	
	@Autowired
	private ReplyDAO replyDAO;

	public void setReplyDAO(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}
	
	//댓글 전체 목록 요청 ,bdID 종속
	public List<ReplyVO>GetReply(int pagenum) {
		return replyDAO.AllGetList(pagenum);
	}
	
	//db 입력. 
	public void inputComment(ReplyVO vo) {
		int commentnum=replyDAO.getCommentnum(vo.getBoardnum());
		
		vo.setCommentnum(commentnum);
		replyDAO.InputComment(vo);
	}
	
	
	
	
	

}
