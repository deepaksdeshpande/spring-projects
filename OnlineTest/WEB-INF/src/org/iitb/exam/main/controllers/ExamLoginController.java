/**
 * 
 */
package org.iitb.exam.main.controllers;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.iitb.exam.main.dao.DesignationService;
import org.iitb.exam.main.dto.Designation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author deepak
 *
 */
@Controller
public class ExamLoginController {

	ApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate-servlet.xml");
	protected final Logger logger = Logger.getLogger(ExamLoginController.class);
	/**
	 * 
	 */
	public ExamLoginController() {
		// TODO Auto-generated constructor stub
	}

	static String name="";
	
	@RequestMapping(value = "/examlogin.htm", method = RequestMethod.POST)//default:is GET
	public String displayExamLogin(HttpServletRequest request, Model model) 
			throws Exception {
		String today = new Date().toString();
		HttpSession session = request.getSession(true);
		//This static setting of advtId in Session object needs to be get from user selected advertisment.(Future)
		logger.info("value is"+ request.getParameter("advtid"));
		if(session.getAttribute("advtId") == null) {
			session.setAttribute("advtId", Integer.parseInt(request.getParameter("advtid")));//dynamic should come;
		}
		if(request.getParameter("advtid") != null) {
			session.setAttribute("advtId", Integer.parseInt(request.getParameter("advtid")));
		}
		if(request.getParameter("advtName") != null) {
			session.setAttribute("advtName", request.getParameter("advtName"));
		}
		logger.info("advtName is "+ session.getAttribute("advtName"));
		logger.info("advtId is "+ session.getAttribute("advtId"));
		int advtId = Integer.parseInt(session.getAttribute("advtId").toString());
		ArrayList<Designation> posts = new ArrayList<Designation>();
		DesignationService desg =  (DesignationService) context.getBean("fetchDesignation");
		posts = desg.fetchDesignation(advtId);
		logger.info("Designation List Size : " + posts.size());
		model.addAttribute("posts", posts);
        FileOutputStream fileOut = new FileOutputStream(request.getServletContext().getRealPath("/")+"/designation/designations"+advtId+".txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(posts);
        out.close();
		logger.info("::::: Loading the exam login page... ::::: " + today);
		return "exam/examlogin";
	}
	
	/*
	 * Mapping for Forgot Password
	 */
	@RequestMapping(value="/forgot.htm", method = RequestMethod.POST)
	public String displayForgotPassword(HttpServletRequest request, Model model) {
		logger.info("::::: Loading the Forgot Password page... ::::: ");
		return "exam/forgotPassword";
	}
	
//	@RequestMapping(value="/sample.htm", method = RequestMethod.GET)
//	public String sample(HttpServletRequest request, Model model) {
//		logger.info("::::: Loading the Forgot Password page... ::::: ");
//		return "exam/sample";
//	}
}
