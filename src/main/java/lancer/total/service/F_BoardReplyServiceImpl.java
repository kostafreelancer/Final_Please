package lancer.total.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.ognl.IteratorElementsAccessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lancer.f_board.domain.F_BoardVO;
import lancer.f_board.domain.F_Criteria;
import lancer.f_board.domain.F_ReplyVO;
import lancer.total.persistence.F_BoardDAO;
import lancer.total.persistence.F_BoardReplyDAO;

@Service
public class F_BoardReplyServiceImpl implements F_BoardReplyService{

	@Inject
	F_BoardReplyDAO replydao;

	
	@Override
	public List<F_ReplyVO> list(Integer board_num, String nowId, String oriId) throws Exception {
		F_BoardVO f_vo = new F_BoardVO();
		List<F_ReplyVO> items = replydao.list(board_num);
		System.out.println("쇽쇽쇽!!!!!!!");
		//비댓 확인
		for(int i=0; i<items.size(); i++){
			if(items.get(i).getSecretreply().equals("y")){
				if(nowId == null){
					items.get(i).setReply_content("비밀 댓글입니다.");
					System.out.println("비댓?");
			}else{
					String writer =oriId;
					String replyer = items.get(i).getF_id();
					if(!nowId.equals(writer) && !nowId.equals(replyer)){
						items.get(i).setReply_content("비밀 댓글입니다.");
						System.out.println("비댓?");
					}
		    	}
	    	}
		}
		return items;
	}

	@Override
	public void create(F_ReplyVO vo) throws Exception {
		replydao.create(vo);
	}

	@Override
	public void update(F_ReplyVO vo) throws Exception {
		replydao.update(vo);
	}

	@Override
	public void delete(Integer reply_num) throws Exception {
		replydao.delete(reply_num);
	}
	
	@Override
	public int count(int board_num) throws Exception {
		return replydao.count(board_num);
	}

	@Override
	public F_ReplyVO detail(Integer reply_num) throws Exception {
		return replydao.detail(reply_num);
	}

	
	
	
/*	@Inject
	private F_BoardReplyDAO replyDao;
	
	@Inject
	private F_BoardDAO boardDao;

	@Transactional
	@Override
	public void addReply(F_ReplyVO vo) throws Exception {
		replyDao.create(vo);
		boardDao.updateReplyCnt(vo.getBoard_num(), 1);
	}

	@Override
	public List<F_ReplyVO> listReply(Integer board_num) throws Exception {
		return replyDao.list(board_num);
	}

	@Override
	public List<F_ReplyVO> listReplyPage(Integer board_num, F_Criteria cri) throws Exception {
		return replyDao.listPage(board_num, cri);
	}

	@Override
	public void modifyReply(F_ReplyVO vo) throws Exception {
		replyDao.update(vo);
	}

	@Transactional
	@Override
	public void removeReply(Integer reply_num) throws Exception {
		int bno = replyDao.getBno(reply_num);
		replyDao.delete(reply_num);
		boardDao.updateReplyCnt(bno, -1);

	}

	@Override
	public int count(Integer board_num) throws Exception {
		return replyDao.count(board_num);
	}*/

	


}
