package lancer.total.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.f_board.domain.F_BoardVO;
import lancer.f_board.domain.F_Criteria;
import lancer.total.persistence.F_BoardDAO;

@Service
public class F_BoardServiceImpl implements F_BoardService{

	@Inject
	private F_BoardDAO dao;
	@Override
	public void regist(F_BoardVO board) throws Exception {
		dao.create(board);
	}

	@Override
	public F_BoardVO read(Integer f_board_num) throws Exception {
		return dao.read(f_board_num);
	}

	@Override
	public void modify(F_BoardVO board) throws Exception {
		dao.update(board);
	}

	@Override
	public void remove(Integer f_board_num) throws Exception {
		dao.delete(f_board_num);
	}

	@Override
	public List<F_BoardVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<F_BoardVO> listCriteria(F_Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	


}
