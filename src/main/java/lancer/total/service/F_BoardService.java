package lancer.total.service;

import java.util.List;


import lancer.f_board.domain.F_BoardVO;
import lancer.f_board.domain.F_Criteria;
import lancer.f_board.domain.F_SearchCriteria;

public interface F_BoardService {
	
	public void regist(F_BoardVO board)throws Exception;
	
	public F_BoardVO read(Integer f_board_num)throws Exception;
	
	public void modify(F_BoardVO board)throws Exception;
	
	public void remove(Integer f_board_num)throws Exception;
	
	public List<F_BoardVO> listAll() throws Exception;
	
	public List<F_BoardVO> listCriteria(F_SearchCriteria cri)throws Exception;
	
	public int listCountCriteria(F_SearchCriteria cri) throws Exception;
	
	//public List<String> getAttach(Integer bno) throws Exception;
}
