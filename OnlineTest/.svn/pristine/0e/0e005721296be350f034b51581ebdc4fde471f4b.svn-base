 /**
 * 
 */
package org.iitb.exam.main.daoimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.iitb.exam.main.dao.ExamLoginService;
import org.iitb.exam.main.dto.UserDetails;
import org.iitb.exam.main.utils.GrandCentralPasswordHashGenerator;
import org.iitb.exam.main.utils.SimpleStringCipher;

/**
 * @author deepak
 *
 */
public class ExamLoginServiceImpl implements ExamLoginService {

	private SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(ExamLoginServiceImpl.class);
	
	/**
	 * 
	 */
	public ExamLoginServiceImpl() {
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

	/* (non-Javadoc)
	 * @see org.iitb.exam.dao.LoginService#performLogin(java.lang.String)
	 */
//	@Override
//	public UserDetails performLogin(String emailId) {
//		// TODO Auto-generated method stub
//		Session session = getSessionFactory().openSession();
//		Transaction transaction = session.beginTransaction();
//		Query query = session.createQuery("from UserDetails as u where u.emailid = :emailId");
//		query.setString("emailId", emailId);
//		
//		@SuppressWarnings("unchecked")
//		List<UserDetails> emailList = (ArrayList<UserDetails>) query.list();
//		transaction.commit();
//		
//		UserDetails userDetails = new UserDetails();
//		for(UserDetails el :emailList){
//			userDetails=el;
//			System.out.println("Username :"+userDetails.getEmailid());
//		}
//		session.close();
//		return userDetails;
//	}

	@Override
	public UserDetails performLogin(String emailId, String password) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		GrandCentralPasswordHashGenerator encrypt = GrandCentralPasswordHashGenerator.GetInstance();
		password = encrypt.hashPasswordToSHA512(password);
		Query query = session.createQuery("from UserDetails as u where u.emailid = :emailId and password= :passwd");
		query.setString("emailId", emailId);
		query.setString("passwd", password);
		
		@SuppressWarnings("unchecked")
		List<UserDetails> emailList = (ArrayList<UserDetails>) query.list();
		transaction.commit();
		
		UserDetails userDetails = new UserDetails();
		for(UserDetails el :emailList){
			userDetails=el;
			System.out.println("Username :"+userDetails.getEmailid());
		}
		session.close();
		return userDetails;
	}
	
	/**
	 * Following is new implementation of perform login function.
	 * It will help in displaying particular error occurred during login either due to wrong username or password.
	 * Function take 'email' and 'password' as input and returns object of UserDetails dto. 
	 */
	
	@Override
	public UserDetails performLogin(String emailId) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from UserDetails as u where u.emailid = :emailId");
		query.setString("emailId", emailId);

		@SuppressWarnings("unchecked")
		List<UserDetails> emailList = (ArrayList<UserDetails>) query.list();
		transaction.commit();
		
		UserDetails userDetails = new UserDetails();
		if(emailList.size() == 0) {
			userDetails = null;
		} else {
			for(UserDetails el :emailList){
				userDetails=el;
				System.out.println("Username :"+userDetails.getEmailid());
			}
		}
		session.close();
		return (UserDetails) userDetails;
	}
	
	
	
	/*
	 * Following method is used in generating Forgot Password link for Forgot Password utility.
	 * @see org.iitb.exam.main.dao.ExamLoginService#generateForgotPasswordLink(java.lang.String)
	 */
	@Override
	public String generateForgotPasswordLink(String emailId) {
		String link = "";
		String Id = "";
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from UserDetails as u where u.emailid = :emailId");
		query.setString("emailId", emailId);
//		List<UserDetails> emailList = (ArrayList<UserDetails>)session.createCriteria(UserDetails.class).setProjection(Projections.property("userdetailsid")).list();
		@SuppressWarnings("unchecked")
//		List<UserDetails> results = (ArrayList<UserDetails>)query.list();
//		for (Iterator it = results.iterator(); it.hasNext(); ) {
//			   Object[] myResult = (Object[]) it.next();
//			   Id = (String) myResult[0];
//		}
		List<UserDetails> results= (ArrayList<UserDetails>)session.createCriteria(UserDetails.class).add(Restrictions.eq("emailid", emailId)).list(); 
		for (Iterator<UserDetails> it = results.iterator(); it.hasNext(); ) {
				UserDetails myResult = it.next();
			   Id = String.valueOf(myResult.getUserDetailsId());
		}
		logger.info("Id : " + Id);
		try {
			link = "forgotPasswordRecovery.htm?url="+SimpleStringCipher.encrypt(Id.concat("$$").concat(emailId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		transaction.commit();
		return link;
	}

	@Override
	public int changePassword(String password, int userID) {

		Transaction transaction = null;
		Session session = null;
		int success = 0;
	    try{
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			UserDetails userDetails = (UserDetails) session.get(UserDetails.class, userID);
			GrandCentralPasswordHashGenerator generator = GrandCentralPasswordHashGenerator.GetInstance();
			userDetails.setPassword(generator.hashPasswordToSHA512(password));
			session.update(userDetails);
			transaction.commit();
			success = 1;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
			success = 0;
		} finally {
			session.close();
		}
		return success;
	}
}