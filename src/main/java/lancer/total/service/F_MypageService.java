package lancer.total.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.c_login.domain.c_login_freelancerVO;
import lancer.f_mypage.domain.ApplyProject;
import lancer.f_mypage.domain.Calendar;
import lancer.f_mypage.domain.Career;
import lancer.f_mypage.domain.Certificate;
import lancer.f_mypage.domain.F_job;
import lancer.f_mypage.domain.Freelancer;
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
	
	public List<School> showSchoolInfo(int f_num) throws Exception{
		return dao.showSchoolInfo(f_num);
	}
	
	public List<Certificate> showCertiInfo(int f_num) throws Exception{
		return dao.showCertiInfo(f_num);
	}
	
	public List<ApplyProject> getApplyProject(int f_num) throws Exception{
		return dao.getApplyProject(f_num);
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

}
