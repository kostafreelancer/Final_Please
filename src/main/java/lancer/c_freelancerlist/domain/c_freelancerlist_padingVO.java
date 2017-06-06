package lancer.c_freelancerlist.domain;

import java.io.Serializable;
import java.util.List;

public class c_freelancerlist_padingVO implements Serializable{
	private List<c_freelancerlist_totalVO> totallists;
	private int requestPage;
	private int totalPageCount;
	private int startPage;
	private int endPage;
	public c_freelancerlist_padingVO(){}
	public c_freelancerlist_padingVO(List<c_freelancerlist_totalVO> totallists, int requestPage, int totalPageCount,
			int startPage, int endPage) {
		super();
		this.totallists = totallists;
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.startPage = startPage;
		this.endPage = endPage;
	}
	public List<c_freelancerlist_totalVO> getTotallists() {
		return totallists;
	}
	public void setTotallists(List<c_freelancerlist_totalVO> totallists) {
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
