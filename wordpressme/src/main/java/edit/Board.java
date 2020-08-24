package edit;

import java.time.LocalDateTime;

public class Board {
	private int bdID;
	private String bdTitle;
	private String userID; // name
	private LocalDateTime bdDate;
	private String bdContent;
	private int bdIsdelete;

	public Board(String bdTitle, String userID, LocalDateTime bdDate, String bdContent) {
		this.bdTitle = bdTitle;
		this.userID = userID;
		this.bdDate = bdDate;
		this.bdContent = bdContent;
	}

	public int getBdID() {
		return bdID;
	}

	public void setBdID(int bdID) {
		this.bdID = bdID;
	}

	public String getBdTitle() {
		return bdTitle;
	}

	public void setBdTitle(String bdTitle) {
		this.bdTitle = bdTitle;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public LocalDateTime getBdDate() {
		return bdDate;
	}

	public void setBdDate(LocalDateTime bdDate) {
		this.bdDate = bdDate;
	}

	public String getBdContent() {
		return bdContent;
	}

	public void setBdContent(String bdContent) {
		this.bdContent = bdContent;
	}

	public int getBdIsdelete() {
		return bdIsdelete;
	}

	public void setBdIsdelete(int bdIsdelete) {
		this.bdIsdelete = bdIsdelete;
	}

}
