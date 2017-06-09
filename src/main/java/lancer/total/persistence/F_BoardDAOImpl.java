package lancer.total.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import lancer.f_board.domain.F_BoardVO;
import lancer.f_board.domain.F_Criteria;
import lancer.f_board.domain.F_SearchCriteria;

@Repository
public class F_BoardDAOImpl implements F_BoardDAO{

	@Inject
	private SqlSession session;

	private static String namespace = "lancer.mapper.f_boardMapper";
	
	@Override
	public void create(F_BoardVO vo) throws Exception {
		session.insert(namespace+".create", vo);
	}

	@Override
	public F_BoardVO read(Integer f_board_num) throws Exception {
		return session.selectOne(namespace+".read", f_board_num);
	}

	@Override
	public void update(F_BoardVO vo) throws Exception {
		session.update(namespace+".update", vo);
	}

	@Override
	public void delete(Integer f_board_num) throws Exception {
		session.delete(namespace+".delete", f_board_num);
	}

	@Override
	public List<F_BoardVO> listAll() throws Exception {
		return session.selectList(namespace+".listAll");
	}

/*	@Override
	public List<F_BoardVO> listPage(int page) throws Exception {
		if(page<=0){
			page=1;
		}
		page=(page-1)*10;
		return session.selectList(namespace+".listPage", page);
	}*/

	@Override
	public List<F_BoardVO> listCriteria(F_SearchCriteria cri) throws Exception {
		return session.selectList(namespace+".listAll", cri, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}
	
	@Override
	public int countPaging(F_SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public void updateReplyCnt(Integer f_board_num, int amount) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("f_board_num", f_board_num);
		paramMap.put("amount", amount);
		session.update(namespace + ".updateReplyCnt", paramMap);
		
	}

	@Override
	public void updateViewCnt(Integer bno) throws Exception {
		session.update(namespace + ".updateViewCnt", bno);
		
	}

/*	@Override
	public void addAttach(String fileName) throws Exception {
		session.insert(namespace + ".addAttach",fileName);
	}

	@Override
	public List<String> getAttach(Integer bno) throws Exception {
		return session.selectList(namespace + ".getAttach", bno);
	}

	@Override
	public void deleteAttach(Integer bno) throws Exception {
		session.delete(namespace + ".deleteAttach", bno);
	}

	@Override
	public void replaceAttach(String fullName, Integer bno) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bno", bno);
		paramMap.put("fullName", fullName);
		session.insert(namespace + ".replaceAttach", paramMap);
	}
	*/
}
