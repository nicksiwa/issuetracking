package com.siwa.dao;

import java.util.List;

import com.siwa.model.Issue;

public interface IssueDAO {

	public void addIssue(Issue issue);

	public void deleteIssue(int issueID);

	public void updateIssue(Issue issue);

	public List<Issue> getAllIssues();

	public Issue getIssueById(int issueID);
	
}
