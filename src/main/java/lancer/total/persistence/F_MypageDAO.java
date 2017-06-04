package lancer.total.persistence;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.f_mypage.domain.ApplyProject;
import lancer.f_mypage.domain.Calendar;
import lancer.f_mypage.domain.Career;
import lancer.f_mypage.domain.Certificate;
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
	
	public void updateFreelancerInfo(Freelancer freelancer) throws Exception{
		session.update(namespace + ".updateFreelancerInfo", freelancer);
	}
	
	public void deleteFreelancerJobInfo(int f_num) throws Exception{
		session.delete(namespace + ".deleteFreelancerJobInfo", f_num); 
	}
	
	public String getMyProjectName(int f_num) throws Exception{
		return session.selectOne(namespace + ".getMyProjectName", f_num);
	}
	
	public List<Calendar> getMySchedule(int f_num) throws Exception{
		return session.selectList(namespace + ".getMySchedule", f_num);
	}
	
	
}
