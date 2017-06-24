package lancer.total.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.c_freelancerlist.domain.c_freelancerlist_searchVO;
import lancer.c_projectlist.domain.Contract;
import lancer.c_projectlist.domain.Criteria;
import lancer.c_projectlist.domain.SearchCriteria;
import lancer.c_projectlist.domain.SubmitVO;
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
		
		if(cri.getJobs()!=null){
			String str[] = cri.getJobs();
			for(int i=0;i<cri.getJobs().length;i++){
				
				System.out.println(str[i]);
			}
		}
	
		System.out.println(	(session.selectList(namespace+".listSearch", cri ,new RowBounds(cri.getPageStart(),cri.getPerPageNum()))).size()+"이거 싸이즈");
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
	
	@Override
	public int getnum()throws Exception{
		return session.selectOne(namespace+".getnum");
	}

	@Override
	public void insertContract(SubmitVO submitVO) throws Exception {
		session.selectOne(namespace+".insertContract",submitVO);
		
	}

	@Override
	public int selectCon(c_freelancerlist_searchVO vo) throws Exception{
		return session.selectOne(namespace+".selectCon", vo);
	}

	@Override
	public int getRelation(HashMap<String, Integer> map) throws Exception {
		return session.selectOne(namespace + ".getRelation", map);
	}

	@Override
	public int getRelation2(int e_pr_num) throws Exception {
		return session.selectOne(namespace + ".getRelation2", e_pr_num);
	}

	@Override
	public double myEval(HashMap<String, Integer> map) throws Exception {
		return session.selectOne(namespace + ".myEval", map);
	}

	@Override
	public String getProjectName(int e_pr_num) throws Exception {
		return session.selectOne(namespace + ".getProjectName", e_pr_num);
	}

	

}
