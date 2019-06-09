package org.iitb.exam.main.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.iitb.exam.main.dao.GetAdvertistmentDesignationNameService;
import org.iitb.exam.main.dto.Advertisements;
import org.iitb.exam.main.dto.Designation;

public class GetAdvertistmentDesignationNameImpl implements GetAdvertistmentDesignationNameService{

	private SessionFactory sessionFactory;
	protected final Logger logger = Logger.getLogger(GetAdvertistmentDesignationNameImpl.class);
	
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

	@SuppressWarnings("unchecked")
	public String fetchAdvertismentDesignationId(int postId, int advtId) {
		
		logger.info("postId : " + postId + " AdvtId : " + advtId);
		session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String designationName = "";
		String advertisementName = "";
		Query query = session.createQuery("from Designation where designationid = :postId");
		query.setInteger("postId", postId);
		for(Designation a : (List<Designation>)query.list()) {
			designationName = a.getDesignationName();
		}
		logger.info("designationName : " + designationName);
		query = session.createQuery("from Advertisements where advertisementid = :AdvtId");
		query.setInteger("AdvtId", advtId);
		for(Advertisements a : (List<Advertisements>)query.list()) {
			advertisementName = a.getAdvertisementTitle();
		}
		logger.info("advertisementName : " + advertisementName);
		transaction.commit();
		session.close();
		return advertisementName.concat("_").concat(designationName);
	}
}