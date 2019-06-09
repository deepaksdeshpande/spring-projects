package org.iitb.exam.main.formcontrollers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.iitb.exam.main.controllers.ExamLoginController;
import org.iitb.exam.main.dao.CreateExamService;
import org.iitb.exam.main.dao.ExamLoginService;
import org.iitb.exam.main.dto.Exam;
import org.iitb.exam.main.dto.UserDetails;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExamCreatedFormController {
	private SessionFactory sessionFactory;
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"spring-hibernate-servlet.xml");
	protected final Logger logger = Logger.getLogger(ExamLoginController.class);
	private Exam exam;

	/**
	 * 
	 */
	public ExamCreatedFormController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@RequestMapping(value = "/examcreated.htm", method = RequestMethod.POST)
	public String createExam(HttpServletRequest request, Model model)
			throws Exception {

		logger.info("Start time : " + Calendar.getInstance().getTimeInMillis());

		/************* Storing Selected Questions without Named Query **************/
		// QuestionBankService questionbankService = (QuestionBankService)
		// context
		// .getBean("fetchQuestion");
		/***************************************************************************/

		ExamLoginService examLoginService = (ExamLoginService) context
				.getBean("examLoginService");
		CreateExamService createExamService = (CreateExamService) context
				.getBean("createExam");
		HttpSession session = request.getSession(true);

		Date date = new Date();
		int desgId = Integer.parseInt(request.getParameter("desgId"));
		String email = (String) session.getAttribute("email");
		String examName = request.getParameter("examname");
		String examDate = request.getParameter("examdate");
		String examDuration = request.getParameter("examduration");
		String[] questionsSelected = request
				.getParameterValues("questionsSelected");

		/************* Storing Selected Questions without Named Query **************/
		Set<String> questionSelectedSet = new HashSet<String>(
				new ArrayList<String>(Arrays.asList(questionsSelected)));
		// logger.info("With Named Query ");
		/***************************************************************************/

		String userId = session.getAttribute("userid").toString();
		logger.info("User Id............................................."
				+ userId);
		exam = new Exam();
		UserDetails u = examLoginService.performLogin(email);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		try {
			date = formatter.parse(examDate);
			logger.info(date);
			logger.info(formatter.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		exam.setCreatedBy(u);
		exam.setAnswerOption(null);

		/************* Storing Selected Questions without Named Query **************/
		// Set<QuestionBank> questionBank =
		// questionbankService.fetchRandomQuestions(questionsSelected);
		// exam.setQuestionBank(questionBank);
		// exam.setExamid(examId);
		/***************************************************************************/
		
		exam.setExamDuration(Integer.parseInt(examDuration));
		exam.setExamName(examName);
		exam.setExamDate(date);
		exam.setTotalQuestions(questionsSelected.length);
		exam.setAnswerOption(null);

		/************* Storing Selected Questions without Named Query **************/
		// if(!questionBank.isEmpty()) {
		// createExamService.createExam(exam);
		/***************************************************************************/

		createExamService.createExam(exam, questionSelectedSet, desgId, (Integer) session.getAttribute("advtId"));
		// createExamService.createExamAndAdvtExamMapping(exam,
		// questionSelectedSet);
		return "examhome/examcreationsuccess";

		/************* Storing Selected Questions without Named Query **************/
		// } else {
		// return "examhome/adminHome";
		// }
		/***************************************************************************/
	}
}
