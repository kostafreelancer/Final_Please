package lancer.total.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MatchingDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "lancer.mapper.matchingMapper";
	
}
