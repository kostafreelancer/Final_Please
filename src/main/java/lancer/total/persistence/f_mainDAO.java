package lancer.total.persistence;

import java.util.List;

import lancer.f_main.domain.member;
import lancer.f_main.domain.recommendProject;

public interface f_mainDAO {

	public void getF_info(member m) throws Exception;
	public int countFreelancer() throws Exception;
	public int countProject() throws Exception;
	public List<recommendProject> recommendProject(int f_num) throws Exception;
}
