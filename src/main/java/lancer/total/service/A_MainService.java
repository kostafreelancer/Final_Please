package lancer.total.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.a_main.domain.Criteria;
import lancer.a_main.domain.Enterprise;
import lancer.a_main.domain.Freelancer;
import lancer.a_main.domain.ProjectPermit;
import lancer.a_main.domain.askList;
import lancer.total.persistence.A_MainDAO;
import lancer.total.persistence.c_membercenterASKDAO;
import lancer.total.persistence.c_membercenterASKDAOImpl;
import lancer.total.persistence.f_mainDAO;

@Service
public class A_MainService {
	@Inject
	private A_MainDAO dao;

	
	public List<Freelancer> listFreelancer(Criteria cri) throws Exception {
		return dao.listFreelancer(cri);
	}
	
	public List<Enterprise> listEnterprise(Criteria cri) throws Exception {
		return dao.listEnterprise(cri);
	}
	
	public List<Enterprise> listEnterprisePermit(Criteria cri) throws Exception {
		return dao.listEnterprisePermit(cri);
	}
	
	public List<ProjectPermit> listProjectPermit(Criteria cri) throws Exception {
		return dao.listProjectPermit(cri);
	}
	
	public Integer countFreelancer() throws Exception{
		return dao.countFreelancer();
	}
	
	public Integer countEnterprise() throws Exception{
		return dao.countEnterprise();
	}
	
	public Integer countEnterprisePermit() throws Exception{
		return dao.countEnterprisePermit();
	}
	
	public Integer countProjectPermit() throws Exception{
		return dao.countProjectPermit();
	}
	
	public void deleteAccountF(int deleteF_num) throws Exception {
		dao.deleteAccountF(deleteF_num);
	}
	
	public void deleteAccountE(int deleteE_num) throws Exception {
		dao.deleteAccountE(deleteE_num);
	}
	
	public void permitAccount(int permitE_num) throws Exception {
		dao.permitAccount(permitE_num);
	}
	
	public void permitProject(int permitE_pr_num) throws Exception {
		dao.permitProject(permitE_pr_num);
	}
	
	//프리랜서 이메일 얻어오기
	public Freelancer getF_mail(int f_num) throws Exception{
		return dao.getF_mail(f_num);
	}
	
	//기업 이메일 얻어오기
	public Enterprise getE_mail(int e_num) throws Exception{
		return dao.getE_mail(e_num);
	}
	
	public List<askList> askList(Criteria cri) throws Exception{
		return dao.askList(cri);
	}
	
	public Integer countAskList() throws Exception{
		return dao.countAskList();
	}
	
	public askList askcontents(int asknum) throws Exception{
		return dao.askcontents(asknum);
	}
	
	public void doAsk(askList al) throws Exception{
		 dao.doAsk(al);
		
	}
	
	public List<askList> answerOK(Criteria cri) throws Exception{
		return dao.answerOK(cri);
	}
	
	public Integer countAnswerOK() throws Exception{
		return dao.countAnswerOK();
	}
}
