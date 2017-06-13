package lancer.c_join.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class E_join implements Serializable{
	private int e_num;		// 기업번호
	private String e_id;		// 기업회원 아이디(접속할때)
	private String e_pwd;	// 기업회원 비밀번호	(접속할때)
	private String e_mail;	// 기업 이메일
	private String e_mail1;	// 기업 이메일
	private String e_mail2;	// 기업 이메일
	private String e_name;				// 가입자 명
	private String e_ename;			// 기업 이름
	private String e_owner;		// 기업 대표자 명
	private String e_regno;			// 사업자등록번호 ( 123-42322)
	private String e_regno1;			// 사업자등록번호 ( 123-42322)
	private String e_regno2;			// 사업자등록번호 ( 123-42322)
	private String e_regno3;			// 사업자등록번호 ( 123-42322)
	private String e_phone;		// 기업 전화번호
	private String e_phone1;		// 기업 전화번호
	private String e_phone2;		// 기업 전화번호
	private String e_phone3;		// 기업 전화번호
	private String e_bf;					// 업무분야 텍스트
	private String manager_name;		// 담당자 이름
	private String manager_hphone;	// 담당자 핸드폰
	private String manager_hphone1;	// 담당자 핸드폰
	private String manager_hphone2;	// 담당자 핸드폰
	private String manager_hphone3;	// 담당자 핸드폰
	private String manager_mail;		// 담당자 이메일
	private String manager_mail1;		// 담당자 이메일
	private String manager_mail2;		// 담당자 이메일
	private String e_address;			// 기업 주소
	private String e_address1;			// 기업 주소
	private String e_address2;			// 기업 주소
	private String e_address3;			// 기업 주소
	private String e_homepage;			// 기업 홈페이지
	private int start_year;				// 기업 설립년도
	private int e_enum;				// 기업 사원 수
	private String e_listing;			// 상장여부   (상장, 비상장)
	private int e_capital;		// 자본금
	private int e_sales;		// 연매출
	private String e_scale;			// 기업규모 (대기업, 중소기업, 개인)
	private String e_check;		// 이메일인증을 통한 가입승인여부
	private double e_score;
	private MultipartFile e_ownerfile;	// 기업 대표자 사진파일 경로
	private MultipartFile e_licensefile;		// 사업자등록증 파일
	private String e_ownerfileExist;
	private String e_licensefileExist;
	
	
	public E_join(){
	}


	public E_join(int e_num, String e_id, String e_pwd, String e_mail, String e_mail1, String e_mail2, String e_name,
			String e_ename, String e_owner, String e_regno, String e_regno1, String e_regno2, String e_regno3,
			String e_phone, String e_phone1, String e_phone2, String e_phone3, String e_bf, String manager_name,
			String manager_hphone, String manager_hphone1, String manager_hphone2, String manager_hphone3,
			String manager_mail, String manager_mail1, String manager_mail2, String e_address, String e_address1,
			String e_address2, String e_address3, String e_homepage, int start_year, int e_enum, String e_listing,
			int e_capital, int e_sales, String e_scale, String e_check, double e_score, MultipartFile e_ownerfile,
			MultipartFile e_licensefile, String e_ownerfileExist, String e_licensefileExist) {
		super();
		this.e_num = e_num;
		this.e_id = e_id;
		this.e_pwd = e_pwd;
		this.e_mail = e_mail;
		this.e_mail1 = e_mail1;
		this.e_mail2 = e_mail2;
		this.e_name = e_name;
		this.e_ename = e_ename;
		this.e_owner = e_owner;
		this.e_regno = e_regno;
		this.e_regno1 = e_regno1;
		this.e_regno2 = e_regno2;
		this.e_regno3 = e_regno3;
		this.e_phone = e_phone;
		this.e_phone1 = e_phone1;
		this.e_phone2 = e_phone2;
		this.e_phone3 = e_phone3;
		this.e_bf = e_bf;
		this.manager_name = manager_name;
		this.manager_hphone = manager_hphone;
		this.manager_hphone1 = manager_hphone1;
		this.manager_hphone2 = manager_hphone2;
		this.manager_hphone3 = manager_hphone3;
		this.manager_mail = manager_mail;
		this.manager_mail1 = manager_mail1;
		this.manager_mail2 = manager_mail2;
		this.e_address = e_address;
		this.e_address1 = e_address1;
		this.e_address2 = e_address2;
		this.e_address3 = e_address3;
		this.e_homepage = e_homepage;
		this.start_year = start_year;
		this.e_enum = e_enum;
		this.e_listing = e_listing;
		this.e_capital = e_capital;
		this.e_sales = e_sales;
		this.e_scale = e_scale;
		this.e_check = e_check;
		this.e_score = e_score;
		this.e_ownerfile = e_ownerfile;
		this.e_licensefile = e_licensefile;
		this.e_ownerfileExist = e_ownerfileExist;
		this.e_licensefileExist = e_licensefileExist;
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


	public String getE_mail1() {
		return e_mail1;
	}


	public void setE_mail1(String e_mail1) {
		this.e_mail1 = e_mail1;
	}


	public String getE_mail2() {
		return e_mail2;
	}


	public void setE_mail2(String e_mail2) {
		this.e_mail2 = e_mail2;
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


	public String getE_regno() {
		return e_regno;
	}


	public void setE_regno(String e_regno) {
		this.e_regno = e_regno;
	}


	public String getE_regno1() {
		return e_regno1;
	}


	public void setE_regno1(String e_regno1) {
		this.e_regno1 = e_regno1;
	}


	public String getE_regno2() {
		return e_regno2;
	}


	public void setE_regno2(String e_regno2) {
		this.e_regno2 = e_regno2;
	}


	public String getE_regno3() {
		return e_regno3;
	}


	public void setE_regno3(String e_regno3) {
		this.e_regno3 = e_regno3;
	}


	public String getE_phone() {
		return e_phone;
	}


	public void setE_phone(String e_phone) {
		this.e_phone = e_phone;
	}


	public String getE_phone1() {
		return e_phone1;
	}


	public void setE_phone1(String e_phone1) {
		this.e_phone1 = e_phone1;
	}


	public String getE_phone2() {
		return e_phone2;
	}


	public void setE_phone2(String e_phone2) {
		this.e_phone2 = e_phone2;
	}


	public String getE_phone3() {
		return e_phone3;
	}


	public void setE_phone3(String e_phone3) {
		this.e_phone3 = e_phone3;
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


	public String getManager_hphone1() {
		return manager_hphone1;
	}


	public void setManager_hphone1(String manager_hphone1) {
		this.manager_hphone1 = manager_hphone1;
	}


	public String getManager_hphone2() {
		return manager_hphone2;
	}


	public void setManager_hphone2(String manager_hphone2) {
		this.manager_hphone2 = manager_hphone2;
	}


	public String getManager_hphone3() {
		return manager_hphone3;
	}


	public void setManager_hphone3(String manager_hphone3) {
		this.manager_hphone3 = manager_hphone3;
	}


	public String getManager_mail() {
		return manager_mail;
	}


	public void setManager_mail(String manager_mail) {
		this.manager_mail = manager_mail;
	}


	public String getManager_mail1() {
		return manager_mail1;
	}


	public void setManager_mail1(String manager_mail1) {
		this.manager_mail1 = manager_mail1;
	}


	public String getManager_mail2() {
		return manager_mail2;
	}


	public void setManager_mail2(String manager_mail2) {
		this.manager_mail2 = manager_mail2;
	}


	public String getE_address() {
		return e_address;
	}


	public void setE_address(String e_address) {
		this.e_address = e_address;
	}


	public String getE_address1() {
		return e_address1;
	}


	public void setE_address1(String e_address1) {
		this.e_address1 = e_address1;
	}


	public String getE_address2() {
		return e_address2;
	}


	public void setE_address2(String e_address2) {
		this.e_address2 = e_address2;
	}


	public String getE_address3() {
		return e_address3;
	}


	public void setE_address3(String e_address3) {
		this.e_address3 = e_address3;
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


	public String getE_check() {
		return e_check;
	}


	public void setE_check(String e_check) {
		this.e_check = e_check;
	}


	public double getE_score() {
		return e_score;
	}


	public void setE_score(double e_score) {
		this.e_score = e_score;
	}


	public MultipartFile getE_ownerfile() {
		return e_ownerfile;
	}


	public void setE_ownerfile(MultipartFile e_ownerfile) {
		this.e_ownerfile = e_ownerfile;
	}


	public MultipartFile getE_licensefile() {
		return e_licensefile;
	}


	public void setE_licensefile(MultipartFile e_licensefile) {
		this.e_licensefile = e_licensefile;
	}


	public String getE_ownerfileExist() {
		return e_ownerfileExist;
	}


	public void setE_ownerfileExist(String e_ownerfileExist) {
		this.e_ownerfileExist = e_ownerfileExist;
	}


	public String getE_licensefileExist() {
		return e_licensefileExist;
	}


	public void setE_licensefileExist(String e_licensefileExist) {
		this.e_licensefileExist = e_licensefileExist;
	}


	
}