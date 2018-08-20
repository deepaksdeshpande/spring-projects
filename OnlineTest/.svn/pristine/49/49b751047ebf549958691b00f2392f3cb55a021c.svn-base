package org.iitb.exam.main.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.iitb.exam.main.dao.CreateContactUsService;
import org.iitb.exam.main.dto.ContactusDetails;

public class CreateContactUsServiceImpl implements CreateContactUsService {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createContactUs(ContactusDetails contact) {
		
		Session sessions = getSessionFactory().openSession();
		sessions.beginTransaction();
		sessions.save(contact);
		sessions.getTransaction().commit();
		
	}
	
	

}
