package lancer.total.persistence;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.e_insertproject.domain.E_Insert;

@Repository
public class e_insertprojectDAOImpl implements e_insertprojectDAO {
	@Inject
	private SqlSession session;
		
    String namespace = "lancer.mappers.e_insertprojectMapper";
	
	public void  insertProject(E_Insert project)throws Exception{
		session.insert(namespace+".insertProject",project);
	}
		
	public int getnum()throws Exception{
		return session.selectOne(namespace+".getnum");
	}
	
	public void insertP_Job(Map<String, Integer> map)throws Exception{
		session.insert(namespace+".insertP_Job",map);
	}
		

}


