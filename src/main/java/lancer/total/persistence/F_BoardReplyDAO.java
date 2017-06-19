package lancer.total.persistence;

import java.util.List;

import lancer.f_board.domain.F_Criteria;
import lancer.f_board.domain.F_ReplyVO;

public interface F_BoardReplyDAO {
	
	public List<F_ReplyVO> list(Integer board_num)throws Exception;
	public void create(F_ReplyVO vo)throws Exception;
	public F_ReplyVO detail(Integer reply_num)throws Exception;
	public void update(F_ReplyVO vo)throws Exception;
	public void delete(Integer reply_num)throws Exception;
	public int count(int board_num)throws Exception;
/*	public List<F_ReplyVO> list(Integer board_num) throws Exception;
	public List<F_ReplyVO> listPage(Integer board_num, F_Criteria cri) throws Exception;
	public void create(F_ReplyVO vo) throws Exception;
	public void update(F_ReplyVO vo) throws Exception;
	public void delete(Integer reply_num) throws Exception;
	public int count(Integer board_num) throws Exception;
	public int getBno(Integer reply_num) throws Exception;*/
}
