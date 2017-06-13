package lancer.f_mypage.domain;

import java.io.Serializable;

public class ApplyProject implements Serializable{
	private int c_num;
	private String p_name;
	private String manager_hphone;
	private String c_request_date;
	private String c_state;
	private int e_pr_num;
	private int e_num;
	
	public ApplyProject(){};
	

	public ApplyProject(int c_num, String p_name, String manager_hphone, String c_request_date, String c_state,
			int e_pr_num, int e_num) {
		super();
		this.c_num = c_num;
		this.p_name = p_name;
		this.manager_hphone = manager_hphone;
		this.c_request_date = c_request_date;
		this.c_state = c_state;
		this.e_pr_num = e_pr_num;
		this.e_num = e_num;
	}



	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getManager_hphone() {
		return manager_hphone;
	}

	public void setManager_hphone(String manager_hphone) {
		this.manager_hphone = manager_hphone;
	}

	public String getC_request_date() {
		return c_request_date;
	}

	public void setC_request_date(String c_request_date) {
		this.c_request_date = c_request_date;
	}

	public String getC_state() {
		return c_state;
	}

	public void setC_state(String c_state) {
		this.c_state = c_state;
	}


	public int getE_pr_num() {
		return e_pr_num;
	}


	public void setE_pr_num(int e_pr_num) {
		this.e_pr_num = e_pr_num;
	}


	public int getE_num() {
		return e_num;
	}


	public void setE_num(int e_num) {
		this.e_num = e_num;
	}
	
	
	
}
