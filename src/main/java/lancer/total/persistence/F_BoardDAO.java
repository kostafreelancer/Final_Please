package lancer.total.persistence;

import java.util.List;



import lancer.f_board.domain.F_BoardVO;
import lancer.f_board.domain.F_Criteria;
import lancer.f_board.domain.F_SearchCriteria;

public interface F_BoardDAO {
	public void create(F_BoardVO vo)throws Exception;
	
	public F_BoardVO read(Integer f_board_num)throws Exception;
	
	public void update(F_BoardVO vo)throws Exception;
	
	public void delete(Integer f_board_num)throws Exception;
	
	public List<F_BoardVO> listAll()throws Exception;
	
	public List<F_BoardVO> listCriteria(F_SearchCriteria cri)throws Exception;
	
	public int countPaging(F_SearchCriteria cri) throws Exception;
	
	public void updateReplyCnt(Integer f_board_num, int amount) throws Exception;
	
	public void updateViewCnt(Integer f_board_num) throws Exception;


	
	
/*	public void addAttach(String fileName) throws Exception;
	public List<String> getAttach(Integer bno) throws Exception;
	public void deleteAttach(Integer bno) throws Exception;
	public void replaceAttach(String fullName, Integer bno) throws Exception;*/
}
