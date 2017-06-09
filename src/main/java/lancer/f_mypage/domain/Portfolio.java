package lancer.f_mypage.domain;

public class Portfolio {
	private int portfolio_num;
	private int f_num;
	private String contents;
	private String portfile;
	
	public Portfolio(){}

	public Portfolio(int portfolio_num, int f_num, String contents, String portfile) {
		this.portfolio_num = portfolio_num;
		this.f_num = f_num;
		this.contents = contents;
		this.portfile = portfile;
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

	public String getPortfile() {
		return portfile;
	}

	public void setPortfile(String portfile) {
		this.portfile = portfile;
	}
	
}
