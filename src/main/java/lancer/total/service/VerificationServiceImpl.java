package lancer.total.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.total.persistence.VerificationDAO;
import lancer.verification.domain.VerificationVO;

@Service
public class VerificationServiceImpl implements VerificationService {

	@Inject
	VerificationDAO verificationDao;
	
	@Override
	public String verifying_freelancer_id(VerificationVO veriVO) throws Exception {
		
		return verificationDao.verifying_freelancer_id(veriVO);
	}

	@Override
	public String verifying_enterprise_id(VerificationVO veriVO) throws Exception {
		
		return verificationDao.verifying_enterprise_id(veriVO);
	}
	
	@Override
	public String verifying_freelancer_pwd(VerificationVO veriVO) throws Exception {
		
		return verificationDao.verifying_freelancer_pwd(veriVO);
	}

	@Override
	public String verifying_enterprise_pwd(VerificationVO veriVO) throws Exception {
		
		return verificationDao.verifying_enterprise_pwd(veriVO);
	}

	@Override
	public Integer checking_freelancer(VerificationVO veriVO) throws Exception {
		
		return verificationDao.checking_freelancer(veriVO);
	}

	@Override
	public Integer checking_enterprise(VerificationVO veriVO) throws Exception {
		
		return verificationDao.checking_enterprise(veriVO);
	}
	

}
