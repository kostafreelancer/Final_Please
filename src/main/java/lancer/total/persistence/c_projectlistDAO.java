package lancer.total.persistence;

import java.util.HashMap;
import java.util.List;

import lancer.c_freelancerlist.domain.c_freelancerlist_searchVO;
import lancer.c_projectlist.domain.Contract;
import lancer.c_projectlist.domain.Criteria;
import lancer.c_projectlist.domain.SearchCriteria;
import lancer.c_projectlist.domain.SubmitVO;
import lancer.e_insertproject.domain.E_Insert;
import lancer.e_insertproject.domain.Enterprise;

public interface c_projectlistDAO {

	List<E_Insert> listAll() throws Exception;

	List<E_Insert> listCriteria(Criteria cri) throws Exception;

	int countPaging(Criteria cri) throws Exception;

	List<E_Insert> listSearch(SearchCriteria cri) throws Exception;

	int listSearchCount(SearchCriteria cri) throws Exception;

	E_Insert read(Integer e_pr_num) throws Exception;

	List<Integer> selectP_job(int e_pr_num) throws Exception;

	Enterprise selectEnterprise(Integer e_num) throws Exception;

	public int getnum()throws Exception;
	
	public void insertContract(SubmitVO submitVO) throws Exception;

	int selectCon(c_freelancerlist_searchVO vo) throws Exception;

	public int getRelation(HashMap<String, Integer> map) throws Exception;
	
	public int getRelation2(int e_pr_num) throws Exception;

	public double myEval(HashMap<String, Integer> map) throws Exception;
	
	public String getProjectName(int e_pr_num) throws Exception;
}
