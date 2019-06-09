package org.iitb.exam.main.daoimpl;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.iitb.exam.main.controllers.ExamLoginController;
import org.iitb.exam.main.dao.CreateExamService;
import org.iitb.exam.main.dto.Exam;

public class CreateExamServiceImpl implements CreateExamService {

	private SessionFactory sessionFactory;
	protected final Logger logger = Logger.getLogger(ExamLoginController.class);

	HttpSession session;

	/**
	 * 
	 */
	public CreateExamServiceImpl() {
		// TODO Auto-generated constructor stub
	}

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
	public void createExam(Exam exam, Set<String> questionSelectedSet, int desgId, int advtId) {
		// public void createExam(Exam exam) {
		Session sessions = getSessionFactory().openSession();
		sessions.beginTransaction();
		sessions.save(exam);
		int examId = 0;
		Query query = sessions.getNamedQuery("examId.byexamName");
		query.setString(0, exam.getExamName());
		for (Exam a : (List<Exam>) query.list()) {
			examId = a.getExamid();
		}
		query = sessions.getNamedQuery("insertInExamQuestionMapping.byexamid");
		@SuppressWarnings("rawtypes")
		Iterator it = questionSelectedSet.iterator();
		while (it.hasNext()) {
			query.setInteger(0, examId);
			query.setInteger(1, Integer.parseInt((String) it.next()));
			query.executeUpdate();
		}

		query = sessions.getNamedQuery("insertInAdvtExamDesgMapping");
		query.setInteger(0, advtId);
		query.setInteger(1, examId);
		query.setInteger(2, desgId);
		query.executeUpdate();
		sessions.getTransaction().commit();
		sessions.close();
		logger.info("End time : " + Calendar.getInstance().getTimeInMillis());
	}

/*********************************************************************************/
	
	@SuppressWarnings("unchecked")
	@Override
	public void createExamAndAdvtExamMapping(Exam exam,
			Set<String> questionSelectedSet) {

		Session sessions = getSessionFactory().openSession();
		sessions.beginTransaction();
		sessions.save(exam);

		int examId = 0;
		Query query = sessions.getNamedQuery("examId.byexamName");
		query.setString(0, exam.getExamName());
		for (Exam a : (List<Exam>) query.list()) {
			examId = a.getExamid();
		}

		query = sessions.getNamedQuery("insertInExamQuestionMapping.byexamid");
		@SuppressWarnings("rawtypes")
		Iterator it = questionSelectedSet.iterator();
		while (it.hasNext()) {
			query.setInteger(0, examId);
			query.setInteger(1, Integer.parseInt((String) it.next()));
			query.executeUpdate();
		}
	}
}