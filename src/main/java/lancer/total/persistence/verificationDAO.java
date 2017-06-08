package lancer.total.persistence;

import java.util.HashMap;
import java.util.List;

public interface verificationDAO {
	
	public String verifying_freelancer_id(HashMap<String, String> map)throws Exception;
	public String verifying_freelancer_pwd(HashMap<String, String> map)throws Exception;

	public String verifying_enterprise_id(HashMap<String, String> map)throws Exception;
	public String verifying_enterprise_pwd(HashMap<String, String> map)throws Exception;
	
}
