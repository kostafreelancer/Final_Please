package lancer.total.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


@Repository
public class C_DropDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "lancer.mappers.c_dropMapper";
	
	public void deleteCalendar(int f_num) throws Exception {
		session.delete(namespace+".deleteCalendar", f_num);
	}
	public void deleteF_job(int f_num) throws Exception {
		session.delete(namespace+".deleteF_job", f_num);
	}
	public void deletePortfolio(int f_num) throws Exception {
		session.delete(namespace+".deletePortfolio", f_num);
	}
	public void deleteCareer(int f_num) throws Exception {
		session.delete(namespace+".deleteCareer", f_num);
	}
	public void deleteSchool(int f_num) throws Exception {
		session.delete(namespace+".deleteSchool", f_num);
	}
	public void deleteCertificate(int f_num) throws Exception {
		session.delete(namespace+".deleteCertificate", f_num);
	}
	public void deleteAccounting(int f_num) throws Exception {
		session.delete(namespace+".deleteAccounting", f_num);
	}
	public void deleteF_grade(int f_num) throws Exception {
		session.delete(namespace+".deleteF_grade", f_num);
	}
	public void deleteFreelancerAsk(int f_num) throws Exception {
		session.delete(namespace+".deleteFreelancerAsk", f_num);
	}
	public void deleteFreelancer(int f_num) throws Exception {
		session.delete(namespace+".deleteFreelancer", f_num);
	}
	
	public Integer selectContract(int e_pr_num) throws Exception {
		return session.selectOne(namespace+".selectContract", e_pr_num);
	}
	public void deleteContractSheet(int c_num) throws Exception {
		session.delete(namespace+".deleteContractSheet", c_num);
	}
	public void deleteContract(int e_pr_num) throws Exception {
		session.delete(namespace+".deleteContract", e_pr_num);
	}
	public void deleteP_job(int e_pr_num) throws Exception {
		session.delete(namespace+".deleteP_job", e_pr_num);
	}
	public void deleteProject(int e_pr_num) throws Exception {
		session.delete(namespace+".deleteProject", e_pr_num);
	}
	
	public void deleteE_grade(int e_num) throws Exception {
		session.delete(namespace+".deleteE_grade", e_num);
	}
	public void deleteEnterpriseAsk(int e_num) throws Exception {
		session.delete(namespace+".deleteEnterpriseAsk", e_num);
	}
	public List<Integer> selectProjects(int e_num) throws Exception {
		return session.selectList(namespace+".selectProjects", e_num);
	}
	public void deleteEnterprise(int e_num) throws Exception {
		session.delete(namespace+".deleteEnterprise", e_num);
	}
	
	
}
