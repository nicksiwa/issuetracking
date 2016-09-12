package com.siwa.dao;

import java.util.List;

import com.siwa.model.Test;

public interface TestDAO {
	
	public void addTest(Test test);

	public void deleteTest(int testID);

	public void updateTest(Test test);

	public List<Test> getAllTest();

	public Test getTestById(int testID);

}

