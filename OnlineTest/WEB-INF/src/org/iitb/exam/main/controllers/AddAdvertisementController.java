package org.iitb.exam.main.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.iitb.exam.main.dto.Advertisements;
import org.apache.log4j.Logger;
import org.iitb.exam.main.controllers.AddQuestionController;
import org.iitb.exam.main.dao.AdvertisementService;
import org.iitb.exam.main.dao.CreateAdvertisementService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AddAdvertisementController {

	private static final Logger logger = Logger.getLogger(AddQuestionController.class);
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-hibernate-servlet.xml");
	
	public AddAdvertisementController() {
		// TODO Auto-generated constructor stub
	}
	
	
	/*
	 * Load the Advertisement jsp Page 
	 */
	
	@RequestMapping(method = RequestMethod.POST, value = "/displayadvertisementpage.htm")
	public String displayAddAdvertisementForm(HttpServletRequest request, Model model) {
				logger.info("::::: Loaded the Advertisement Creation page :::::");
			    return "advertisement/addadvertisement";
		}
	
	
	/*
	 *  get all the values and then save it in the databases.
	 */
	
	
	@RequestMapping(method = RequestMethod.POST, value = "addadverstisement.htm")
	public String loadAdvertisementsPage(HttpServletRequest request, Model model) {
		logger.info("::::: Saving the Advertisement Creation page :::::");
		CreateAdvertisementService createadvertisements = (CreateAdvertisementService) ctx.getBean("createAdvt");
		
		Date stdate = new Date();
		Date eddate = new Date();

		// getting the values from the user

		int advtID = Integer.parseInt(request.getParameter("advtID"));
		String advtName = request.getParameter("advtName");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		String advttitle = request.getParameter("advttitle");
		String projectCode = request.getParameter("projectCode");

		// Formatting the Date (Start Date and End Date)

		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy") then convert it;
		try {
			stdate = formatter.parse(startdate);
			logger.info(stdate);
			logger.info(formatter.format(stdate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			eddate = formatter.parse(enddate);
			logger.info(eddate);
			logger.info(formatter.format(eddate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// object created for Advertisement class.
		Advertisements advt = new Advertisements();

		// setting all the values.
		advt.setAdvertisementId(advtID);
		advt.setAdvertisementTitle(advttitle);
		advt.setStartDate(stdate);
		advt.setEndDate(eddate);
		advt.setProjCode(projectCode);
		advt.setAdvertisementDetails(advtName);
		advt.setPublishedStatus(false);

	    createadvertisements.createAdvertisements(advt);

		
		return "advertisement/addadvertisement";
	}
	
	    // Editing the advertisement page
		// populating the advertisement dropdown box
	    @RequestMapping(value = "displayeditadvertisementpage.htm")
		public String editAdvertisementsPage(HttpServletRequest request, Model model) {
				logger.info("::::: Loaded the ADVT page :::::");
				ArrayList<Advertisements> advts = new ArrayList<Advertisements>();
				AdvertisementService advtService = (AdvertisementService) ctx.getBean("advertisementService");
				advts = advtService.getAllAdvertisementNames();
				logger.info("::::: Advertisement List Size ::::: " + advts.size());
				ArrayList<String> advtTitle = new ArrayList<String>();
				ArrayList<Integer> advtId = new ArrayList<Integer>();
				for (int i = 0; i < advts.size(); i++) {
					advtId.add(advts.get(i).getAdvertisementId());
					advtTitle.add(advts.get(i).getAdvertisementTitle());
				}
				model.addAttribute("advts", advts);
				return "advertisement/editadvertisement";
			
		}
		
	    //first page of the website.
	    @RequestMapping(value = "predisplayeditadvertisementpage.htm")
		public String preAdvertisementsPage(HttpServletRequest request, Model model) {
				logger.info("::::: i m in new controller superman:::::");
				ArrayList<Advertisements> advts = new ArrayList<Advertisements>();
				AdvertisementService advtService = (AdvertisementService) ctx.getBean("advertisementService");
				advts = advtService.getAllAdvertisementNames();
				logger.info("::::: Advertisement List Size ::::: " + advts.size());
				ArrayList<String> advtTitle = new ArrayList<String>();
				ArrayList<Integer> advtId = new ArrayList<Integer>();
				ArrayList<String> enddate = new ArrayList<String>();
				for (int i = 0; i < advts.size(); i++) {
					advtId.add(advts.get(i).getAdvertisementId());
					advtTitle.add(advts.get(i).getAdvertisementTitle());
					enddate.add(advts.get(i).getEndDate().toString());
					
				}
				model.addAttribute("advts", advts);
				return "exam/examprelogin";
			
		}
	    
	    
	    
	    
		
		// populate the text box on selecting the dropdown box.
		@RequestMapping(value = "populateAdvtDetails.htm")
		public String updateAdvt(HttpServletRequest request, Model model) {
			logger.info("::::: Loaded Designation Question page called :::::");
			int advtId = Integer.parseInt(request.getParameter("Value"));
			logger.info("::::: Advertisement ID ::::: " + advtId);
			ArrayList<Advertisements> posts = new ArrayList<Advertisements>();
			CreateAdvertisementService desg = (CreateAdvertisementService) ctx.getBean("createAdvt");
			posts = desg.updateAdvertisements(advtId);

			logger.info("::::: Designation List Size ::::: " + posts.size());
			model.addAttribute("posts", posts);
			return "advertisement/getvalueeditadvertisement";
		}
	
}
