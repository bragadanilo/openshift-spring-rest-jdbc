package com.dbraga.springrest.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbraga.springrest.app.dao.PersonDAO;
import com.dbraga.springrest.app.domain.Person;

@RestController
public class HelloWorldRestController {

	@Autowired
	private PersonDAO personDAO;

	@RequestMapping("/")
	public String welcome() {
		return "index";
	}

	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = "application/json")
	public Person getById(@PathVariable String id) {

		Person person = personDAO.get(Integer.valueOf(id));
		
		System.out.println(person);		
		return person;
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET, produces = "application/json")
	public List<Person> getAll() {

		List<Person> personList = personDAO.list();
		
		System.out.println(personList);		
		return personList;
	}

}
