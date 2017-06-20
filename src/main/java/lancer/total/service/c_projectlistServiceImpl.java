package lancer.total.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.c_projectlist.domain.Contract;
import lancer.c_projectlist.domain.Criteria;
import lancer.c_projectlist.domain.SearchCriteria;
import lancer.c_projectlist.domain.SubmitVO;
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
		List<E_Insert> list = new ArrayList<E_Insert>();
		List<Integer> job_list =new ArrayList<Integer>();
		int count1 =0;
		int count2 =0;
		int count3=0;
		
		list = dao.listSearch(cri);
		for(int i=0;i<list.size();i++){
			job_list = dao.selectP_job(list.get(i).getE_pr_num());
			//프로젝트 번호로 분야를 배열로 가져온거
			for(int j=0;j<job_list.size();j++){ //그 분야 만큼 불러서 카운팅하고 
				if(job_list.get(j)<30){
					count1++;
				}else if(job_list.get(j)<41){
					count2++;
				}else{
					count3++;
				}
			}
			if(count1>count2&count1>count3){
				list.get(i).setP_field("개발");
			}else if(count2>count1&count2>count3){
				list.get(i).setP_field("디자인");
			}else if(count3>count1&count3>count2){
				list.get(i).setP_field("기획");
			}else{
				list.get(i).setP_field("공통");
			}
			count1=0;
			count2=0;
			count3=0;
		}
		
		
		return list;
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
	
	@Override
	public int getnum() throws Exception{
		return dao.getnum();
	}

	@Override
	public void insertContract(SubmitVO submitVO) throws Exception {
		dao.insertContract(submitVO);
		
	}
/*	@Override
	public List<Integer> selectEprnum() throws Exception {
		return dao.selectEprnum();
	}
	@Override
	public List<Integer> selectFnum() throws Exception {
		return dao.selectFnum();
	}*/
	@Override
	public int selectContract() throws Exception{
		return dao.selectContract();
	}
}
