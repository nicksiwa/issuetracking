package com.siwa.dao;

import com.siwa.model.Register;

public interface RegisterDAO {
	public void registerUser(Register register);
	
	public void registerPerson(Register register);
	
	public Register checkUser(String user);
	
	public Register getId(int id);
}
