package com.siwa.dao;

import java.util.List;

import com.siwa.model.Index;

public interface IndexDAO {
	
	public List<Index> getAllIndex(String assign);
	
	public List<Index> getReportByMe(String report);
	
	public List<Index> getResolveIssue();
 	
}
