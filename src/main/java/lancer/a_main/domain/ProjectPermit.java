package lancer.a_main.domain;

import java.io.Serializable;

public class ProjectPermit implements Serializable{
	private int e_pr_num;
	private int e_num;
	private String p_name;
	private String p_content;
	private int p_lowerage;
	private int p_upperage;
	private String p_academic;
	private int p_requirenum;
	private String p_regdate;
	private String p_exdate;
	private int p_lowercost;
	private int p_uppercost;
	private String p_startdate;
	private String p_enddate;
	private String p_location;
	private int p_experience;
	private String project_check_state;
	private int ad_num;
	private String p_state;
	
	private String e_ename;
	private String manager_hphone;
	private String manager_mail;
	
	public ProjectPermit(){}

	public ProjectPermit(int e_pr_num, int e_num, String p_name, String p_content, int p_lowerage, int p_upperage,
			String p_academic, int p_requirenum, String p_regdate, String p_exdate, int p_lowercost, int p_uppercost,
			String p_startdate, String p_enddate, String p_location, int p_experience, String project_check_state,
			int ad_num, String p_state, String e_ename, String manager_hphone, String manager_mail) {
		super();
		this.e_pr_num = e_pr_num;
		this.e_num = e_num;
		this.p_name = p_name;
		this.p_content = p_content;
		this.p_lowerage = p_lowerage;
		this.p_upperage = p_upperage;
		this.p_academic = p_academic;
		this.p_requirenum = p_requirenum;
		this.p_regdate = p_regdate;
		this.p_exdate = p_exdate;
		this.p_lowercost = p_lowercost;
		this.p_uppercost = p_uppercost;
		this.p_startdate = p_startdate;
		this.p_enddate = p_enddate;
		this.p_location = p_location;
		this.p_experience = p_experience;
		this.project_check_state = project_check_state;
		this.ad_num = ad_num;
		this.p_state = p_state;
		this.e_ename = e_ename;
		this.manager_hphone = manager_hphone;
		this.manager_mail = manager_mail;
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

	public int getP_lowerage() {
		return p_lowerage;
	}

	public void setP_lowerage(int p_lowerage) {
		this.p_lowerage = p_lowerage;
	}

	public int getP_upperage() {
		return p_upperage;
	}

	public void setP_upperage(int p_upperage) {
		this.p_upperage = p_upperage;
	}

	public String getP_academic() {
		return p_academic;
	}

	public void setP_academic(String p_academic) {
		this.p_academic = p_academic;
	}

	public int getP_requirenum() {
		return p_requirenum;
	}

	public void setP_requirenum(int p_requirenum) {
		this.p_requirenum = p_requirenum;
	}

	public String getP_regdate() {
		return p_regdate;
	}

	public void setP_regdate(String p_regdate) {
		this.p_regdate = p_regdate;
	}

	public String getP_exdate() {
		return p_exdate;
	}

	public void setP_exdate(String p_exdate) {
		this.p_exdate = p_exdate;
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

	public String getP_enddate() {
		return p_enddate;
	}

	public void setP_enddate(String p_enddate) {
		this.p_enddate = p_enddate;
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

	public int getAd_num() {
		return ad_num;
	}

	public void setAd_num(int ad_num) {
		this.ad_num = ad_num;
	}

	public String getP_state() {
		return p_state;
	}

	public void setP_state(String p_state) {
		this.p_state = p_state;
	}

	public String getE_ename() {
		return e_ename;
	}

	public void setE_ename(String e_ename) {
		this.e_ename = e_ename;
	}

	public String getManager_hphone() {
		return manager_hphone;
	}

	public void setManager_hphone(String manager_hphone) {
		this.manager_hphone = manager_hphone;
	}

	public String getManager_mail() {
		return manager_mail;
	}

	public void setManager_mail(String manager_mail) {
		this.manager_mail = manager_mail;
	}
	}
