package org.iitb.exam.main.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.iitb.exam.main.dao.EnterExamDetails;
import org.iitb.exam.main.dto.Exam;

public class EnterExamDetailsImpl implements EnterExamDetails{

	private SessionFactory sessionFactory;
	
	Session session;

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
	public Boolean enterExamDetails(Exam exam) {
		this.sessionFactory.getCurrentSession().save(exam);
		return null;
	}
}