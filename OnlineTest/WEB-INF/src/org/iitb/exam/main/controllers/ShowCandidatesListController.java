package org.iitb.exam.main.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.iitb.exam.main.dao.AdvertisementService;
import org.iitb.exam.main.dao.UserDetailsService;
import org.iitb.exam.main.dto.UserDetails;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShowCandidatesListController {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-hibernate-servlet.xml");
	protected final Logger logger = Logger.getLogger(ShowCandidatesListController.class);
			
	@RequestMapping(value = "/showCandidatesList.htm",method=RequestMethod.POST)
	public String showCandidatesList(HttpServletRequest request, Model model) {

		HttpSession session = request.getSession(true);
		ArrayList<UserDetails> userDetailsList = new ArrayList<UserDetails>();
		int designationId = Integer.parseInt(request.getParameter("post"));
		String designationName = request.getParameter("hiddenpostname");
		logger.info("::::: DesignationID ::::::: : " + designationId);
		logger.info("::::: Designation Name ::::::: : " + designationName);

		UserDetailsService userDetailsService = (UserDetailsService) ctx.getBean("fetchUserDetails");
		AdvertisementService advtService = (AdvertisementService) ctx.getBean("fetchAdvertisement");
		userDetailsList = userDetailsService.fetchUserDetails(designationId, Integer.parseInt(session.getAttribute("advtId").toString()));
		logger.info("::::: userDetailsList::::::: : " + userDetailsList);
		
		String advtName = advtService.fetchAdvertisements(Integer.parseInt(session.getAttribute("advtId").toString())).getAdvertisementTitle();

		model.addAttribute("advtName", advtName);
		model.addAttribute("postName", designationName);
		model.addAttribute("userDetailsList", userDetailsList);
		return "showlist/showCandidateList";
	}
}