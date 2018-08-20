/**
 * 
 */
package org.iitb.exam.main.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * @author deepak
 *
 */
@Entity
@NamedNativeQuery(name = "designation.byAdvtId", 
query = "select d.designationid,d.designationdescription,d.designationname from Advt_Desg_Mapping adm join Designation d on adm.designationid = d.designationid where adm.advertisementid=?", resultClass = Designation.class)
@Table(name="Advertisements")
public class Advertisements implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6124429868637268214L;

	@Id
	@Column(name = "advertisementid", nullable = false)
	private int advertisementId;
	
	@Column(name = "advertisementtitle", nullable = false)
	private String advertisementTitle;
	
	@Column(name="startdate", nullable = false)
	@Type(type = "org.hibernate.type.TimestampType")
	private Date startDate;
	
	@Column(name = "enddate", nullable = false)
	@Type(type = "org.hibernate.type.TimestampType")
	private Date endDate;
	
	@Column(name = "advertisementdetails", nullable = false)
	@Type(type = "org.hibernate.type.TextType")
	private String advertisementDetails;
	
	@Column(name = "publishedstatus", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean publishedStatus;
	
	@Column(name = "projcode", nullable = false)
	private String projCode;
	
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Advt_Desg_UserDetails_Mapping", joinColumns = { @JoinColumn(name = "advertisementid")},
	inverseJoinColumns = { @JoinColumn(name = "designationid") })
	private Set<Designation> designation = new HashSet<Designation>();
	
	/*
	 * This mapping is to just fetch the designation details for a particular Advt.
	 */
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "Advt_Desg_Mapping", joinColumns = {@JoinColumn(name="advertisementid")}, 
	inverseJoinColumns = { @JoinColumn(name = "designationid")})
	private Set<Designation> designationPerAdvt = new HashSet<Designation>();
	
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "advertisementid")
	private Set<Answer> answerOption = new HashSet<Answer>();
	
	/**
	 * 
	 */
	public Advertisements() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param advertisementId
	 * @param advertisementTitle
	 * @param startDate
	 * @param endDate
	 * @param advertisementDetails
	 * @param publishedStatus
	 * @param projCode
	 * @param designation
	 * @param designationPerAdvt
	 * @param answerOption
	 * 
	 */
	public Advertisements(int advertisementId, String advertisementTitle,
			Date startDate, Date endDate, String advertisementDetails,String projCode,
			Boolean publishedStatus, Set<Designation> designation,
			Set<Designation> designationPerAdvt, Set<Answer> answerOption) {
		super();
		this.advertisementId = advertisementId;
		this.advertisementTitle = advertisementTitle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.advertisementDetails = advertisementDetails;
		this.publishedStatus = publishedStatus;
		this.designation = designation;
		this.designationPerAdvt = designationPerAdvt;
		this.answerOption = answerOption;
		this.projCode = projCode;
		
	}


	public String getProjCode() {
		return projCode;
	}


	public void setProjCode(String projCode) {
		this.projCode = projCode;
	}


	/**
	 * @return the advertisementId
	 */
	public int getAdvertisementId() {
		return advertisementId;
	}
	/**
	 * @param advertisementId the advertisementId to set
	 */
	public void setAdvertisementId(int advertisementId) {
		this.advertisementId = advertisementId;
	}
	/**
	 * @return the advertisementTitle
	 */
	public String getAdvertisementTitle() {
		return advertisementTitle;
	}
	/**
	 * @param advertisementTitle the advertisementTitle to set
	 */
	public void setAdvertisementTitle(String advertisementTitle) {
		this.advertisementTitle = advertisementTitle;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the advertisementDetails
	 */
	public String getAdvertisementDetails() {
		return advertisementDetails;
	}
	/**
	 * @param advertisementDetails the advertisementDetails to set
	 */
	public void setAdvertisementDetails(String advertisementDetails) {
		this.advertisementDetails = advertisementDetails;
	}
	/**
	 * @return the publishedStatus
	 */
	public Boolean getPublishedStatus() {
		return publishedStatus;
	}
	/**
	 * @param publishedStatus the publishedStatus to set
	 */
	public void setPublishedStatus(Boolean publishedStatus) {
		this.publishedStatus = publishedStatus;
	}
	/**
	 * @return the designation
	 */
	public Set<Designation> getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(Set<Designation> designation) {
		this.designation = designation;
	}
	
	/**
	 * @return the designationPerAdvt
	 */
	public Set<Designation> getDesignationPerAdvt() {
		return designationPerAdvt;
	}
	/**
	 * @param designationPerAdvt the designationPerAdvt to set
	 */
	public void setDesignationPerAdvt(Set<Designation> designationPerAdvt) {
		this.designationPerAdvt = designationPerAdvt;
	}
	
	/**
	 * @return the answerOption
	 */
	public Set<Answer> getAnswerOption() {
		return answerOption;
	}
	/**
	 * @param answerOption the answerOption to set
	 */
	public void setAnswerOption(Set<Answer> answerOption) {
		this.answerOption = answerOption;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/*@Override
	public String toString() {
		return "Advertisements [advertisementId=" + advertisementId
				+ ", advertisementTitle=" + advertisementTitle + ", startDate="
				+ startDate + ", endDate=" + endDate
				+ ", advertisementDetails=" + advertisementDetails
				+ ", publishedStatus=" + publishedStatus + ", designation="
				+ designation + ", designationPerAdvt=" + designationPerAdvt
				+ ", answerOption=" + answerOption + "]";
	}
	*/
	
}
