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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author deepak
 * 
 */
@Entity
@Table(name = "UserRoles")
public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7910083328752128038L;

	private int userRoleId;
	private String userRoleName;
	private String userRoleDescription;
	private Set<UserDetails> userDetails = new HashSet<UserDetails>();

	/**
	 * @return the userRoleId
	 */
	@Id
	@Column(name = "userroleid", nullable = false)
	public int getUserRoleId() {
		return userRoleId;
	}

	/**
	 * @param userRoleId
	 *            the userRoleId to set
	 */
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	/**
	 * @return the userRole
	 */
	@Column(name = "userrolename", nullable = false)
	public String getUserRoleName() {
		return userRoleName;
	}

	/**
	 * @param userRole
	 *            the userRole to set
	 */
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	/**
	 * @return the userRoleDescription
	 */
	@Column(name = "userroledescription", nullable = false)
	public String getUserRoleDescription() {
		return userRoleDescription;
	}

	/**
	 * @param userRoleDescription
	 *            the userRoleDescription to set
	 */
	public void setUserRoleDescription(String userRoleDescription) {
		this.userRoleDescription = userRoleDescription;
	}

	/**
	 * @return the userDetails
	 */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userroleid")
	public Set<UserDetails> getUserDetails() {
		return userDetails;
	}

	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(Set<UserDetails> userDetails) {
		this.userDetails = userDetails;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/*@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", userRoleName="
				+ userRoleName + ", userRoleDescription=" + userRoleDescription
				+ ", userDetails=" + userDetails + "]";
	}*/
}
