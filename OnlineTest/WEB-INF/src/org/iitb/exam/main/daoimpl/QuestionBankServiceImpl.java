package org.iitb.exam.main.daoimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.iitb.exam.main.dao.QuestionBankService;
import org.iitb.exam.main.dto.QuestionBank;

public class QuestionBankServiceImpl implements QuestionBankService{
private SessionFactory sessionFactory;
	
	Session session;
	/**
	 * 
	 */
	public QuestionBankServiceImpl() {
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
	@Override
	public Set<QuestionBank> fetchRandomQuestions() {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from QuestionBank order by RAND()");
		query.setMaxResults(12);
		@SuppressWarnings("unchecked")
		ArrayList<QuestionBank> questionList = (ArrayList<QuestionBank>) query.list();
		Set<QuestionBank> questionSet = new HashSet<QuestionBank>(questionList);
		transaction.commit();
		session.close();
		return questionSet;
	}
}
