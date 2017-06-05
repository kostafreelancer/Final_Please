package lancer.total.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.e_mypage.domain.Project;
import lancer.temp.domain.Enterprise;
import lancer.temp.domain.Freelancer;
import lancer.total.persistence.C_TempDAO;

@Service
public class C_TempService {
	
	@Inject
	private C_TempDAO dao;
	
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
