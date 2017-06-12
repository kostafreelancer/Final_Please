package lancer.f_mypage.domain;

public class Portfolio {
	private int portfolio_num;
	private int f_num;
	private String contents;
	private String portfile;
	private int portfile_iden;
	
	public Portfolio(){}


	public Portfolio(int portfolio_num, int f_num, String contents, String portfile, int portfile_iden) {
		super();
		this.portfolio_num = portfolio_num;
		this.f_num = f_num;
		this.contents = contents;
		this.portfile = portfile;
		this.portfile_iden = portfile_iden;
	}


	public int getPortfile_iden() {
		return portfile_iden;
	}


	public void setPortfile_iden(int portfile_iden) {
		this.portfile_iden = portfile_iden;
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
