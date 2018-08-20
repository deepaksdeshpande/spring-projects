package org.iitb.exam.main.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ContactUs")
/*
 * The below annotation allows only the rows being modified to be updated,
 * while leaving the rest of the rows unmodified/unchanged.
 */
@org.hibernate.annotations.Entity(dynamicUpdate = true, dynamicInsert = true)

public class ContactusDetails implements Serializable{
	
	private static final long serialVersionUID = 5794012283333113408L;

	private int    contactid;
	private String contactname;
	private String contactemail;
	private String contactphone;
	private String feedbacktype;
	private String message;
	
	
	@Id
	@GeneratedValue
	@Column(name = "contactid", nullable = false)
	public int getContactid() {
		return contactid;
	}
	public void setContactid(int contactid) {
		this.contactid = contactid;
	}
	
	
	
	@Column(name = "contactname", nullable = false)
	public String getContactname() {
		return contactname;
	}
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	
	
	
	@Column(name = "contactemail", nullable = false)
	public String getContactemail() {
		return contactemail;
	}
	public void setContactemail(String contactemail) {
		this.contactemail = contactemail;
	}
	
	
	
	@Column(name = "contactphone", nullable = false)
	public String getContactphone() {
		return contactphone;
	}
	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}
	
	
	
	@Column(name = "feedbacktype", nullable = false)
	public String getFeedbacktype() {
		return feedbacktype;
	}
	public void setFeedbacktype(String feedbacktype) {
		this.feedbacktype = feedbacktype;
	}
	
	
	
	@Column(name = "message", nullable = false)
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
