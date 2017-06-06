package lancer.total.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.c_projectlist.domain.Criteria;
import lancer.c_projectlist.domain.SearchCriteria;
import lancer.e_insertproject.domain.E_Insert;
import lancer.e_insertproject.domain.Enterprise;
import lancer.total.persistence.c_projectlistDAO;

@Service
public class c_projectlistServiceImpl implements c_projectlistService {
	
	@Inject
	c_projectlistDAO dao;
	
	@Override
	public List<E_Insert> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<E_Insert> listCriteria(Criteria cri) throws Exception {
		
		return dao.listCriteria(cri);
	}
	
	@Override
	public List<E_Insert> listSearch(SearchCriteria cri) throws Exception {
		
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		
		return dao.listSearchCount(cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		
		return dao.countPaging(cri);
	}
	
	@Override
	public E_Insert read(Integer e_pr_num) throws Exception {
		return dao.read(e_pr_num);
	}
	
	@Override
	public Enterprise selectEnterprise(Integer e_num) throws Exception {
		return dao.selectEnterprise(e_num);
	}
	
	@Override
	public List<Integer> selectP_job(int e_pr_num) throws Exception {
		return dao.selectP_job(e_pr_num);
	}
	
	
}
