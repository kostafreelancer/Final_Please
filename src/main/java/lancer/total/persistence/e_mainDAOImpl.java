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
	public Integer countFreelancer() throws Exception {
	
		return session.selectOne(namespace+".countFreelancer");
	}

	@Override
	public Integer countProject() throws Exception {
		
		return session.selectOne(namespace+".countProject");
	}

	@Override
	public Integer e_developer() throws Exception {
		
		return session.selectOne(namespace+".e_developer");
	}

	@Override
	public Integer e_designer() throws Exception {
		
		return session.selectOne(namespace+".e_designer");
	}

	@Override
	public Integer e_planner() throws Exception {
		
		return session.selectOne(namespace+".e_planner");
	}

	@Override
	public Integer development() throws Exception {
		
		return session.selectOne(namespace+".development");
	}

	@Override
	public Integer design() throws Exception {
		
		return session.selectOne(namespace+".design");
	}

	@Override
	public Integer planning() throws Exception {
		
		return session.selectOne(namespace+".planning");
	}

	

}
