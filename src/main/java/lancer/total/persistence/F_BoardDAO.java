package lancer.total.persistence;

import java.util.List;

import lancer.f_board.domain.F_BoardVO;

public interface F_BoardDAO {
	public void create(F_BoardVO vo)throws Exception;
	
	public F_BoardVO read(Integer f_board_num)throws Exception;
	
	public void update(F_BoardVO vo)throws Exception;
	
	public void delete(Integer f_board_num)throws Exception;
	
	public List<F_BoardVO> listAll()throws Exception;
}
