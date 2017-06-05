package lancer.total.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.c_projectlist.domain.Criteria;
import lancer.c_projectlist.domain.SearchCriteria;
import lancer.e_insertproject.domain.E_Insert;

@Repository
public class c_projectlistDAOImpl implements c_projectlistDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namepace = "lancer.mappers.c_projectlistMapper";	
	
	@Override
	public List<E_Insert> listAll() throws Exception {
		
		return session.selectList(namepace+".listAll");
	}

	@Override
	public List<E_Insert> listCriteria(Criteria cri) throws Exception {
		
		return session.selectList(namepace+".listAll",cri,new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}
	
	@Override
	public List<E_Insert> listSearch(SearchCriteria cri) throws Exception {
	
		return session.selectList(namepace+".listSearch", cri ,new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {

		return session.selectOne(namepace+".listSearchCount", cri);
	}
	
	@Override
	public int countPaging(Criteria cri) throws Exception {
		
		return session.selectOne(namepace+".countPaging");
	}
	
	@Override
	public E_Insert read(Integer e_pr_num) throws Exception {
		
		return session.selectOne(namepace+".read",e_pr_num);
	}

}
