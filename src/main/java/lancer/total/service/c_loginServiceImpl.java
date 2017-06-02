package lancer.total.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.c_login.domain.c_loginVO;
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
	
}
