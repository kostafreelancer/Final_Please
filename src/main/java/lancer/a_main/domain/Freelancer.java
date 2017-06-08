package lancer.a_main.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Freelancer implements Serializable{
	private int f_num;
	private String f_id;
	private String f_name;
	private String f_birth;
	private String f_hphone;
	private String f_email;
	private String f_address;
	private String f_major;
	private String f_nowstate;
	private Timestamp f_recentlogin;
	
	public int getF_num() {
		return f_num;
	}
	public void setF_num(int f_num) {
		this.f_num = f_num;
	}
	public String getF_id() {
		return f_id;
	}
	public void setF_id(String f_id) {
		this.f_id = f_id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF_birth() {
		return f_birth;
	}
	public void setF_birth(String f_birth) {
		this.f_birth = f_birth;
	}
	public String getF_hphone() {
		return f_hphone;
	}
	public void setF_hphone(String f_hphone) {
		this.f_hphone = f_hphone;
	}
	public String getF_email() {
		return f_email;
	}
	public void setF_email(String f_email) {
		this.f_email = f_email;
	}
	public String getF_address() {
		return f_address;
	}
	public void setF_address(String f_address) {
		this.f_address = f_address;
	}
	public String getF_major() {
		return f_major;
	}
	public void setF_major(String f_major) {
		this.f_major = f_major;
	}
	public String getF_nowstate() {
		return f_nowstate;
	}
	public void setF_nowstate(String f_nowstate) {
		this.f_nowstate = f_nowstate;
	}
	public Timestamp getF_recentlogin() {
		return f_recentlogin;
	}
	public void setF_recentlogin(Timestamp f_recentlogin) {
		this.f_recentlogin = f_recentlogin;
	}
	
}
