package lancer.total.util;

import java.io.File;
import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	
	private String filePath = "C:\\lancer\\upload\\";	
     
    public HashMap<String, Object> parseInsertFileInfo(MultipartFile multipartFile, String section, int common_num) throws Exception{
         
        String original_file_name = null;
        String originalFileExtension = null;
        String stored_file_name = null;
        long file_size = 0;
        
        File file = new File(filePath);
        if(file.exists() == false){
            file.mkdirs();
        }

        original_file_name = multipartFile.getOriginalFilename();
        originalFileExtension = original_file_name.substring(original_file_name.lastIndexOf("."));
        stored_file_name = CommonUtils.getRandomString() + originalFileExtension;
        file_size = multipartFile.getSize();
        
        file = new File(filePath + stored_file_name);
        multipartFile.transferTo(file);
        
        
        HashMap<String, Object> map = new HashMap<String, Object>();
        
        map.put("section", section);
        map.put("common_num", common_num);
        map.put("original_file_name", original_file_name);
        map.put("stored_file_name", stored_file_name);
        map.put("file_size", file_size);
        
        System.out.println(filePath);       
        System.out.println("section: " + section);
        System.out.println("common_num: " + common_num);
        System.out.println("original_file_name: " + original_file_name);
        System.out.println("stored_file_name: " + stored_file_name);
        System.out.println("file_size: " + file_size);
        
        return map;
    }
}