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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;


/**
 * @author Rishab
 *
 */
@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name = "qualificationDetails.byuserId", query = "SELECT * FROM QualificationDetails where userdetailsid = ?", resultClass = QualificationDetails.class)
})
@Table(name="QualificationDetails")
public class QualificationDetails implements Serializable{

	private static final long serialVersionUID = -4003843022823336017L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="qualificationid")
	private int qualificationId;
	
	@Column(name = "qualificationName", nullable = false)
	private String qualificationName;
	
	@Column(name = "qualificationType", nullable = false)
	private String qualificationType;
	
	@Column(name = "percentage", nullable = false)
	private int percentage;
	
	@Column(name = "passYear", nullable = false)
	private int passYear;
	
	@Column(name = "university", nullable = false)
	private String university;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "userdetailsid", nullable = false, insertable=true, updatable=true)
	private UserDetails userDetails;
	
	public QualificationDetails() {
	}

	public QualificationDetails(String qualificationName, String qualificationType, int percentage, int passYear, String university, UserDetails userDetails) {
		super();
		this.qualificationName = qualificationName;
		this.qualificationType = qualificationType;
		this.percentage = percentage;
		this.passYear = passYear;
		this.university = university;
		this.userDetails = userDetails;
	}

	public int getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(int qualificationId) {
		this.qualificationId = qualificationId;
	}
	
	public String getQualificationName() {
		return qualificationName;
	}

	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}

	public String getQualificationType() {
		return qualificationType;
	}

	public void setQualificationType(String qualificationType) {
		this.qualificationType = qualificationType;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public int getPassYear() {
		return passYear;
	}

	public void setPassYear(int passYear) {
		this.passYear = passYear;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}