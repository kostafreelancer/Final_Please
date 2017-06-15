package lancer.f_mypage.domain;

import java.io.Serializable;

public class F_job  implements Serializable{
	private int f_num;
	private int job_id;
	
	public F_job(){}


	public F_job(int f_num, int job_id) {
		super();
		this.f_num = f_num;
		this.job_id = job_id;
	}


	public int getF_num() {
		return f_num;
	}


	public void setF_num(int f_num) {
		this.f_num = f_num;
	}


	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	
	
	
}
