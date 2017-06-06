package lancer.total.service;

import java.util.List;

import lancer.c_freelancerlist.domain.c_freelancerlist_totalVO;
import lancer.c_login.domain.c_login_freelancerVO;

public interface c_freelancerlistService {
	public List<c_freelancerlist_totalVO> c_freelancerlist_select_basic();
}
