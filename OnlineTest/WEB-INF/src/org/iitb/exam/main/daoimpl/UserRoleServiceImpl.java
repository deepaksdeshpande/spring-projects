package org.iitb.exam.main.daoimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.iitb.exam.main.dao.UserRoleService;
import org.iitb.exam.main.dto.QuestionBank;
import org.iitb.exam.main.dto.UserDetails;
import org.iitb.exam.main.dto.UserRole;

public class UserRoleServiceImpl implements UserRoleService{
    private SessionFactory sessionFactory;
	
	Session session;
	/**
	 * 
	 */
	public UserRoleServiceImpl() {
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
	public UserRole fetchUserRole(int userRoleId) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from UserRole where userroleid = :userRoleId");
		query.setInteger("userRoleId", userRoleId);
		
		@SuppressWarnings("unchecked")
		List<UserRole> roleList = (ArrayList<UserRole>) query.list();
		transaction.commit();
		
		UserRole userRole = new UserRole();
		for(UserRole el :roleList){
			userRole=el;
		}
		session.close();
		return userRole;
	}

}
