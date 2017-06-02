package lancer.total.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.f_mypage.domain.ApplyProject;
import lancer.f_mypage.domain.Career;
import lancer.f_mypage.domain.Certificate;
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
	
	public void updateFreelancerInfo(Freelancer freelancer) throws Exception{
		dao.updateFreelancerInfo(freelancer);
	}
	
	public void deleteFreelancerJobInfo(int f_num) throws Exception{
		dao.deleteFreelancerJobInfo(f_num);
	}
	
}
