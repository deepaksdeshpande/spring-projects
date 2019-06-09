package org.iitb.exam.main.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.iitb.exam.main.dao.DesignationService;
import org.iitb.exam.main.dto.Designation;

public class DesignationServiceImpl implements DesignationService {

	static final Logger log = Logger.getLogger(DesignationServiceImpl.class);

	private SessionFactory sessionFactory;

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

	
	public ArrayList<Designation> fetchDesignation(int advtId) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		//Query query = session.createQuery("FROM Advt_Desg_UserDetails_Mapping where advertisementId = :advertisementId");
		Query query = session.getNamedQuery("designation.byAdvtId");
		query.setInteger(0, advtId);
		@SuppressWarnings("unchecked")
		ArrayList<Designation> posts = (ArrayList<Designation>) query.list();
		log.info("Post : " + posts);
		transaction.commit();
		session.close();
		return posts;
	}


	public ArrayList<Designation> getDesignationsByAdvtId(int advtId) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		//Query query = session.createQuery("FROM Advt_Desg_UserDetails_Mapping where advertisementId = :advertisementId");
		Query query = session.getNamedQuery("designation.byAdvtId");
		query.setInteger(0, advtId);
		@SuppressWarnings("unchecked")
		ArrayList<Designation> designationList = (ArrayList<Designation>) query.list();
		log.info("::::: Size of Designations for this advt is ::::: "+designationList.size());
		transaction.commit();
		session.close();
		return designationList;
	}
	
	
	public List<Designation> getDesignationDetails(Set<String> desgNameSet) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Object[] params = desgNameSet.toArray();
		
		Query query = session.createQuery("from Designation where designationName in (:desgNameSet)");
		query.setParameterList("desgNameSet", params);
		@SuppressWarnings("unchecked")
		ArrayList<Designation> desgList = (ArrayList<Designation>) query.list();
		
		transaction.commit();
		session.close();
		return desgList;
	}
	
	
}