package lancer.f_mypage.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Certificate implements Serializable{
	private int certificate_num;
	private int f_num;
	private String certificate_name;
	private String organization;
	private String accept_date;
	
	public Certificate(){}
	
	public Certificate(int certificate_num, int f_num, String certificate_name, String organization,
			String accept_date) {
		super();
		this.certificate_num = certificate_num;
		this.f_num = f_num;
		this.certificate_name = certificate_name;
		this.organization = organization;
		this.accept_date = accept_date;
	}

	public int getCertificate_num() {
		return certificate_num;
	}

	public void setCertificate_num(int certificate_num) {
		this.certificate_num = certificate_num;
	}

	public int getF_num() {
		return f_num;
	}

	public void setF_num(int f_num) {
		this.f_num = f_num;
	}

	public String getCertificate_name() {
		return certificate_name;
	}

	public void setCertificate_name(String certificate_name) {
		this.certificate_name = certificate_name;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getAccept_date() {
		return accept_date;
	}

	public void setAccept_date(String accept_date) {
		this.accept_date = accept_date;
	}
	
}
