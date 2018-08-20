package org.iitb.exam.main.formcontrollers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUpload;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.iitb.exam.main.controllers.ExamLoginController;
import org.iitb.exam.main.dao.AdvertisementService;
import org.iitb.exam.main.dao.CreateExamService;
import org.iitb.exam.main.dao.Desg_Exam_AdvtServices;
import org.iitb.exam.main.dao.ExamLoginService;
import org.iitb.exam.main.dao.ExperienceService;
import org.iitb.exam.main.dao.QualificationService;
import org.iitb.exam.main.dao.QuestionBankService;
import org.iitb.exam.main.dao.UserRegistrationService;
import org.iitb.exam.main.dao.UserRoleService;
import org.iitb.exam.main.daoimpl.MailServiceImpl;
import org.iitb.exam.main.dto.Advertisements;
import org.iitb.exam.main.dto.Designation;
import org.iitb.exam.main.dto.Exam;
import org.iitb.exam.main.dto.ExperienceDetails;
import org.iitb.exam.main.dto.QualificationDetails;
import org.iitb.exam.main.dto.QuestionBank;
import org.iitb.exam.main.dto.UserDetails;
import org.iitb.exam.main.dto.UserRole;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class ContactDetailsFormController {
	private SessionFactory sessionFactory;
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate-servlet.xml");
	protected final Logger logger = Logger.getLogger(ExamLoginController.class);
	private Exam exam;
	Session session;
	/**
	 * 
	 */
	public ContactDetailsFormController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
	
	@RequestMapping(value = "/confirmcontactdetails.htm", method = RequestMethod.POST)
	public String createUser(HttpServletRequest request, Model model) throws Exception {
		//UserRoleService userRoleService = (UserRoleService) context.getBean("fetchUserRole");
		UserRegistrationService userService = (UserRegistrationService) context.getBean("createUser");
		ExamLoginService examLoginService = (ExamLoginService) context.getBean("examLoginService");
			
		HttpSession session = request.getSession(true);
		logger.info("Email : " + session.getAttribute("emailId"));
		String emailid = session.getAttribute("emailId").toString();
		UserDetails user = new UserDetails();
		
		String photo = request.getParameter("photo");
		String resume = request.getParameter("resume");
		String altemail = request.getParameter("altemail");
//		String gender = request.getParameter("gender");
//		gender = gender.trim();
//		boolean genders = false;
//		if(gender.equals("M"))
//			genders = true;
//		else
//			genders = false;
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		String landlineno = request.getParameter("landlineno");
		//user.setUserDetailsId(Integer.parseInt(userid));
		user.setUserPhoto(photo);
		user.setResume(resume);
		user.setAltEmailId(altemail);
		user.setmobileno(Long.parseLong(mobile));
		user.setLandLineNo(landlineno);
//		user.setGender(genders);
		user.setPresentAddress(address);
		//userService.createUser(user);
		model.addAttribute("user",user);
		return "registration/confirmcontactdetails";
	}
	
	@RequestMapping(value = "/qualification.htm", method = RequestMethod.POST)
	public String updateUserContactDetails(HttpServletRequest request, Model model) throws Exception {
		logger.info("in professiondetails.htm controller");
		UserRegistrationService userService = (UserRegistrationService) context.getBean("createUser");
		ExamLoginService examLoginService = (ExamLoginService) context.getBean("examLoginService");
			
//		HttpSession session = request.getSession(true);
		String emailId = request.getParameter("emailId"); 
		UserDetails user = new UserDetails();
		UserRole userRole = null;
		user  = examLoginService.performLogin(emailId);
		int userId = 0;
		String name =null;
		int age = 0;
		String username = null;
		String password = null;
		Date regDate = null;
		if(user != null)
		{
			userId = user.getUserDetailsId();
			name = user.getName();
			age = user.getAge();
			username = user.getUserName();
			password = user.getPassword();
			userRole = user.getUserRole();
			regDate = user.getRegistrationDate();
		}
		String photo = request.getParameter("photo");
		String resume = request.getParameter("resume");
		String altemail = request.getParameter("altemail");
//		String gender = request.getParameter("gender");
//		gender = gender.trim();
//		boolean genders = false;
//		if(gender.equals("M"))
//			genders = true;
//		else
//			genders = false;
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		String landlineno = request.getParameter("landlineno");
		user.setName(name);
		user.setEmailid(emailId);
		user.setPassword(password);
		user.setAge(age);
		user.setUserName(username);
		user.setRegistrationDate(regDate);
		user.setUserRole(userRole);
		user.setUserDetailsId(userId);
		user.setUserPhoto(photo);
		user.setResume(resume);
		user.setAltEmailId(altemail);
		user.setmobileno(Long.parseLong(mobile));
		user.setLandLineNo(landlineno);
//		user.setGender(genders);
		user.setPresentAddress(address);
		userService.updateUser(user);
		return "registration/qualification";
	}
	
	@RequestMapping(value = "/addqualification.htm", method = RequestMethod.GET)
	public String insertQualification(HttpServletRequest request, Model model) throws Exception {
		QualificationService qualificationService = (QualificationService) context.getBean("qualificationService");
		ExamLoginService examLoginService = (ExamLoginService) context.getBean("examLoginService");
		
		
		String emailId = request.getParameter("emailId");
		String qualificationDetails[] = request.getParameterValues("qualificationdetails");
		if(qualificationDetails!=null)
			logger.info("Qualificationdetails not null: ");
		else
			logger.info("Qualificationdetails is null ");
	
		String[] qualificationArray = qualificationDetails[0].split(",");
		
		UserDetails user = new UserDetails();
		
		
		
		user  = examLoginService.performLogin(emailId);
		
		for(int i = 0 ; i < qualificationArray.length ; i = i+5 )
		{
			QualificationDetails qualification = new QualificationDetails();
			qualification.setQualificationName(qualificationArray[i]);
			qualification.setPassYear(Integer.parseInt(qualificationArray[i+1]));
			qualification.setUniversity(qualificationArray[i+2]);
			qualification.setPercentage(Integer.parseInt(qualificationArray[i+3]));
			qualification.setQualificationType(qualificationArray[i+4]);
			qualification.setUserDetails(user);
			qualificationService.insertQualification(qualification);
		}	
		return null;
	}
	
	@RequestMapping(value = "/experience.htm", method = RequestMethod.GET)
	public String showExperiencePage(HttpServletRequest request, Model model) throws Exception {
		return "registration/experience";
	}
	
	@RequestMapping(value = "/addexperience.htm", method = RequestMethod.GET)
	public String insertExperience(HttpServletRequest request, Model model) throws Exception {
		ExperienceService experienceService = (ExperienceService) context.getBean("experienceService");
		ExamLoginService examLoginService = (ExamLoginService) context.getBean("examLoginService");
		
		
		String emailId = request.getParameter("emailId");
		String experienceDetails[] = request.getParameterValues("experiencedetails");
		if(experienceDetails!=null)
			logger.info("Qualificationdetails not null: ");
		else
			logger.info("Qualificationdetails is null ");
	
		String[] experienceArray = experienceDetails[0].split(",");
		
		UserDetails user = new UserDetails();
		
		System.out.println(experienceArray.toString());
		
		user  = examLoginService.performLogin(emailId);
		for(int i = 0 ; i < experienceArray.length ; i = i+7 )
		{
			ExperienceDetails experience = new ExperienceDetails();
			experience.setCompanyName(experienceArray[i]);
			experience.setCurrentCTC(Integer.parseInt(experienceArray[i+1]));
			if(experienceArray[i+2].equals("YES"))
				experience.setCurrentCompany(true);
			else
				experience.setCurrentCompany(false);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date startDate = formatter.parse(experienceArray[i+3]);
			experience.setStartDate(startDate);
			Date endDate = formatter.parse(experienceArray[i+4]);
			experience.setEndDate(endDate);
			experience.setPosition(experienceArray[i+5]);
			experience.setYearOfExperience(Integer.parseInt(experienceArray[i+6]));
			experience.setUserDetails(user);
			experienceService.insertExperience(experience);
		}	
		return null;
	}
	
	@RequestMapping(value = "/registrationsuccess.htm", method = RequestMethod.GET)
	public String registrationSuccess(HttpServletRequest request, Model model) throws Exception {
		return "registration/registrationsuccess";
	}
}
