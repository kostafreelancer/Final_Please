package lancer.c_freelancerlist.domain;

public class c_freelancerlist_portfolio {
	private int portfolio_num;
	private int f_num;
	private String contents;
	private String addfile;
	
	public c_freelancerlist_portfolio(){}

	public c_freelancerlist_portfolio(int portfolio_num, int f_num, String contents, String addfile) {
		super();
		this.portfolio_num = portfolio_num;
		this.f_num = f_num;
		this.contents = contents;
		this.addfile = addfile;
	}

	public int getPortfolio_num() {
		return portfolio_num;
	}

	public void setPortfolio_num(int portfolio_num) {
		this.portfolio_num = portfolio_num;
	}

	public int getF_num() {
		return f_num;
	}

	public void setF_num(int f_num) {
		this.f_num = f_num;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getAddfile() {
		return addfile;
	}

	public void setAddfile(String addfile) {
		this.addfile = addfile;
	}
	
}
