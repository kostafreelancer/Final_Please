package lancer.total.persistence;

import java.util.List;

import lancer.c_freelancerlist.domain.c_freelancerlist_careerVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_portfolioVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_schoolVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_totalVO;
import lancer.c_login.domain.c_login_freelancerVO;

public interface c_freelancerlistDAO {
	public List<c_freelancerlist_totalVO> c_freelancerlist_select_basic();
	public List<c_freelancerlist_careerVO> c_freelancerlist_select_career(int f_num);
	public List<c_freelancerlist_portfolioVO> c_freelancerlist_select_portfolio(int f_num);
	public List<String> c_freelancerlist_select_job(int f_num);
	public List<c_freelancerlist_schoolVO> c_freelancerlist_select_school(int f_num);
	
}
