package edit.pageing;

//
public class Criteria {

	private int page; // 현재 페이지 번호
	private int perPageNum; // 한 페이지당 보여줄 게시글 수.

	public int getPageStart() {
		/* 특정 페이지의 게시글 시작 번호 */

		return (this.page - 1) * perPageNum;
	}

	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			// 기본 페이지 설정
			this.page = 1;
		} else {
			this.page = page;
		}
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int pageCount) {
		int cnt = this.perPageNum;
		if (pageCount != cnt) {
			this.perPageNum = cnt;
		} else {
			this.perPageNum = pageCount;
		}
	}

}
