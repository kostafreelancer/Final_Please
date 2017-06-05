package lancer.total.service;

import java.util.List;

import lancer.c_membercenter.domain.MembercenterASKVO;

public interface c_membercenterASKService {

	public void insertAsk(MembercenterASKVO vo) throws Exception;
	public List<MembercenterASKVO> myAskList(int num) throws Exception;
	public List<MembercenterASKVO> e_myAskList(int num) throws Exception;
}
