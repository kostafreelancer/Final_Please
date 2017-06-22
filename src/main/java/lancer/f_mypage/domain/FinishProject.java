package lancer.f_mypage.domain;

import java.io.Serializable;

public class FinishProject  implements Serializable{
	private String proName;
	private String proTerm;
	private String cost;
	private String p_job;
	private int e_pr_num;
	private int e_num;
	private int c_num;
	
	public FinishProject(){}


	public FinishProject(String proName, String proTerm, String cost, String p_job, int e_pr_num, int e_num,
			int c_num) {
		super();
		this.proName = proName;
		this.proTerm = proTerm;
		this.cost = cost;
		this.p_job = p_job;
		this.e_pr_num = e_pr_num;
		this.e_num = e_num;
		this.c_num = c_num;
	}


	public int getC_num() {
		return c_num;
	}


	public void setC_num(int c_num) {
		this.c_num = c_num;
	}


	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProTerm() {
		return proTerm;
	}

	public void setProTerm(String proTerm) {
		this.proTerm = proTerm;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getP_job() {
		return p_job;
	}

	public void setP_job(String p_job) {
		this.p_job = p_job;
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
