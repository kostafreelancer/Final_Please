package lancer.total.service;

import lancer.verification.domain.VerificationVO;

public interface VerificationService {
	
	public String verifying_freelancer_id(VerificationVO veriVO)throws Exception;
	public String verifying_freelancer_pwd(VerificationVO veriVO)throws Exception;
	
	public String verifying_enterprise_id(VerificationVO veriVO)throws Exception;
	public String verifying_enterprise_pwd(VerificationVO veriVO)throws Exception;
	
	public Integer checking_freelancer(VerificationVO veriVO)throws Exception;
	public Integer checking_enterprise(VerificationVO veriVO)throws Exception;
	

}
