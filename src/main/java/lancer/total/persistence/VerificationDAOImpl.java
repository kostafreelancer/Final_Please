package lancer.total.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.verification.domain.VerificationVO;

@Repository
public class VerificationDAOImpl implements VerificationDAO {

	@Inject
	private SqlSession session;
		
    String namespace = "lancer.mappers.verificationMapper";
    
	@Override
	public String verifying_freelancer_id(VerificationVO veriVO) throws Exception {
	
		return session.selectOne(namespace+".verifying_freelancer_id", veriVO);
	}
	@Override
	public String verifying_enterprise_id(VerificationVO veriVO) throws Exception {
		
		return session.selectOne(namespace+".verifying_enterprise_id", veriVO);
	}

	@Override
	public String verifying_freelancer_pwd(VerificationVO veriVO) throws Exception {
		
		return session.selectOne(namespace+".verifying_freelancer_pwd", veriVO);
	}
	
	@Override
	public String verifying_enterprise_pwd(VerificationVO veriVO) throws Exception {
		System.out.println("디오에서 "+session.selectOne(namespace+".verifying_enterprise_pwd", veriVO));
		return session.selectOne(namespace+".verifying_enterprise_pwd", veriVO);
	}

	@Override
	public Integer checking_freelancer(VerificationVO veriVO) throws Exception {
		
		return session.selectOne(namespace+".checking_freelancer", veriVO);
	}

	@Override
	public Integer checking_enterprise(VerificationVO veriVO) throws Exception {
		
		return session.selectOne(namespace+".checking_enterprise", veriVO);
	}

}
