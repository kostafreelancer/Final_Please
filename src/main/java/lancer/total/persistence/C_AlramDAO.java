package lancer.total.persistence;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class C_AlramDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "lancer.mappers.c_alramMapper";
	
	public void insertAlramF(HashMap<String, Object> map) throws Exception {
		session.insert(namespace+".insertAlramF", map);
	}
	
	public void insertAlramE(HashMap<String, Object> map) throws Exception {
		session.insert(namespace+".insertAlramE", map);
	}
}
