package com.siwa.dao;

import java.util.List;

import com.siwa.model.Index;

public interface IndexDAO {
	
	public List<Index> getAllIndex();

	public Index getIndexById(String assignName);

}
