package lancer.total.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.a_main.domain.Enterprise;
import lancer.a_main.domain.Freelancer;

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
	
	public void deleteAccountF(int deleteF_num) throws Exception {
		session.delete(namespace+".deleteAccountF", deleteF_num);
	}
	
	public void deleteAccountE(int deleteE_num) throws Exception {
		session.delete(namespace+".deleteAccountE", deleteE_num);
	}
	
	public void permitAccount(int permitE_num) throws Exception {
		session.update(namespace+".permitAccount", permitE_num);
	}
	
	//메일발송 관련 회원메일주소 불러오기
	public Freelancer getF_mail(int f_num) throws Exception{
		return session.selectOne(namespace+".getF_mail" + f_num);
	}
}
