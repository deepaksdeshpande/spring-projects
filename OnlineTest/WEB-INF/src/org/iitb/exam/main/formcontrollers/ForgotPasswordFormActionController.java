package org.iitb.exam.main.formcontrollers;

import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.iitb.exam.main.dao.ExamLoginService;
import org.iitb.exam.main.dao.UserDetailsService;
import org.iitb.exam.main.daoimpl.MailServiceImpl;
import org.iitb.exam.main.utils.SimpleStringCipher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class ForgotPasswordFormActionController {

	ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"spring-hibernate-servlet.xml");
	static final Logger logger = Logger
			.getLogger(ExamLoginFormController.class);

	@RequestMapping(value = "forgotPasswordFormAction", method = RequestMethod.POST)
	public @ResponseBody String forgotPasswordFormAction(HttpServletRequest request, SessionStatus sessionStatus, Model model) {

		logger.info("In forgotPasswordFormAction");
		UserDetailsService userDetailsService = (UserDetailsService) ctx.getBean("fetchUserDetails");
        logger.info("emailId : " + request.getParameter("emailId"));
		if(userDetailsService.checkEmail(request.getParameter("emailId"))) {
			logger.info("In If not matched");
			request.setAttribute("notReg", "true");
			return "notReg";
		} else {
			logger.info("In else matched");
			model.addAttribute("notReg", "false");
			String message = "";
			ExamLoginService examLoginService = (ExamLoginService) ctx.getBean("examLoginService");
			String link = examLoginService.generateForgotPasswordLink(request.getParameter("emailId"));
			logger.info("Link is : " + link);
			//MailServiceImpl mail = new MailServiceImpl();
			try {
				File messagefile = new File(request.getServletContext().getRealPath("/").concat("/mails/forgot_password_text.txt"));
	 
	            Scanner scanner = new Scanner(messagefile);
	            while (scanner.hasNextLine()) {
	                message += scanner.nextLine();
	                if(message.contains("<email>"))
	                	message = message.replaceAll("\\<email\\>", "http://"+request.getLocalAddr()+":"+request.getLocalPort()+request.getContextPath()+"/".concat(link));
	            }
	            String [] sendingEmails = {request.getParameter("emailId")};
	            logger.info("message : " + message);
				//mail.sendSSLMessage(sendingEmails, "mhrd-recruit@cse.iitb.ac.in", "Forgot Password Initiated by User", message, "mhrd-recruit@cse.iitb.ac.in");
				model.addAttribute("email", request.getParameter("emailId"));
				return "reg";
			} catch (Exception e) {
				e.printStackTrace();
				return "exam/" + link;
			}
		}
	}
	
	/*
	 * Mapping for Forgot Password
	 */
	@RequestMapping(value="/forgotPasswordLinkSend.htm", method = RequestMethod.GET)
	public String displayForgotPassword(HttpServletRequest request, Model model) {
		logger.info("::::: Loading the forgotPasswordLinkSend page... ::::: ");
		return "exam/forgotPasswordLinkSend";
	}

	/*
	 * 
	 */
	@RequestMapping(value = "forgotPasswordRecovery.htm", method = RequestMethod.GET)
	public String forgotPasswordRecovery(HttpServletRequest request, SessionStatus sessionStatus, Model model) {
		logger.info("In forgotPasswordRecovery.htm");
		String url = request.getParameter("url");
		url = url.trim();
		if (url != null && !url.equals("")) {
			try {
				url = SimpleStringCipher.decrypt(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("url : " + url);
			url = url.trim();
			String id = url.split("\\$\\$")[0];
			logger.info("id : " + id);
			String email = url.split("\\$\\$")[1];
			logger.info("email : " + email);
			model.addAttribute("userid", id);
			model.addAttribute("email", email);
			logger.info("userid is : " + id);
			logger.info("email is : " + email);
			return "exam/forgotPasswordRecovery";
		} else {
			return "errorpages/sessionexpired";
		}
	}

	/*
	 * 
	 */
	@RequestMapping(value = "changePassword.htm", method = RequestMethod.POST)
	public String changePassword(HttpServletRequest request, SessionStatus sessionStatus, Model model) {
		logger.info("In changePassword");
		int success = 0;
		String userId = request.getParameter("userId");
		String email = request.getParameter("email");
		String newPassword = request.getParameter("newPassword");
		newPassword = newPassword.trim();
		if (newPassword != null && !newPassword.equals("")) {
			logger.info("newPassword : " + newPassword);
			logger.info("userid is : " + userId);
			logger.info("email is : " + email);

			ExamLoginService examLoginService = (ExamLoginService) ctx.getBean("examLoginService");
			success = examLoginService.changePassword(newPassword, Integer.parseInt(userId));
			if(success == 1) {
				model.addAttribute("email", email);
				return "exam/forgotPasswordRecoverySucess";
			} else {
				model.addAttribute("fail", "fail");
				return "exam/forgotPasswordRecovery";
			}
		} else {
			model.addAttribute("wrong", "wrong");
			return "exam/forgotPasswordRecovery";
		}
	}
}