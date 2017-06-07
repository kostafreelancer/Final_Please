package lancer.total.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.temp.domain.Enterprise;
import lancer.temp.domain.Freelancer;
import lancer.total.persistence.A_MainDAO;

@Service
public class A_MainService {
	@Inject
	private A_MainDAO dao;
	
	public List<Freelancer> listFreelancer() throws Exception {
		return dao.listFreelancer();
	}
	
	public List<Enterprise> listEnterprise() throws Exception {
		return dao.listEnterprise();
	}
	
	public List<Enterprise> listEnterprisePermit() throws Exception {
		return dao.listEnterprisePermit();
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
}
