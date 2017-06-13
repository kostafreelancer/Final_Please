package lancer.total.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lancer.total.service.A_MainService;
import lancer.total.service.C_DropService;
import lancer.total.service.C_FileService;
import lancer.total.util.MediaUtils;

@Controller
@RequestMapping("/c_file/*")
public class C_FileController {
	
	@Resource(name = "uploadPath")
	private String uploadPath;

	@Inject
	private C_FileService service;
	
	@RequestMapping(value = "/downloadFile", method = RequestMethod.POST)
	public void downloadFileGET(@RequestParam("file_num") int file_num, HttpServletResponse response)throws Exception{
		
		HashMap<String,Object> map = service.selectFileInfo(file_num);
	    String original_file_name = (String)map.get("original_file_name");
	    String stored_file_name = (String)map.get("stored_file_name");
	    
	    byte fileByte[] = FileUtils.readFileToByteArray(new File(uploadPath+stored_file_name));
	     
	    response.setContentType("application/octet-stream");
	    response.setContentLength(fileByte.length);
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(original_file_name,"UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    response.getOutputStream().write(fileByte);
	     
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
	}
	
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName)throws Exception{
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			
			MediaType mType = MediaUtils.getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			
			System.out.println(uploadPath);
			System.out.println(fileName);
			
			in = new FileInputStream(uploadPath+fileName);
			
			if(mType != null){
				headers.setContentType(mType);
			}else{
				fileName = fileName.substring(fileName.indexOf("_")+1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition",  "attachment; filename=\""+
						new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
			}
			
				entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),
						headers,
						HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally{
			in.close();
		}
		
		return entity;
	}
}
