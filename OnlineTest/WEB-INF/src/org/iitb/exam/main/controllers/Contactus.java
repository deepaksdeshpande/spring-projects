package org.iitb.exam.main.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Contactus {
	private static final Logger logger = Logger.getLogger(Contactus.class);
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-hibernate-servlet.xml");
	
	
	//Load the contact us form.
	@RequestMapping(method = RequestMethod.GET, value = "/contactus.htm")
	public String displayContactForm(HttpServletRequest request, Model model) {
				logger.info("::::: Loaded the contact us page :::::");
			    return "contact/contactus";
		}
	
	
	
}
