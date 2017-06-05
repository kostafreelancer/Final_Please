package lancer.total.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.c_login.domain.c_login_enterpriseVO;
import lancer.e_mypage.domain.Enterprise;
import lancer.e_mypage.domain.Project;
import lancer.total.persistence.E_MypageDao;

@Service
public class E_MypageService{

	@Inject
	private E_MypageDao dao;
	
	public List<Project> listProjectReady(int e_num) throws Exception {
		return dao.listProjectReady(e_num);
	}
	
	public List<Project> listProjectDoing(int e_num) throws Exception {
		return dao.listProjectDoing(e_num);
	}
	
	public List<Project> listProjectDone(int e_num) throws Exception {
		return dao.listProjectDone(e_num);
	}
	
	public Project selectProject(HashMap<String, Integer> map) throws Exception {
		return dao.selectProject(map);
	}
	
	public List<Integer> selectP_job(int e_pr_num) throws Exception {
		return dao.selectP_job(e_pr_num);
	}

	public void updateEnterprise(c_login_enterpriseVO enterprise) throws Exception {
		dao.updateEnterprise(enterprise);
	}
	
	/*@Transactional
	@Override
	public void regist(BoardVO board) throws Exception {
		dao.create(board);
		
		FileVO vo = new FileVO();
		vo.setBno(dao.maxNum());
		
		String[] files = board.getFiles();
		
		if(files == null) {return; }
		
		for(String fileName : files){
			vo.setFullName(fileName);
			dao.addAttach(vo);
		}
	}

	@Transactional(isolation=Isolation.READ_COMMITTED)
	@Override
	public BoardVO read(Integer bno) throws Exception {
		dao.updateViewCnt(bno);
		return dao.read(bno);
	}

	@Transactional
	@Override
	public void modify(BoardVO board) throws Exception {
		dao.update(board);
		
		Integer bno = board.getBno();
		
		dao.deleteAttach(bno);
		
		String[] files = board.getFiles();
		
		if(files == null) {return; }
		
		for(String fileName : files){
			dao.replaceAttach(fileName, bno);
		}
	}

	@Transactional
	@Override
	public void remove(Integer bno) throws Exception {
		dao.deleteAttach(bno);
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public List<String> getAttach(Integer bno) throws Exception {
		return dao.getAttach(bno);
	}*/
	

}
