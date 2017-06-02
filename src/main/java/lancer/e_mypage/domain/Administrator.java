package lancer.e_mypage.domain;

import java.io.Serializable;

public class Administrator implements Serializable{
	private int ad_num;
	private String ad_id;
	private String ad_pwd;
	
	public Administrator(){}

	public Administrator(int ad_num, String ad_id, String ad_pwd) {
		super();
		this.ad_num = ad_num;
		this.ad_id = ad_id;
		this.ad_pwd = ad_pwd;
	}

	public int getAd_num() {
		return ad_num;
	}

	public void setAd_num(int ad_num) {
		this.ad_num = ad_num;
	}

	public String getAd_id() {
		return ad_id;
	}

	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}

	public String getAd_pwd() {
		return ad_pwd;
	}

	public void setAd_pwd(String ad_pwd) {
		this.ad_pwd = ad_pwd;
	};
	
}
