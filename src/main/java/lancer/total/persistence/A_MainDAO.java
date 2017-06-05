package lancer.total.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class A_MainDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "lancer.mappers.a_mainMapper";
	
	
}
