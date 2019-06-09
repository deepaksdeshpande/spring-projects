package org.iitb.exam.main.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.iitb.exam.main.dao.UserDetailsService;
import org.iitb.exam.main.dto.ExperienceDetails;
import org.iitb.exam.main.dto.QualificationDetails;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShowCandidateInfoController {


	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-hibernate-servlet.xml");
	protected final Logger logger = Logger.getLogger(ShowCandidatesListController.class);
			
	@RequestMapping(value = "/displayUserInfo.htm",method=RequestMethod.POST)
	public String displayUserInfo(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession(true);
		logger.info("name : " + request.getParameter("nameWithId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		String name = request.getParameter("nameWithId");
		String email = request.getParameter("emailWithId");
		String age = request.getParameter("ageWithId");
		
		UserDetailsService userDetailsService = (UserDetailsService) ctx.getBean("fetchUserDetails");
		ArrayList<QualificationDetails> userQualificationDetails = new ArrayList<QualificationDetails>();
		ArrayList<ExperienceDetails> userExperienceDetails = new ArrayList<ExperienceDetails>();
		userQualificationDetails.addAll(userDetailsService.fetchUserQualification(userId));
		userExperienceDetails.addAll(userDetailsService.fetchUserExperienceDetails(userId));
		
		float totalExperience = 0f;
		for(int j=0; j<userExperienceDetails.size(); j++) {
			logger.info("User Details : " + userExperienceDetails.get(j).getYearOfExperience());
			totalExperience = totalExperience + userExperienceDetails.get(j).getYearOfExperience();
		}
		
		model.addAttribute("qualification", userQualificationDetails);
		model.addAttribute("experience", userExperienceDetails);
		model.addAttribute("nameWithId", name);
		model.addAttribute("emailWithId", email);
		model.addAttribute("ageWithId", age);
		model.addAttribute("tExp", (totalExperience > 0 ? (String.valueOf(totalExperience)).toString().concat(" Years") : "Fresher"));
		model.addAttribute("size", (userQualificationDetails.size() > userExperienceDetails.size() ? userQualificationDetails.size() : userExperienceDetails.size()));
//		for(int i=0; i < userQualificationDetails.size(); i++) {
//			logger.info("User Details : " + userQualificationDetails.get(i).getPassYear());
//		}
		return "showlist/displayUserInfo";
	}
}
