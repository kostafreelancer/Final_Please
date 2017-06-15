package lancer.f_mypage.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class PortfolioCommand  implements Serializable{
	private int portfolio_num;
	private int f_num;
	private String portfolio_title;
	private String contents;
	private MultipartFile portfile;
	private int portfile_iden;
	
	public PortfolioCommand(){}



	public PortfolioCommand(int portfolio_num, int f_num, String portfolio_title, String contents,
			MultipartFile portfile, int portfile_iden) {
		super();
		this.portfolio_num = portfolio_num;
		this.f_num = f_num;
		this.portfolio_title = portfolio_title;
		this.contents = contents;
		this.portfile = portfile;
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

	public MultipartFile getPortfile() {
		return portfile;
	}

	public void setPortfile(MultipartFile  portfile) {
		this.portfile = portfile;
	}


	public int getPortfile_iden() {
		return portfile_iden;
	}


	public void setPortfile_iden(int portfile_iden) {
		this.portfile_iden = portfile_iden;
	}



	public String getPortfolio_title() {
		return portfolio_title;
	}



	public void setPortfolio_title(String portfolio_title) {
		this.portfolio_title = portfolio_title;
	}
	
	
}
