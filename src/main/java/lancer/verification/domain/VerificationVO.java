package lancer.verification.domain;

public class VerificationVO {
	
	String id;
	String name;
	String emailId;
	String emailDomain;
	String emailAddr;
	String sort;
	
	public VerificationVO() {}

	public VerificationVO(String id, String name, String emailId, String emailDomain, String sort) {
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.emailDomain = emailDomain;
		this.sort = sort;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmailDomain() {
		return emailDomain;
	}

	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}

	public String getEmailAddr() {
		return emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	

}
