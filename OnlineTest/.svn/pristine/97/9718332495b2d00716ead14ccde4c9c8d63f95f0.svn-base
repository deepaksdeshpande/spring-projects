package org.iitb.exam.main.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.iitb.exam.main.dao.UserDetailsService;
import org.iitb.exam.main.dto.UploadImage;
import org.iitb.exam.main.dto.UserDetails;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadImageDetails {
	
	static final Logger logger = Logger.getLogger(UploadImageDetails.class);
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate-servlet.xml");
	
	@RequestMapping(value = "fileUpload.htm")
	public ModelAndView processImageUpload( @ModelAttribute("uploadedFile") UploadImage uploadF, BindingResult result) {
//	public String upload(@RequestParam(value = "userImage", required = false) MultipartFile myFile, HttpServletResponse httpServletResponse) {

		logger.info("::::::::::::processImageUpload:::::::::");
		InputStream inputStream = null;
		OutputStream outputStream = null;
        String stringList = null;
		logger.info("::::::::::::errors::::::::: " + stringList);
		MultipartFile myFile = uploadF.getFile(); 
		
		String fileName = myFile.getOriginalFilename();
		
		logger.info("File Name : " + fileName);
		logger.info("::::::::::::upload.getFile ::::::::: " + myFile.getSize() + " bytes");
		logger.info("::::::::::::fileName ::::::::: " + fileName);
//		
		try {
			inputStream = myFile.getInputStream();

			File newFile = new File("System.getenv('HOME')"+"/workspace/OnlineTest/user_images/"+fileName);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "showuploadpage.htm")
	public String openUploadImage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(true);
		
		UserDetailsService userDetails = (UserDetailsService)context.getBean("fetchUserDetails");
		int designationId = Integer.parseInt(request.getParameter("post"));
		
		ArrayList<UserDetails> userDetailsList = userDetails.fetchUserDetails(designationId, Integer.parseInt(session.getAttribute("advtId").toString()));
		logger.info("::::: userDetailsList::::::: : " + userDetailsList);
		model.addAttribute("userDetailsList", userDetailsList);
		
		return "userdetails/uploadImage";
	}
	
	@RequestMapping(value = "showImage.htm", method=RequestMethod.POST)
	public String showImage(HttpServletRequest request, Model model) {
		model.addAttribute("image", request.getParameter("photo"));
		model.addAttribute("name", request.getParameter("name"));
		logger.info("::::: photo::::::: : " + request.getParameter("photo"));
		
		return "userdetails/showImage";
	}
}