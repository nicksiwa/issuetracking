package com.siwa.dao;

import com.siwa.model.Login;

public interface LoginDAO {
	
	public String authenticateUser(Login login);

}
