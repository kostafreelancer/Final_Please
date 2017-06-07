package lancer.c_projectlist.domain;

import java.io.Serializable;
import java.util.Date;

public class P_Job implements Serializable{
	private int e_pr_num;
	private int job_id;

	public P_Job(){}
	
	
	public P_Job(int e_pr_num, int job_id) {
		super();
		this.e_pr_num = e_pr_num;
		this.job_id = job_id;
	}


	public int getE_pr_num() {
		return e_pr_num;
	}

	public void setE_pr_num(int e_pr_num) {
		this.e_pr_num = e_pr_num;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}


	@Override
	public String toString() {
		return "P_Job [e_pr_num=" + e_pr_num + ", job_id=" + job_id + "]";
	}
	
	
	
}
