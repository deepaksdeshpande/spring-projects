/**
 * 
 */
package org.iitb.exam.main.dao;

import java.util.ArrayList;

import org.iitb.exam.main.dto.ExperienceDetails;
import org.iitb.exam.main.dto.QualificationDetails;
/*import org.iitb.exam.main.dto.ExperienceDetails;
import org.iitb.exam.main.dto.QualificationDetails;*/
import org.iitb.exam.main.dto.UserDetails;

/**
 * @author rishab
 *
 */
public interface UserDetailsService {
	ArrayList<UserDetails> fetchUserDetails(int designationId, int advertisementId);
	ArrayList<QualificationDetails> fetchUserQualification(int userId);
	ArrayList<ExperienceDetails> fetchUserExperienceDetails(int userId);
	Boolean checkEmail(String email);
}