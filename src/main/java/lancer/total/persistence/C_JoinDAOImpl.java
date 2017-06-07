package lancer.total.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.c_join.domain.E_join;
import lancer.c_join.domain.F_join;
import lancer.f_mypage.domain.F_job;


@Repository
public class C_JoinDAOImpl implements C_JoinDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace="lancer.mapper.c_joinMapper";

	@Override
	public void insertF_join(F_join  f_join) throws Exception {
		session.insert(namespace+".insertF_join", f_join);		
	}

	@Override
	public Integer getF_num() throws Exception {
		return session.selectOne(namespace+".getF_num");
	}

	@Override
	public List<String> getAllF_Id() throws Exception {
		return session.selectList(namespace + ".getAllF_Id");
	}

	@Override
	public void insertF_Job(F_job f_job) throws Exception {
		 session.insert(namespace+".insertF_Job", f_job);
	}

	@Override
	public void insertE_join(E_join e_join) throws Exception {
		session.insert(namespace+".insertE_join", e_join);
	}

	@Override
	public Integer getE_num() throws Exception {
		return session.selectOne(namespace+".getE_num");
	}

	@Override
	public List<String> getAllE_Id() throws Exception {
		return session.selectList(namespace + ".getAllE_Id");
	}

	@Override
	public int f_idcheck(String f_id) throws Exception {
	
		return session.selectOne(namespace+".f_idcheck", f_id);
	}

	@Override
	public int e_idcheck(String e_id) throws Exception {
		return session.selectOne(namespace+".e_idcheck", e_id);
	}
	
}
