package lancer.total.persistence;

import java.util.List;

import lancer.c_membercenter.domain.MemberCenterAnswerVO;
import lancer.c_membercenter.domain.MembercenterASKVO;

public interface c_membercenterASKDAO {

	public void insertAsk(MembercenterASKVO vo) throws Exception;
	public List<MembercenterASKVO> myAskList(int num)throws Exception;
	public List<MembercenterASKVO> e_myAskList(int num)throws Exception;
	public List<MemberCenterAnswerVO> myAnswer(int asknum)throws Exception;
	public void readUpdate(int asknum) throws Exception;
	public List<MembercenterASKVO> myAskListOK(int num)throws Exception;
	public List<MembercenterASKVO> e_myAskListOK(int num)throws Exception;
}
