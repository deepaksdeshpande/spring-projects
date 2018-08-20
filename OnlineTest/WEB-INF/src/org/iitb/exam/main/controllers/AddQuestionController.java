/**
 * 
 */
package org.iitb.exam.main.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.iitb.exam.main.dao.AdvertisementService;
import org.iitb.exam.main.dao.DesignationService;
import org.iitb.exam.main.dto.Advertisements;
import org.iitb.exam.main.dto.Designation;
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
public class AddQuestionController {

	private static final Logger logger = Logger.getLogger(AddQuestionController.class);
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-hibernate-servlet.xml");
	/**
	 * 
	 */
	public AddQuestionController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addquestion.htm")
	public String displayAddQuestionForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
			logger.info("::::: Loaded the Add Question page :::::");
			
			ArrayList<Advertisements> advts = new ArrayList<Advertisements>();
			AdvertisementService advtService = (AdvertisementService) ctx.getBean("advertisementService");
			advts = advtService.getAllAdvertisementNames();
			logger.info("::::: Advertisement List Size ::::: " + advts.size());
			ArrayList<String> advtTitle = new ArrayList<String>();
			ArrayList<Integer> advtId = new ArrayList<Integer>();
			for(int i=0; i<advts.size(); i++) {
				advtId.add(advts.get(i).getAdvertisementId());
				advtTitle.add(advts.get(i).getAdvertisementTitle());
			}
			
			model.addAttribute("advts", advts);
						
			return "questionbank/addquestion";
		}
		else {
			return "errorpage/sessionexpired";
		}
	}
	
	
	@RequestMapping(value = "designationcontrol.htm")
    public String loadDesignationpage(HttpServletRequest request, Model model) {
        logger.info("::::: Loaded Designation Question page called :::::");
        int advtId=Integer.parseInt(request.getParameter("Value"));
        logger.info("::::: Advertisement ID ::::: " + advtId);
        ArrayList<Designation> posts = new ArrayList<Designation>();
        DesignationService desg =  (DesignationService) ctx.getBean("fetchDesignation");
        posts = desg.getDesignationsByAdvtId(advtId);
        logger.info("::::: Designation List Size ::::: " + posts.size());
        ArrayList<String> postNames = new ArrayList<String>();
        for (int i = 0; i < posts.size(); i++) {
            postNames.add(posts.get(i).getDesignationName());
        }
        request.setAttribute("posts", posts);
        request.setAttribute("postNames", postNames);
        model.addAttribute("posts", posts);
        return "questionbank/displaydesignation";
    }
}
