package edit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ReplyService {

	@Autowired
	private ReplyDAO replyDAO;

	public void setReplyDAO(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}

	// 댓글 전체 목록 요청 ,bdID 종속
	public List<ReplyVO> GetReply(int pagenum) {
		return replyDAO.AllGetList(pagenum);
	}

	// 디비 입력.
	public void inputComment(ReplyVO vo) {
		int commentnum = replyDAO.getCommentnum(vo.getBoardnum());

		vo.setCommentnum(commentnum);
		replyDAO.InputComment(vo);
	}

	// 댓글 삭제
	public int delComment(int commentnum, int bdId, String writer) {
		int result = replyDAO.delReply(commentnum, bdId, writer);
		return result;

	}

}
