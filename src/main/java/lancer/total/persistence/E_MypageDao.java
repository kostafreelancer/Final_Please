package lancer.total.persistence;


import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.c_login.domain.c_login_enterpriseVO;
import lancer.e_mypage.domain.Criteria;
import lancer.e_mypage.domain.Enterprise;
import lancer.e_mypage.domain.Member;
import lancer.e_mypage.domain.Project;



@Repository
public class E_MypageDao{

	@Inject
	private SqlSession session;
	
	private static String namespace = "lancer.mappers.e_mypageMapper";
	
	public Enterprise selectEnterprise(int e_num) throws Exception {
		return session.selectOne(namespace+".selectEnterprise", e_num);
	}
	
	public void updateEnterprise(c_login_enterpriseVO enterprise) throws Exception {
		session.update(namespace+".updateEnterprise", enterprise);
	}
	
	public List<Project> listProjectReady(int e_num, Criteria cri) throws Exception {
		return session.selectList(namespace + ".listProjectReady", e_num, new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}
	
	public List<Project> listProjectDoing(int e_num, Criteria cri) throws Exception {
		return session.selectList(namespace + ".listProjectDoing", e_num, new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}
	
	public List<Project> listProjectDone(int e_num, Criteria cri) throws Exception {
		return session.selectList(namespace + ".listProjectDone", e_num, new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}
	
	public Integer countProjectReady(int e_num) throws Exception{
		return session.selectOne(namespace + ".countProjectReady", e_num);
	}
	
	public Integer countProjectDoing(int e_num) throws Exception{
		return session.selectOne(namespace + ".countProjectDoing", e_num);
	}
	
	public Integer countProjectDone(int e_num) throws Exception{
		return session.selectOne(namespace + ".countProjectDone", e_num);
	}
	
	
	
	
	public Project selectProject(HashMap<String, Integer> map) throws Exception {
		return session.selectOne(namespace + ".selectProject", map);
	}
	
	public List<Integer> selectP_job(int e_pr_num) throws Exception {
		return session.selectList(namespace + ".selectP_job", e_pr_num);
	}
	
	public List<Member> selectMember(int e_pr_num, Criteria cri) throws Exception {
		return session.selectList(namespace + ".selectMember", e_pr_num, new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}
	
	public List<Member> selectApplicant(int e_pr_num, Criteria cri) throws Exception {
		return session.selectList(namespace + ".selectApplicant", e_pr_num, new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}
	
	public List<Member> selectScout(int e_pr_num, Criteria cri) throws Exception {
		return session.selectList(namespace + ".selectScout", e_pr_num, new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}
	
	public Integer countMember(int e_pr_num) throws Exception {
		return session.selectOne(namespace + ".countMember", e_pr_num);
	}
	
	public Integer countApplicant(int e_pr_num) throws Exception {
		return session.selectOne(namespace + ".countApplicant", e_pr_num);
	}
	
	public Integer countScout(int e_pr_num) throws Exception {
		return session.selectOne(namespace + ".countScout", e_pr_num);
	}
	
	
	public void acceptApplicant(HashMap<String, Integer> map) throws Exception {
		session.update(namespace + ".acceptApplicant", map);
	}
	
	public void rejectApplicant(HashMap<String, Integer> map) throws Exception {
		session.update(namespace + ".rejectApplicant", map);
	}
	
	public void cancelScout(HashMap<String, Integer> map) throws Exception {
		session.delete(namespace + ".cancelScout", map);
	}
	

	public Integer countSheet(int e_pr_num) throws Exception {
		return session.selectOne(namespace + ".countSheet", e_pr_num);
	}
	
	public void startProject(int e_pr_num) throws Exception {
		session.update(namespace + ".startProject", e_pr_num);
	}
	
	public void changeMemberDoing(int e_pr_num) throws Exception {
		session.update(namespace + ".changeMemberDoing", e_pr_num);
	}
	
	public void additionalRecruit(int e_pr_num) throws Exception {
		session.update(namespace + ".additionalRecruit", e_pr_num);
	}
	
	public void endProject(int e_pr_num) throws Exception {
		session.update(namespace + ".endProject", e_pr_num);
	}
	
	public void changeMemberDone(int e_pr_num) throws Exception {
		session.update(namespace + ".changeMemberDone", e_pr_num);
	}
	
	public Integer selectC_num(HashMap<String, Integer> map) throws Exception {
		return session.selectOne(namespace + ".selectC_num", map);
	}

}
