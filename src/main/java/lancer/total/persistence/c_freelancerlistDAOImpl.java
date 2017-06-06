package lancer.total.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.c_freelancerlist.domain.c_freelancerlist_careerVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_portfolioVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_schoolVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_totalVO;
import lancer.c_login.domain.c_login_freelancerVO;

@Repository
public class c_freelancerlistDAOImpl implements c_freelancerlistDAO{
	
	
	@Inject
	private SqlSession session;
	
	private static String namepace = "lancer.mappers.c_freelancerlistMapper";
	
	@Override
	public List<c_freelancerlist_totalVO> c_freelancerlist_select_basic() {
		
		/*List<c_freelancerlist_total> list = session.selectList(namepace+".c_freelancerlist_select_basic");
		System.out.println(list.size()+"리스트 사이즈 ");*/
		return session.selectList(namepace+".c_freelancerlist_select_basic");
	}

	@Override
	public List<c_freelancerlist_careerVO> c_freelancerlist_select_career(int f_num) {
	
		return session.selectList(namepace+".c_freelancerlist_select_career",f_num);
	}

	@Override
	public List<c_freelancerlist_portfolioVO> c_freelancerlist_select_portfolio(int f_num) {

		return session.selectList(namepace+".c_freelancerlist_select_portfolio",f_num);
	}

	@Override
	public List<String> c_freelancerlist_select_job(int f_num) {
		
		return session.selectList(namepace+".c_freelancerlist_select_job",f_num);
	}

	@Override
	public List<c_freelancerlist_schoolVO> c_freelancerlist_select_school(int f_num) {
		
		return session.selectList(namepace+".c_freelancerlist_select_school",f_num);
	}


}
