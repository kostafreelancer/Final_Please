package lancer.total.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.c_join.domain.E_join;
import lancer.c_join.domain.F_join;
import lancer.f_mypage.domain.F_job;
import lancer.total.persistence.C_JoinDAO;

@Service
public class C_JoinServiceImpl implements C_JoinService{

	@Inject
	private C_JoinDAO dao;
	
	@Override
	public void insertF_join(F_join f_join) throws Exception {
		dao.insertF_join(f_join);
	}

	@Override
	public int getF_num() throws Exception {
		return dao.getF_num();
	}

	@Override
	public List<String> getAllF_Id() throws Exception {
		return dao.getAllF_Id();
	}

	@Override
	public int insertF_Job(F_job f_job) throws Exception {
		return dao.insertF_Job(f_job);
	}

	@Override
	public void insertE_join(E_join e_join) throws Exception {
		dao.insertE_join(e_join);
	}

	@Override
	public Integer getE_num() throws Exception {
		return dao.getE_num();
	}

	@Override
	public List<String> getAllE_Id() throws Exception {
		return dao.getAllE_Id();
	}

}
