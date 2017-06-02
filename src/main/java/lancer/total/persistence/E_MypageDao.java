package lancer.total.persistence;


import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.c_login.domain.c_login_enterpriseVO;
import lancer.e_mypage.domain.Enterprise;
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
	
	public List<Project> listProjectReady(int e_num) throws Exception {
		return session.selectList(namespace + ".listProjectReady", e_num);
	}
	
	public List<Project> listProjectDoing(int e_num) throws Exception {
		return session.selectList(namespace + ".listProjectDoing", e_num);
	}
	
	public List<Project> listProjectDone(int e_num) throws Exception {
		return session.selectList(namespace + ".listProjectDone", e_num);
	}
	
	public Project selectProject(HashMap<String, Integer> map) throws Exception {
		return session.selectOne(namespace + ".selectProject", map);
	}
	
	public List<Integer> selectP_job(int e_pr_num) throws Exception {
		return session.selectList(namespace + ".selectP_job", e_pr_num);
	}

}
