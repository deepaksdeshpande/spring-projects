package org.iitb.exam.main.dto;

import java.io.Serializable;
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
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * @author dipti
 * 
 */

@Entity
@Table(name = "QuestionBank")
/*
 * The below annotation allows only the rows being modified to be updated,
 * while leaving the rest of the rows unmodified/unchanged.
 */
@org.hibernate.annotations.Entity(
		dynamicUpdate = true, dynamicInsert = true
)
public class QuestionBank implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5014860091049668435L;

	@Id
	@GeneratedValue
	@Column(name = "questionid")
	private int questionid;

	@Column(name = "questionText", nullable=false)
	@Type(type="org.hibernate.type.TextType")
	private String questionText;

	@Column(name = "QuestionType" ,nullable=false)
	private int questionType;

	@Column(name = "levelOfDifficulty" , nullable=false)
	private int levelOfDifficulty;

	@Column(name = "shuffle", nullable=false)
	private int shuffle;
	
	@Column(name = "archived", nullable=false)
	private int archived;
	
	@Column(name = "questionCategory", nullable=false)
	private String questionCategory;

	@OneToMany(mappedBy = "questions")
	private Set<OptionBank> Options = new HashSet<OptionBank>();
	
	@ManyToMany(mappedBy = "questionBank")
	private Set<Exam> exam = new HashSet<Exam>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "questionid")
	private Set<Answer> answerOption = new HashSet<Answer>();

	
	
	/*
	 * This mapping is for Advt_Desg_QuestionBank_Mapping
	 */
	 @JoinTable(name = "Advt_Desg_QuestionBank_Mapping", joinColumns = @JoinColumn(name = "questionid"),
			 inverseJoinColumns = @JoinColumn(name = "advertisementid"))
	 @MapKeyJoinColumn(name = "designationid")
	 @ElementCollection
	 private Map<Designation, Advertisements> AdvtByDesg = new HashMap<Designation, Advertisements>();
	
	public QuestionBank() {

	}
	
	

	/**
	 * @param questionid
	 * @param questionText
	 * @param questionType
	 * @param levelOfDifficulty
	 * @param questionText
	 * @param questionType
	 * @param levelOfDifficulty
	 */
	
	public QuestionBank(int questionid, String questionText, int questionType,
			int levelOfDifficulty, int shuffle, int archived,
			String questionCategory, Set<OptionBank> options) {
		super();
		this.questionid = questionid;
		this.questionText = questionText;
		this.questionType = questionType;
		this.levelOfDifficulty = levelOfDifficulty;
		this.shuffle = shuffle;
		this.archived = archived;
		this.questionCategory = questionCategory;
		Options = options;
	}
	

	/**
	 * @return the questionid
	 */
	public int getQuestionid() {
		return questionid;
	}
	/**
	 * @param questionid
	 *            the questionid to set
	 */
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	/**
	 * @return the questionText
	 */
	public String getQuestionText() {
		return questionText;
	}
	/**
	 * @param questionText
	 *            the questionText to set
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	/**
	 * @return the questionType
	 */
	public int getQuestionType() {
		return questionType;
	}
	/**
	 * @param questionType
	 *            the questionType to set
	 */
	public void setQuestionType(int QuestionType) {
		questionType = QuestionType;
	}

	/**
	 * @return the levelOfDifficulty
	 */
	public int getLevelOfDifficulty() {
		return levelOfDifficulty;
	}
	/**
	 * @param levelOfDifficulty
	 *            the levelOfDifficulty to set
	 */
	public void setLevelOfDifficulty(int levelOfDifficulty) {
		this.levelOfDifficulty = levelOfDifficulty;
	}

	/**
	 * @return the shuffle
	 */
	public int getShuffle() {
		return shuffle;
	}
	/**
	 * @param shuffle
	 *            the shuffle to set
	 */
	public void setShuffle(int shuffle) {
		this.shuffle = shuffle;
	}

	/**
	 * @return the archived
	 */
	public int getArchived() {
		return archived;
	}
	/**
	 * @param archived
	 *            the archived to set
	 */
	public void setArchived(int archived) {
		this.archived = archived;
	}

	/**
	 * @return the questionCategory
	 */
	public String getQuestionCategory() {
		return questionCategory;
	}
	/**
	 * @param questionCategory
	 *            the questionCategory to set
	 */
	public void setQuestionCategory(String questionCategory) {
		this.questionCategory = questionCategory;
	}

	/**
	 * @return the Options
	 */
	public Set<OptionBank> getOptions() {
		return Options;
	}
	/**
	 * @param Options
	 *            the Options to set
	 */
	public void setOptions(Set<OptionBank> Options) {
		this.Options = Options;
	}

	public Set<Exam> getExam() {
		return exam;
	}

	public void setExam(Set<Exam> exam) {
		this.exam = exam;
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
