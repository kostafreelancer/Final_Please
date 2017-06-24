package lancer.f_main.domain;

import java.io.Serializable;

public class recommendProject implements Serializable{

	public String p_name;
	public int p_lowercost;
	public int p_uppercost;
	public String p_startdate;
	public int e_pr_num;
	public int e_num;
	public String e_name;
	public String p_content;
	
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public int getE_num() {
		return e_num;
	}
	public void setE_num(int e_num) {
		this.e_num = e_num;
	}
	public int getE_pr_num() {
		return e_pr_num;
	}
	public void setE_pr_num(int e_pr_num) {
		this.e_pr_num = e_pr_num;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_lowercost() {
		return p_lowercost;
	}
	public void setP_lowercost(int p_lowercost) {
		this.p_lowercost = p_lowercost;
	}
	public int getP_uppercost() {
		return p_uppercost;
	}
	public void setP_uppercost(int p_uppercost) {
		this.p_uppercost = p_uppercost;
	}
	public String getP_startdate() {
		return p_startdate;
	}
	public void setP_startdate(String p_startdate) {
		this.p_startdate = p_startdate;
	}
	
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	@Override
	public String toString() {
		return "recommendProject [p_name=" + p_name + ", p_lowercost=" + p_lowercost + ", p_uppercost=" + p_uppercost
				+ ", p_startdate=" + p_startdate + ", e_pr_num=" + e_pr_num + ", e_num=" + e_num + ", e_name=" + e_name
				+ ", p_content=" + p_content + "]";
	}

	
	
}
