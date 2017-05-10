package com.siwa.dao;

import java.util.List;

import com.siwa.model.Issue;
import com.siwa.model.Project;
import com.siwa.model.Report;

public interface ReportDAO {
	
public List <Issue> getAllIssue();
	
	public List <Project> getAllproject();

	public List <Project> getAllproject2();
	
	public Report find();
	
	public List <Issue> IssueID(int offset, int noOfRecords);
	
	public List <Issue> SeveritySort(int offset, int noOfRecords);
	
	public List <Issue> DueDateSort(int offset, int noOfRecords);
	
	public List <Issue> UpdateDateSort(int offset, int noOfRecords);
	
	public List <Issue> CreateDateSort(int offset, int noOfRecords);
	
	public List <Issue> getNumberofIssue();
	
	public List <Issue> Pagination();
	
	public List <Issue> GrapStatus();

}
