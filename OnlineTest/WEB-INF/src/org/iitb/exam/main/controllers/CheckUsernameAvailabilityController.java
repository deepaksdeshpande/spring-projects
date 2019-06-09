package org.iitb.exam.main.controllers;	

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.iitb.exam.main.dao.CheckUsernameService;
import org.iitb.exam.main.dto.UserDetails;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CheckUsernameAvailabilityController {
	protected final Logger logger = Logger.getLogger(ExamLoginController.class);
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-hibernate-servlet.xml");
	
	/**
	 * 
	 */
	public CheckUsernameAvailabilityController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/checkusername.htm", method = RequestMethod.POST)
	public @ResponseBody String checkUsername(HttpServletRequest request, Model model) throws Exception {
		logger.info("Username checking................");
		CheckUsernameService checkUser = (CheckUsernameService) ctx.getBean("checkusername");
		String username = request.getParameter("username");
		UserDetails user = new UserDetails();
		user = checkUser.checkUsername(username);
		if(user != null)
			return "Username Not Available";
		else
			return "Username Available";
	}	
}
