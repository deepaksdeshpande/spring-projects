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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "Designation")
@NamedNativeQuery(name="exam.getDesignationName", query="select * from Designation where designationid=?", resultClass=Designation.class)
public class Designation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5192204852848047958L;

	@Id
	@Column(name = "designationid", nullable = false)
	private int designationId;
	
	@Column(name = "designationname", nullable = false)
	private String designationName;
	
	@Column(name = "designationdescription", nullable = false)
	@Type(type = "org.hibernate.type.TextType")
	private String designationDescription;
		
	@ManyToMany(mappedBy = "designationPerAdvt")
	private Set<Advertisements> adDesg = new HashSet<Advertisements>();
	
		
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "designationid")
	private Set<Answer> answerOption = new HashSet<Answer>();
	
	
	/**
	 * 
	 */
	public Designation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param designationId
	 * @param designationName
	 * @param designationDescription
	 * @param userDesignationDetails
	 * @param jobsApplied
	 */
	public Designation(int designationId, String designationName,
			String designationDescription,
			Set<UserDetails> userDesignationDetails) {
		super();
		this.designationId = designationId;
		this.designationName = designationName;
		this.designationDescription = designationDescription;
	}

	/**
	 * @return the designationId
	 */
	public int getDesignationId() {
		return designationId;
	}

	/**
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	/**
	 * @return the designationName
	 */
	public String getDesignationName() {
		return designationName;
	}

	/**
	 * @param designationName the designationName to set
	 */
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	/**
	 * @return the designationDescription
	 */
	public String getDesignationDescription() {
		return designationDescription;
	}

	/**
	 * @param designationDescription the designationDescription to set
	 */
	public void setDesignationDescription(String designationDescription) {
		this.designationDescription = designationDescription;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/*@Override
	public String toString() {
		return "Designation [designationId=" + designationId
				+ ", designationName=" + designationName
				+ ", designationDescription=" + designationDescription
				+ ", adDesg=" + adDesg + ", answerOption=" + answerOption + "]";
	}*/

}