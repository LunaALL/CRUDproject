package edit;

import java.time.LocalDateTime;

//댓글 관련 이벤트를 위한 VO. 댓글 객체 
public class ReplyVO {
	private int boardnum;
	private int commentnum;
	private String content;
	private String writer;
	private LocalDateTime bdcDate;
	
	public ReplyVO(int boardnum, int commentnum, String content, String writer, LocalDateTime bdcDate) {
		super();
		this.boardnum = boardnum;
		this.commentnum = commentnum;
		this.content = content;
		this.writer = writer;
		this.bdcDate = bdcDate;
	}
	
	public ReplyVO() {
		
	}
	
	public LocalDateTime getBdcDate() {
		return bdcDate;
	}
	public void setBdcDate(LocalDateTime bdcDate) {
		this.bdcDate = bdcDate;
	}
	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	} 
	public int getCommentnum() {
		return commentnum;
	}
	public void setCommentnum(int commentnum) {
		this.commentnum = commentnum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	

}
