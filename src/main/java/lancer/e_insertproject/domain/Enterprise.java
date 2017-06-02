package lancer.e_insertproject.domain;

import java.io.Serializable;

public class Enterprise implements Serializable{
	private int e_num;		// 기업번호
	private String e_id;		// 기업?��?�� ?��?��?��(?��?��?��?��)
	private String e_pwd;	// 기업?��?�� 비�?번호	(?��?��?��?��)
	private String e_mail;	// 기업 ?��메일
	private double e_score;		// 기업?��?��
	private String e_name;				// �??��?�� �?
	private String e_ename;			// 기업 ?���?
	private String e_owner;		// 기업 ???��?�� �?
	private String e_ownerfile;	// 기업 ???��?�� ?��진파?�� 경로
	private String e_regno;			// ?��?��?��?��록번?�� ( 123-42322)
	private String e_phone;		// 기업 ?��?��번호
	private String e_bf;					// ?��무분?�� ?��?��?��
	private String manager_name;		// ?��?��?�� ?���?
	private String manager_hphone;	// ?��?��?�� ?��?��?��
	private String manager_mail;		// ?��?��?�� ?��메일
	private String e_address;			// 기업 주소
	private String e_homepage;			// 기업 ?��?��?���?
	private int start_year;				// 기업 ?��립년?��
	private int e_enum;				// 기업 ?��?�� ?��
	private String e_listing;			// ?��?��?���?   (?��?��, 비상?��)
	private int e_capital;		// ?��본금
	private int e_sales;		// ?��매출
	private String e_scale;			// 기업규모 (??기업, 중소기업, 개인)
	private String e_licensefile;		// ?��?��?��?��록증 ?��진파?�� 경로
	private String e_check;		// ?��메일?��증을 ?��?�� �??��?��?��?���?   �??��?��?��?��?��?�� 1,  ?���? ?���? ?��?��?���? 0
	
	public Enterprise(){}

	public Enterprise(int e_num, String e_id, String e_pwd, String e_mail, double e_score, String e_name,
			String e_ename, String e_owner, String e_ownerfile, String e_regno, String e_phone, String e_bf,
			String manager_name, String manager_hphone, String manager_mail, String e_address, String e_homepage,
			int start_year, int e_enum, String e_listing, int e_capital, int e_sales, String e_scale,
			String e_licensefile, String e_check) {
		super();
		this.e_num = e_num;
		this.e_id = e_id;
		this.e_pwd = e_pwd;
		this.e_mail = e_mail;
		this.e_score = e_score;
		this.e_name = e_name;
		this.e_ename = e_ename;
		this.e_owner = e_owner;
		this.e_ownerfile = e_ownerfile;
		this.e_regno = e_regno;
		this.e_phone = e_phone;
		this.e_bf = e_bf;
		this.manager_name = manager_name;
		this.manager_hphone = manager_hphone;
		this.manager_mail = manager_mail;
		this.e_address = e_address;
		this.e_homepage = e_homepage;
		this.start_year = start_year;
		this.e_enum = e_enum;
		this.e_listing = e_listing;
		this.e_capital = e_capital;
		this.e_sales = e_sales;
		this.e_scale = e_scale;
		this.e_licensefile = e_licensefile;
		this.e_check = e_check;
	}

	public int getE_num() {
		return e_num;
	}

	public void setE_num(int e_num) {
		this.e_num = e_num;
	}

	public String getE_id() {
		return e_id;
	}

	public void setE_id(String e_id) {
		this.e_id = e_id;
	}

	public String getE_pwd() {
		return e_pwd;
	}

	public void setE_pwd(String e_pwd) {
		this.e_pwd = e_pwd;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public double getE_score() {
		return e_score;
	}

	public void setE_score(double e_score) {
		this.e_score = e_score;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public String getE_ename() {
		return e_ename;
	}

	public void setE_ename(String e_ename) {
		this.e_ename = e_ename;
	}

	public String getE_owner() {
		return e_owner;
	}

	public void setE_owner(String e_owner) {
		this.e_owner = e_owner;
	}

	public String getE_ownerfile() {
		return e_ownerfile;
	}

	public void setE_ownerfile(String e_ownerfile) {
		this.e_ownerfile = e_ownerfile;
	}

	public String getE_regno() {
		return e_regno;
	}

	public void setE_regno(String e_regno) {
		this.e_regno = e_regno;
	}

	public String getE_phone() {
		return e_phone;
	}

	public void setE_phone(String e_phone) {
		this.e_phone = e_phone;
	}

	public String getE_bf() {
		return e_bf;
	}

	public void setE_bf(String e_bf) {
		this.e_bf = e_bf;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
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

	public String getE_address() {
		return e_address;
	}

	public void setE_address(String e_address) {
		this.e_address = e_address;
	}

	public String getE_homepage() {
		return e_homepage;
	}

	public void setE_homepage(String e_homepage) {
		this.e_homepage = e_homepage;
	}

	public int getStart_year() {
		return start_year;
	}

	public void setStart_year(int start_year) {
		this.start_year = start_year;
	}

	public int getE_enum() {
		return e_enum;
	}

	public void setE_enum(int e_enum) {
		this.e_enum = e_enum;
	}

	public String getE_listing() {
		return e_listing;
	}

	public void setE_listing(String e_listing) {
		this.e_listing = e_listing;
	}

	public int getE_capital() {
		return e_capital;
	}

	public void setE_capital(int e_capital) {
		this.e_capital = e_capital;
	}

	public int getE_sales() {
		return e_sales;
	}

	public void setE_sales(int e_sales) {
		this.e_sales = e_sales;
	}

	public String getE_scale() {
		return e_scale;
	}

	public void setE_scale(String e_scale) {
		this.e_scale = e_scale;
	}

	public String getE_licensefile() {
		return e_licensefile;
	}

	public void setE_licensefile(String e_licensefile) {
		this.e_licensefile = e_licensefile;
	}

	public String getE_check() {
		return e_check;
	}

	public void setE_check(String e_check) {
		this.e_check = e_check;
	}
	
	
}
