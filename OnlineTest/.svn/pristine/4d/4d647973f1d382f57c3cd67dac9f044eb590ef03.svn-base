package org.iitb.exam.main.controllers;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationActivationController {
	protected final Logger logger = Logger.getLogger(ExamLoginController.class);
	
	/**
	 * 
	 */
	public RegistrationActivationController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/registrationactivation.htm", method = RequestMethod.GET)
	public String createExam(HttpServletRequest request, Model model) throws Exception {
		return "registration/completeregistration";
	}	
}
