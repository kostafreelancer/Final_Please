package lancer.total.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lancer.c_membercenter.domain.MemberCenterAnswerVO;
import lancer.c_membercenter.domain.MembercenterASKVO;
import lancer.total.persistence.c_membercenterASKDAO;
import lancer.total.persistence.f_mainDAO;

@Service
public class c_membercenterASKServiceImpl implements c_membercenterASKService {

	
	@Inject
	private c_membercenterASKDAO dao;
	@Inject
	private f_mainDAO dao2;
	
	@Override
	public void insertAsk(MembercenterASKVO vo) throws Exception {
		dao.insertAsk(vo);

	}
	
	@Override
	public List<MembercenterASKVO> myAskList(int num) throws Exception{
		return dao.myAskList(num);
	}
	
	@Override
	public List<MembercenterASKVO> e_myAskList(int num) throws Exception{
		return dao.e_myAskList(num);
	}
	
	@Override
	public List<MemberCenterAnswerVO> myAnswer(int asknum) throws Exception{
		return dao.myAnswer(asknum);
	}

	@Override
	@Transactional
	public void readUpdate(int asknum, int f_num) throws Exception{
		dao.readUpdate(asknum);
		dao2.alram(f_num);
		dao2.f_read(f_num);
	}
	
	@Override
	public List<MembercenterASKVO> myAskListOK(int num) throws Exception{
		return dao.myAskListOK(num);
	}
	
	@Override
	public List<MembercenterASKVO> e_myAskListOK(int num) throws Exception{
		return dao.e_myAskListOK(num);
	}
}
