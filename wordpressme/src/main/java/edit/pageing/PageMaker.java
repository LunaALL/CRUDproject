package edit.pageing;

public class PageMaker {

	private Criteria cri;
	private int totalCount; // 총 게시글 수
	private int startPage;
	private int endPage; // 화면에 보일 마지막(끝) 페이지 번호, 페이지 끝 번호

	private boolean prev; //이전 버튼
	private boolean next; //페이지 다음 버튼
	private int displayPageNum = 5; // 화면 하단에 보이는 각 페이지 번호 리미트.

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public int getTotalCount() {
		return totalCount;
	}

	// 페이징 관련 버튼(1,2,3,4,5) 계산을 하는 메서드, 인자로 총 게시글 갯수를 받음.
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}

	private void calcData() {
		// getPage 현재 페이지 번호를 반환
		// 끝 페이지 번호 = (현재 페이지 번호 / 5 * 5
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);

		startPage = (endPage - displayPageNum) + 1;

		if (startPage <= 0)
			startPage = 1;
		// getPerPageNum 한 페이지당 보여줄 게시글의 갯수 기본 10개
		// tempEndPage 동적 한 페이지당 보여줄 게시글의 갯수 ( 총 12개 , 1페이지 10개, 2페이지 2개)
		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));

		if (endPage > tempEndPage) {
			// 게시글 최소 표시숫자보다 적을경우
			endPage = tempEndPage;
		}
		// 이전 버튼 생성 여부 .
		prev = startPage == 1 ? false : true;
		// 다음 페이지 버튼 생성 여부.
		next = endPage * cri.getPerPageNum() < totalCount ? true : false;

	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

}
