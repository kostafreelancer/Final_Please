package lancer.f_board.domain;


public class F_Criteria {
	private int page;
	private int perPageNum;
	
	public F_Criteria(){
		this.page=1;
		this.perPageNum=3;
	}
	
	public void setPage(int page){
		if(page<=0){
			this.page=1;
			return;
		}
		this.page=page;
	}
	
	public void setPerPageNum(int perPageNum){
		if(perPageNum<=0 || perPageNum>100){
			this.perPageNum=3;
			return;
		}
		this.perPageNum=perPageNum;
	}
	
	public int getPage(){
		return page;
	}
	
	public int getPageStart(){
		return (this.page - 1)*perPageNum;
	}
	
	public int getPerPageNum(){
		return this.perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
	
}