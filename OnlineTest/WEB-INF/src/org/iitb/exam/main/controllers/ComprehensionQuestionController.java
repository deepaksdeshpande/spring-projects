/**
 * 
 */
package org.iitb.exam.main.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author deepak
 *
 */
@Controller
public class ComprehensionQuestionController {

	Logger logger = Logger.getLogger(ComprehensionQuestionController.class);
	/**
	 * 
	 */
	public ComprehensionQuestionController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "addcomprehensionquestion.htm")
	public String loadComprehensionQuestionPage(HttpServletRequest request, Model model){
		logger.info("::::: Loaded Comprehension Questions page :::::");
		return "questionbank/addcomprehensionquestion";
	}
}
