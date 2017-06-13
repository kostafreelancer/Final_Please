package lancer.total.service;

import lancer.c_login.domain.c_loginVO;
import lancer.c_login.domain.c_login_adminVO;
import lancer.c_login.domain.c_login_enterpriseVO;
import lancer.c_login.domain.c_login_freelancerVO;

public interface c_loginService {
	public c_login_freelancerVO select_f_login(c_loginVO vo);
	public c_login_enterpriseVO select_e_login(c_loginVO vo);
	public c_login_adminVO select_a_login(c_loginVO vo);
	public c_login_enterpriseVO select_e_login_nocheck(c_loginVO vo);
	public c_login_enterpriseVO select_e_login_idcheck(c_loginVO vo);
	public c_login_freelancerVO select_f_login_idcheck(c_loginVO vo);
	
}
