package org.iitb.exam.main.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.iitb.exam.main.dao.GetAdvertistmentDesignationNameService;
import org.iitb.exam.main.dao.GetQuestionsAdvtandDesgService;
import org.iitb.exam.main.dto.QuestionBank;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreateExamController {
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"spring-hibernate-servlet.xml");
	protected final Logger logger = Logger.getLogger(ExamLoginController.class);

	/**
	 * 
	 */
	public CreateExamController() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/createexam.htm", method = RequestMethod.POST)
	public String createExamSelected(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		
		/*** Setting post variable in Model for using it during entering in Advt_Desg_Exam_Mapping table while making entry in exam table ***/
		model.addAttribute("postId", request.getParameter("post"));
		GetAdvertistmentDesignationNameService get = (GetAdvertistmentDesignationNameService) context
				.getBean("fetchAdvtDesgName");
		logger.info("post : " + (String) request.getParameter("post"));
		String examName = get.fetchAdvertismentDesignationId(
				Integer.parseInt((String) request.getParameter("post")),
				(Integer) session.getAttribute("advtId"));
		logger.info("Exam Name : " + examName);
		model.addAttribute("examname", examName.concat("_").concat(String.valueOf(Calendar.getInstance().get(Calendar.YEAR))));
		GetQuestionsAdvtandDesgService questions = (GetQuestionsAdvtandDesgService) context
				.getBean("fetchQuestionByAdvtIdandDesgId");
		ArrayList<QuestionBank> questionBank = new ArrayList<QuestionBank>();
		questionBank = questions.getQuestionsBasedOnAdvtandDesg(
				(Integer) session.getAttribute("advtId"),
				Integer.parseInt((String) request.getParameter("post")));
		model.addAttribute("questionBank", questionBank);
		String questionType = "";
		String categoryType = "";
		Map<Integer, String> categoryTypeMap = new HashedMap();
		Map<Integer, String> questionTypeMap = new HashedMap();
		for (int i = 0; i < questionBank.size(); i++) {
			switch (Integer.parseInt(questionBank.get(i).getQuestionCategory())) {
			case 1:
				categoryType = "Aptitude";
                break;
			case 2:
				categoryType = "Technical";
                break;
			case 3:
				categoryType = "Comprehension";
                break;
			case 4:
				categoryType = "Compilation";
                break;
			case 5:
				categoryType = "Coding";
                break;
			default:
				categoryType = "Un-defined";
			}
			categoryTypeMap.put(questionBank.get(i).getQuestionid(), categoryType);
			
			switch (questionBank.get(i).getQuestionType()) {
			case 1:
				questionType = "Single Choice";
                break;
			case 2:
				questionType = "Multiple Choice";
                break;
			case 3:
				questionType = "Numeric Type";
                break;
			case 4:
				questionType = "True/False";
                break;
			default:
				questionType = "Un-defined";
                break;
			}
			questionTypeMap.put(questionBank.get(i).getQuestionid(), questionType);
		}
		model.addAttribute("categoryType", categoryTypeMap);
		model.addAttribute("questionType", questionTypeMap);
		return "examhome/createExam";
	}

	public String createExam(HttpServletRequest request, Model model) throws Exception {
		int postId = Integer.parseInt((String)request.getParameter("post"));
		HttpSession session = request.getSession(true);
		@SuppressWarnings("unused")
		String sessionId = null;
		sessionId = session.getId();
		session.setAttribute("postId",postId);
		return "createexam/createExamByParameters";
	}	

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/createexammanual.htm", method = RequestMethod.POST)
	public String createExamManual(HttpServletRequest request, Model model) throws Exception {

		return "createexam/createExamTabs";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/byparameters.htm", method = RequestMethod.GET)
	public String createExambyparameters(HttpServletRequest request, Model model) throws Exception {

		return "createexam/createExamByParameters";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/bysearch.htm", method = RequestMethod.GET)
	public String createExambysearch(HttpServletRequest request, Model model) throws Exception {
		logger.info("in createExamBySearch");
		return "createexam/createExamBySearch";
	}
}