package org.iitb.exam.main.dto;

import java.io.Serializable;
import java.util.Date;

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

@Entity
@NamedNativeQueries({ @NamedNativeQuery(name = "experienceDetails.byuserId", query = "SELECT * FROM ExperienceDetails where userdetailsid = ?", resultClass = ExperienceDetails.class) })
@Table(name = "ExperienceDetails")
public class ExperienceDetails implements Serializable {

	private static final long serialVersionUID = 9067841786593512075L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "experiencedetailsId")
	private int experiencedetailsId;

	@Column(name = "yearOfExperience", nullable = false)
	private float yearOfExperience;

	@Column(name = "companyName", nullable = true)
	private String companyName;

	@Column(name = "position", nullable = true)
	private String position;

	@Column(name = "currentCompany")
	private Boolean currentCompany;

	@Column(name = "currentCTC")
	private Integer currentCTC;

	@Column(name = "startDate")
	private Date startDate;

	@Column(name = "endDate")
	private Date endDate;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "userdetailsid", nullable = false, insertable = true, updatable = true)
	private UserDetails userDetails;

	public ExperienceDetails() {

	}

	public ExperienceDetails(float yearOfExperience, String companyName,
			String position, Boolean currentCompany, Integer currentCTC,
			Date startDate, Date endDate, UserDetails userdetailsid) {
		super();
		this.yearOfExperience = yearOfExperience;
		this.companyName = companyName;
		this.position = position;
		this.currentCompany = currentCompany;
		this.currentCTC = currentCTC;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userDetails = userdetailsid;
	}

	public int getExperiencedetailsId() {
		return experiencedetailsId;
	}

	public void setExperiencedetailsId(int experiencedetailsId) {
		this.experiencedetailsId = experiencedetailsId;
	}

	public float getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(float yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Boolean getCurrentCompany() {
		return currentCompany;
	}

	public void setCurrentCompany(Boolean currentCompany) {
		this.currentCompany = currentCompany;
	}

	public Integer getCurrentCTC() {
		return currentCTC;
	}

	public void setCurrentCTC(Integer currentCTC) {
		this.currentCTC = currentCTC;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}