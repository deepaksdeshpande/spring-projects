package org.iitb.exam.main.dao;

import org.iitb.exam.main.dto.UserDetails;

public interface CheckUsernameService {
	public UserDetails checkUsername(String username);
}
