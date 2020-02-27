package com.hwak.model;

// 화면에 필요한 설계
public class PageVO {
	// 페이징 시작번호
	private int startPage;
	// 페이징 끝번호
	private int endPage;
	// 페이징 이전
	private boolean prev;
	// 페이징 다음
	private boolean next;
	
	private int total;
	
	private Criteria cri;
	
	public PageVO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		// 페이징 끝번호를 알 수 있게 계산
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*9;
		this.startPage = this.endPage-8;
		int realEnd = (int)(Math.ceil((total*1.0)/cri.getAmount()));
		
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
}
