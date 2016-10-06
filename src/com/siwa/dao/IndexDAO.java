package com.siwa.dao;

import java.util.List;

import com.siwa.model.Index;
import com.siwa.model.Issue;

public interface IndexDAO {
	
	public Index getIndexById(String assign);
	
	public List<Index> getAllIndex(String assign);
	
}
