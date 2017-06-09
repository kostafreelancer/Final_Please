package lancer.total.persistence;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


@Repository
public class C_FileDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "lancer.mappers.c_fileMapper";
	
	public void insertFile(HashMap<String, Object> map) throws Exception {
		session.insert(namespace+".insertFile", map);
	}
	
	public void deleteFile(HashMap<String, Object> map) throws Exception {
		session.delete(namespace+".deleteFile", map);
	}
	
	public Integer selectFileNum(HashMap<String, Object> map) throws Exception {
		return session.selectOne(namespace+".selectFileNum", map);
	}
	
	public String selectFileName(HashMap<String, Object> map) throws Exception {
		return session.selectOne(namespace+".selectFileName", map);
	}
	
	public Integer selectFileSize(HashMap<String, Object> map) throws Exception {
		return session.selectOne(namespace+".selectFileSize", map);
	}

	public String selectFileOriginalNameByInt(int file_num) throws Exception {
		return session.selectOne(namespace+".selectFileOriginalNameByInt", file_num);
	}
		
	public String selectFileStoredNameByInt(int file_num) throws Exception {
		return session.selectOne(namespace+".selectFileStoredNameByInt", file_num);
	}
	
}
