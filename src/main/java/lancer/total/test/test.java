package lancer.total.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lancer.total.persistence.F_MypageDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class test {
	
	@Inject
	private F_MypageDAO dao;
	
	@Test
	public void testTime() throws Exception{
		dao.selectOnePortfolio(1);
		
	}

}
