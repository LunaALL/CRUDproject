package edit.pageing;

public class PageMaker {

	private Criteria cri;
	private int totalCount; // 총 게시글 수
	private int startPage;
	private int endPage; // 화면에 보일 마지막(끝) 페이지 번호, 페이지 끝 번호
	private boolean prev;
	private boolean next;
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

	// 페이징 관련 버튼(1,2,3,4,5) 계산을 하는 메서드
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}

	private void calcData() {
		// getpage=현재 페이지 번호
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
		// 끝 페이지 번호 = (현재 페이지 번호 / 화면에 보여질 페이지 번호의 갯수) * 화면에 보여질 페이지 번호의 갯수
		System.out.println("엔드페이지 출력 " + endPage);
		startPage = (endPage - displayPageNum) + 1;

		if (startPage <= 0)
			startPage = 1;
		// getperpagenum 한 페이지당 보여줄 게시글의 갯수

		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		// tempendpage는 총 게시글 숫자를 한 페이지당 보여줄 게시글의 갯수(5)를 나눈것.

		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}

		prev = startPage == 1 ? false : true;
		// 이전 버튼 생성 여부 .
		next = endPage * cri.getPerPageNum() < totalCount ? true : false;
		// 다음 페이지 버튼 생성 여부.

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
