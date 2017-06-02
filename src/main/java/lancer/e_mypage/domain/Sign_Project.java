package lancer.e_mypage.domain;

import java.io.Serializable;

public class Sign_Project implements Serializable{
	private int p_num;
	private int e_pr_num;
	private int ad_num;
	private String state;		// 모집중, 진행중, 완료
	
	public Sign_Project(){}

	public Sign_Project(int p_num, int e_pr_num, int ad_num, String state) {
		super();
		this.p_num = p_num;
		this.e_pr_num = e_pr_num;
		this.ad_num = ad_num;
		this.state = state;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public int getE_pr_num() {
		return e_pr_num;
	}

	public void setE_pr_num(int e_pr_num) {
		this.e_pr_num = e_pr_num;
	}

	public int getAd_num() {
		return ad_num;
	}

	public void setAd_num(int ad_num) {
		this.ad_num = ad_num;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	};
	
}
