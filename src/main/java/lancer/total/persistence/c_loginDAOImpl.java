package lancer.total.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.c_login.domain.c_loginVO;
import lancer.c_login.domain.c_login_enterpriseVO;
import lancer.c_login.domain.c_login_freelancerVO;
@Repository
public class c_loginDAOImpl implements c_loginDAO {
	
	String namespace = "lancer.mappers.c_loginMapper";
	@Inject
	private SqlSession session;
	
	@Override
	public c_login_freelancerVO select_f_login(c_loginVO vo) {
		
		return session.selectOne(namespace+".select_f_login",vo);
	}
	@Override
	public c_login_enterpriseVO select_e_login(c_loginVO vo) {
		
		return session.selectOne(namespace+".select_e_login",vo);
	}
	
	
}
