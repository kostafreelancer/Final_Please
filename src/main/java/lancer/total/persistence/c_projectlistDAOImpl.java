package lancer.total.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.c_projectlist.domain.Criteria;
import lancer.c_projectlist.domain.SearchCriteria;
import lancer.e_insertproject.domain.E_Insert;
import lancer.e_insertproject.domain.Enterprise;

@Repository
public class c_projectlistDAOImpl implements c_projectlistDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "lancer.mappers.c_projectlistMapper";	
	
	@Override
	public List<E_Insert> listAll() throws Exception {
		
		return session.selectList(namespace+".listAll");
	}

	@Override
	public List<E_Insert> listCriteria(Criteria cri) throws Exception {
		
		return session.selectList(namespace+".listAll",cri,new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}
	
	@Override
	public List<E_Insert> listSearch(SearchCriteria cri) throws Exception {
	
		return session.selectList(namespace+".listSearch", cri ,new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {

		return session.selectOne(namespace+".listSearchCount", cri);
	}
	
	@Override
	public int countPaging(Criteria cri) throws Exception {
		
		return session.selectOne(namespace+".countPaging");
	}
	
	@Override
	public E_Insert read(Integer e_pr_num) throws Exception {
		
		return session.selectOne(namespace+".read",e_pr_num);
	}
	
	@Override
	public Enterprise selectEnterprise(Integer e_num) throws Exception {
		return session.selectOne(namespace+".selectEnterprise",e_num);
	}
	
	
	@Override
	public List<Integer> selectP_job(int e_pr_num) throws Exception {
		return session.selectList(namespace + ".selectP_job", e_pr_num);
	}

}
