package lancer.total.service;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.total.persistence.VerificationDAO;

@Service
public class VerificationServiceImpl implements VerificationService {

	@Inject
	VerificationDAO verificationDao;
	
	@Override
	public String verifying_freelancer_id(HashMap<String, String> map) throws Exception {
		
		return verificationDao.verifying_enterprise_id(map);
	}

	@Override
	public String verifying_freelancer_pwd(HashMap<String, String> map) throws Exception {
		
		return verificationDao.verifying_enterprise_pwd(map);
	}

	@Override
	public String verifying_enterprise_id(HashMap<String, String> map) throws Exception {
		
		return verificationDao.verifying_freelancer_id(map);
	}

	@Override
	public String verifying_enterprise_pwd(HashMap<String, String> map) throws Exception {
		
		return verificationDao.verifying_freelancer_pwd(map);
	}

}
