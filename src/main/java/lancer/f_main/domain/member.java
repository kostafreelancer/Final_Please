package lancer.f_main.domain;

import java.io.Serializable;

public class member implements Serializable{
	public String f_name;
	public String f_sex;
	public String f_email;
	public String f_major;
	public String f_recentlogin;
	
	
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF_sex() {
		return f_sex;
	}
	public void setF_sex(String f_sex) {
		this.f_sex = f_sex;
	}
	public String getF_email() {
		return f_email;
	}
	public void setF_email(String f_email) {
		this.f_email = f_email;
	}
	public String getF_major() {
		return f_major;
	}
	public void setF_major(String f_major) {
		this.f_major = f_major;
	}
	public String getF_recentlogin() {
		return f_recentlogin;
	}
	public void setF_recentlogin(String f_recentlogin) {
		this.f_recentlogin = f_recentlogin;
	}
	
	@Override
	public String toString() {
		return "member [f_name=" + f_name + ", f_sex=" + f_sex + ", f_email=" + f_email + ", f_major=" + f_major
				+ ", f_recentlogin=" + f_recentlogin + "]";
	}
	
	
	
	
	
	
	
	
	
}
