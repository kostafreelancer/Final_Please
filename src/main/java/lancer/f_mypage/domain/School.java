package lancer.f_mypage.domain;

import java.io.Serializable;

public class School implements Serializable{
	private int school_num;
	private int f_num;
	private String school_name;
	private String major;
	private String school_term;
	private String school_location;
	private String school_degree;
	
	public School(){}

	public School(int school_num, int f_num, String school_name, String major, String school_term,
			String school_location, String school_degree) {
		super();
		this.school_num = school_num;
		this.f_num = f_num;
		this.school_name = school_name;
		this.major = major;
		this.school_term = school_term;
		this.school_location = school_location;
		this.school_degree = school_degree;
	}

	public int getSchool_num() {
		return school_num;
	}

	public void setSchool_num(int school_num) {
		this.school_num = school_num;
	}

	public int getF_num() {
		return f_num;
	}

	public void setF_num(int f_num) {
		this.f_num = f_num;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSchool_term() {
		return school_term;
	}

	public void setSchool_term(String school_term) {
		this.school_term = school_term;
	}

	public String getSchool_location() {
		return school_location;
	}

	public void setSchool_location(String school_location) {
		this.school_location = school_location;
	}

	public String getSchool_degree() {
		return school_degree;
	}

	public void setSchool_degree(String school_degree) {
		this.school_degree = school_degree;
	}
	
	
	
	
}
