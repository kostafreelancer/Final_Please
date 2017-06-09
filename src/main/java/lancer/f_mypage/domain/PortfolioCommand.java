package lancer.f_mypage.domain;

import org.springframework.web.multipart.MultipartFile;

public class PortfolioCommand {
	private int portfolio_num;
	private int f_num;
	private String contents;
	private MultipartFile portfile;
	
	public PortfolioCommand(){}

	public PortfolioCommand(int portfolio_num, int f_num, String contents, MultipartFile portfile) {
		super();
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

	public MultipartFile getPortfile() {
		return portfile;
	}

	public void setPortfile(MultipartFile  portfile) {
		this.portfile = portfile;
	}
	
}
