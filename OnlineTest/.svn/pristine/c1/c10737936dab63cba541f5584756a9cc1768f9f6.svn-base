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
public class SequenceQuestionController {

	Logger logger = Logger.getLogger(SequenceQuestionController.class);
	/**
	 * 
	 */
	public SequenceQuestionController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "addsequencequestion.htm")
	public String loadComprehensionQuestionPage(HttpServletRequest request, Model model){
		logger.info("::::: Loaded Sequence Questions page :::::");
		return "questionbank/addsequencequestion";
	}

}
