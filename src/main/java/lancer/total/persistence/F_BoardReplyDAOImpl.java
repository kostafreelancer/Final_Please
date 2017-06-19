package lancer.total.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.f_board.domain.F_Criteria;
import lancer.f_board.domain.F_ReplyVO;

@Repository
public class F_BoardReplyDAOImpl implements F_BoardReplyDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace = "lancer.mapper.f_board_replyMapper";

	@Override
	public List<F_ReplyVO> list(Integer board_num) throws Exception {
		System.out.println("여기 들어오셧어요?");
		return session.selectList(namespace+".list", board_num);
	}

	@Override
	public void create(F_ReplyVO vo) throws Exception {
		session.insert(namespace+".create", vo);
	}

	@Override
	public void update(F_ReplyVO vo) throws Exception {
		session.update(namespace+".update", vo);
	}

	@Override
	public void delete(Integer reply_num) throws Exception {
		session.delete(namespace + ".delete", reply_num);
	}

	@Override
	public int count(int board_num) throws Exception {
		return session.selectOne(namespace+".count", board_num);
	}

	@Override
	public F_ReplyVO detail(Integer reply_num) throws Exception {
		return session.selectOne(namespace+".detail", reply_num);
	}
	
/*	@Override
	public List<F_ReplyVO> list(Integer board_num) throws Exception {
		return session.selectList(namespace + ".list", board_num);
	}

	@Override
	public List<F_ReplyVO> listPage(Integer board_num, F_Criteria cri) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("board_num", board_num);
		paramMap.put("cri", cri);
		return session.selectList(namespace + ".listPage", paramMap);
	}

	@Override
	public void create(F_ReplyVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public void update(F_ReplyVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer reply_num) throws Exception {
		session.delete(namespace + ".delete", reply_num);
		
	}

	@Override
	public int count(Integer board_num) throws Exception {
		return session.selectOne(namespace + ".count", board_num);
	}

	@Override
	public int getBno(Integer reply_num) throws Exception {
		return session.selectOne(namespace + ".getBno", reply_num);
	}*/
	
	
}
