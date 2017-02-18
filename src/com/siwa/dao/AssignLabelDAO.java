package com.siwa.dao;

import java.util.List;

import com.siwa.model.AssignLabel;

public interface AssignLabelDAO {
	
	public void addAssignLabel (AssignLabel assignLabel);
	
	public void deleteAssignLabel (int assignLabelID);
	
	public List<AssignLabel> getLabel();
	
	public List<AssignLabel> getIssue();

}
