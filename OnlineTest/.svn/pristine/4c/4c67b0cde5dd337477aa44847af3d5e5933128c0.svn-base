/**
 * 
 */
package org.iitb.exam.main.formcontrollers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.iitb.exam.main.dao.ExamLoginService;
import org.iitb.exam.main.dto.Designation;
import org.iitb.exam.main.dto.UserDetails;
import org.iitb.exam.main.utils.GrandCentralPasswordHashGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author deepak
 * 
 */
@Controller
public class ExamLoginFormController implements Serializable {

	private static final long serialVersionUID = 1208052614489460064L;
	static final Logger logger = Logger
			.getLogger(ExamLoginFormController.class);

	ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"spring-hibernate-servlet.xml");

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "examhome.htm", method = RequestMethod.POST)
	public String processEmailLogin(
			@ModelAttribute("examLoginForm") UserDetails userDetails,
			BindingResult result, Model model, HttpServletRequest request,
			SessionStatus sessionStatus) throws Exception {

		ExamLoginService examLoginService = (ExamLoginService) ctx
				.getBean("examLoginService");

		String remoteAddr = request.getRemoteAddr();
		logger.info(":::::: Remote machine IP address is :::::: " + remoteAddr);

		String emailIdForm = request.getParameter("email"); // pass email id
															// through url here
		CharSequence passwdForm = request.getParameter("password");
		
		logger.info("::::: Email Id from Form is : " + emailIdForm);

		userDetails.setEmailid(emailIdForm);
		logger.info(":::::: Email id entered is :::::: " + userDetails.getEmailid());

		logger.info(":::::: LOADED Exam Login Form CONTROLLER ::::::");

		HttpSession session = request.getSession(true);
		ArrayList<Designation> posts;
		int roleId = 0;
		logger.info("Session : " + session.getAttribute("roleId"));
		if (session.getAttribute("roleId") != null) {
			roleId = Integer.parseInt(session.getAttribute("roleId").toString());
		}
		if (session.getAttribute("email") != null && roleId != 1) {
			if (session.getAttribute("email") != null && roleId == 3) {
				FileInputStream fileIn = new FileInputStream(request.getServletContext().getRealPath("/") + "/designation/designations"	+ session.getAttribute("advtId") + ".txt");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				posts = (ArrayList<Designation>) in.readObject();
				model.addAttribute("posts", posts);
				in.close();
				return "examhome/paHome";
			} else {
				FileInputStream fileIn = new FileInputStream(request.getServletContext().getRealPath("/") + "/posts/posts"+ session.getAttribute("userid") + ".txt");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				posts = (ArrayList<Designation>) in.readObject();
				model.addAttribute("posts", posts);
				in.close();
				return "examhome/examhome";
			}
		} else if (session.getAttribute("email") != null && roleId == 1) {
			FileInputStream fileIn = new FileInputStream(request.getServletContext().getRealPath("/") + "/designation/designations"	+ session.getAttribute("advtId") + ".txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			posts = (ArrayList<Designation>) in.readObject();
			model.addAttribute("posts", posts);
			in.close();
			return "examhome/adminHome";

		}
		else {
			logger.info("::::: LOADED THE LOGIN SERVICE BEAN :::::");

			if (emailIdForm != null && passwdForm != null
					&& userDetails.getEmailid() != null
					&& !emailIdForm.equals("") && !passwdForm.equals("")
					&& !userDetails.getEmailid().equals("")) {
				userDetails = examLoginService.performLogin(emailIdForm);
				
				if (userDetails == null) {														// Change Added on 17 Apr for display Wrong Email or wrong Password if 
					session.setAttribute("error", "errorEmail");								// Login failed.
					return "redirect:/examlogin.htm";
				} else {
					GrandCentralPasswordHashGenerator encrypt = GrandCentralPasswordHashGenerator.GetInstance();
					if(!(userDetails.getPassword().equals(encrypt.hashPasswordToSHA512(passwdForm.toString())))) {
						session.setAttribute("error", "errorPassword");
						emailIdForm = null;
						passwdForm = null;
						return "redirect:/examlogin.htm";
					} else {
						session.setAttribute("email", emailIdForm);
						session.setAttribute("roleId", userDetails.getUserRole().getUserRoleId());
						session.setAttribute("roleName", userDetails.getUserRole().getUserRoleName());
						session.setAttribute("userid", userDetails.getUserDetailsId());
						session.setAttribute("userName", userDetails.getName());
						emailIdForm = null;
						passwdForm = null;
						logger.info("" + session.getAttribute("email"));
						logger.info("" + userDetails.getEmailid());

						// Redirecting pa user, admin user to admin and pa home page respectively.
						if (userDetails.getUserRole().getUserRoleId() == 1 || userDetails.getUserRole().getUserRoleId() == 3) {
							ArrayList<Designation> designations = new ArrayList<Designation>();
							FileInputStream fileIn = new FileInputStream(request.getServletContext().getRealPath("/") + "/designation/designations" + session.getAttribute("advtId") + ".txt");
							ObjectInputStream in = new ObjectInputStream(fileIn);
							designations = (ArrayList<Designation>) in.readObject();
							in.close();
							model.addAttribute("posts", designations);
							if (userDetails.getUserRole().getUserRoleId() == 1)
								return "examhome/adminHome";
							else
								// Redirecting admin user to admin home page.
								return "examhome/paHome";
						}
						
						Set<Designation> it = userDetails.getAdvtByDesg().keySet();
						posts = new ArrayList<Designation>(it);
						
						if (session.getAttribute("email") != null && session.getAttribute("email").equals(userDetails.getEmailid())) {
							model.addAttribute("posts", posts);
							logger.info(request.getServletContext().getRealPath("/"));
							FileOutputStream fileOut = new FileOutputStream(request.getServletContext().getRealPath("/") + "/posts/posts" + session.getAttribute("userid") + ".txt");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(posts);
							out.close();
							model.addAttribute("email", emailIdForm);
							logger.info(":::::: Login succeeded :::::::");
							logger.info(":::::: Session value after logging in is :::::: " + session.getAttribute("email"));
							model.addAttribute("message", "Welcome " + session.getAttribute(emailIdForm));
							return "examhome/examhome";
						} else {
							session.setAttribute("error", "error");
							return "redirect:/examlogin.htm";
						}
					}
				}
			} else {
				session.setAttribute("error", "error");
				return "redirect:/examlogin.htm";
			}
		}
	}
}