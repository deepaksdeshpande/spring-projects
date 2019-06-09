/**
 * 
 */
package org.iitb.exam.main.formcontrollers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.iitb.exam.main.dao.QuestionService;
import org.iitb.exam.main.dto.OptionBank;
import org.iitb.exam.main.dto.QuestionBank;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author deepak
 *
 */
@Controller
public class UpdateQuestionFormController {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-hibernate-servlet.xml");
	
	static final Logger logger = Logger.getLogger(UpdateQuestionFormController.class);
	/**
	 * 
	 */
	public UpdateQuestionFormController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/updatedsuccessfully.htm", method = RequestMethod.POST)
	public String updateSingleChoiceQuestion(
			@ModelAttribute("editsinglechoicequestion") QuestionBank questionBank,
			@ModelAttribute("options") OptionBank optionBank,
			HttpServletRequest request, Model model) {
	
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
			QuestionService questionService = (QuestionService) ctx.getBean("questionService");
			
			String qid = request.getParameter("questionId");
			int questionId = Integer.parseInt(qid);
			logger.info("::::: Question ID ::::: "+questionId);
		
			int levelOfDifficulty = Integer.parseInt(request.getParameter("lod"));
			logger.info("::::: Level of difficulty is ::::: "+levelOfDifficulty);
		
			String strShuffle = request.getParameter("shufflecheck");
			int shuffle = 0;
			logger.info("::::: strShuffle ::::: "+strShuffle);
			if(strShuffle!=null) {
				shuffle=1;
			}
			else {
				shuffle=0;
			}
			logger.info("::::: Shuffle is ::::: "+shuffle);
		
			String strArchived = request.getParameter("archivedcheck");
			logger.info("::::: strArchived ::::: "+strArchived);
			int archived=0;
			if(strArchived!=null) {
				archived=1;
			}
			else {
				archived=0;
			}
			logger.info("::::: Question archived ::::: "+archived);
		
			String questionText = request.getParameter("qText");
			logger.info("::::: Question Text is ::::: "+questionText);
			
			String optionCount = request.getParameter("count");
			int countValue=0;
			
			if(optionCount!=null) {
				countValue = Integer.parseInt(optionCount);
			}
			logger.info("::::: No of options is :::::" +countValue);
			
			String[] optionValues = new String[countValue];
			logger.info("::::: Option Values length ::::: " +optionValues.length);
			
			ArrayList<OptionBank> optBankList = new ArrayList<OptionBank>();
			optBankList.clear();
			
			String correctOption = request.getParameter("option");
			int optionCorrectness=0;
			
			if(correctOption!=null) {
				optionCorrectness = Integer.parseInt(correctOption)-1;
			}
						
			int optionId=0;
			String option="";
			String optionText="";
			
			for(int i=0; i<optionValues.length; i++) {
				option = request.getParameter("optionId");
				optionText = request.getParameter(""+(i+1));
				
				optionId = Integer.parseInt(option)+i; 
				logger.info("::::: The option Id being updated is ::::: "+optionId);
				
				optionBank = new OptionBank();
				
				logger.info("::::: Updated Option text is ::::: "+optionText);
				int correctStatus = 0;				
				if(optionCorrectness == i) {
					correctStatus=1;
					logger.info("::::: Correct option for this question is "+optionBank.getOptionText()+" and it is being set to "+optionBank.getOptionCorrectness()+" in the Option Bank :::::");
				} else {
					correctStatus=0;
					logger.info("::::: Wrong options for this question are "+optionBank.getOptionText()+" and it is being set to "+optionBank.getOptionCorrectness()+" in the Option Bank :::::");
				}
				logger.info("::::: Contents of OptBankList is ::::: "+optBankList);
				
				questionService.updateSingleChoiceQuestionById(questionId,
						levelOfDifficulty, shuffle, archived, questionText,
						optionId, correctStatus, optionText);
			}
			
			return "questionbank/updatedsuccessfully";
		}
		else {
			return "errorpage/internalservererror";
		}
		
	}

}