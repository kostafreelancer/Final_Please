package lancer.total.persistence;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.c_login.domain.c_login_freelancerVO;
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
	
	public List<School> showSchoolInfo(int f_num) throws Exception{
		return session.selectList(namespace + ".showSchoolInfo", f_num);
	}
	
	public List<Certificate> showCertiInfo(int f_num) throws Exception{
		return session.selectList(namespace + ".showCertiInfo", f_num);
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
	
}
