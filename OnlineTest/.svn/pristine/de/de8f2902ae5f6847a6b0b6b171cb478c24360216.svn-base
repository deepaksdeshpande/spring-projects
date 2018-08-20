/**
 * 
 */
package org.iitb.exam.main.formcontrollers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.iitb.exam.main.dao.QuestionService;
import org.iitb.exam.main.dto.QuestionBank;
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
public class DisplayAllQuestionsFormController {

	Logger logger = Logger.getLogger(DisplayAllQuestionsFormController.class);
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-hibernate-servlet.xml");
	/**
	 * 
	 */
	public DisplayAllQuestionsFormController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="displayallquestions.htm", method = RequestMethod.POST)
	public String displayQuestions(HttpServletRequest request, Model model) {
		logger.info("::::: Loaded Display All questions page ::::: ");
		QuestionService questionService = (QuestionService) ctx.getBean("questionService");
		List<QuestionBank> questionBankList = questionService.displayAllAddedQuestions();
		
		model.addAttribute("questionBankList", questionBankList);
		return "questionbank/displayallquestions";
	}
	
}
