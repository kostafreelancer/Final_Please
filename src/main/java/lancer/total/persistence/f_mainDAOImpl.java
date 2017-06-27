package lancer.total.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.f_main.domain.alram;
import lancer.f_main.domain.member;
import lancer.f_main.domain.recommendProject;

@Repository
public class f_mainDAOImpl implements f_mainDAO {

	
	@Inject
	private SqlSession session;
	
	private static String namespace = "lancer.mappers.f_mainMapper";

	@Override
	public void getF_info(member m) throws Exception{
		
		
		session.selectList(namespace + ".getF_info", m);
	}
	
	@Override
	public int countFreelancer() throws Exception{
		
		return session.selectOne(namespace + ".countFreelancer");
	}
	
	@Override
	public int countProject() throws Exception{
		
		return session.selectOne(namespace + ".countProject");
	}
	
	@Override
	public List<recommendProject> recommendProject(int f_num) throws Exception{
		
		return session.selectList(namespace + ".recommendProject", f_num);
	}
	
	@Override
	public int f_create() throws Exception{
		return session.selectOne(namespace + ".f_create");
	}
	
	@Override
	public int f_design() throws Exception{
		return session.selectOne(namespace + ".f_design");
	}
	
	@Override
	public int f_planner() throws Exception{
		return session.selectOne(namespace + ".f_planner");
	}

	@Override
	public int f_read(int f_num) throws Exception{
		return session.selectOne(namespace + ".f_read" , f_num);
	}
	
	@Override
	public List<alram> alram(int f_num) throws Exception{
		return session.selectList(namespace + ".alram" , f_num);
	}

	@Override
	public int countenterprise() throws Exception {
		
		return session.selectOne(namespace + ".countenterprise");
	}
}
