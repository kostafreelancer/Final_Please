package lancer.e_insertproject.domain;

import java.io.Serializable;
import java.util.Date;

public class E_Insert implements Serializable{
	private int e_pr_num;
	private int e_num;
	private String p_name;
	private String p_content;
	private int p_lowerAge;
	private int p_upperAge;
	private String p_academic;
	private int p_requireNum;
	private Date p_regDate;
	private Date p_exDate;
	private int p_lowerCost;
	private int p_upperCost;
	private Date p_startDate;
	private Date p_endDate;
	private String p_location;
	private int p_experience;
	private String project_check_state;
	private String p_state;
	private String p_field;
	public E_Insert(){}
	public E_Insert(int e_pr_num, int e_num, String p_name, String p_content, int p_lowerAge, int p_upperAge,
			String p_academic, int p_requireNum, Date p_regDate, Date p_exDate, int p_lowerCost, int p_upperCost,
			Date p_startDate, Date p_endDate, String p_location, int p_experience, String project_check_state,
			String p_state, String p_field) {
		super();
		this.e_pr_num = e_pr_num;
		this.e_num = e_num;
		this.p_name = p_name;
		this.p_content = p_content;
		this.p_lowerAge = p_lowerAge;
		this.p_upperAge = p_upperAge;
		this.p_academic = p_academic;
		this.p_requireNum = p_requireNum;
		this.p_regDate = p_regDate;
		this.p_exDate = p_exDate;
		this.p_lowerCost = p_lowerCost;
		this.p_upperCost = p_upperCost;
		this.p_startDate = p_startDate;
		this.p_endDate = p_endDate;
		this.p_location = p_location;
		this.p_experience = p_experience;
		this.project_check_state = project_check_state;
		this.p_state = p_state;
		this.p_field = p_field;
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
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public int getP_lowerAge() {
		return p_lowerAge;
	}
	public void setP_lowerAge(int p_lowerAge) {
		this.p_lowerAge = p_lowerAge;
	}
	public int getP_upperAge() {
		return p_upperAge;
	}
	public void setP_upperAge(int p_upperAge) {
		this.p_upperAge = p_upperAge;
	}
	public String getP_academic() {
		return p_academic;
	}
	public void setP_academic(String p_academic) {
		this.p_academic = p_academic;
	}
	public int getP_requireNum() {
		return p_requireNum;
	}
	public void setP_requireNum(int p_requireNum) {
		this.p_requireNum = p_requireNum;
	}
	public Date getP_regDate() {
		return p_regDate;
	}
	public void setP_regDate(Date p_regDate) {
		this.p_regDate = p_regDate;
	}
	public Date getP_exDate() {
		return p_exDate;
	}
	public void setP_exDate(Date p_exDate) {
		this.p_exDate = p_exDate;
	}
	public int getP_lowerCost() {
		return p_lowerCost;
	}
	public void setP_lowerCost(int p_lowerCost) {
		this.p_lowerCost = p_lowerCost;
	}
	public int getP_upperCost() {
		return p_upperCost;
	}
	public void setP_upperCost(int p_upperCost) {
		this.p_upperCost = p_upperCost;
	}
	public Date getP_startDate() {
		return p_startDate;
	}
	public void setP_startDate(Date p_startDate) {
		this.p_startDate = p_startDate;
	}
	public Date getP_endDate() {
		return p_endDate;
	}
	public void setP_endDate(Date p_endDate) {
		this.p_endDate = p_endDate;
	}
	public String getP_location() {
		return p_location;
	}
	public void setP_location(String p_location) {
		this.p_location = p_location;
	}
	public int getP_experience() {
		return p_experience;
	}
	public void setP_experience(int p_experience) {
		this.p_experience = p_experience;
	}
	public String getProject_check_state() {
		return project_check_state;
	}
	public void setProject_check_state(String project_check_state) {
		this.project_check_state = project_check_state;
	}
	public String getP_state() {
		return p_state;
	}
	public void setP_state(String p_state) {
		this.p_state = p_state;
	}
	public String getP_field() {
		return p_field;
	}
	public void setP_field(String p_field) {
		this.p_field = p_field;
	}
	
	

	

	


	


	

	
	
}
