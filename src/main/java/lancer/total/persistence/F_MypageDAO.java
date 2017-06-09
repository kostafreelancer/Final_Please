package lancer.total.persistence;

import java.sql.Date;
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
	public List<Accounting> getIncomeAccounting(int f_num) throws Exception{
		return session.selectList(namespace + ".getIncomeAccounting", f_num);
	}
	
}
