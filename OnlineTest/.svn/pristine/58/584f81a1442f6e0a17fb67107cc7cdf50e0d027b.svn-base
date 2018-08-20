package org.iitb.exam.main.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.iitb.exam.main.dao.UserRegistrationService;
import org.iitb.exam.main.dto.UserDetails;

public class UserRegistrationServiceImpl implements UserRegistrationService{

	private SessionFactory sessionFactory;
	
	Session session;
	/**
	 * 
	 */
	public UserRegistrationServiceImpl() {
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
	
	@Override
	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub
		Session sessions = getSessionFactory().openSession();
		sessions.beginTransaction();
		sessions.save(user);
        sessions.getTransaction().commit();
	}
	
	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		Session sessions = getSessionFactory().openSession();
		sessions.beginTransaction();
		sessions.update(user);
        sessions.getTransaction().commit();
	}
}
