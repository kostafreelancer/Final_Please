package lancer.c_freelancerlist.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class c_freelancerlist_totalVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int f_num;
	private String f_id;
	private String f_pwd;
	private String f_name;
	private String f_birth;
	private String f_sex;
	private String f_hphone;
	private String f_phone;
	private String f_email;
	private String f_address;
	private String f_major;
	private String f_nowstate;
	private Date f_recentlogin;
	private List<c_freelancerlist_schoolVO> list_school;
	private List<c_freelancerlist_careerVO> list_career;
	private List<c_freelancerlist_portfolioVO> list_portfolio;
	private List<String> list_job;
	private int f_age;
	private String f_highest_career;
	private String f_highest_school;
	private String f_field;
	private Object f_photo;
	
	public c_freelancerlist_totalVO(){}
	
	public c_freelancerlist_totalVO(int f_num, String f_id, String f_pwd, String f_name, String f_birth, String f_sex,
			String f_hphone, String f_phone, String f_email, String f_address, String f_major, String f_nowstate,
			Date f_recentlogin, List<c_freelancerlist_schoolVO> list_school,
			List<c_freelancerlist_careerVO> list_career, List<c_freelancerlist_portfolioVO> list_portfolio,
			List<String> list_job, int f_age, String f_highest_career, String f_highest_school, String f_field,
			Object f_photo) {
		super();
		this.f_num = f_num;
		this.f_id = f_id;
		this.f_pwd = f_pwd;
		this.f_name = f_name;
		this.f_birth = f_birth;
		this.f_sex = f_sex;
		this.f_hphone = f_hphone;
		this.f_phone = f_phone;
		this.f_email = f_email;
		this.f_address = f_address;
		this.f_major = f_major;
		this.f_nowstate = f_nowstate;
		this.f_recentlogin = f_recentlogin;
		this.list_school = list_school;
		this.list_career = list_career;
		this.list_portfolio = list_portfolio;
		this.list_job = list_job;
		this.f_age = f_age;
		this.f_highest_career = f_highest_career;
		this.f_highest_school = f_highest_school;
		this.f_field = f_field;
		this.f_photo = f_photo;
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
	public String getF_pwd() {
		return f_pwd;
	}
	public void setF_pwd(String f_pwd) {
		this.f_pwd = f_pwd;
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
	public String getF_phone() {
		return f_phone;
	}
	public void setF_phone(String f_phone) {
		this.f_phone = f_phone;
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
	public Date getF_recentlogin() {
		return f_recentlogin;
	}
	public void setF_recentlogin(Date f_recentlogin) {
		this.f_recentlogin = f_recentlogin;
	}
	public List<c_freelancerlist_schoolVO> getList_school() {
		return list_school;
	}
	public void setList_school(List<c_freelancerlist_schoolVO> list_school) {
		this.list_school = list_school;
	}
	public List<c_freelancerlist_careerVO> getList_career() {
		return list_career;
	}
	public void setList_career(List<c_freelancerlist_careerVO> list_career) {
		this.list_career = list_career;
	}
	public List<c_freelancerlist_portfolioVO> getList_portfolio() {
		return list_portfolio;
	}
	public void setList_portfolio(List<c_freelancerlist_portfolioVO> list_portfolio) {
		this.list_portfolio = list_portfolio;
	}
	public List<String> getList_job() {
		return list_job;
	}
	public void setList_job(List<String> list_job) {
		this.list_job = list_job;
	}
	public int getF_age() {
		return f_age;
	}
	public void setF_age(int f_age) {
		this.f_age = f_age;
	}
	public String getF_highest_career() {
		return f_highest_career;
	}
	public void setF_highest_career(String f_highest_career) {
		this.f_highest_career = f_highest_career;
	}
	public String getF_highest_school() {
		return f_highest_school;
	}
	public void setF_highest_school(String f_highest_school) {
		this.f_highest_school = f_highest_school;
	}
	
	public String getF_field() {
		return f_field;
	}
	public void setF_field(String f_field) {
		this.f_field = f_field;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Object getF_photo() {
		return f_photo;
	}

	public void setF_photo(Object f_photo) {
		this.f_photo = f_photo;
	}
	
	
	
}
