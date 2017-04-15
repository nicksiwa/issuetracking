package com.siwa.dao;

import java.util.List;
import com.siwa.model.Person;

public interface PersonDAO {
	public void addPerson(Person person);

	public void deletePerson(int personId);

	public void updatePerson(Person person);

	public List<Person> getAllPersons();

	public Person getPersonById(int personId);
	
	public Person getPersonByUsername(String username);
	
	public Person getGitHubByUsername(String username);
	
	public List<Person> pagination(int startIndex,int numberOfArticlePerpage);
}