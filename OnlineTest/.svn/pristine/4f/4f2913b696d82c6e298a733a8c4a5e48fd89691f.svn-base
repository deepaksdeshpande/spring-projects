/**
 * 
 */
package org.iitb.exam.main.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.iitb.exam.main.dao.UserDetailsService;
import org.iitb.exam.main.dto.ExperienceDetails;
import org.iitb.exam.main.dto.QualificationDetails;
import org.iitb.exam.main.dto.UserDetails;

/**
 * @author rishab
 * 
 */
public class UserDetailsServiceImpl implements UserDetailsService {

	static final Logger log = Logger.getLogger(UserDetailsServiceImpl.class);

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

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<UserDetails> fetchUserDetails(int designationId,
			int advertisementId) {
		ArrayList<UserDetails> userDetailsList = new ArrayList<UserDetails>();
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.getNamedQuery("userDetails.bydesgID");
		query.setInteger(0, designationId);
		query.setInteger(1, advertisementId);
		userDetailsList = (ArrayList<UserDetails>) query.list();
		transaction.commit();
		session.close();
		return userDetailsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<QualificationDetails> fetchUserQualification(int userId) {
		ArrayList<QualificationDetails> qualificationDetails = new ArrayList<QualificationDetails>();
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.getNamedQuery("qualificationDetails.byuserId");
		query.setInteger(0, userId);
		qualificationDetails = (ArrayList<QualificationDetails>) query.list();
		transaction.commit();
		session.close();
		return qualificationDetails;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<ExperienceDetails> fetchUserExperienceDetails(int userId) {
		ArrayList<ExperienceDetails> experienceDetails = new ArrayList<ExperienceDetails>();
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.getNamedQuery("experienceDetails.byuserId");
		query.setInteger(0, userId);
		experienceDetails = (ArrayList<ExperienceDetails>) query.list();
		transaction.commit();
		session.close();
		return experienceDetails;
	}

	@Override
	public Boolean checkEmail(String email) {
		Boolean result = false;
		Session session = getSessionFactory().openSession();
		log.info("Email: " + email);
		// UserDetails user = (UserDetails) session
		// .createCriteria(UserDetails.class)
		// .setFetchMode("permissions", FetchMode.JOIN)
		// .add(Restrictions.eq("emailid", email)).uniqueResult();
		//Criteria criteria = session.createCriteria(UserDetails.class).add(Restrictions.eq("emailid", email));
		String hql = "from UserDetails where emailid = :email";
		Query q = session.createQuery(hql);
		q.setString("email", email);
		//UserDetails user = (UserDetails) criteria.uniqueResult();
		//UserDetails user = (UserDetails) q.list().;
		List<UserDetails> list = (ArrayList<UserDetails>)q.list();
		if (list.isEmpty()) {
			result = true;
		}
		log.info(result);
		return result;
	}
}