package lancer.total.persistence;

import lancer.f_main.domain.member;

public interface f_mainDAO {

	public void getF_info(member m) throws Exception;
	public int countFreelancer() throws Exception;
	public int countProject() throws Exception;
}
