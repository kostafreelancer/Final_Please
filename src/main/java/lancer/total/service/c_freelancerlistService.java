package lancer.total.service;

import java.util.List;

import lancer.c_freelancerlist.domain.c_freelancerlist_SearchCriteria;
import lancer.c_freelancerlist.domain.c_freelancerlist_totalVO;
import lancer.c_login.domain.c_login_freelancerVO;
import lancer.c_projectlist.domain.SearchCriteria;
import lancer.e_mypage.domain.Project;
import lancer.f_mypage.domain.Career;
import lancer.f_mypage.domain.Certificate;
import lancer.f_mypage.domain.Freelancer;
import lancer.f_mypage.domain.School;

public interface c_freelancerlistService {
	public List<c_freelancerlist_totalVO> c_freelancerlist_select_basic(c_freelancerlist_SearchCriteria cri);
	public Integer c_freelancerlist_totalCount(c_freelancerlist_SearchCriteria cri);
	c_freelancerlist_totalVO selectFreelancer(Integer f_num) throws Exception;
	List<Integer> selectF_job(int f_num) throws Exception;
	List<Career> showCareerInfo(int f_num) throws Exception;
	List<School> showSchoolInfo(int f_num) throws Exception;
	List<Certificate> showCertiInfo(int f_num) throws Exception;
	List<Project> getMyFinishProject(int f_num) throws Exception;
	List<String> getProjectP_job(int e_pr_num) throws Exception;
}
