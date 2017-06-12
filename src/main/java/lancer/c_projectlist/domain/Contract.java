package lancer.c_projectlist.domain;

import java.io.Serializable;
import java.util.Date;

public class Contract implements Serializable{
	private int c_num;
	private String c_request_date;
	private int e_pr_num;
	private int f_num;
	private String c_state;
	
	public Contract(){}

	public Contract(int c_num, String c_request_date, int e_pr_num, int f_num, String c_state) {
		super();
		this.c_num = c_num;
		this.c_request_date = c_request_date;
		this.e_pr_num = e_pr_num;
		this.f_num = f_num;
		this.c_state = c_state;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public String getC_request_date() {
		return c_request_date;
	}

	public void setC_request_date(String c_request_date) {
		this.c_request_date = c_request_date;
	}

	public int getE_pr_num() {
		return e_pr_num;
	}

	public void setE_pr_num(int e_pr_num) {
		this.e_pr_num = e_pr_num;
	}

	public int getF_num() {
		return f_num;
	}

	public void setF_num(int f_num) {
		this.f_num = f_num;
	}

	public String getC_state() {
		return c_state;
	}

	public void setC_state(String c_state) {
		this.c_state = c_state;
	}

	@Override
	public String toString() {
		return "Contract [c_num=" + c_num + ", c_request_date=" + c_request_date + ", e_pr_num=" + e_pr_num + ", f_num="
				+ f_num + ", c_state=" + c_state + "]";
	}
	
	
	
	


	
	
}
