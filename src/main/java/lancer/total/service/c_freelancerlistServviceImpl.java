package lancer.total.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.c_freelancerlist.domain.c_freelancerlist_total;
import lancer.total.persistence.c_freelancerlistDAO;

@Service
public class c_freelancerlistServviceImpl implements c_freelancerlistService {
	@Inject
	private static c_freelancerlistDAO dao;
	@Override
	public List<c_freelancerlist_total> c_freelancerlist_select_basic() {
		List<c_freelancerlist_total> list = dao.c_freelancerlist_select_basic();
		System.out.println(list.toString());
		return list;
	}

}
