package lancer.total.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

public class verificationDAOImpl implements verificationDAO {

	@Inject
	private SqlSession session;
		
    String namespace = "lancer.mappers.verficationMapper";
    
	@Override
	public String verifying_freelancer_id(HashMap<String, String> map) throws Exception {
		
		return session.selectOne(namespace+".verifying_freelancer_id", map);
	}

	@Override
	public String verifying_freelancer_pwd(HashMap<String, String> map) throws Exception {
		
		return session.selectOne(namespace+"verifying_freelancer_pwd", map);
	}

	@Override
	public String verifying_enterprise_id(HashMap<String, String> map) throws Exception {
		
		return session.selectOne(namespace+"verifying_enterprise_id", map);
	}

	@Override
	public String verifying_enterprise_pwd(HashMap<String, String> map) throws Exception {
		
		return session.selectOne(namespace+"verifying_enterprise_pwd", map);
	}

}
