package lancer.total.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	
	private static String uploadPath = "C:\\lancer\\upload\\";
     
    public static HashMap<String, Object> parseInsertFileInfo(MultipartFile multipartFile, String section, int common_num, int identy) throws Exception{
         
        String original_file_name = null;
        String originalFileExtension = null;
        String stored_file_name = null;
        long file_size = 0;
        
        File file = new File(uploadPath);
        if(file.exists() == false){
            file.mkdirs();
        }

        original_file_name = multipartFile.getOriginalFilename();
        originalFileExtension = original_file_name.substring(original_file_name.lastIndexOf("."));
        stored_file_name = CommonUtils.getRandomString() + originalFileExtension;
        file_size = multipartFile.getSize();
        
        file = new File(uploadPath + stored_file_name);
        multipartFile.transferTo(file);
        
        
        HashMap<String, Object> map = new HashMap<String, Object>();
        
        map.put("section", section);
        map.put("common_num", common_num);
        map.put("identy", identy);
        map.put("original_file_name", original_file_name);
        map.put("stored_file_name", stored_file_name);
        map.put("file_size", file_size);
        
        return map;
    }
    
    public static HashMap<String, Object> parseInsertImageFileInfo(MultipartFile multipartFile, String section, int common_num, int identy) throws Exception{
    	
    	String original_file_name = null;
    	String originalFileExtension = null;
    	String formatName = null;
    	String stored_file_name = null;
    	long file_size = 0;
    	
    	File file = new File(uploadPath);
    	if(file.exists() == false){
    		file.mkdirs();
    	}
    	
    	original_file_name = multipartFile.getOriginalFilename();
    	originalFileExtension = original_file_name.substring(original_file_name.lastIndexOf("."));
    	//확장자
    	formatName = original_file_name.substring(original_file_name.lastIndexOf(".")+1);
    	stored_file_name = CommonUtils.getRandomString() + originalFileExtension;
    	file_size = multipartFile.getSize();
    	
    	// 이미지가 아니면 종료
    	if(MediaUtils.getMediaType(formatName) == null){
    		System.out.println("이미지가아니다");
    		return null;
    	}    	
    	
    	
    	file = new File(uploadPath + stored_file_name);
    	multipartFile.transferTo(file);
    	
    	
    	BufferedImage sourceImg = ImageIO.read(file);
    	
    	BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT, 120, 160);
    	
    	ImageIO.write(destImg, "jpg", file);
    	
    	HashMap<String, Object> map = new HashMap<String, Object>();
    	
    	map.put("section", section);
    	map.put("common_num", common_num);
    	map.put("identy", identy);
    	map.put("original_file_name", original_file_name);
    	map.put("stored_file_name", stored_file_name);
    	map.put("file_size", file_size);
    	
    	return map;
    }
    

}