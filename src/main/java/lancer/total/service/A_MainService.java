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
}
