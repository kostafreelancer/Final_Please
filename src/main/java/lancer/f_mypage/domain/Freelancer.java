package lancer.f_mypage.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class Freelancer implements Serializable{
	private int f_num;
	private String f_id;
	private String f_pwd;
	private String f_name;
	private String f_birth;
	private String f_sex;
	private String f_hphone;
	private String fm_phone1;
	private String fm_phone2;
	private String fm_phone3;
	private String f_phone;
	private String fm_tel1;
	private String fm_tel2;
	private String fm_tel3;
	private String f_email;
	private String fm_email11;
	private String fm_email12;
	private String f_address;
	private String fm_zip;
	private String fm_address;
	private String fm_address_etc;
	private String f_major;
	private String f_nowstate;
	private Timestamp f_recentlogin;
	private double f_score;
	private MultipartFile f_fname;
	private String f_photoExist;
	
	public String getF_photoExist() {
		return f_photoExist;
	}
	public void setF_photoExist(String f_photoExist) {
		this.f_photoExist = f_photoExist;
	}
	
	public MultipartFile getF_fname() {
		return f_fname;
	}
	public void setF_fname(MultipartFile f_fname) {
		this.f_fname = f_fname;
	}
	public double getF_score() {
		return f_score;
	}
	public void setF_score(double f_score) {
		this.f_score = f_score;
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
	public Timestamp getF_recentlogin() {
		return f_recentlogin;
	}
	public void setF_recentlogin(Timestamp f_recentlogin) {
		this.f_recentlogin = f_recentlogin;
	}

	public String getFm_phone1() {
		return fm_phone1;
	}
	public void setFm_phone1(String fm_phone1) {
		this.fm_phone1 = fm_phone1;
	}
	public String getFm_phone2() {
		return fm_phone2;
	}
	public void setFm_phone2(String fm_phone2) {
		this.fm_phone2 = fm_phone2;
	}
	public String getFm_phone3() {
		return fm_phone3;
	}
	public void setFm_phone3(String fm_phone3) {
		this.fm_phone3 = fm_phone3;
	}
	public String getFm_tel1() {
		return fm_tel1;
	}
	public void setFm_tel1(String fm_tel1) {
		this.fm_tel1 = fm_tel1;
	}
	public String getFm_tel2() {
		return fm_tel2;
	}
	public void setFm_tel2(String fm_tel2) {
		this.fm_tel2 = fm_tel2;
	}
	public String getFm_tel3() {
		return fm_tel3;
	}
	public void setFm_tel3(String fm_tel3) {
		this.fm_tel3 = fm_tel3;
	}
	public String getFm_email11() {
		return fm_email11;
	}
	public void setFm_email11(String fm_email11) {
		this.fm_email11 = fm_email11;
	}
	public String getFm_email12() {
		return fm_email12;
	}
	public void setFm_email12(String fm_email12) {
		this.fm_email12 = fm_email12;
	}
	public String getFm_zip() {
		return fm_zip;
	}
	public void setFm_zip(String fm_zip) {
		this.fm_zip = fm_zip;
	}
	public String getFm_address() {
		return fm_address;
	}
	public void setFm_address(String fm_address) {
		this.fm_address = fm_address;
	}
	public String getFm_address_etc() {
		return fm_address_etc;
	}
	public void setFm_address_etc(String fm_address_etc) {
		this.fm_address_etc = fm_address_etc;
	}
	
	
}
