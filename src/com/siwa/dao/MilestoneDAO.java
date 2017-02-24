package com.siwa.dao;

import java.util.List;


import com.siwa.model.Milestone;

public interface MilestoneDAO {
	
	public void addMilestone(Milestone milestone);
	
	public void deleteMilestone(int milestoneID);
	
	public List<Milestone> getAllMilestone();
	
	public List<Milestone> getAllMilestoneByProjectId(int projectID);

	public List<Milestone> getMilestoneByIssueId(int issueID);
	
	public List<Milestone> getAssignMilestone(int issueID);
	
	public void updatePercent(Milestone milestone);
	
}
