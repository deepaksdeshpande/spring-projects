/**
 * 
 */
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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

/**
 * @author deepak
 * 
 */

@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name = "userDetails.bydesgID", query = "SELECT UserDetails.userdetailsid, UserDetails.age, UserDetails.name, UserDetails.gender, UserDetails.emailid, UserDetails.alternateemailid, UserDetails.username, UserDetails.password, UserDetails.userphoto, UserDetails.resume, UserDetails.presentaddress, UserDetails.pincode, UserDetails.landlineno, UserDetails.mobileno, UserDetails.registrationdate, UserDetails.userroleid FROM Advt_Desg_UserDetails_Mapping, UserDetails where Advt_Desg_UserDetails_Mapping.designationid = ? and Advt_Desg_UserDetails_Mapping.advertisementid = ? and UserDetails.userdetailsid=Advt_Desg_UserDetails_Mapping.userdetailsid", resultClass = UserDetails.class)
//	@NamedNativeQuery(name = "userDetails.bydesgID", query = "SELECT * FROM Advt_Desg_UserDetails_Mapping, UserDetails where designationid = ? and advertisementid = ?", resultClass = UserDetails.class)
})

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="UserDetails")
@Table(name = "UserDetails")
public class UserDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2035170424379800778L;

	@Id
	@Column(name="userdetailsid", nullable = false)
	private int userDetailsId;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "age", length = 2, nullable = false)
	private Integer age;
	
	@Column(name = "gender")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean gender;
	
	@Column(name = "emailid", nullable = false)
	private String emailid;
	
	@Column(name = "alternateemailid")
	private String altEmailId;
	
	@Column(name = "username", nullable = false)
	private String userName;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "userphoto")
	private String userPhoto;
	
	@Column(name="resume")
	@Type(type = "org.hibernate.type.TextType")
	private String resume;
	
	@Column(name = "presentaddress")
	private String presentAddress;
	
	@Column(name = "pincode", length = 6)
	@Type(type = "java.lang.Integer")
	private Integer pincode;

	@Column(name = "landlineno")
	private String landLineNo;
	
	@Column(name = "mobileno", length = 10)
	@Type(type = "java.lang.Long")
	private Long mobileno;
	
	@Column(name = "registrationdate", nullable = false)
	@Type(type = "org.hibernate.type.TimestampType")
	private Date registrationDate;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER )
	@JoinColumn(name = "userroleid", insertable=true, updatable=true, nullable = false)
	private UserRole userRole;
	
	/*
	 * This mapping is for Advt_Desg_QuestionBank_Mapping
	 */
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	 @JoinTable(name = "Advt_Desg_UserDetails_Mapping", joinColumns = @JoinColumn(name = "userdetailsid"),
			 inverseJoinColumns = @JoinColumn(name = "advertisementid"))
	 @MapKeyJoinColumn(name = "designationid")
	 @ElementCollection
	 private Map<Designation, Advertisements> AdvtByDesg = new HashMap<Designation, Advertisements>();
	/*
	 * Mapping for Advt_Desg_QuestionBank_Mapping Mapping ends...
	 */
	
	

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userdetailsid")
	private Set<Exam> examid = new HashSet<Exam>();
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userdetailsid")
	private Set<Answer> answerOption = new HashSet<Answer>();


	/**
	 * 
	 */
	public UserDetails() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param userDetailsId
	 * @param name
	 * @param age
	 * @param gender
	 * @param emailId
	 * @param altEmailId
	 * @param userName
	 * @param password
	 * @param userPhoto
	 * @param resume
	 * @param presentAddress
	 * @param pincode
	 * @param landLineNo
	 * @param mobileNo
	 * @param registrationDate
	 * @param userRole
	 * @param userDesignation
	 */
	public UserDetails(int userDetailsId, String name, Integer age,
			Boolean gender, String emailId, String altEmailId, String userName,
			String password, String userPhoto, String resume,
			String presentAddress, Integer pincode, String landLineNo,
			Long mobileNo, Date registrationDate, UserRole userRole) {
		super();
		this.userDetailsId = userDetailsId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.emailid = emailId;
		this.altEmailId = altEmailId;
		this.userName = userName;
		this.password = password;
		this.userPhoto = userPhoto;
		this.resume = resume;
		this.presentAddress = presentAddress;
		this.pincode = pincode;
		this.landLineNo = landLineNo;
		this.mobileno = mobileNo;
		this.registrationDate = registrationDate;
		this.userRole = userRole;
	}



	/**
	 * @return the userDetailsId
	 */
	
	public int getUserDetailsId() {
		return userDetailsId;
	}

	/**
	 * @param userDetailsId
	 *            the userDetailsId to set
	 */
	public void setUserDetailsId(int userDetailsId) {
		this.userDetailsId = userDetailsId;
	}

	/**
	 * @return the name
	 */
	
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the sex
	 */
	
	public Boolean getGender() {
		return gender;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	/**
	 * @return the emailId
	 */
	
	public String getEmailid() {
		return emailid;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailid(String emailId) {
		this.emailid = emailId;
	}

	/**
	 * @return the altEmailId
	 */
	
	public String getAltEmailId() {
		return altEmailId;
	}

	/**
	 * @param altEmailId
	 *            the altEmailId to set
	 */
	public void setAltEmailId(String altEmailId) {
		this.altEmailId = altEmailId;
	}

	/**
	 * @return the userName
	 */
	
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userPhoto
	 */
	
	public String getUserPhoto() {
		return userPhoto;
	}

	/**
	 * @param userPhoto
	 *            the userPhoto to set
	 */
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	/**
	 * @return the resume
	 */
	
	public String getResume() {
		return resume;
	}

	/**
	 * @param resume
	 *            the resume to set
	 */
	public void setResume(String resume) {
		this.resume = resume;
	}

	/**
	 * @return the presentAddress
	 */
	
	public String getPresentAddress() {
		return presentAddress;
	}

	/**
	 * @param presentAddress
	 *            the presentAddress to set
	 */
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	/**
	 * @return the pincode
	 */
	
	public Integer getPincode() {
		return pincode;
	}

	/**
	 * @param pincode
	 *            the pincode to set
	 */
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the landLineNo
	 */
	
	public String getLandLineNo() {
		return landLineNo;
	}

	/**
	 * @param landLineNo
	 *            the landLineNo to set
	 */
	public void setLandLineNo(String landLineNo) {
		this.landLineNo = landLineNo;
	}

	/**
	 * @return the mobileNo
	 */
	
	public Long getmobileno() {
		return mobileno;
	}

	/**
	 * @param mobileNo
	 *            the mobileNo to set
	 */
	public void setmobileno(Long mobileNo) {
		this.mobileno = mobileNo;
	}

	/**
	 * @return the registrationDate
	 */
	
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * @return the userRoleId
	 */
	
	public UserRole getUserRole() {
		return userRole;
	}

	/**
	 * @param userRoleId
	 *            the userRoleId to set
	 */
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public Map<Designation, Advertisements> getAdvtByDesg() {
		return AdvtByDesg;
	}



	public void setAdvtByDesg(Map<Designation, Advertisements> advtByDesg) {
		AdvtByDesg = advtByDesg;
	}

	public Set<Exam> getExamid() {
		return examid;
	}

	public void setExamid(Set<Exam> examid) {
		this.examid = examid;
	}

	public Set<Answer> getAnswerOption() {
		return answerOption;
	}

	public void setAnswerOption(Set<Answer> answerOption) {
		this.answerOption = answerOption;
	}

}
