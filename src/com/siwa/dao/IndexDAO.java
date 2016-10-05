package com.siwa.dao;

import java.util.List;

import com.siwa.model.Index;

public interface IndexDAO {
	
	public List<Index> getAllIndex(String assignName);
	
}
