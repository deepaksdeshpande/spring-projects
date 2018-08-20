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
public class MultipleChoiceQuestionController {

	Logger logger = Logger.getLogger(MultipleChoiceQuestionController.class);
	/**
	 * 
	 */
	public MultipleChoiceQuestionController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "addmultiplechoicequestion.htm")
	public String loadMulChoiceQuestionPage(HttpServletRequest request, Model model) {
		logger.info("::::: Loaded Multiple Choice Question page :::::");
		return "questionbank/addmultiplechoicequestion";
	}
}
