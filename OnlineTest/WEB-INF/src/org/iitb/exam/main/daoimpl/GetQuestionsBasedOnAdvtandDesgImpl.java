package org.iitb.exam.main.daoimpl;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.iitb.exam.main.dao.GetQuestionsAdvtandDesgService;
import org.iitb.exam.main.dto.QuestionBank;

public class GetQuestionsBasedOnAdvtandDesgImpl implements
		GetQuestionsAdvtandDesgService {

	protected final Logger logger = Logger
			.getLogger(GetQuestionsBasedOnAdvtandDesgImpl.class);

	private SessionFactory sessionFactory;

	Session session;

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

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<QuestionBank> getQuestionsBasedOnAdvtandDesg(int advtId, int desgId) {
		session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.getNamedQuery("questionbank.byAdvtIdandDesgId");
		query.setInteger(0, desgId);
		query.setInteger(1, advtId);
		logger.info(query.toString());
		ArrayList<QuestionBank> questionList = (ArrayList<QuestionBank>) query.list();
		transaction.commit();
		session.close();
		return questionList;
	}

}
