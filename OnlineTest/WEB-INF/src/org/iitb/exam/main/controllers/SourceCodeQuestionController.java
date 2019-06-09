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
public class SourceCodeQuestionController {

	Logger logger = Logger.getLogger(SourceCodeQuestionController.class);
	/**
	 * 
	 */
	public SourceCodeQuestionController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "addcodingquestion.htm")
	public String loadSourceCodeQuestionPage(HttpServletRequest request, Model model){
		logger.info("::::: Loaded Code Submission Questions page :::::");
		return "questionbank/addcodingquestion";
	}
}
