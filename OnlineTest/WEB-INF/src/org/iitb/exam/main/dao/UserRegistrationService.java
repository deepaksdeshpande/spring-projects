package org.iitb.exam.main.dao;

import org.iitb.exam.main.dto.UserDetails;


public interface UserRegistrationService {
	void createUser(UserDetails user);
	void updateUser(UserDetails user);
}
