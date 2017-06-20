package lancer.total.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.a_main.domain.Criteria;
import lancer.a_main.domain.Enterprise;
import lancer.a_main.domain.Freelancer;
import lancer.a_main.domain.ProjectPermit;
import lancer.a_main.domain.askList;

@Repository
public class A_MainDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "lancer.mappers.a_mainMapper";
	
	public List<Freelancer> listFreelancer(Criteria cri) throws Exception {
		return session.selectList(namespace+".listFreelancer", cri, new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}
	
	public List<Enterprise> listEnterprise(Criteria cri) throws Exception {
		return session.selectList(namespace+".listEnterprise", cri, new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}
	
	public List<Enterprise> listEnterprisePermit(Criteria cri) throws Exception {
		return session.selectList(namespace+".listEnterprisePermit", cri, new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}
	
	public List<ProjectPermit> listProjectPermit(Criteria cri) throws Exception {
		return session.selectList(namespace+".listProjectPermit", cri, new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}
	
	public Integer countFreelancer() throws Exception {
		return session.selectOne(namespace+".countFreelancer");
	}
	
	public Integer countEnterprise() throws Exception {
		return session.selectOne(namespace+".countEnterprise");
	}
	
	public Integer countEnterprisePermit() throws Exception {
		return session.selectOne(namespace+".countEnterprisePermit");
	}
	
	public Integer countProjectPermit() throws Exception {
		return session.selectOne(namespace+".countProjectPermit");
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
	
	public void permitProject(int permitE_pr_num) throws Exception {
		session.update(namespace+".permitProject", permitE_pr_num);
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
	public List<askList> askList(Criteria cri) throws Exception{
		return session.selectList(namespace + ".askList", cri, new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}
	
	public Integer countAskList() throws Exception{
		return session.selectOne(namespace + ".countAskList");
	}
	
	public askList askcontents(int asknum) throws Exception{
		return session.selectOne(namespace + ".askcontents", asknum);
	}
	
	public void doAsk(askList al) throws Exception{
		session.selectOne(namespace + ".doAsk", al);
	}
	
	public List<askList> answerOK(Criteria cri) throws Exception{
		return session.selectList(namespace + ".answerOK", cri, new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}
	
	public Integer countAnswerOK() throws Exception{
		return session.selectOne(namespace+".countAnswerOK");
	}
}
