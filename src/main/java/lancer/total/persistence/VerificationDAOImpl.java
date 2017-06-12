package lancer.total.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class VerificationDAOImpl implements VerificationDAO {

	@Inject
	private SqlSession session;
		
    String namespace = "lancer.mappers.verificationMapper";
    
	@Override
	public String verifying_freelancer_id(HashMap<String, String> map) throws Exception {
	
		return session.selectOne(namespace+".verifying_freelancer_id", map);
	}
	@Override
	public String verifying_enterprise_id(HashMap<String, String> map) throws Exception {
		
		return session.selectOne(namespace+".verifying_enterprise_id", map);
	}

	@Override
	public String verifying_freelancer_pwd(HashMap<String, String> map) throws Exception {
		System.out.println("DAO 프리랜서 비번 : "+session.selectOne(namespace+".verifying_freelancer_pwd", map));
		return session.selectOne(namespace+".verifying_freelancer_pwd", map);
	}
	
	@Override
	public String verifying_enterprise_pwd(HashMap<String, String> map) throws Exception {
		
		return session.selectOne(namespace+".verifying_enterprise_pwd", map);
	}

	@Override
	public Integer checking_freelancer(HashMap<String, String> map) throws Exception {
		
		return session.selectOne(namespace+".checking_freelancer", map);
	}

	@Override
	public Integer checking_enterprise(HashMap<String, String> map) throws Exception {
		
		return session.selectOne(namespace+".checking_enterprise", map);
	}

}
