package com.siwa.dao;

import java.util.List;

import com.siwa.model.Assign;

public interface AssignDAO {
	
	public void addAssign(Assign assign);

	public void deleteAssign(int assignID);

	public void updateAssign(Assign assign);

	public List<Assign> getAllAssign();

	public Assign getAssignById(int assignID);

}
