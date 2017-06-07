package lancer.total.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import lancer.total.persistence.C_DropDAO;

@Service
public class C_DropService {
	@Inject
	private C_DropDAO dao;
	
	public void deleteFreelancer(int f_num) throws Exception {
		dao.deleteCalendar(f_num);
		dao.deleteF_job(f_num);
		dao.deletePortfolio(f_num);
		dao.deleteCareer(f_num);
		dao.deleteSchool(f_num);
		dao.deleteCertificate(f_num);
		dao.deleteAccounting(f_num);
		dao.deleteF_grade(f_num);
		dao.deleteFreelancerAsk(f_num);
		dao.deleteFreelancer(f_num);
	}
	
	public void deleteProject(int e_pr_num) throws Exception {
		Integer c_num = dao.selectContract(e_pr_num);
		if(c_num != null){
			dao.deleteContractSheet(c_num);
		}
		dao.deleteContract(e_pr_num);
		dao.deleteP_job(e_pr_num);
		dao.deleteProject(e_pr_num);
	}
	
	public void deleteEnterprise(int e_num) throws Exception {
		dao.deleteE_grade(e_num);
		dao.deleteEnterpriseAsk(e_num);
		// 해당 기업의 모집중, 진행중 프로젝트 삭제
		List<Integer> e_pr_nums = dao.selectProjects(e_num);
		System.out.println(e_pr_nums);
		for(int i=0; i<e_pr_nums.size(); i++){
			deleteProject(e_pr_nums.get(i));
		}
		dao.deleteEnterprise(e_num);
	}
	
	
}
