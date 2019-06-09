package org.iitb.exam.main.daoimpl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.iitb.exam.main.controllers.AddQuestionController;
import org.iitb.exam.main.dao.CreateAdvertisementService;
import org.iitb.exam.main.dto.Advertisements;
import org.apache.log4j.Category;
import org.apache.log4j.Logger;

public class CreateAdvertisementServiceImpl implements CreateAdvertisementService{
	private SessionFactory sessionFactory;
	Session session;	
	private static final Logger logger = Logger.getLogger(AddQuestionController.class);

	
	
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

	/**
	 * 
	 */
	public CreateAdvertisementServiceImpl(){
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Saves into the database
	 * 
	 */
	@Override
	public void createAdvertisements(Advertisements advertisements) {
		Session sessions = getSessionFactory().openSession();
		sessions.beginTransaction();
		sessions.saveOrUpdate(advertisements);
		//sessions.save(advertisements);
		sessions.getTransaction().commit();
	}
	
	/*
	 * updates the records
	 * 
	 */
	
	@Override
	public ArrayList<Advertisements> updateAdvertisements(Integer advtId) {
		
		Session sessions = getSessionFactory().openSession();
		Transaction transaction = sessions.beginTransaction();
		
		Query query = sessions.createQuery("from Advertisements where advertisementid = :advtId");
		
		query.setInteger("advtId", advtId);
		
		@SuppressWarnings("unchecked")
		ArrayList<Advertisements> advtList = (ArrayList<Advertisements>) query.list();
		
		logger.info("::::: updateAdvtController : "+advtList);
    	transaction.commit();
		sessions.close();
		return advtList;
	
	}
	
	
	
}