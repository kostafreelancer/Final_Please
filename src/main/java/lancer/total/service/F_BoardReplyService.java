package lancer.total.service;

import java.util.List;

import javax.inject.Inject;

import lancer.f_board.domain.F_Criteria;
import lancer.f_board.domain.F_ReplyVO;


public interface F_BoardReplyService {
	public List<F_ReplyVO> list(Integer board_num)throws Exception;
	public void create(F_ReplyVO vo)throws Exception;
	public void update(F_ReplyVO vo)throws Exception ;
	public void delete(Integer reply_num)throws Exception;
	public int count(int board_num) throws Exception;
/*	public void addReply(F_ReplyVO vo) throws Exception;
	public List<F_ReplyVO> listReply(Integer board_num) throws Exception;
	public List<F_ReplyVO> listReplyPage(Integer board_num, F_Criteria cri) throws Exception;
	public void modifyReply(F_ReplyVO vo) throws Exception;
	public void removeReply(Integer reply_num) throws Exception;
	public int count(Integer board_num) throws Exception;*/
}
