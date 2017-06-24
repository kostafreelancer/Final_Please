package lancer.total.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.c_login.domain.c_loginVO;
import lancer.c_login.domain.c_login_adminVO;
import lancer.c_login.domain.c_login_alramVO;
import lancer.c_login.domain.c_login_enterpriseVO;
import lancer.c_login.domain.c_login_freelancerVO;
@Repository
public class c_loginDAOImpl implements c_loginDAO {
	
	private static String namespace = "lancer.mappers.c_loginMapper";
	@Inject
	private SqlSession session;
	
	@Override
	public c_login_freelancerVO select_f_login(c_loginVO vo) {
		System.out.println(vo.getC_id()+"아이디야 아이디~~");
		return session.selectOne(namespace+".select_f_login",vo);
	}
	@Override
	public c_login_enterpriseVO select_e_login(c_loginVO vo) {
		
		return session.selectOne(namespace+".select_e_login",vo);
	}
	@Override
	public c_login_adminVO select_a_login(c_loginVO vo) {
		
		return session.selectOne(namespace+".select_a_login",vo);
	}
	@Override
	public c_login_enterpriseVO select_e_login_nocheck(c_loginVO vo) {
		
		return session.selectOne(namespace+".select_e_login_nocheck",vo);
	}
	@Override
	public c_login_enterpriseVO select_e_login_idcheck(c_loginVO vo) {

		return session.selectOne(namespace+".select_e_login_idcheck",vo);
	}
	@Override
	public c_login_freelancerVO select_f_login_idcheck(c_loginVO vo) {

		return session.selectOne(namespace+".select_f_login_idcheck",vo);
	}
	@Override
	public int chang_check(int f_num) {
		System.out.println(f_num+"이게 에프넘여기 안들어 오지? ");
		return session.selectOne(namespace+".chang_check",f_num);
	}
	@Override
	public List<c_login_alramVO> alram_contents(int f_num) {
		return session.selectList(namespace+".alram_contents",f_num);
	}
	@Override
	public void updateRecentLogin(int f_num) {
		session.update(namespace + ".updateRecentLogin", f_num);	
	}
	@Override
	public void updatef_nowstate(int f_num) {
		session.update(namespace + ".updatef_nowstate", f_num);
	}
	@Override
	public int chang_check_e(int e_num) {
		return session.selectOne(namespace+".chang_check_e",e_num);
	}
	@Override
	public List<c_login_alramVO> alram_contents_E(int e_num) {
		return session.selectList(namespace+".alram_contents_e",e_num);
	}
	
	
	
	
}
