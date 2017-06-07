package lancer.total.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.f_board.domain.F_BoardVO;

@Repository
public class F_BoardDAOImpl implements F_BoardDAO{

	@Inject
	private SqlSession session;

	private static String namespace = "lancer.mapper.f_boardMapper";
	
	@Override
	public void create(F_BoardVO vo) throws Exception {
		session.insert(namespace+".create", vo);
	}

	@Override
	public F_BoardVO read(Integer f_board_num) throws Exception {
		return session.selectOne(namespace+".read", f_board_num);
	}

	@Override
	public void update(F_BoardVO vo) throws Exception {
		session.update(namespace+".update", vo);
	}

	@Override
	public void delete(Integer f_board_num) throws Exception {
		session.delete(namespace+".delete", f_board_num);
	}

	@Override
	public List<F_BoardVO> listAll() throws Exception {
		return session.selectList(namespace+".listAll");
	}
	
	
}
