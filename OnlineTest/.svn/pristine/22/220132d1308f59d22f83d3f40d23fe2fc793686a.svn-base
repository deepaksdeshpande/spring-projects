package org.iitb.exam.main.controllers;

import java.util.ArrayList;
import com.google.gson.Gson;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.iitb.exam.main.dao.ExamService;
import org.iitb.exam.main.dto.Exam;
import org.iitb.exam.main.wrappers.ExamDetail;
import org.iitb.exam.main.wrappers.Question;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author dipti
 *
 */
@Controller
public class GetExamDetailController {


	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-hibernate-servlet.xml");
	protected final Logger logger = Logger.getLogger(GetExamDetailController.class);
	/**
	 * 
	 */
	public GetExamDetailController() {
		// TODO Auto-generated constructor stub
	}

	
	@RequestMapping(value = "/examdetails.htm",method=RequestMethod.POST)
	public String displayExamDetails(HttpServletRequest request, Model model) 
			throws Exception {
	
		Exam examdetails = new Exam();
		HttpSession session = request.getSession(true);
	
		int advtId = Integer.parseInt(session.getAttribute("advtId").toString());
		int designationId=Integer.parseInt(request.getParameter("designationId"));
		int userId=Integer.parseInt(session.getAttribute("userid").toString());
		logger.info("::::: Advertisement number:::::::: : " + advtId);
		logger.info("::::: DesignationID::::::: : " + designationId);
		logger.info("::::: userId::::::: " + userId);
		
		
			ExamService examService = (ExamService) ctx.getBean("examService");
			examdetails = examService.getExamDetails(advtId, designationId);
			session.setAttribute("examdetails", examdetails);
			session.setAttribute("desgnId",designationId);
			model.addAttribute("examdetails", examdetails);
			return "examhome/examinfomodel";
	}
	
	
	@RequestMapping(value = "/startexam.htm",method=RequestMethod.POST)
	public String displayExamQuestion(HttpServletRequest request, Model model) 
			throws Exception {
		Exam examdetail=new Exam();
		HttpSession session = request.getSession(true);
		/*
		 * Get Designation name from database
		 */
		
		String designId=session.getAttribute("desgnId").toString();
		ExamService examService = (ExamService) ctx.getBean("examService");
		String desgnName = examService.getDesignationName(designId);
		
		examdetail=(Exam) session.getAttribute("examdetails");
		ExamDetail exam=new ExamDetail();
		exam.setExamId(examdetail.getExamid());
		exam.setExamDate(examdetail.getExamDate());
		exam.setExamDuration(examdetail.getExamDuration());
		exam.setExamName(examdetail.getExamName());
		exam.setDesignationName(desgnName);
		ArrayList<Question> questionlist=new ArrayList<Question>();
		
		ExamService questionservice = (ExamService) ctx.getBean("examService");
		questionlist = questionservice.getExamQuestions(examdetail.getExamid());
		exam.setQuestionList(questionlist);
		Gson gson = new Gson();
		String examjson = gson.toJson(exam);			
		model.addAttribute("examobject",exam);
		session.setAttribute("ExamObject", examjson);
		return "displayexam/startexam";
		
		
	}
	
	
	
}



