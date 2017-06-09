package lancer.total.service;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lancer.total.persistence.C_FileDAO;
import lancer.total.util.FileUtils;

@Service
public class C_FileService {
	@Inject
	private C_FileDAO dao;

	public void uploadFile(MultipartFile multipartFile, String section, int common_num) throws Exception {
		
		HashMap<String, Object> map = FileUtils.parseInsertFileInfo(multipartFile, section, common_num);
	
		dao.deleteFile(map);
		dao.insertFile(map);
	}
	
	public void uploadImageFile(MultipartFile multipartFile, String section, int common_num) throws Exception {
		
		HashMap<String, Object> map = FileUtils.parseInsertImageFileInfo(multipartFile, section, common_num);
		
		if(map == null){
			return;
		}
		
		dao.deleteFile(map);
		dao.insertFile(map);
	}
	
	public HashMap<String, Object> selectFile(String section, int common_num) throws Exception {
		HashMap<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("section", section);
		parameterMap.put("common_num", common_num);
		
		HashMap<String, Object> resultFileMap = new HashMap<String, Object>();
		resultFileMap.put("file_num", dao.selectFileNum(parameterMap));
		resultFileMap.put("original_file_name", dao.selectFileName(parameterMap));
		resultFileMap.put("file_size", dao.selectFileSize(parameterMap));
	     
	    return resultFileMap;
	}
	
	public HashMap<String, Object> selectFileInfo(int file_num) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("original_file_name", dao.selectFileOriginalNameByInt(file_num));
		map.put("stored_file_name", dao.selectFileStoredNameByInt(file_num));
	    return map;
	}
}
