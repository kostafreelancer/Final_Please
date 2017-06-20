package lancer.total.service;

import java.util.List;

import lancer.f_main.domain.alram;
import lancer.f_main.domain.member;
import lancer.f_main.domain.recommendProject;

public interface f_mainService {
	
	public void getF_info(member m) throws Exception;
	public int countFreelancer() throws Exception;
	public int countProject() throws Exception;
	public List<recommendProject> recommendProject(int f_num) throws Exception;
	public int f_create() throws Exception;
	public int f_design() throws Exception;
	public int f_planner() throws Exception;
	public int f_read(int f_num) throws Exception;
	public List<alram> alram(int f_num) throws Exception;
}
