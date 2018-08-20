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
public class SingleChoiceQuestionController {

	Logger logger = Logger.getLogger(SingleChoiceQuestionController.class);
	/**
	 * 
	 */
	public SingleChoiceQuestionController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "addsinglechoicequestion.htm")
	public String loadSingleChoiceQuestionPage(HttpServletRequest request, Model model){
		logger.info("::::: Loaded Single Choice Questions page :::::");
		return "questionbank/addsinglechoicequestion";
	}
}
