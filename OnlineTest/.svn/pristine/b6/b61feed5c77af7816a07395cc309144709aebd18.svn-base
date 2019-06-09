/**
 * 
 */
package org.iitb.exam.main.daoimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.iitb.exam.main.dao.AdvertisementService;
import org.iitb.exam.main.dto.Advertisements;

/**
 * @author deepak
 *
 */
public class AdvertisementServiceImpl implements AdvertisementService {

	private static final Logger logger = Logger.getLogger(AdvertisementServiceImpl.class);
	
	private SessionFactory sessionFactory;
	
	
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
	public AdvertisementServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Advertisements fetchAdvertisements(int advtId) {
		// TODO Auto-generated method stub
		Advertisements advt = new Advertisements();
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Advertisements where advertisementid = :advtId");
		query.setInteger("advtId", advtId);
		@SuppressWarnings("unchecked")
		ArrayList<Advertisements> advertisementList = (ArrayList<Advertisements>) query.list();
		@SuppressWarnings("unused")
		Set<Advertisements> advertisementSet = new HashSet<Advertisements>(advertisementList);
		for (int i = 0; i < advertisementList.size(); i++) {  
			  advt  = (Advertisements) advertisementList.get(i);  
		} 
		transaction.commit();
		session.close();
		return advt;
	}
	
	/* (non-Javadoc)
	 * @see org.iitb.exam.main.dao.AdvertisementService#getAllAdvertisementNames()
	 */
	@Override
	public ArrayList<Advertisements> getAllAdvertisementNames() {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Advertisements");
		@SuppressWarnings("unchecked")
		ArrayList<Advertisements> advtList = (ArrayList<Advertisements>) query.list();
		logger.info("::::: The Advertisement List size is : "+advtList.size());
		
		transaction.commit();
		session.close();
		return advtList;
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
