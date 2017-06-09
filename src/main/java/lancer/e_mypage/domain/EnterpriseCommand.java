package lancer.e_mypage.domain;

import org.springframework.web.multipart.MultipartFile;

public class EnterpriseCommand {

	private String e_pwd_1;	// 기업회원 비밀번호	(접속할때)
	private String e_pwd_2;	// 기업회원 비밀번호	(접속할때)
	private String e_mail_1;	// 기업 이메일
	private String e_mail_2;	// 기업 이메일
	private String e_name;				// 가입자 명
	private String e_ename;			// 기업 이름
	private String e_owner;		// 기업 대표자 명
	private String e_ownerfile;	// 기업 대표자 사진파일 경로
	private String e_regno_1;			// 사업자등록번호 ( 123-42322)
	private String e_regno_2;			// 사업자등록번호 ( 123-42322)
	private String e_regno_3;			// 사업자등록번호 ( 123-42322)
	private String e_phone_1;		// 기업 전화번호
	private String e_phone_2;		// 기업 전화번호
	private String e_phone_3;		// 기업 전화번호
	private String e_bf;					// 업무분야 텍스트
	private String manager_name;		// 담당자 이름
	private String manager_hphone_1;	// 담당자 핸드폰
	private String manager_hphone_2;	// 담당자 핸드폰
	private String manager_hphone_3;	// 담당자 핸드폰
	private String manager_mail_1;		// 담당자 이메일
	private String manager_mail_2;		// 담당자 이메일
	private String e_address_1;			// 기업 주소
	private String e_address_2;			// 기업 주소
	private String e_address_3;			// 기업 주소
	private String e_homepage;			// 기업 홈페이지
	private int start_year;				// 기업 설립년도
	private int e_enum;				// 기업 사원 수
	private String e_listing;			// 상장여부   (상장, 비상장)
	private int e_capital;		// 자본금
	private int e_sales;		// 연매출
	private String e_scale;			// 기업규모 (대기업, 중소기업, 개인)
	private MultipartFile e_licensefile;		// 사업자등록증 사진파일 경로
	private String fileExist;
	
	public EnterpriseCommand(){
		
	}
	
	public EnterpriseCommand(String e_pwd_1, String e_pwd_2, String e_mail_1, String e_mail_2, String e_name,
			String e_ename, String e_owner, String e_ownerfile, String e_regno_1, String e_regno_2, String e_regno_3,
			String e_phone_1, String e_phone_2, String e_phone_3, String e_bf, String manager_name,
			String manager_hphone_1, String manager_hphone_2, String manager_hphone_3, String manager_mail_1,
			String manager_mail_2, String e_address_1, String e_address_2, String e_address_3, String e_homepage,
			int start_year, int e_enum, String e_listing, int e_capital, int e_sales, String e_scale,
			MultipartFile e_licensefile, String fileExist) {
		super();
		this.e_pwd_1 = e_pwd_1;
		this.e_pwd_2 = e_pwd_2;
		this.e_mail_1 = e_mail_1;
		this.e_mail_2 = e_mail_2;
		this.e_name = e_name;
		this.e_ename = e_ename;
		this.e_owner = e_owner;
		this.e_ownerfile = e_ownerfile;
		this.e_regno_1 = e_regno_1;
		this.e_regno_2 = e_regno_2;
		this.e_regno_3 = e_regno_3;
		this.e_phone_1 = e_phone_1;
		this.e_phone_2 = e_phone_2;
		this.e_phone_3 = e_phone_3;
		this.e_bf = e_bf;
		this.manager_name = manager_name;
		this.manager_hphone_1 = manager_hphone_1;
		this.manager_hphone_2 = manager_hphone_2;
		this.manager_hphone_3 = manager_hphone_3;
		this.manager_mail_1 = manager_mail_1;
		this.manager_mail_2 = manager_mail_2;
		this.e_address_1 = e_address_1;
		this.e_address_2 = e_address_2;
		this.e_address_3 = e_address_3;
		this.e_homepage = e_homepage;
		this.start_year = start_year;
		this.e_enum = e_enum;
		this.e_listing = e_listing;
		this.e_capital = e_capital;
		this.e_sales = e_sales;
		this.e_scale = e_scale;
		this.e_licensefile = e_licensefile;
		this.fileExist = fileExist;
	}

	public String getE_pwd_1() {
		return e_pwd_1;
	}

	public void setE_pwd_1(String e_pwd_1) {
		this.e_pwd_1 = e_pwd_1;
	}

	public String getE_pwd_2() {
		return e_pwd_2;
	}

	public void setE_pwd_2(String e_pwd_2) {
		this.e_pwd_2 = e_pwd_2;
	}

	public String getE_mail_1() {
		return e_mail_1;
	}

	public void setE_mail_1(String e_mail_1) {
		this.e_mail_1 = e_mail_1;
	}

	public String getE_mail_2() {
		return e_mail_2;
	}

	public void setE_mail_2(String e_mail_2) {
		this.e_mail_2 = e_mail_2;
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

	public String getE_regno_1() {
		return e_regno_1;
	}

	public void setE_regno_1(String e_regno_1) {
		this.e_regno_1 = e_regno_1;
	}

	public String getE_regno_2() {
		return e_regno_2;
	}

	public void setE_regno_2(String e_regno_2) {
		this.e_regno_2 = e_regno_2;
	}

	public String getE_regno_3() {
		return e_regno_3;
	}

	public void setE_regno_3(String e_regno_3) {
		this.e_regno_3 = e_regno_3;
	}

	public String getE_phone_1() {
		return e_phone_1;
	}

	public void setE_phone_1(String e_phone_1) {
		this.e_phone_1 = e_phone_1;
	}

	public String getE_phone_2() {
		return e_phone_2;
	}

	public void setE_phone_2(String e_phone_2) {
		this.e_phone_2 = e_phone_2;
	}

	public String getE_phone_3() {
		return e_phone_3;
	}

	public void setE_phone_3(String e_phone_3) {
		this.e_phone_3 = e_phone_3;
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

	public String getManager_hphone_1() {
		return manager_hphone_1;
	}

	public void setManager_hphone_1(String manager_hphone_1) {
		this.manager_hphone_1 = manager_hphone_1;
	}

	public String getManager_hphone_2() {
		return manager_hphone_2;
	}

	public void setManager_hphone_2(String manager_hphone_2) {
		this.manager_hphone_2 = manager_hphone_2;
	}

	public String getManager_hphone_3() {
		return manager_hphone_3;
	}

	public void setManager_hphone_3(String manager_hphone_3) {
		this.manager_hphone_3 = manager_hphone_3;
	}

	public String getManager_mail_1() {
		return manager_mail_1;
	}

	public void setManager_mail_1(String manager_mail_1) {
		this.manager_mail_1 = manager_mail_1;
	}

	public String getManager_mail_2() {
		return manager_mail_2;
	}

	public void setManager_mail_2(String manager_mail_2) {
		this.manager_mail_2 = manager_mail_2;
	}

	public String getE_address_1() {
		return e_address_1;
	}

	public void setE_address_1(String e_address_1) {
		this.e_address_1 = e_address_1;
	}

	public String getE_address_2() {
		return e_address_2;
	}

	public void setE_address_2(String e_address_2) {
		this.e_address_2 = e_address_2;
	}

	public String getE_address_3() {
		return e_address_3;
	}

	public void setE_address_3(String e_address_3) {
		this.e_address_3 = e_address_3;
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

	public MultipartFile getE_licensefile() {
		return e_licensefile;
	}

	public void setE_licensefile(MultipartFile e_licensefile) {
		this.e_licensefile = e_licensefile;
	}

	public String getFileExist() {
		return fileExist;
	}

	public void setFileExist(String fileExist) {
		this.fileExist = fileExist;
	}
	
	
}


