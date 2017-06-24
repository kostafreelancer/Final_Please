package lancer.total.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.c_login.domain.c_login_freelancerVO;
import lancer.e_mypage.domain.Project;
import lancer.f_mypage.domain.Accounting;
import lancer.f_mypage.domain.ApplyProject;
import lancer.f_mypage.domain.Calendar;
import lancer.f_mypage.domain.Career;
import lancer.f_mypage.domain.Certificate;
import lancer.f_mypage.domain.E_grade;
import lancer.f_mypage.domain.F_job;
import lancer.f_mypage.domain.Freelancer;
import lancer.f_mypage.domain.NowProject;
import lancer.f_mypage.domain.Portfolio;
import lancer.f_mypage.domain.School;
import lancer.total.persistence.F_MypageDAO;

@Service
public class F_MypageService {

	@Inject
	private F_MypageDAO dao;

	public Freelancer showFreelancerInfo(int f_num) throws Exception{
		return dao.showFreelancerInfo(f_num);
	}
	
	public List<Integer> showFreelancerJobInfo(int f_num) throws Exception{
		return dao.showFreelancerJobInfo(f_num);
	}
	
	public List<Career> showCareerInfo(int f_num) throws Exception {
		return dao.showCareerInfo(f_num);
	}
	
	public int getCareerNum() throws Exception{
		return dao.getCareerNum();
	}
	
	public void insertCareer(Career career) throws Exception{
		dao.insertCareer(career);
	}
	
	public void updateCareer(Career career) throws Exception{
		dao.updateCareer(career);
	}
	
	public void deleteCareer(int career_num) throws Exception{
		dao.deleteCareer(career_num);
	}
	
	public List<School> showSchoolInfo(int f_num) throws Exception{
		return dao.showSchoolInfo(f_num);
	}
	
	public int getSchoolNum() throws Exception{
		return dao.getSchoolNum();
	}
	
	public void insertSchool(School school) throws Exception{
		dao.insertSchool(school);
	}
	
	public void updateSchool(School school) throws Exception{
		dao.updateSchool(school);
	}
	
	public void deleteSchool(int school_num) throws Exception{
		dao.deleteSchool(school_num);
	}
	
	public List<Certificate> showCertiInfo(int f_num) throws Exception{
		return dao.showCertiInfo(f_num);
	}
	
	public int getCertiNum() throws Exception{
		return dao.getCertiNum();
	}
	
	public void insertCerti(Certificate certi) throws Exception{
		dao.insertCerti(certi);
	}
	
	public void updateCerti(Certificate certi) throws Exception{
		dao.updateCerti(certi);
	}
	
	public void deleteCerti(int certi_num) throws Exception{
		dao.deleteCerti(certi_num);
	}
	
	public List<ApplyProject> getApplyProject(int f_num) throws Exception{
		return dao.getApplyProject(f_num);
	}
	
	public void deleteApplyProject(int c_num) throws Exception{
		dao.deleteApplyProject(c_num);
	}
	
	public List<ApplyProject> getSuggestProject(int f_num) throws Exception{
		return dao.getSuggestProject(f_num);
	}
	
	public void rejectSuggestProject(int c_num) throws Exception{
		dao.rejectSuggestProject(c_num);
	}
	
	public String getFreelancerPassword(int f_num) throws Exception{
		return dao.getFreelancerPassword(f_num);
	}
	
	public void updateFreelancerInfo(c_login_freelancerVO original) throws Exception{
		dao.updateFreelancerInfo(original);
	}
	
	public void deleteFreelancerJobInfo(int f_num) throws Exception{
		dao.deleteFreelancerJobInfo(f_num);
	}
	
	public void insertFreelancerJobInfo(F_job f_job) throws Exception{
		dao.insertFreelancerJobInfo(f_job);
	}
	
	public NowProject getMyNowProject(int f_num) throws Exception{
		return dao.getMyNowProject(f_num);
	}
	
	public NowProject getMyMatchingProject(int f_num) throws Exception{
		return dao.getMyMatchingProject(f_num);
	}
	
	public List<NowProject> getMyFinishProject(int f_num) throws Exception{
		return dao.getMyFinishProject(f_num);
	}
	
	public List<String> getProjectP_job(int e_pr_num) throws Exception{
		return dao.getProjectP_job(e_pr_num);
	}
	
	public String getMyProjectName(int f_num) throws Exception{
		return dao.getMyProjectName(f_num);
	}
	
	public List<Calendar> getMySchedule(int f_num) throws Exception{
		return dao.getMySchedule(f_num);
	}
	
	public int getScheduleNum() throws Exception{
		return dao.getScheduleNum();
	}
	
	public void insertMySchedule(Calendar calen) throws Exception{
		dao.insertMySchedule(calen);
	}

	public void updateMySchedule(Calendar calen) throws Exception{
		dao.updateMySchedule(calen);
	}
	
	public void deleteMySchedule(Calendar calen) throws Exception{
		dao.deleteMySchedule(calen);
	}

	public List<Accounting> getSpendAccounting(int f_num) throws Exception{
		return dao.getSpendAccounting(f_num);
	}
	
	public List<Accounting> searchSpendList(HashMap<String, Object> searchDateMap) throws Exception{
		return dao.searchSpendList(searchDateMap);
	}
	
	public List<Accounting> searchIncomeList(HashMap<String, Object> searchDateMap) throws Exception{
		return dao.searchIncomeList(searchDateMap);
	}

	public int getSpendAccountingNum() throws Exception{
		return dao.getSpendAccountingNum();
	}
	public void insertSpendAccounting(Accounting accounting) throws Exception{
		dao.insertSpendAccounting(accounting);
	}
	
	public void updateSpendAccounting(Accounting accounting) throws Exception{
		dao.updateSpendAccounting(accounting);
	}
	
	public List<Accounting> getIncomeAccounting(int f_num) throws Exception{
		return dao.getIncomeAccounting(f_num);
	}	
	
	public int getAccounting_iden(int f_num) throws Exception{
		return dao.getAccounting_iden(f_num);
	}
	
	public Accounting selectOneAccounting(int a_num) throws Exception{
		return dao.selectOneAccounting(a_num);
	}
	
	public void deleteAccounting(int a_num) throws Exception{
		dao.deleteAccounting(a_num);
	}
	
	public List<Portfolio> showPortfolioInfo(int f_num) throws Exception{
		return dao.showPortfolioInfo(f_num);
	}
	
	public Portfolio selectOnePortfolio(int portfolio_num) throws Exception{
		return dao.selectOnePortfolio(portfolio_num);
	}
	
	public int getPortfolioNum() throws Exception{
		return dao.getPortfolioNum();
	}
	
	public void insertPortfolio(Portfolio portfolio) throws Exception{
		dao.insertPortfolio(portfolio);
	}
	public void updatePortfolio(Portfolio portfolio) throws Exception{
		dao.updatePortfolio(portfolio);
	}
	
	public void deletePortfolio(int portfolio_num) throws Exception{
		dao.deletePortfolio(portfolio_num);
	}
	
	public int getPortfolio_iden(int f_num) throws Exception{
		return dao.getPortfolio_iden(f_num);
	}
	
	public void suggestApply(HashMap<String, Integer> map) throws Exception{
		dao.suggestApply(map);
	}
	
	public void suggestReject(HashMap<String, Integer> map) throws Exception{
		dao.suggestReject(map);
	}
	
	public int evaluateCheck(HashMap<String, Integer> map) throws Exception{
		return dao.evaluateCheck(map);
	}
	
	public int countAllE_grade() throws Exception{
		return dao.countAllE_grade();
	}
	
	public void insertE_grade(E_grade e_grade) throws Exception{
		dao.insertE_grade(e_grade);
	}
	
	public double getAvgE_grade(int e_num) throws Exception{
		return dao.getAvgE_grade(e_num);
	}
	
	public void updateE_grade(HashMap<String, Object> map) throws Exception{
		dao.updateE_grade(map);
	}
	
	public String getF_id(int f_num) throws Exception{
		return dao.getF_id(f_num);
	}
}
