package lancer.total.service;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import lancer.total.persistence.C_AlramDAO;

@Service
public class C_AlramService {

	@Inject
	private C_AlramDAO dao;
	
	public void insertAlramF(int f_num, int e_pr_num, String p_content) throws Exception {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("f_num", f_num);
		map.put("e_pr_num", e_pr_num);
		map.put("p_content", p_content);
		
		dao.insertAlramF(map);
	}
	
	public void insertAlramE(int e_num, int e_pr_num, String p_content) throws Exception {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("e_num", e_num);
		map.put("e_pr_num", e_pr_num);
		map.put("p_content", p_content);
		
		dao.insertAlramE(map);
	}
}
