package com.siwa.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.siwa.dao.PersonDAO;
import com.siwa.dao.PersonDAOImplementation;
import com.siwa.model.Person;

@WebServlet("/PersonController")
public class PersonController extends HttpServlet {

	private PersonDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String lIST_PERSON = "/listPerson.jsp";
	public static final String INSERT_OR_EDIT = "/person.jsp";

	public PersonController() {
		dao = new PersonDAOImplementation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			forward = lIST_PERSON;
			int personId = Integer.parseInt(request.getParameter("personId"));
			dao.deletePerson(personId);
			request.setAttribute("persons", dao.getAllPersons());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int personId = Integer.parseInt(request.getParameter("personId"));
			Person person = dao.getPersonById(personId);
			request.setAttribute("person", person);
		} else if (action.equalsIgnoreCase("insert")) {
			forward = INSERT_OR_EDIT;
		} else {
			forward = lIST_PERSON;
			request.setAttribute("persons", dao.getAllPersons());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Person person = new Person();

		String firstname = (request.getParameter("firstName"));
		firstname = new String(firstname.getBytes("ISO8859-1"), "UTF-8");
		person.setFirstName(firstname);

		String lastname = (request.getParameter("lastName"));
		lastname = new String(lastname.getBytes("ISO8859-1"), "UTF-8");
		person.setLastName(lastname);

		try {
			Date birthdate = new SimpleDateFormat("yyy-MM-dd", Locale.ENGLISH).parse(request.getParameter("birthDate"));
			person.setBirthDate(birthdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String gender = (request.getParameter("gender"));
		gender = new String(gender.getBytes("ISO8859-1"), "UTF-8");
		person.setGender(gender);

		String address = (request.getParameter("address"));
		address = new String(address.getBytes("ISO8859-1"), "UTF-8");
		person.setAddress(address);

		String tel = (request.getParameter("tel"));
		tel = new String(tel.getBytes("ISO8859-1"), "UTF-8");
		person.setTel(tel);

		String position = (request.getParameter("position"));
		position = new String(position.getBytes("ISO8859-1"), "UTF-8");
		person.setPosition(position);

		String personId = request.getParameter("personId");

		if (personId == null || personId.isEmpty())
			dao.addPerson(person);
		else {
			person.setPersonId(Integer.parseInt(personId));
			dao.updatePerson(person);
		}
		RequestDispatcher view = request.getRequestDispatcher(lIST_PERSON);
		request.setAttribute("persons", dao.getAllPersons());
		view.forward(request, response);
	
	}
}