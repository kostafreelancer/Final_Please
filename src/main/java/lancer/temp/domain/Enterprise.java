package lancer.temp.domain;

import java.io.Serializable;

public class Enterprise implements Serializable{
	private int e_num;		// 기업번호
	private String e_id;		// 기업회원 아이디(접속할때)
	private String e_mail;	// 기업 이메일
	private String e_name;				// 가입자 명
	private String e_ename;			// 기업 이름
	private String e_regno;			// 사업자등록번호 ( 123-42322)
	private String e_phone;		// 기업 전화번호
	private String e_address;			// 기업 주소
	private String e_scale;			// 기업규모 (대기업, 중소기업, 개인)
	private String e_licensefile;		// 사업자등록증 사진파일 경로
	private String e_check;		// 이메일인증을 통한 가입승인여부   가입승인됬을시 1,  인증 아직 안했으면 0
	
	public Enterprise(){}

	public Enterprise(int e_num, String e_id, String e_mail, String e_name, String e_ename, String e_regno,
			String e_phone, String e_address, String e_scale, String e_licensefile, String e_check) {
		super();
		this.e_num = e_num;
		this.e_id = e_id;
		this.e_mail = e_mail;
		this.e_name = e_name;
		this.e_ename = e_ename;
		this.e_regno = e_regno;
		this.e_phone = e_phone;
		this.e_address = e_address;
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

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
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

	public String getE_address() {
		return e_address;
	}

	public void setE_address(String e_address) {
		this.e_address = e_address;
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
