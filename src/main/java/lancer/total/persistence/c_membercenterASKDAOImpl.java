package lancer.total.persistence;

import java.lang.reflect.Member;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.c_membercenter.domain.MembercenterASKVO;

@Repository
public class c_membercenterASKDAOImpl implements c_membercenterASKDAO {

	
	@Inject
	private SqlSession session;
	
	private static String namespace = "lancer.mappers.c_membercenterMapper";
	
	
	@Override
	public void insertAsk(MembercenterASKVO vo) throws Exception {
		
		session.insert(namespace + ".insertAsk", vo);
	}
	
	@Override
	public List<MembercenterASKVO> myAskList(int num) throws Exception{
		
		return session.selectList(namespace+".myAskList",num);
	}
	
	@Override
	public List<MembercenterASKVO> e_myAskList(int num) throws Exception{
		
		return session.selectList(namespace+".myAskList",num);
	}

}
