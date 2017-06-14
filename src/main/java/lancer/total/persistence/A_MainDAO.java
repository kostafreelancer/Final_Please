package lancer.total.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.a_main.domain.Enterprise;
import lancer.a_main.domain.Freelancer;
import lancer.a_main.domain.askList;

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
		return session.selectOne(namespace+".getF_mail", f_num);
	}
	
	//메일발송 관련 기업메일주소 불러오기
	public Enterprise getE_mail(int e_num) throws Exception{
		return session.selectOne(namespace + ".getE_mail", e_num);
	}
	
	//질문리스트
	public List<askList> askList() throws Exception{
		return session.selectList(namespace + ".askList");
	}
	
	public askList askcontents(int asknum) throws Exception{
		return session.selectOne(namespace + ".askcontents", asknum);
	}
	
	public void doAsk(askList al) throws Exception{
		session.selectOne(namespace + ".doAsk", al);
	}
	
	public List<askList> answerOK() throws Exception{
		return session.selectList(namespace + ".answerOK");
	}
}
