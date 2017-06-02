package lancer.total.persistence;

import java.util.List;

import lancer.c_join.domain.E_join;
import lancer.c_join.domain.F_join;
import lancer.f_mypage.domain.F_job;

public interface C_JoinDAO {
	//프리랜서
	public void insertF_join(F_join f_join)throws Exception;
	public int getF_num()throws Exception;
	public List<String> getAllF_Id()throws Exception;
	public int insertF_Job(F_job f_job)throws Exception;
	//기업
	void insertE_join(E_join e_join)throws Exception;
	public Integer getE_num()throws Exception;
	public List<String> getAllE_Id()throws Exception;
}
