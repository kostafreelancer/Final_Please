package lancer.total.persistence;

import java.util.List;

import lancer.c_freelancerlist.domain.c_freelancerlist_SearchCriteria;
import lancer.c_freelancerlist.domain.c_freelancerlist_careerVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_portfolioVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_schoolVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_searchVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_totalVO;
import lancer.c_login.domain.c_login_freelancerVO;
import lancer.c_projectlist.domain.Contract;
import lancer.c_projectlist.domain.SearchCriteria;
import lancer.c_projectlist.domain.SubmitVO;
import lancer.e_insertproject.domain.E_Insert;
import lancer.e_mypage.domain.Project;
import lancer.f_mypage.domain.ApplyProject;
import lancer.f_mypage.domain.Career;
import lancer.f_mypage.domain.Certificate;
import lancer.f_mypage.domain.Freelancer;
import lancer.f_mypage.domain.NowProject;
import lancer.f_mypage.domain.Portfolio;
import lancer.f_mypage.domain.School;

public interface c_freelancerlistDAO {
	public List<c_freelancerlist_totalVO> c_freelancerlist_select_basic(c_freelancerlist_SearchCriteria cri) throws Exception;
	public List<c_freelancerlist_careerVO> c_freelancerlist_select_career(int f_num);
	public List<c_freelancerlist_portfolioVO> c_freelancerlist_select_portfolio(int f_num);
	public List<String> c_freelancerlist_select_job(int f_num);
	public List<c_freelancerlist_schoolVO> c_freelancerlist_select_school(int f_num);
	public Integer c_freelancerlist_totalCount(c_freelancerlist_SearchCriteria cri);
	c_freelancerlist_totalVO selectFreelancer(Integer f_num) throws Exception;
	List<Integer> selectF_job(int f_num) throws Exception;
	List<Career> showCareerInfo(int f_num) throws Exception;
	List<School> showSchoolInfo(int f_num) throws Exception;
	List<Certificate> showCertiInfo(int f_num) throws Exception;
	List<NowProject> getMyFinishProject(int f_num) throws Exception;
	List<String> getProjectP_job(int e_pr_num) throws Exception;
	int getnum() throws Exception;
	void insertContract(SubmitVO submitVO) throws Exception;
	List<E_Insert> getProject(int e_num) throws Exception;
	List<Portfolio> showPortfolioInfo(int f_num) throws Exception;
	Portfolio selectOnePortfolio(int portfolio_num) throws Exception;
	int getPortfolioNum() throws Exception;
	int selectCon(c_freelancerlist_searchVO vo) throws Exception;
}
