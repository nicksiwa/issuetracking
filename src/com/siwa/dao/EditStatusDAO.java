package com.siwa.dao;

import com.siwa.model.Issue;

public interface EditStatusDAO {
	
	public void editIssueStatus(Issue issue);
	
	public Issue getIsuseStatusById(int issueID);

}
