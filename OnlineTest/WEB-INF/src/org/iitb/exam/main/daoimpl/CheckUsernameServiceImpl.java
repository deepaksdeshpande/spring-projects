package org.iitb.exam.main.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.iitb.exam.main.dao.CheckUsernameService;
import org.iitb.exam.main.dto.UserDetails;
import org.iitb.exam.main.utils.GrandCentralPasswordHashGenerator;

public class CheckUsernameServiceImpl implements CheckUsernameService{

	static final Logger log = Logger.getLogger(UserDetailsServiceImpl.class);

	private SessionFactory sessionFactory;

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
	
	@Override
	public UserDetails checkUsername(String username) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("USername: "+username);
		Query query = session.createQuery("from UserDetails as u where u.userName = :username");
		query.setString("username", username);
		
		@SuppressWarnings("unchecked")
		List<UserDetails> usernameList = (ArrayList<UserDetails>) query.list();
		System.out.println("LIST SIZE: "+usernameList.size());
		transaction.commit();
		
		UserDetails userDetails = null;
		for(UserDetails el :usernameList){
			userDetails = new UserDetails();
			userDetails=el;
		}
		session.close();
		return userDetails;
	}
}
