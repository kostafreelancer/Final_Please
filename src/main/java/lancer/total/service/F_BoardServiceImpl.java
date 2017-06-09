package lancer.total.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import lancer.f_board.domain.F_BoardVO;
import lancer.f_board.domain.F_Criteria;
import lancer.f_board.domain.F_SearchCriteria;
import lancer.total.persistence.F_BoardDAO;

@Service
public class F_BoardServiceImpl implements F_BoardService{

	@Inject
	private F_BoardDAO dao;
	
	@Transactional
	@Override
	public void regist(F_BoardVO board) throws Exception {
		dao.create(board);
/*		String[] files = board.getFiles();
		if(files == null){return;}
		for(String fileName : files){
			dao.addAttach(fileName);
		}*/
	}

	@Transactional(isolation=Isolation.READ_COMMITTED)
	@Override
	public F_BoardVO read(Integer f_board_num) throws Exception {
		dao.updateViewCnt(f_board_num);
		return dao.read(f_board_num);
	}

	@Override
	public void modify(F_BoardVO board) throws Exception {
		dao.update(board);
		
/*		Integer bno = board.getBno();
		dao.deleteAttach(bno);
		String[] files = board.getFiles();
		
		if(files==null){return;}
		for(String fileName : files){
			dao.replaceAttach(fileName, bno);
		}*/
	}

	@Override
	public void remove(Integer f_board_num) throws Exception {
		/*dao.deleteAttach(f_board_num);*/
		dao.delete(f_board_num);
	}

	@Override
	public List<F_BoardVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<F_BoardVO> listCriteria(F_SearchCriteria cri) throws Exception {
		return dao.listCriteria(cri);
	}
	
	@Override
	public int listCountCriteria(F_SearchCriteria cri) throws Exception {
		return dao.countPaging(cri);
	}

/*	@Override
	public List<String> getAttach(Integer bno) throws Exception {
		return dao.getAttach(bno);
	}*/

	


}
