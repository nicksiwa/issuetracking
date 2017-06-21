package com.siwa.dao;

import java.util.List;


import com.siwa.model.File;

public interface FileDAO {
	
	public File getFileByIssueId(int issueID);
	
	public List<File> getAllFileByIssueId(int issueID);

}
