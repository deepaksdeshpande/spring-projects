package org.iitb.exam.main.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.iitb.exam.main.dao.QualificationService;
import org.iitb.exam.main.dto.QualificationDetails;

public class QualificationServiceImpl implements QualificationService{
private SessionFactory sessionFactory;
	
	Session session;
	/**
	 * 
	 */
	public QualificationServiceImpl() {
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
	public void insertQualification(QualificationDetails qualification) {
		// TODO Auto-generated method stub
		Session sessions = getSessionFactory().openSession();
		sessions.beginTransaction();
		sessions.saveOrUpdate(qualification);
        sessions.getTransaction().commit();
        sessions.close();
	}
}
