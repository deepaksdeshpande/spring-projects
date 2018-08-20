/**
 * 
 */
package org.iitb.exam.main.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author deepak
 *
 */
@Entity
@Table(name = "Answer")
public class Answer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9074092939059880347L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "answerid")
	private int answerid;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY )
	@JoinColumn(name = "userdetailsid", insertable=true, updatable=true, nullable = false)
	private UserDetails userdetailsid;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY )
	@JoinColumn(name = "designationid", insertable=true, updatable=true, nullable = false)
	private Designation designationid;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY )
	@JoinColumn(name = "examid", insertable=true, updatable=true, nullable = false)
	private Exam examid;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY )
	@JoinColumn(name = "advertisementid", insertable=true, updatable=true, nullable = false)
	private Advertisements advertisementId;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY )
	@JoinColumn(name = "questionid", insertable=true, updatable=true, nullable = false)
	private QuestionBank questionId;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY )
	@JoinColumn(name = "optionid", insertable=true, updatable=true, nullable = false)
	private OptionBank selectedOptionId;
	
	/**
	 * 
	 */
	public Answer() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param answerid
	 * @param userdetailsid
	 * @param designationid
	 * @param examid
	 * @param advertisementId
	 * @param questionId
	 * @param selectedOptionId
	 */
	public Answer(int answerid, UserDetails userdetailsid,
			Designation designationid, Exam examid,
			Advertisements advertisementId, QuestionBank questionId,
			OptionBank selectedOptionId) {
		super();
		this.answerid = answerid;
		this.userdetailsid = userdetailsid;
		this.designationid = designationid;
		this.examid = examid;
		this.advertisementId = advertisementId;
		this.questionId = questionId;
		this.selectedOptionId = selectedOptionId;
	}


	/**
	 * @return the answerid
	 */
	public int getAnswerid() {
		return answerid;
	}

	/**
	 * @param answerid the answerid to set
	 */
	public void setAnswerid(int answerid) {
		this.answerid = answerid;
	}

	/**
	 * @return the userdetailsid
	 */
	public UserDetails getUserdetailsid() {
		return userdetailsid;
	}

	/**
	 * @param userdetailsid the userdetailsid to set
	 */
	public void setUserdetailsid(UserDetails userdetailsid) {
		this.userdetailsid = userdetailsid;
	}

	/**
	 * @return the designationid
	 */
	public Designation getDesignationid() {
		return designationid;
	}

	/**
	 * @param designationid the designationid to set
	 */
	public void setDesignationid(Designation designationid) {
		this.designationid = designationid;
	}

	/**
	 * @return the examid
	 */
	public Exam getExamid() {
		return examid;
	}

	/**
	 * @param examid the examid to set
	 */
	public void setExamid(Exam examid) {
		this.examid = examid;
	}

	/**
	 * @return the advertisementId
	 */
	public Advertisements getAdvertisementId() {
		return advertisementId;
	}

	/**
	 * @param advertisementId the advertisementId to set
	 */
	public void setAdvertisementId(Advertisements advertisementId) {
		this.advertisementId = advertisementId;
	}

	/**
	 * @return the questionId
	 */
	public QuestionBank getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(QuestionBank questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return the selectedOptionId
	 */
	public OptionBank getSelectedOptionId() {
		return selectedOptionId;
	}

	/**
	 * @param selectedOptionId the selectedOptionId to set
	 */
	public void setSelectedOptionId(OptionBank selectedOptionId) {
		this.selectedOptionId = selectedOptionId;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/*@Override
	public String toString() {
		return "Answer [answerid=" + answerid + ", userdetailsid="
				+ userdetailsid + ", designationid=" + designationid
				+ ", examid=" + examid + ", advertisementId=" + advertisementId
				+ ", questionId=" + questionId + ", selectedOptionId="
				+ selectedOptionId + "]";
	}*/
	
}
