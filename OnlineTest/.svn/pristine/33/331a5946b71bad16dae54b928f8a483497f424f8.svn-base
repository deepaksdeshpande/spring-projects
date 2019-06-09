package org.iitb.exam.main.controllers;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.iitb.exam.main.dao.AdvertisementService;
import org.iitb.exam.main.dto.Advertisements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class AdvertisementController {
	
	private final Logger logger = Logger.getLogger(AdvertisementController.class);
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-hibernate-servlet.xml");
	
	public String editAdvertisement() {
		AdvertisementService advtServices = (AdvertisementService) ctx.getBean("fetchAdvertisement");
		ArrayList<Advertisements> advtList = advtServices.getAllAdvertisementNames();
		
		return "advertisement/editAdvertisement";
	}
}
