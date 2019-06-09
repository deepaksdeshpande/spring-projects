package org.iitb.exam.main.daoimpl;
/**
 * Dinesh
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.iitb.exam.main.dao.Desg_Exam_AdvtServices;
import org.iitb.exam.main.dto.Designation;

public class Desg_Exam_AdvtServiceImpl implements Desg_Exam_AdvtServices{
private SessionFactory sessionFactory;
	
	Session session;
	/**
	 * 
	 */
	public Desg_Exam_AdvtServiceImpl() {
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
	public Designation fetchDesignation(int desgId) {
		// TODO Auto-generated method stub
		Designation desg = new Designation();
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("Desgination iD: "+desgId);
		Query query = session.createQuery("from Designation where designationid = :desgId");
		query.setInteger("desgId", desgId);
		@SuppressWarnings("unchecked")
		ArrayList<Designation> designationList = (ArrayList<Designation>) query.list();
		@SuppressWarnings("unused")
		Set<Designation> designationSet = new HashSet<Designation>(designationList);
		for (int i = 0; i < designationList.size(); i++) {  
			  desg  = (Designation) designationList.get(i);  
		}
		transaction.commit();
		session.close();
		return desg;
	}

}
