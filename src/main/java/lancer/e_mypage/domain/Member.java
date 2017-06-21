package lancer.e_mypage.domain;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	private int f_num;
	private String f_id;
	private String f_name;
	private String f_sex;
	private String f_hphone;
	private String f_email;
	private String f_major;
	private double f_score;
	private String c_state;
	
	public Member(){}

	public Member(int f_num, String f_id, String f_name, String f_sex, String f_hphone, String f_email,
			String f_major, double f_score, String c_state) {
		super();
		this.f_num = f_num;
		this.f_id = f_id;
		this.f_name = f_name;
		this.f_sex = f_sex;
		this.f_hphone = f_hphone;
		this.f_email = f_email;
		this.f_major = f_major;
		this.f_score = f_score;
		this.c_state = c_state;
	}

	public String getC_state() {
		return c_state;
	}

	public void setC_state(String c_state) {
		this.c_state = c_state;
	}

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

	public String getF_sex() {
		return f_sex;
	}

	public void setF_sex(String f_sex) {
		this.f_sex = f_sex;
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

	public String getF_major() {
		return f_major;
	}

	public void setF_major(String f_major) {
		this.f_major = f_major;
	}

	public double getF_score() {
		return f_score;
	}

	public void setF_score(double f_score) {
		this.f_score = f_score;
	}
	
	
}