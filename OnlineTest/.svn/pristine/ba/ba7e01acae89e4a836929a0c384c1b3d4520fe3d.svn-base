package org.iitb.exam.main.formcontrollers;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.iitb.exam.main.dao.CreateContactUsService;
import org.iitb.exam.main.daoimpl.MailServiceImpl;
import org.iitb.exam.main.dto.ContactusDetails;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AddContactUsController {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-hibernate-servlet.xml");
	
	static final Logger logger = Logger.getLogger(AddContactUsController.class);
	
	
	/*
	 * Submit the contact us form.
	 */
	
	@RequestMapping(method = RequestMethod.POST, value = "/submitcontactusform.htm")
	public String createcontactusform(HttpServletRequest request, Model model) {
				logger.info("::::: Sending the contact us  :::::");
				
				CreateContactUsService createContact = (CreateContactUsService) ctx.getBean("createContactus");
				
				
				MailServiceImpl sendMail = new MailServiceImpl();
			
				String[] sendTo = null;
				sendTo = new String[1];
				
				sendTo[0] ="mhrd-recruit@cse.iitb.ac.in";
				String cc = "vivek0511@gmail.com";
				String emailSubjectTxt = "FeedBack";	
			
				String name = request.getParameter("fullname");
				String emailfrom = request.getParameter("email");
				String phone = request.getParameter("phone");
				String message = request.getParameter("message");
				String drpcontact = request.getParameter("drpcontact");
				
				
								
				logger.info("::::: Sending the contact us name :::::" + name);
				logger.info("::::: Sending the contact us emailfrom  :::::" + emailfrom);
				logger.info("::::: Sending the contact us  phone:::::" + phone);
				logger.info("::::: Sending the contact us  dropdown:::::" + drpcontact);
				logger.info("::::: Sending the contact us message :::::" + message);
				
	

				
				StringBuilder msg = new StringBuilder();
				
				
				msg.append("Name " + name );
				msg.append("        ");
				msg.append("Email " + emailfrom);
				msg.append("        ");
				msg.append("phone " + phone);
				msg.append("           ");
				msg.append("Feedbacl Type " + drpcontact);
				
			
				msg.append(message);
			
				try {
					sendMail.sendSSLMessage(sendTo, cc, emailSubjectTxt, msg.toString(), emailfrom);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				
				
				//create Object of contactus
 
				ContactusDetails contactdetails = new ContactusDetails();
				
				contactdetails.setContactname(name);
				contactdetails.setContactemail(emailfrom);
				contactdetails.setContactphone(phone);
				contactdetails.setFeedbacktype(drpcontact);
				contactdetails.setMessage(message);
				
				createContact.createContactUs(contactdetails);
				
				
				
			   return "contact/contactSuccess";
		}
	
	
	

}
