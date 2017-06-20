package lancer.total.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lancer.c_freelancerlist.domain.c_freelancerlist_SearchCriteria;
import lancer.c_freelancerlist.domain.c_freelancerlist_careerVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_portfolioVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_schoolVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_totalVO;
import lancer.c_login.domain.c_login_freelancerVO;
import lancer.c_projectlist.domain.Contract;
import lancer.c_projectlist.domain.SearchCriteria;
import lancer.c_projectlist.domain.SubmitVO;
import lancer.e_insertproject.domain.E_Insert;
import lancer.e_mypage.domain.Project;
import lancer.f_mypage.domain.ApplyProject;
import lancer.f_mypage.domain.Career;
import lancer.f_mypage.domain.Certificate;
import lancer.f_mypage.domain.Freelancer;
import lancer.f_mypage.domain.Portfolio;
import lancer.f_mypage.domain.School;

@Repository
public class c_freelancerlistDAOImpl implements c_freelancerlistDAO{
	
	
	@Inject
	private SqlSession session;
	
	private static String namepace = "lancer.mappers.c_freelancerlistMapper";
	
	@Override
	public List<c_freelancerlist_totalVO> c_freelancerlist_select_basic(c_freelancerlist_SearchCriteria cri) throws Exception {
		
		/*List<c_freelancerlist_total> list = session.selectList(namepace+".c_freelancerlist_select_basic");
		System.out.println(list.size()+"리스트 사이즈 ");*/
		if(cri.getJobs()!=null){
			String str[] = cri.getJobs();
			for(int i=0;i<cri.getJobs().length;i++){
				
				System.out.println(str[i]+"이거다 제발쫌!");
			}
		}
		return session.selectList(namepace+".c_freelancerlist_select_basic",cri,new RowBounds(cri.getPageStart(),cri.getPerPageNum()));
	}

	@Override
	public List<c_freelancerlist_careerVO> c_freelancerlist_select_career(int f_num) {
	
		return session.selectList(namepace+".c_freelancerlist_select_career",f_num);
	}

	@Override
	public List<c_freelancerlist_portfolioVO> c_freelancerlist_select_portfolio(int f_num) {

		return session.selectList(namepace+".c_freelancerlist_select_portfolio",f_num);
	}

	@Override
	public List<String> c_freelancerlist_select_job(int f_num) {
		
		return session.selectList(namepace+".c_freelancerlist_select_job",f_num);
	}

	@Override
	public List<c_freelancerlist_schoolVO> c_freelancerlist_select_school(int f_num) {
		
		return session.selectList(namepace+".c_freelancerlist_select_school",f_num);
	}

	@Override
	public Integer c_freelancerlist_totalCount(c_freelancerlist_SearchCriteria cri) {
		return session.selectOne(namepace+".c_freelancerlist_totalCount",cri);
	}
	
    @Override
	public c_freelancerlist_totalVO selectFreelancer(Integer f_num) throws Exception{
		return session.selectOne(namepace + ".selectFreelancer",f_num);
	}
    
    @Override
    public List<Integer> selectF_job(int f_num) throws Exception{
    	return session.selectList(namepace+".selectF_job", f_num);
    }
    
    @Override
	public List<Career> showCareerInfo(int f_num) throws Exception{
		return session.selectList(namepace + ".showCareerInfo", f_num);
	}
    
    @Override
    public List<School> showSchoolInfo(int f_num) throws Exception{
		return session.selectList(namepace + ".showSchoolInfo", f_num);
	}
    
    @Override
    public List<Certificate> showCertiInfo(int f_num) throws Exception{
		return session.selectList(namepace + ".showCertiInfo", f_num);
	}
    
    @Override
    public List<Project> getMyFinishProject(int f_num) throws Exception{
		System.out.println(f_num);
		return session.selectList(namepace + ".getMyFinishProject", f_num);
	}
    
    @Override
    public List<String> getProjectP_job(int e_pr_num) throws Exception{
		return session.selectList(namepace + ".getProjectP_job", e_pr_num);
	}
    
    @Override
	public int getnum()throws Exception{
		return session.selectOne(namepace+".getnum");
	}

	@Override
	public void insertContract(SubmitVO submitVO) throws Exception {
		session.selectOne(namepace+".insertContract",submitVO);
		
	}
    
	@Override
	public List<E_Insert> getProject(int e_num) throws Exception {
	 return session.selectList(namepace+".getProject",e_num);
	}
	@Override
	public List<Portfolio> showPortfolioInfo(int f_num) throws Exception{
		return session.selectList(namepace + ".showPortfolioInfo", f_num);
	}
	@Override
	public Portfolio selectOnePortfolio(int portfolio_num) throws Exception{
		return session.selectOne(namepace + ".selectOnePortfolio", portfolio_num);
	}
	@Override
	public int getPortfolioNum() throws Exception{
		return session.selectOne(namepace + ".getPortfolioNum");
	}
	
	@Override
	public List<Contract> selectCon(int f_num) throws Exception{
		return session.selectList(namepace+".selectCon", f_num);
	}


}
