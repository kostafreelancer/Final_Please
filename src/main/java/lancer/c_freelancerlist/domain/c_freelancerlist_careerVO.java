package lancer.c_freelancerlist.domain;

import java.io.Serializable;

public class c_freelancerlist_careerVO implements Serializable{
	private int career_num;
	private int f_num;
	private String dept;
	private String rank;
	private String career_term;
	private String career_location;
	
	public c_freelancerlist_careerVO(){}

	public c_freelancerlist_careerVO(int career_num, int f_num, String dept, String rank, String career_term,
			String career_location) {
		super();
		this.career_num = career_num;
		this.f_num = f_num;
		this.dept = dept;
		this.rank = rank;
		this.career_term = career_term;
		this.career_location = career_location;
	}

	public int getCareer_num() {
		return career_num;
	}

	public void setCareer_num(int career_num) {
		this.career_num = career_num;
	}

	public int getF_num() {
		return f_num;
	}

	public void setF_num(int f_num) {
		this.f_num = f_num;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getCareer_term() {
		return career_term;
	}

	public void setCareer_term(String career_term) {
		this.career_term = career_term;
	}

	public String getCareer_location() {
		return career_location;
	}

	public void setCareer_location(String career_location) {
		this.career_location = career_location;
	}
	
	
}
