package org.iitb.exam.main.formcontrollers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.iitb.exam.main.dao.QuestionBankService;
import org.iitb.exam.main.dao.UserDetailsService;
import org.iitb.exam.main.dao.UserRegistrationService;
import org.iitb.exam.main.dao.UserRoleService;
import org.iitb.exam.main.daoimpl.MailServiceImpl;
import org.iitb.exam.main.dto.Advertisements;
import org.iitb.exam.main.dto.Designation;
import org.iitb.exam.main.dto.Exam;
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
public class RegistrationFormController {
	private SessionFactory sessionFactory;
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"spring-hibernate-servlet.xml");
	protected final Logger logger = Logger.getLogger(ExamLoginController.class);
	private Exam exam;
	Session session;

	/**
	 * 
	 */
	public RegistrationFormController() {
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

	@RequestMapping("/usercreated.htm")
	public String createUser(HttpServletRequest request, Model model) {
		UserRoleService userRoleService = (UserRoleService) context
				.getBean("fetchUserRole");
		UserRegistrationService userService = (UserRegistrationService) context
				.getBean("createUser");
		UserDetailsService userDetailsService = (UserDetailsService) context
				.getBean("fetchUserDetails");

		UserDetails user = new UserDetails();
		String name = request.getParameter("name").trim();
		String email = request.getParameter("email").trim();
		String age = request.getParameter("age").trim();
		String userName = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		Integer gender = Integer
				.parseInt(request.getParameter("gender").trim());
		Boolean emailRegistered = userDetailsService.checkEmail(email);
		MailServiceImpl mailSend = new MailServiceImpl();
		StringBuffer sb = new StringBuffer();
		String message = null;
		String recipients[] = new String[1];
		String subject = null;
		if (emailRegistered) {
			user.setName(name);
			user.setEmailid(email);
			user.setPassword(password);
			user.setAge(Integer.parseInt(age));
			user.setUserName(userName);
			if (gender == 1) {
				user.setGender(true);
			} else {
				user.setGender(false);
			}

			UserRole userRole = userRoleService.fetchUserRole(1);
			user.setUserRole(userRole);
			Date d = new Date();
			user.setRegistrationDate(d);
			userService.createUser(user);

			recipients[0] = email;
			try {
				FileReader file = new FileReader(request.getServletContext()
						.getRealPath("/") + "/mailtext/registrationsuccess.txt");
				BufferedReader br = new BufferedReader(file);
				while ((message = br.readLine()) != null) {
					if (message
							.contains("http://localhost:8080/OnlineTest/registrationactivation.htm?id=<email>")) {
						message = message.replaceFirst("\\<email\\>", email
								+ "");
					}
					sb.append(message);
					sb.append("\n");
				}
				message = sb.toString();
				br.close();
				subject = "Successful Registration for the IITB Recruitment";
				mailSend.sendSSLMessage(recipients,
						"mhrd-recruit@cse.iitb.ac.in", subject, message,
						"mhrd-recruit@cse.iitb.ac.in");
			} catch (Exception e) {
				e.printStackTrace();
				return "registration/registration.htm";
			}
			return "registration/userregistrationdone";
		} else {
			recipients[0] = email;
			try {
				FileReader file = new FileReader(request.getServletContext()
						.getRealPath("/")
						+ "/mailtext/registeredmailidused.txt");
				BufferedReader br = new BufferedReader(file);
				while ((message = br.readLine()) != null) {

					sb.append(message);
					sb.append("\n");
				}
				message = sb.toString();
				br.close();
				subject = "Registration was tried for IITB Recruitment using your mail id";
				mailSend.sendSSLMessage(recipients, "mhrd-recruit@cse.iitb.ac.in",
						subject, message, "mhrd-recruit@cse.iitb.ac.in");
			} catch (Exception e) {
				e.printStackTrace();
				return "registration/registration.htm";
			}
			return "registration/useralreadyexist";
		}
	}
}