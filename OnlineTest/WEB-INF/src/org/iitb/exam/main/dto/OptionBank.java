/**
 * 
 */
package org.iitb.exam.main.dto;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * @author dipti
 * 
 */

@Entity
@Table(name = "OptionBank")
/*
 * The below annotation allows only the rows being modified to be updated,
 * while leaving the rest of the rows unmodified/unchanged.
 */
@org.hibernate.annotations.Entity(
		dynamicUpdate = true, dynamicInsert = true
)
public class OptionBank implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5794012283333113408L;

	@Id
	@GeneratedValue
	@Column(name = "optionid")
	private int optionid;

	@Column(name = "optionCorrectness")
	//@Type(type="org.hibernate.type.NumericBooleanType")
	private int optionCorrectness;

	@Column(name = "optionText")
	@Type(type="org.hibernate.type.TextType")
	private String optionText;

	
	@ManyToOne
	@JoinColumn(name = "questionid")
	private QuestionBank questions;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "optionid")
	private Set<Answer> answerOption = new HashSet<Answer>();

	public OptionBank() {
	}

	/**
	 * @param optionid
	 * @param optionCorrectness
	 * @param optionText
	 * @param questions
	 */
	
	public OptionBank(int optionid, int optionCorrectness, String optionText,
			QuestionBank questions) {
		super();
		this.optionid = optionid;
		this.optionCorrectness = optionCorrectness;
		this.optionText = optionText;
		this.questions = questions;
	}

	/**
	 * @return the optionid
	 */
	public int getOptionId() {
		return optionid;
	}
	
	/**
	 * @param optionid
	 *            the optionid to set
	 */
	public void setOptionId(int optionId) {
		this.optionid = optionId;
	}
	/**
	 * @return the optionText
	 */
	public String getOptionText() {
		return optionText;
	}
	/**
	 * @param optionText
	 *            the optionText to set
	 */
	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}
	/**
	 * @return the optionCorrectness
	 */
	public int getOptionCorrectness() {
		return optionCorrectness;
	}
	/**
	 * @param optionCorrectness
	 *            the optionCorrectness to set
	 */
	public void setOptionCorrectness(int optionCorrectness) {
		this.optionCorrectness = optionCorrectness;
	}
	/**
	 * @return the questions
	 */
	public QuestionBank getQuestion() {
		return questions;
	}
	/**
	 * @param questions
	 *            the questions to set
	 */
	public void setQuestion(QuestionBank question) {
		this.questions = question;
	}

}
