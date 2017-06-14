package lancer.total.persistence;

import lancer.verification.domain.VerificationVO;

public interface VerificationDAO {
	
	public String verifying_freelancer_id(VerificationVO veriVO)throws Exception;
	public String verifying_enterprise_id(VerificationVO veriVO)throws Exception;
	
	public String verifying_freelancer_pwd(VerificationVO veriVO)throws Exception;
	public String verifying_enterprise_pwd(VerificationVO veriVO)throws Exception;
	
	public Integer checking_freelancer(VerificationVO veriVO)throws Exception;
	public Integer checking_enterprise(VerificationVO veriVO)throws Exception;
	
}
