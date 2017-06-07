package lancer.total.service;

import java.util.List;

import lancer.f_board.domain.F_BoardVO;

public interface F_BoardService {
	
	public void regist(F_BoardVO board)throws Exception;
	
	public F_BoardVO read(Integer f_board_num)throws Exception;
	
	public void modify(F_BoardVO board)throws Exception;
	
	public void remove(Integer f_board_num)throws Exception;
	
	public List<F_BoardVO> listAll() throws Exception;
}
