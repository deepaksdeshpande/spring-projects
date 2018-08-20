/**
 * 
 */
package org.iitb.exam.main.daoimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.iitb.exam.main.dao.QuestionService;
import org.iitb.exam.main.dto.OptionBank;
import org.iitb.exam.main.dto.QuestionBank;

import com.google.gson.Gson;

/**
 * @author deepak
 *
 */
public class QuestionServiceImpl implements QuestionService {
	
	private static final Logger logger = Logger.getLogger(QuestionServiceImpl.class);
	
	private SessionFactory sessionFactory;
	/**
	 * 
	 */
	public QuestionServiceImpl() {
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
	 * @see org.iitb.exam.main.dao.QuestionService#addQuestion(org.iitb.exam.main.dto.QuestionBank)
	 */
	@Override
	public void addQuestion(QuestionBank questionBank, List<OptionBank> optionBank) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		questionBank.setQuestionCategory(questionBank.getQuestionCategory());
		questionBank.setLevelOfDifficulty(questionBank.getLevelOfDifficulty());
		questionBank.setQuestionType(questionBank.getQuestionType());
		questionBank.setQuestionText(questionBank.getQuestionText());
		
		questionBank.setArchived(0);
		questionBank.setShuffle(0);
		
		session.saveOrUpdate(questionBank);
		
		logger.info("::::: Question Id is ::::: "+questionBank.getQuestionid());
		logger.info("::::: Question Category is ::::: "+questionBank.getQuestionCategory());
		logger.info("::::: Question Type is ::::: "+questionBank.getQuestionType());
		logger.info("::::: Level of Difficulty is ::::: "+questionBank.getLevelOfDifficulty());
		logger.info("::::: Question Text is ::::: "+questionBank.getQuestionText());
		logger.info("::::: Question Archived is ::::: "+questionBank.getArchived());
		logger.info("::::: Question Shuffle is ::::: "+questionBank.getShuffle());
		
		logger.info(":::::: Saved the question to the question bank :::::");
		
			if(session.contains(questionBank)==true) {
				for(int i=0; i<optionBank.size(); i++) {	
					OptionBank optBank = new OptionBank();
					logger.info("::::: Option Id is ::::: "+optionBank.get(i).getOptionId());
					optBank.setOptionText(optionBank.get(i).getOptionText());
					logger.info("::::: Option Text is ::::: "+optionBank.get(i).getOptionText());
					optBank.setOptionCorrectness(optionBank.get(i).getOptionCorrectness());
					logger.info("::::: Option Correctness is ::::: "+optionBank.get(i).getOptionCorrectness());
					optBank.setQuestion(questionBank);
					logger.info("Question Id for this option is ::::: "+questionBank.getQuestionid());
					session.saveOrUpdate(optBank);
				}
			}
		session.flush();
		transaction.commit();
		session.close();				
	}

	@Override
	public List<QuestionBank> displayAllAddedQuestions() {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from QuestionBank as qb");
		
		@SuppressWarnings("unchecked")
		List<QuestionBank> allQuestionsList = (ArrayList<QuestionBank>) query.list();
		List<QuestionBank> qBankList = new ArrayList<QuestionBank>();
		
		for(QuestionBank questionBank : allQuestionsList) {
			QuestionBank qBank = new QuestionBank();
			qBank=questionBank;
			logger.info("::::: Question Id ::::: "+qBank.getQuestionid());
			logger.info("::::: Question Type ::::: "+qBank.getQuestionType());
			logger.info("::::: Question Category ::::: "+qBank.getQuestionCategory());
			logger.info("::::: Question Level of difficulty ::::: "+qBank.getLevelOfDifficulty());
			logger.info("::::: Question Shuffle is ::::: "+qBank.getShuffle());
			logger.info("::::: Question Archived is ::::: "+qBank.getArchived());
			qBankList.add(qBank);
		}
		logger.info("::::: Total no of Questions is ::::: "+qBankList.size());
		transaction.commit();
		session.close();
		return qBankList;
	}

	/*
	 * Get a particular question from the database for editing
	 */
	
	/*(non-Javadoc)
	 * @see org.iitb.exam.main.dao.QuestionService#fetchQuestionForEdit(int, java.util.List)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public QuestionBank fetchSingleChoiceQuestionForEdit(int questionid) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from QuestionBank where questionid = :questionid");
		query.setInteger("questionid", questionid);
		
		ArrayList<QuestionBank> questionDetailsList = (ArrayList<QuestionBank>) query.list();
				
		QuestionBank questionBank = new QuestionBank();
		
		QuestionBank qb = questionDetailsList.get(0);
		
		questionBank.setQuestionid(qb.getQuestionid());
		questionBank.setQuestionText(qb.getQuestionText());
		questionBank.setQuestionCategory(qb.getQuestionCategory());
		questionBank.setQuestionType(qb.getQuestionType());
		questionBank.setLevelOfDifficulty(qb.getLevelOfDifficulty());
		questionBank.setShuffle(qb.getShuffle());
		questionBank.setArchived(qb.getArchived());

		Query optQuery = session.getNamedQuery("exam.getExamOption");
		optQuery.setInteger(0, qb.getQuestionid());
		
		List<OptionBank> optionList = (ArrayList<OptionBank>) optQuery.list();
		
		Set<OptionBank> optionSet = new HashSet<OptionBank>(optionList);
		
		@SuppressWarnings("unused")
		Gson gson = new Gson();
		@SuppressWarnings("unused")
		OptionBank[] optionArray = new OptionBank[optionSet.size()];
		
		Iterator<OptionBank> it = optionList.iterator();
		while(it.hasNext()) {
			OptionBank optionBank=it.next();
			logger.info("::::: Option Id: " + optionBank.getOptionId()
					+ " Option Text : " + optionBank.getOptionText()
					+ " Option Correctness "
					+ optionBank.getOptionCorrectness() + ":::::");
		}
						
		questionBank.setOptions(optionSet);
		
		transaction.commit();
		session.close();
		
		logger.info("::::: Question to be edited ::::: "+questionBank.getQuestionid()+"..."+questionBank.getQuestionText()+"..."+questionBank.getQuestionType()+"..."+optionSet);
 		return questionBank;
	}
	
	
	
	/*
	 * Update Question
	 */
	
	/*
	 * (non-Javadoc)
	 * @see org.iitb.exam.main.dao.QuestionService#updateQuestionBankByQId(int, int, int, int, int, java.lang.String, java.lang.String, int, int, java.lang.String)
	 */

	@Override
	public void updateSingleChoiceQuestionById(int questionid, 
			int levelOfDifficulty, int shuffle, int archived,
			String questionText, int optionid,
			int optionCorrectness, String optionText) {
		// TODO Auto-generated method stub
		
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session
				.createQuery("UPDATE QuestionBank set "
						+ "levelOfDifficulty = :levelOfDifficulty, "
						+ "shuffle = :shuffle, archived = :archived, "
						+ "questionText = :questionText "
						+ "WHERE questionid = :questionid");
		
		query.setParameter("levelOfDifficulty", levelOfDifficulty);
		query.setParameter("shuffle", shuffle);
		query.setParameter("archived", archived);
		query.setParameter("questionText", questionText);
		query.setParameter("questionid", questionid);
		
		QuestionBank qBank = new QuestionBank();
		
		qBank.setLevelOfDifficulty(levelOfDifficulty);
		qBank.setArchived(archived);
		qBank.setShuffle(shuffle);
		qBank.setQuestionText(questionText);
		
		//transaction.commit();
		//session.flush();
	
		logger.info("::::: Updated Question Level of difficulty ::::: "+qBank.getLevelOfDifficulty());
		logger.info("::::: Updated Question Shuffle is ::::: "+qBank.getShuffle());
		logger.info("::::: Updated Question Archived is ::::: "+qBank.getArchived());
		int result = query.executeUpdate();
		logger.info("::::: Question Bank updated successfully :::::: "+result);
		
		//if(session.contains(qBank)==true) {
			OptionBank optBank = new OptionBank();
			Query optQuery = session.createQuery("Update OptionBank set "
					+ "optionCorrectness = :optionCorrectness, "
					+ "optionText = :optionText "
					+ "WHERE questionid = :questionid "
					+ "AND optionid = :optionid");
			optQuery.setParameter("optionCorrectness", optionCorrectness);
			optQuery.setParameter("optionText", optionText);
			optQuery.setParameter("questionid", questionid);
			optQuery.setParameter("optionid", optionid);
			
			//optBank.setOptionId(optionid);
			optBank.setOptionCorrectness(optionCorrectness);
			optBank.setOptionText(optionText);
			optBank.setQuestion(qBank);
			
			int queryResult = optQuery.executeUpdate();
			logger.info("::::: OptionBank table updated successfully :::::"+queryResult);
			
			transaction.commit();
			session.flush();
			session.close();		
		//}
	}

	
}
