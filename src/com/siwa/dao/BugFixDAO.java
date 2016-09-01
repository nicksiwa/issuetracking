package com.siwa.dao;

import java.util.List;
import com.siwa.model.BugFix;;

public interface BugFixDAO {
	
	public void addBug(BugFix bug);
	
	public void deleteBug(int bugId);
	
	public void updateBug(BugFix bug);
	
	public List<BugFix> getAllBugs();
	
	public BugFix getBugById(int bugId);

}
