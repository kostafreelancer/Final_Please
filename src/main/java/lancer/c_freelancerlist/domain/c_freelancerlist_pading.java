package lancer.c_freelancerlist.domain;

import java.util.List;

public class c_freelancerlist_pading {
	private List<c_freelancerlist_total> totallists;
	private int requestPage;
	private int totalPageCount;
	private int startPage;
	private int endPage;
	public c_freelancerlist_pading(){}
	public c_freelancerlist_pading(List<c_freelancerlist_total> totallists, int requestPage, int totalPageCount,
			int startPage, int endPage) {
		super();
		this.totallists = totallists;
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.startPage = startPage;
		this.endPage = endPage;
	}
	public List<c_freelancerlist_total> getTotallists() {
		return totallists;
	}
	public void setTotallists(List<c_freelancerlist_total> totallists) {
		this.totallists = totallists;
	}
	public int getRequestPage() {
		return requestPage;
	}
	public void setRequestPage(int requestPage) {
		this.requestPage = requestPage;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
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
	
	
}
