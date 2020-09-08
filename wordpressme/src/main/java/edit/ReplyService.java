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
	
	public List<ReplyVO>GetReply(int pagenum) {
		return replyDAO.AllGetList(pagenum);
		
	}
	
	
	

}
