package lancer.c_login.domain;

public class checking_identity {
	private c_login_freelancerVO free;
	private String identity;
	private c_login_enterpriseVO enter;
	public checking_identity(){}
	public checking_identity(c_login_freelancerVO free, String identity, c_login_enterpriseVO enter) {
		super();
		this.free = free;
		this.identity = identity;
		this.enter = enter;
	}
	public c_login_freelancerVO getFree() {
		return free;
	}
	public void setFree(c_login_freelancerVO free) {
		this.free = free;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public c_login_enterpriseVO getEnter() {
		return enter;
	}
	public void setEnter(c_login_enterpriseVO enter) {
		this.enter = enter;
	}
	
	
}
