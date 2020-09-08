package edit;

import java.time.LocalDateTime;

public class ReplyVO {
	private int boardnum;
	private int commentnum;
	private String content;
	private String writer;
	private LocalDateTime bdcdate;
	
	public ReplyVO(int boardnum, int commentnum, String content, String writer, LocalDateTime bdcdate) {
		super();
		this.boardnum = boardnum;
		this.commentnum = commentnum;
		this.content = content;
		this.writer = writer;
		this.bdcdate = bdcdate;
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
	
	@Override
	public String toString() {
		return "ReplyVO [bno=" + boardnum + ", rno=" + commentnum + ", content=" + content + ", writer=" + writer + ", regdate="
				+ bdcdate + "]";
	}

}
