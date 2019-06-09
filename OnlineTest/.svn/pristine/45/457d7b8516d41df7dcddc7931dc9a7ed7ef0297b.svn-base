package org.iitb.exam.main.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author dipti
 * 
 */

@Entity
@NamedNativeQueries({
		@NamedNativeQuery(name = "examId.byexamName", query = "select examid from Exam where examname = ?", resultClass = Exam.class),
		@NamedNativeQuery(name = "insertInExamQuestionMapping.byexamid", query = "insert into QuestionBank_Exam_Mapping (examid, questionid) values (?, ?)", resultClass = Exam.class),
		@NamedNativeQuery(name = "insertInAdvtExamDesgMapping", query = "insert into Advt_Desg_Exam_Mapping (advertisementid, examid, designationid) values (?, ?, ?)", resultClass = Exam.class),
		@NamedNativeQuery(name="exam.getExamDetail", query="Select * from Exam where examid=(select examid from Advt_Desg_Exam_Mapping where advertisementid=? and designationid=?)",resultClass=Exam.class),
		@NamedNativeQuery(name="exam.getExamQuestion", query="select * from QuestionBank where questionid in (select questionid from QuestionBank_Exam_Mapping where examid=?)", resultClass=QuestionBank.class),
		@NamedNativeQuery(name="exam.getExamOption", query="select * from OptionBank where questionid=?", resultClass=OptionBank.class)})
@Table(name = "Exam")

public class Exam implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5016048174547484768L;

	@Id
	@GeneratedValue
	@Column(name = "examid", nullable = false)
	private int examid;

	@Column(name = "examname", nullable = false)
	private String examName;

	@Column(name = "examdate", nullable = false)
	private Date examDate;

	@Column(name = "examduration", nullable = false)
	private int examDuration;

	@Column(name = "totalquestions", nullable = false)
	private int totalQuestions;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "userdetailsid", insertable = true, updatable = true, nullable = false)
	private UserDetails createdBy;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "QuestionBank_Exam_Mapping", joinColumns = { @JoinColumn(name = "examid") }, inverseJoinColumns = { @JoinColumn(name = "questionid") })
	private Set<QuestionBank> questionBank = new HashSet<QuestionBank>();

	/*
	 * This mapping is for Advt_Desg_Exam Mapping
	 */
	 @JoinTable(name = "Advt_Desg_Exam_Mapping", joinColumns = @JoinColumn(name = "examid"),
			 inverseJoinColumns = @JoinColumn(name = "advertisementid"))
	 @MapKeyJoinColumn(name = "designationid")
	 @ElementCollection
	 private Map<Designation, Advertisements> AdvtByDesg = new HashMap<Designation, Advertisements>();
	/*
	 * Mapping for Advt_Desg_Exam Mapping ends...
	 */
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "examid")
	private Set<Answer> answerOption = new HashSet<Answer>();

	public Exam() {
	}
	
	/**
	 * @param examid
	 * @param examName
	 * @param examDate
	 * @param examDuration
	 * @param totalQuestions
	 * @param createdBy
	 * @param questionBank
	 * @param advtByDesg
	 * @param answerOption
	 */
	public Exam(int examid, String examName, Date examDate, int examDuration,
			int totalQuestions, UserDetails createdBy,
			Set<QuestionBank> questionBank,
			Map<Designation, Advertisements> advtByDesg,
			Set<Answer> answerOption) {
		super();
		this.examid = examid;
		this.examName = examName;
		this.examDate = examDate;
		this.examDuration = examDuration;
		this.totalQuestions = totalQuestions;
		this.createdBy = createdBy;
		this.questionBank = questionBank;
		AdvtByDesg = advtByDesg;
		this.answerOption = answerOption;
	}



	/**
	 * @return the examid
	 */
	public int getExamid() {
		return examid;
	}

	/**
	 * @param examid the examid to set
	 */
	public void setExamid(int examid) {
		this.examid = examid;
	}

	/**
	 * @return the examName
	 */
	public String getExamName() {
		return examName;
	}

	/**
	 * @param examName the examName to set
	 */
	public void setExamName(String examName) {
		this.examName = examName;
	}

	/**
	 * @return the examDate
	 */
	public Date getExamDate() {
		return examDate;
	}

	/**
	 * @param examDate the examDate to set
	 */
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public int getExamDuration() {
		return examDuration;
	}

	public void setExamDuration(int examDuration) {
		this.examDuration = examDuration;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public UserDetails getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserDetails createdBy) {
		this.createdBy = createdBy;
	}

	public Set<QuestionBank> getQuestionBank() {
		return questionBank;
	}

	public void setQuestionBank(Set<QuestionBank> questionBank) {
		this.questionBank = questionBank;
	}

	public Set<Answer> getAnswerOption() {
		return answerOption;
	}

	public void setAnswerOption(Set<Answer> answerOption) {
		this.answerOption = answerOption;
	}
	
	public Map<Designation, Advertisements> getAdvtByDesg() {
		return AdvtByDesg;
	}

	public void setAdvtByDesg(Map<Designation, Advertisements> advtByDesg) {
		AdvtByDesg = advtByDesg;
	}
}
