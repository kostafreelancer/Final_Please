package lancer.total.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.c_freelancerlist.domain.c_freelancerlist_totalVO;
import lancer.c_login.domain.c_login_freelancerVO;
import lancer.total.persistence.c_freelancerlistDAO;

@Service
public class c_freelancerlistServiceImpl implements c_freelancerlistService {
	@Inject
	c_freelancerlistDAO dao;
	@Override
	public List<c_freelancerlist_totalVO> c_freelancerlist_select_basic() {
		System.out.println("여기 들어 오는거지?");
		List<c_freelancerlist_totalVO> list = dao.c_freelancerlist_select_basic();
		for(int i=0;i<list.size();i++){
			list.get(i).setList_career(dao.c_freelancerlist_select_career(list.get(i).getF_num()));
			list.get(i).setList_job(dao.c_freelancerlist_select_job(list.get(i).getF_num()));
			list.get(i).setList_portfolio(dao.c_freelancerlist_select_portfolio(list.get(i).getF_num()));
			list.get(i).setList_school(dao.c_freelancerlist_select_school(list.get(i).getF_num()));
		}
		return list;
	}

}
