/**
 * 
 */
package org.iitb.exam.main.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.iitb.exam.main.dao.ExamService;
import org.iitb.exam.main.dto.Designation;
import org.iitb.exam.main.dto.Exam;
import org.iitb.exam.main.dto.OptionBank;
import org.iitb.exam.main.dto.QuestionBank;
import org.iitb.exam.main.wrappers.Option;
import org.iitb.exam.main.wrappers.Question;

/**
 * @author dipti
 *
 */
public class ExamServiceImpl implements ExamService{

	static final Logger log = Logger.getLogger(ExamServiceImpl.class);

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
	
	
	public Exam getExamDetails(int advtId, int desgnId) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Exam exam=new Exam();
		Query query = session.getNamedQuery("exam.getExamDetail");
		query.setInteger(0, advtId);
		query.setInteger(1, desgnId);
		@SuppressWarnings("unchecked")
		List<Exam> list = (List<Exam>) query.list();
		if (!list.isEmpty()){ 
		    exam = list.get(0);
			log.info("::::: Exam object ::::: "+exam);
		}
		log.info("::::: Exam object ::::: "+exam.getExamid()+" No of Question "+exam.getTotalQuestions()+" Duration of Exam :"+exam.getExamDuration());
		transaction.commit();
		session.close();
	
		return exam;
	}
	
	public ArrayList<Question> getExamQuestions(int examId) {
		ArrayList<Question> questionList=new ArrayList<Question>();
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.getNamedQuery("exam.getExamQuestion");
		query.setInteger(0, examId);
		@SuppressWarnings("unchecked")
		List<QuestionBank> list = (List<QuestionBank>) query.list();
		if (!list.isEmpty()){
			for (int i=0;i<list.size();i++){
				QuestionBank qb=list.get(i);
				Question question=new Question();
				question.setQuestionID(qb.getQuestionid());
				question.setQuestionText(qb.getQuestionText());
				question.setQuestionType(qb.getQuestionType());
				
				Vector<Option> optionlist=new Vector<Option>();
				Query optionqry = session.getNamedQuery("exam.getExamOption");
				optionqry.setInteger(0,qb.getQuestionid());
				@SuppressWarnings("unchecked")
				List<OptionBank> optlist = (List<OptionBank>)optionqry.list();
				if(!optlist.isEmpty()){
					for(int p=0;p<optlist.size();p++){
						OptionBank ob=optlist.get(p);					
						Option option=new Option();
						option.setOptionID(ob.getOptionId());
						option.setOptionValue(ob.getOptionText());
						option.setQuestionID(ob.getQuestion().getQuestionid());
						option.setCorrectnessAndOrder(ob.getOptionCorrectness());
						optionlist.add(p, option);	
					}
				}
					
				question.setOptionList(optionlist);
				questionList.add(i, question);
			}
		   
		}
		log.info("This is question list : " +questionList);
		transaction.commit();
		session.close();
		return questionList;
	
		
	}

	
	public String getDesignationName(String desgnId) {
		Designation desgn=new Designation();
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.getNamedQuery("exam.getDesignationName");
		query.setInteger(0, Integer.parseInt(desgnId));
		@SuppressWarnings("unchecked")
		List<Designation> designationlist = (List<Designation>) query.list();
		if (!designationlist.isEmpty()){ 
		 desgn = designationlist.get(0);
			log.info("::::: Exam object ::::: "+desgn);
		}
		transaction.commit();
		session.close();
		return desgn.getDesignationName();
	}

}
