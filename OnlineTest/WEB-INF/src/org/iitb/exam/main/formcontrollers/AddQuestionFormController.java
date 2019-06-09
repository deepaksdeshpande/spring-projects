/**
 * 
 */
package org.iitb.exam.main.formcontrollers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.iitb.exam.main.dao.AdvertisementService;
import org.iitb.exam.main.dao.DesignationService;
import org.iitb.exam.main.dao.QuestionService;
import org.iitb.exam.main.dto.Advertisements;
import org.iitb.exam.main.dto.Designation;
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
public class AddQuestionFormController {

	static final Logger logger = Logger.getLogger(AddQuestionFormController.class);
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-hibernate-servlet.xml");
	
	/**
	 * 
	 */
	public AddQuestionFormController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "addedsuccessfully.htm", method = RequestMethod.POST)
	public String addQuestionToQuestionBank(
			@ModelAttribute("addquestionform") QuestionBank questionBank,
			HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
			String qCategory = request.getParameter("addQuestionCategory");
			logger.info(":::: Selected Question Category is ::::: "+qCategory);
			
			String advtForQuestion = request.getParameter("qpoolforadvt");
			logger.info("::::: Question Pool category is (Based on advertisement ::::: "+advtForQuestion);
			
			Advertisements advt = new Advertisements();			
			AdvertisementService adService = (AdvertisementService)ctx.getBean("fetchAdvertisement");
			advt = adService.fetchAdvertisements(Integer.parseInt(advtForQuestion));
			logger.info("::::: Selected Advertisement name is ::::: "+advt.getAdvertisementTitle());
			/*
			 * This will set the designation for all the different types of questions that will be added to the question bank.
			 */
			
			Set<String> designationSet = null;
			String[] designations = request.getParameterValues("desgnames");
			if(designations==null) {
				designations = new String[1];
				designations[0]="General";
				designationSet = new HashSet<String>(Arrays.asList(designations));
				logger.info("::::: The selected designation(s) for this question is ::::: "+designationSet);
			}
			else {
				designationSet = new HashSet<String>(Arrays.asList(designations));
				logger.info("::::: The selected designations for this question are ::::: "+designationSet);
			}
			
			Designation desg;
			DesignationService desgService = (DesignationService) ctx.getBean("fetchDesignation");
			List<Designation> desgList = desgService.getDesignationDetails(designationSet);
			
			Map<Designation, Advertisements> advtByDesg	= new HashMap<Designation, Advertisements>();
			for(int i=0; i<desgList.size(); i++) {
				desg = new Designation();
				desg.setDesignationId(desgList.get(i).getDesignationId());
				desg.setDesignationName(desgList.get(i).getDesignationName());
				desg.setDesignationDescription(desgList.get(i).getDesignationDescription());
				advtByDesg.put(desg, advt);
			}
			
			for (Map.Entry<Designation, Advertisements> entry : advtByDesg.entrySet()) {
				logger.info("Map key : "+entry.getKey().getDesignationId() + ", Map Value : "+entry.getValue().getAdvertisementTitle());
			}
				
			int levelofDifficulty = Integer.parseInt(request.getParameter("lod"));
			logger.info("::::: Level of difficulty is ::::: "+levelofDifficulty);
			
			int questionType = Integer.parseInt(request.getParameter("qtype"));
			logger.info("::::: Question Type is ::::: "+questionType);
			
			String questionText = request.getParameter("qText");
			logger.info("::::: Question Text is ::::: "+questionText);
			
			String optionCount = request.getParameter("count");
			int countValue=0;
			if(optionCount!=null) {
				countValue = Integer.parseInt(optionCount);
			}
			logger.info("::::: No of options is :::::" +countValue);
			
			String[] optionValues = new String[countValue];
			logger.info(optionValues.length);
			
			ArrayList<OptionBank> optBankList = new ArrayList<OptionBank>();
			questionBank.setQuestionCategory(qCategory);
			questionBank.setLevelOfDifficulty(levelofDifficulty);
			questionBank.setQuestionType(questionType);
			questionBank.setQuestionText(questionText.trim());
			questionBank.setAdvtByDesg(advtByDesg);
			logger.info("----questionBank.getAdvtByDesg : "+questionBank.getAdvtByDesg().keySet());
		
			/*
			 * questionType 1 is Single Choice correct questions.
			 * questionType 2 is Multiple Choice correct questions.
			 * questionType 3 is Comprehension Type questions (same as single choice questions).
			 * questionType 4 is Code Submission questions.
			 */
			if(questionType == 1 || questionType == 3) {
				String correctOption="";
				correctOption = request.getParameter("option");
				optBankList.clear();
				int optionCorrectness = Integer.parseInt(correctOption)-1;
				for(int i=0; i<countValue; i++) {
					OptionBank optionBank = new OptionBank();
					optionBank.setOptionText(request.getParameter(""+(i+1)));
					optionBank.setQuestion(questionBank);
					//optionBank.setOptionText(option.get(i));
					
					if(optionCorrectness == i) {
						optionBank.setOptionCorrectness(1);
						logger.info("::::: Correct option for this question is "+optionBank.getOptionText()+" and it is being set to "+optionBank.getOptionCorrectness()+" in the Option Bank :::::");
					} else {
						optionBank.setOptionCorrectness(0);
						logger.info("::::: Wrong options for this question are "+optionBank.getOptionText()+" and it is being set to "+optionBank.getOptionCorrectness()+" in the Option Bank :::::");
					}
					optBankList.add(i, optionBank);
				}
				logger.info("::::: Contents of OptBankList is ::::: "+optBankList);
			}
			else if(questionType == 2) {
				optBankList.clear();
				String[] checkboxOptions = {"A", "B", "C", "D", "E", "F"};
				for(int i=0; i<countValue; i++) {
					
					OptionBank optionBank = new OptionBank();
					optionBank.setOptionText(request.getParameter(""+(i+1)));
					optionBank.setQuestion(questionBank);
					//optionBank.setOptionText(option.get(i));
					
					if(request.getParameter(checkboxOptions[i])!=null) {
						optionBank.setOptionCorrectness(1);
						logger.info("::::: Correct option for this question is "+optionBank.getOptionText()+" and it is being set to "+optionBank.getOptionCorrectness()+" in the Option Bank :::::");
					} else {
						optionBank.setOptionCorrectness(0);
						logger.info("::::: Wrong options for this question are "+optionBank.getOptionText()+" and it is being set to "+optionBank.getOptionCorrectness()+" in the Option Bank :::::");
					}
					optBankList.add(i, optionBank);
				}
				
			}
			else if(questionType == 4) {
				
			}
			else if(questionType == 5) {
				questionBank.setQuestionText(request.getParameter("qText"));
				logger.info("::::: Coding question text is ::::: "+questionBank.getQuestionText());				
			}
			else {
				model.addAttribute("message", "Invalid Question Type");
				return "redirect:addquestion.htm";
			}
			
			QuestionService questionService = (QuestionService) ctx.getBean("questionService");
			questionService.addQuestion(questionBank, optBankList);
			
			
			return "questionbank/addedsuccessfully";
		}
		else {
			return "errorpage/internalservererror";
		}

	}
}
