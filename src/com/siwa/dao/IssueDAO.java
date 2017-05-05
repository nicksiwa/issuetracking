package com.siwa.dao;

import java.util.Date;
import java.util.List;

import com.siwa.model.Comment;
import com.siwa.model.Issue;
import com.siwa.model.Test;

public interface IssueDAO {
	
	public void addIssue(Issue issue);

	public void deleteIssue(int issueID);

	public void updateIssue(Issue issue);

	public List <Issue> getAllIssue();

	public Issue getAssignById(int issueID);
	
	public List <Issue> getPersonByProject(int issueID);
	
	public List <Comment> getCommentByIssue(int issueID);
	
	public void setStatusAssign(Issue issue);
	
	public void setStatusFeedback(Issue issue);
	
	public void setStatusConfirmed(Issue issue);
	
	public void setStatusResolved(Issue issue);
	
	public List <Issue> getIssueByProject(int projectID);
	
	public Issue getIssueByLastInsert();
	
	public void setStatusClose(Issue issue);
	
	public List <Issue> getAllIssueClosed();
	
	public void setStatusReOpen(Issue issue);
	
	public List <Issue> getMilestonePercent(int projectID);
	
	public List <Issue> geetMilestoneClosedPercent(int projectID);
	
	public List <Issue> getReport(String severity,String status,String firstDate,String secondDate);
	
	public Issue getEmailByUsername(String username);
	
	public List <Issue> getAllIssueByPagination(int offset,int noOfRecords);
	
	public int getNoOfRecords();

	
}
