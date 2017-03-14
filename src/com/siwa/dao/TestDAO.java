package com.siwa.dao;

import java.util.List;

import com.siwa.model.Issue;
import com.siwa.model.Test;
import org.json.*;

public interface TestDAO {
	
	public void addTest(Test test);

	public void deleteTest(int testID);

	public void updateTest(Test test);

	public List<Test> getAllTest();
	
	public List<Test> getPersonAndProject();

	public Test getTestById(String testName);
	
	public Test getTestByUser(int testID);
	
	public Test getTestByStatus(String status);
	
	public List<Issue> getDueDate();
	
	

}

