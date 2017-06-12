package lancer.total.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lancer.total.service.A_MainService;
import lancer.total.service.C_DropService;
import lancer.total.service.C_FileService;

@Controller
@RequestMapping("/c_file/*")
public class C_FileController {

	@Inject
	private C_FileService service;
	
	@RequestMapping(value = "/downloadFile", method = RequestMethod.POST)
	public void downloadFileGET(@RequestParam("file_num") int file_num, HttpServletResponse response, HttpSession session)throws Exception{
		
		HashMap<String,Object> map = service.selectFileInfo(file_num);
	    String original_file_name = (String)map.get("original_file_name");
	    String stored_file_name = (String)map.get("stored_file_name");
	    
	    String filePath = session.getServletContext().getRealPath("/") + "resources\\upload\\";
	    byte fileByte[] = FileUtils.readFileToByteArray(new File(filePath+stored_file_name));
	     
	    response.setContentType("application/octet-stream");
	    response.setContentLength(fileByte.length);
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(original_file_name,"UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    response.getOutputStream().write(fileByte);
	     
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
	}
	
}
