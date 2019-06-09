/**
 * 
 */
package org.iitb.exam.main.controllers;

import java.io.File;
import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author deepak
 * 
 */
@Controller
@RequestMapping(method = RequestMethod.POST)
public class ExamLogoutController {

	static final Logger logger = Logger.getLogger(ExamLogoutController.class);

	/**
	 * 
	 */
	public ExamLogoutController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "examlogout.htm", method = RequestMethod.POST)
	public String processExamLogout(HttpServletRequest request,
			HttpServletResponse response, Model model)
			throws FileNotFoundException {

		logger.info(":::::: Executing the ExamLogoutController ::::::");

		HttpSession session = request.getSession();

		String sessionId = session.getId();
		logger.info("::::: SESSION ID IS :::::" + sessionId);
		String sessionStr = session.toString();
		File file = new File(request.getServletContext().getRealPath("/")
				+ "/posts/posts" + session.getAttribute("userid") + ".txt");

		if (sessionStr == null) {
			logger.info("::::: SESSION IS ALREADY ::::: " + sessionStr);
			logger.info("::::: SESSION ID IS : " + sessionId);
			if (model.containsAttribute("message")) {
				model.asMap().remove("message");
				logger.info("::::: MODEL ATTRIBUTE REMOVED ::::: ");
			}
			sessionId = null;
			logger.info("::::: SESSION ID NOW IS :::::" + sessionId);
			return "errorpage/sessionexpired";
		} else {
			if (model.containsAttribute("message")) {
				model.asMap().clear();
				logger.info("::::: MODEL ATTRIBUTE CLEARED :::::");
			}
			if(file.exists()) {
				file.delete();
			}
			session.invalidate();
			logger.info(":::::: Session invalidated successfully ::::::");
			session = null;
			sessionId = null;
			logger.info(":::::: Session value after invalidating is :::::: "
					+ session);
			logger.info("::::: Session Id is ::::: " + sessionId);
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Cache-control", "no-store");
			response.setDateHeader("Expires", 0);
			response.setHeader("Pragma", "no-cache");
			logger.info("::::: LOGGED OUT SUCCESSFULLY :::::");
			return "redirect:predisplayeditadvertisementpage.htm";
		}
	}
}