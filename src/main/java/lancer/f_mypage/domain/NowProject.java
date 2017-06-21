package lancer.f_mypage.domain;

import java.io.Serializable;

public class NowProject implements Serializable{

	private int c_num;
	private String p_name;
	private String manager_hphone;
	private String p_uppercost;
	private String p_startdate;
	private String p_enddate;
	private String term;
	private int e_pr_num;
	private int e_num;
	
	
	public NowProject(){}
	
	

	public NowProject(int c_num, String p_name, String manager_hphone, String p_uppercost, String p_startdate,
			String p_enddate, String term, int e_pr_num, int e_num) {
		super();
		this.c_num = c_num;
		this.p_name = p_name;
		this.manager_hphone = manager_hphone;
		this.p_uppercost = p_uppercost;
		this.p_startdate = p_startdate;
		this.p_enddate = p_enddate;
		this.term = term;
		this.e_pr_num = e_pr_num;
		this.e_num = e_num;
	}



	public String getTerm() {
		return term;
	}



	public void setTerm(String term) {
		this.term = term;
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

	public String getP_uppercost() {
		return p_uppercost;
	}

	public void setP_uppercost(String p_uppercost) {
		this.p_uppercost = p_uppercost;
	}

	public String getP_startdate() {
		return p_startdate;
	}

	public void setP_startdate(String p_startdate) {
		this.p_startdate = p_startdate;
	}

	public String getP_enddate() {
		return p_enddate;
	}

	public void setP_enddate(String p_enddate) {
		this.p_enddate = p_enddate;
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
