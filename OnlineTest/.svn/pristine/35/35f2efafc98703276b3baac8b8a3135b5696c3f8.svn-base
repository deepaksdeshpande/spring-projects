/**
 * 
 */
package org.iitb.exam.main.formcontrollers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.iitb.exam.main.dao.AdvertisementService;
import org.iitb.exam.main.dao.DesignationService;
import org.iitb.exam.main.dao.QuestionService;
import org.iitb.exam.main.dto.Advertisements;
import org.iitb.exam.main.dto.Designation;
import org.iitb.exam.main.dto.OptionBank;
import org.iitb.exam.main.dto.QuestionBank;
import org.iitb.exam.main.utils.OptionBankSortedWithComparator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author deepak
 *
 */
@Controller
public class DisplaySingleChoiceQForEditFormController {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-hibernate-servlet.xml");
	
	static final Logger logger = Logger.getLogger(DisplaySingleChoiceQForEditFormController.class);
	/**
	 * 
	 */
	public DisplaySingleChoiceQForEditFormController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "designation.htm")
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

	@RequestMapping(value = "/editsinglechoicequestion.htm", method=RequestMethod.POST, params={"qid"})
	public String showEditQuestionForm(@RequestParam(value = "qid") int questionid, HttpServletRequest request, Model model) {
		logger.info("::::: Loaded Edit Form Controller :::::");
		
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
		
		
		QuestionBank questionBank = new QuestionBank();
		
		QuestionService questionService = (QuestionService) ctx.getBean("questionService");
		questionBank = questionService.fetchSingleChoiceQuestionForEdit(questionid);
		
		logger.info("::::: "+questionBank.getQuestionType()+"::"+questionBank.getQuestionid()+"::"+questionBank.getShuffle()+"::"+questionBank.getArchived());
		
		
		questionBank.setOptions(questionBank.getOptions());
		
		Set<OptionBank> options = questionBank.getOptions();
		List<OptionBank> optList = new ArrayList<OptionBank>(options);
		OptionBankSortedWithComparator comparator = new OptionBankSortedWithComparator();
		
		Collections.sort(optList, comparator);
		
		logger.info("List is :: "+optList);
		
		Iterator<OptionBank> it = optList.iterator();
		while(it.hasNext()) {
			OptionBank opt = it.next();
			logger.info("::::: Option Id "+opt.getOptionId()+" ::::: Option Text "+opt.getOptionText()+" ::::: Option Correctness "+opt.getOptionCorrectness()+" :::::");
		}
		
		model.addAttribute("optListSize", optList.size());
		model.addAttribute("optList", optList);  	//set the sorted list as model
		model.addAttribute("questionBank", questionBank);
		model.addAttribute("advts", advts);
		
		return "questionbank/editsinglechoicequestion";
	}
}
