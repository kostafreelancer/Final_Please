package lancer.total.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.c_freelancerlist.domain.c_freelancerlist_total;

@Repository
public class c_freelancerlistDAOImpl implements c_freelancerlistDAO{
	static final String namespace = "lancer.mappers.c_freelancerlistMapper";
	
	@Inject
	private SqlSession session;
	
	@Override
	public List<c_freelancerlist_total> c_freelancerlist_select_basic() {
		System.out.println("여기서 널포인트 나오는거냐?"+session.selectList(namespace+".c_freelancerlist_select_basic"));
		return session.selectOne(namespace+".c_freelancerlist_select_basic");
	}

}
