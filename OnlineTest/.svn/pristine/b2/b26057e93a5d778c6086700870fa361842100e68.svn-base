/**
 * 
 */
package org.iitb.exam.main.dao;

import org.iitb.exam.main.dto.UserDetails;

/**
 * @author deepak
 *
 */

public interface ExamLoginService {
	UserDetails performLogin(String emailId);
	UserDetails performLogin(String emailId, String password);
	String generateForgotPasswordLink(String emailId);
	int changePassword(String password, int userID);
}