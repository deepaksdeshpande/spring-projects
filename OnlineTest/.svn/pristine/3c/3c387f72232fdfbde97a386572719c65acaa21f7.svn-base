package org.iitb.exam.main.daoimpl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.iitb.exam.main.dao.ExperienceService;
import org.iitb.exam.main.dto.ExperienceDetails;

public class ExperienceServiceImpl implements ExperienceService{
	private static final Logger logger = Logger.getLogger(QuestionServiceImpl.class);
	
	private SessionFactory sessionFactory;
	/**
	 * 
	 */
	public ExperienceServiceImpl() {
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
	public void insertExperience(ExperienceDetails experience) {
		// TODO Auto-generated method stub
		Session sessions = getSessionFactory().openSession();
		sessions.beginTransaction();
		sessions.saveOrUpdate(experience);
		sessions.getTransaction().commit();
		sessions.close();
	}

}
