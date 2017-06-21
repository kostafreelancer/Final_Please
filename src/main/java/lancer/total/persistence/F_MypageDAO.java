package lancer.total.persistence;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.c_login.domain.c_login_freelancerVO;
import lancer.e_mypage.domain.Project;
import lancer.f_mypage.domain.Accounting;
import lancer.f_mypage.domain.ApplyProject;
import lancer.f_mypage.domain.Calendar;
import lancer.f_mypage.domain.Career;
import lancer.f_mypage.domain.Certificate;
import lancer.f_mypage.domain.F_job;
import lancer.f_mypage.domain.Freelancer;
import lancer.f_mypage.domain.NowProject;
import lancer.f_mypage.domain.Portfolio;
import lancer.f_mypage.domain.School;

@Repository
public class F_MypageDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "lancer.mapper.f_mypageMapper";

	public Freelancer showFreelancerInfo(int f_num) throws Exception {
		return session.selectOne(namespace + ".showFreelancerInfo", f_num);
	}
	
	public List<Integer> showFreelancerJobInfo(int f_num) throws Exception{
		return session.selectList(namespace + ".showFreelancerJobInfo", f_num);
	}
	
	public List<Career> showCareerInfo(int f_num) throws Exception{
		return session.selectList(namespace + ".showCareerInfo", f_num);
	}
	
	public int getCareerNum() throws Exception{
		return session.selectOne(namespace + ".getCareerNum");
	}
	
	public void insertCareer(Career career) throws Exception{
		session.insert(namespace + ".insertCareer", career);
	}
	
	public void updateCareer(Career career) throws Exception{
		session.update(namespace + ".updateCareer", career);
	}
	
	public void deleteCareer(int career_num) throws Exception{
		session.delete(namespace + ".deleteCareer", career_num);
	}
	
	public List<School> showSchoolInfo(int f_num) throws Exception{
		return session.selectList(namespace + ".showSchoolInfo", f_num);
	}
	
	public int getSchoolNum() throws Exception{
		return session.selectOne(namespace + ".getSchoolNum");
	}
	
	public void insertSchool(School school) throws Exception{
		session.insert(namespace + ".insertSchool", school);
	}
	
	public void updateSchool(School school) throws Exception{
		session.update(namespace + ".updateSchool", school);
	}
	
	public void deleteSchool(int school_num) throws Exception{
		session.delete(namespace + ".deleteSchool", school_num);
	}
	
	public List<Certificate> showCertiInfo(int f_num) throws Exception{
		return session.selectList(namespace + ".showCertiInfo", f_num);
	}
	
	public int getCertiNum() throws Exception{
		return session.selectOne(namespace + ".getCertiNum");
	}
	
	public void insertCerti(Certificate certi) throws Exception{
		session.insert(namespace + ".insertCerti", certi);
	}
	
	public void updateCerti(Certificate certi) throws Exception{
		session.update(namespace + ".updateCerti", certi);
	}
	
	public void deleteCerti(int certi_num) throws Exception{
		session.delete(namespace + ".deleteCerti", certi_num);
	}
	
	public List<ApplyProject> getApplyProject(int f_num) throws Exception{
		return session.selectList(namespace + ".getApplyProject", f_num);
	}
	
	public void deleteApplyProject(int c_num) throws Exception{
		session.delete(namespace + ".deleteApplyProject", c_num);
	}
	
	public List<ApplyProject> getSuggestProject(int f_num) throws Exception{
		return session.selectList(namespace + ".getSuggestProject", f_num);
	}
	
	public void rejectSuggestProject(int c_num) throws Exception{
		session.update(namespace + ".rejectSuggestProject", c_num);
	}
	
	public String getFreelancerPassword(int f_num) throws Exception{
		return session.selectOne(namespace + ".getFreelancerPassword", f_num);
	}
	
	public void updateFreelancerInfo(c_login_freelancerVO original) throws Exception{
		session.update(namespace + ".updateFreelancerInfo", original);
	}
	
	public void deleteFreelancerJobInfo(int f_num) throws Exception{
		session.delete(namespace + ".deleteFreelancerJobInfo", f_num); 
	}
	
	public void insertFreelancerJobInfo(F_job f_job) throws Exception{
		session.insert(namespace + ".insertFreelancerJobInfo", f_job);
	}
	
	public NowProject getMyNowProject(int f_num) throws Exception{
		return session.selectOne(namespace + ".getMyNowProject", f_num);
	}
	
	public List<Project> getMyFinishProject(int f_num) throws Exception{
		System.out.println(f_num);
		return session.selectList(namespace + ".getMyFinishProject", f_num);
	}
	
	public List<String> getProjectP_job(int e_pr_num) throws Exception{
		return session.selectList(namespace + ".getProjectP_job", e_pr_num);
	}
	
	public String getMyProjectName(int f_num) throws Exception{
		return session.selectOne(namespace + ".getMyProjectName", f_num);
	}
	
	public List<Calendar> getMySchedule(int f_num) throws Exception{
		return session.selectList(namespace + ".getMySchedule", f_num);
	}
	
	public int getScheduleNum() throws Exception{
		return session.selectOne(namespace + ".getScheduleNum");
	}
	
	public void insertMySchedule(Calendar calen) throws Exception{
		session.insert(namespace + ".insertMySchedule", calen);
	}
	
	public void updateMySchedule(Calendar calen) throws Exception{
		session.update(namespace + ".updateMySchedule", calen);		
	}
	
	public void deleteMySchedule(Calendar calen) throws Exception{
		session.delete(namespace + ".deleteMySchedule", calen);
	}
	
	public List<Accounting> getSpendAccounting(int f_num) throws Exception{
		return session.selectList(namespace + ".getSpendAccounting", f_num);
	}
	public int getSpendAccountingNum() throws Exception{
		return session.selectOne(namespace + ".getSpendAccountingNum");
	}
	public void insertSpendAccounting(Accounting accounting) throws Exception{
		session.insert(namespace + ".insertSpendAccounting", accounting);
	}
	
	public void updateSpendAccounting(Accounting accounting) throws Exception{
		session.update(namespace +".updateSpendAccounting", accounting);
	}
	
	public List<Accounting> getIncomeAccounting(int f_num) throws Exception{
		return session.selectList(namespace + ".getIncomeAccounting", f_num);
	}
	
	public List<Accounting> searchSpendList(HashMap<String, String> map) throws Exception{
		return session.selectList(namespace + ".searchSpendList", map);
	}
	
	public List<Accounting> searchIncomeList(HashMap<String, String> map) throws Exception{
		return session.selectList(namespace+ ".searchIncomeList", map);
	}
	
	public int getAccounting_iden(int f_num) throws Exception{
		return session.selectOne(namespace + ".getAccounting_iden", f_num);
	}
	
	public Accounting selectOneAccounting(int a_num) throws Exception{
		return session.selectOne(namespace + ".selectOneAccounting", a_num);
	}
	
	public void deleteAccounting(int a_num) throws Exception{
		session.delete(namespace + ".deleteAccounting", a_num);
	}
	
	public List<Portfolio> showPortfolioInfo(int f_num) throws Exception{
		return session.selectList(namespace + ".showPortfolioInfo", f_num);
	}
	
	public Portfolio selectOnePortfolio(int portfolio_num) throws Exception{
		return session.selectOne(namespace + ".selectOnePortfolio", portfolio_num);
	}
	
	public int getPortfolioNum() throws Exception{
		return session.selectOne(namespace + ".getPortfolioNum");
	}
	
	public void insertPortfolio(Portfolio portfolio) throws Exception{
		session.insert(namespace + ".insertPortfolio", portfolio);
	}
	
	public void updatePortfolio(Portfolio portfolio) throws Exception{
		session.update(namespace + ".updatePortfolio", portfolio);
	}
	
	public void deletePortfolio(int portfolio_num) throws Exception{
		session.delete(namespace + ".deletePortfolio", portfolio_num);
	}
	public int getPortfolio_iden(int f_num) throws Exception{
		return session.selectOne(namespace + ".getPortfolio_iden", f_num);
	}
	
	public void suggestApply(HashMap<String, Integer> map) throws Exception{
		session.update(namespace + ".suggestApply", map);
	}
	public void suggestReject(HashMap<String, Integer> map) throws Exception{
		session.update(namespace + ".suggestReject", map);
	}

}
