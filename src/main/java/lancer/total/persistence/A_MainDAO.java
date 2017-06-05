package lancer.total.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.temp.domain.Enterprise;
import lancer.temp.domain.Freelancer;

@Repository
public class A_MainDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "lancer.mappers.a_mainMapper";
	
	public List<Freelancer> listFreelancer() throws Exception {
		return session.selectList(namespace+".listFreelancer");
	}
	
	public List<Enterprise> listEnterprise() throws Exception {
		return session.selectList(namespace+".listEnterprise");
	}
	
	public List<Enterprise> listEnterprisePermit() throws Exception {
		return session.selectList(namespace+".listEnterprisePermit");
	}	
}
