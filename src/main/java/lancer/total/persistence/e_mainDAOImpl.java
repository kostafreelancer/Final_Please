package lancer.total.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class e_mainDAOImpl implements e_mainDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "lancer.mappers.e_mainMapper";
	
	@Override
	public int countFreelancer() throws Exception {
	
		return session.selectOne(namespace+".countFreelancer");
	}

	@Override
	public int countProject() throws Exception {
		
		return session.selectOne(namespace+".countProject");
	}

	@Override
	public int e_developer() throws Exception {
		
		return session.selectOne(namespace+".e_developer");
	}

	@Override
	public int e_designer() throws Exception {
		
		return session.selectOne(namespace+".e_designer");
	}

	@Override
	public int e_planner() throws Exception {
		
		return session.selectOne(namespace+".e_planner");
	}

}
