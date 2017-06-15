package lancer.total.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lancer.f_board.domain.F_Criteria;
import lancer.f_board.domain.F_ReplyVO;
import lancer.total.persistence.F_BoardDAO;
import lancer.total.persistence.F_BoardReplyDAO;

@Service
public class F_BoardReplyServiceImpl implements F_BoardReplyService{

	@Inject
	F_BoardReplyDAO replydao;
	
	@Override
	public List<F_ReplyVO> list(Integer board_num) throws Exception {
		return replydao.list(board_num);
	}

	@Override
	public void create(F_ReplyVO vo) throws Exception {
		replydao.create(vo);
	}

	@Override
	public void update(F_ReplyVO vo) throws Exception {
		
	}

	@Override
	public void delete(Integer reply_num) throws Exception {
		
	}
	
	@Override
	public int count(int board_num) throws Exception {
		return replydao.count(board_num);
	}

	
	
	
/*	@Inject
	private F_BoardReplyDAO replyDao;
	
	@Inject
	private F_BoardDAO boardDao;

	@Transactional
	@Override
	public void addReply(F_ReplyVO vo) throws Exception {
		replyDao.create(vo);
		boardDao.updateReplyCnt(vo.getBoard_num(), 1);
	}

	@Override
	public List<F_ReplyVO> listReply(Integer board_num) throws Exception {
		return replyDao.list(board_num);
	}

	@Override
	public List<F_ReplyVO> listReplyPage(Integer board_num, F_Criteria cri) throws Exception {
		return replyDao.listPage(board_num, cri);
	}

	@Override
	public void modifyReply(F_ReplyVO vo) throws Exception {
		replyDao.update(vo);
	}

	@Transactional
	@Override
	public void removeReply(Integer reply_num) throws Exception {
		int bno = replyDao.getBno(reply_num);
		replyDao.delete(reply_num);
		boardDao.updateReplyCnt(bno, -1);

	}

	@Override
	public int count(Integer board_num) throws Exception {
		return replyDao.count(board_num);
	}*/

	


}
