package lancer.total.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.c_membercenter.domain.MemberCenterAnswerVO;
import lancer.c_membercenter.domain.MembercenterASKVO;
import lancer.total.persistence.c_membercenterASKDAO;

@Service
public class c_membercenterASKServiceImpl implements c_membercenterASKService {

	
	@Inject
	private c_membercenterASKDAO dao;
	
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
	public void readUpdate(int asknum) throws Exception{
		dao.readUpdate(asknum);
	}
}
