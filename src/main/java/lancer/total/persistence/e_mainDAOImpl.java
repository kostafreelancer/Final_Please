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

}
