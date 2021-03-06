package lancer.total.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.c_login.domain.c_loginVO;
import lancer.c_login.domain.c_login_adminVO;
import lancer.c_login.domain.c_login_alramVO;
import lancer.c_login.domain.c_login_enterpriseVO;
import lancer.c_login.domain.c_login_freelancerVO;
import lancer.total.persistence.c_loginDAO;

@Service
public class c_loginServiceImpl implements c_loginService {

	@Inject
	private c_loginDAO dao;
	
	@Override
	public c_login_freelancerVO select_f_login(c_loginVO vo) {
		
		return dao.select_f_login(vo);
	}

	@Override
	public c_login_enterpriseVO select_e_login(c_loginVO vo) {
		
		return dao.select_e_login(vo);
	}

	@Override
	public c_login_adminVO select_a_login(c_loginVO vo) {
		
		return dao.select_a_login(vo);
	}

	@Override
	public c_login_enterpriseVO select_e_login_nocheck(c_loginVO vo) {

		return dao.select_e_login_nocheck(vo);
	}

	@Override
	public c_login_enterpriseVO select_e_login_idcheck(c_loginVO vo) {

		return dao.select_e_login_idcheck(vo);
	}

	@Override
	public c_login_freelancerVO select_f_login_idcheck(c_loginVO vo) {

		return dao.select_f_login_idcheck(vo);
	}

	@Override
	public int chang_check(int f_num) {
		System.out.println(f_num+"이게 f_num");
		return dao.chang_check(f_num);
	}

	@Override
	public List<c_login_alramVO> alram_contents(int f_num) {
		return dao.alram_contents(f_num);
	}

	@Override
	public void updateRecentLogin(int f_num) {
		dao.updateRecentLogin(f_num);
	}

	@Override
	public void updatef_nowstate(int f_num) {
		dao.updatef_nowstate(f_num);
	}

	@Override
	public int chang_check_e(int e_num) {
		return dao.chang_check_e(e_num);
	}

	@Override
	public List<c_login_alramVO> alram_contents_e(int e_num) {
		return dao.alram_contents_E(e_num);
	}
	
}
