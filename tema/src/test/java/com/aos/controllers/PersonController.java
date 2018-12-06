package com.aos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aos.entities.PersonModel;
import com.aos.repository.PersonRepository;

@Controller
public class PersonController {


	@Autowired(required = true)
	private PersonRepository personRepository;

	@GetMapping(path = "/addperson") // Map ONLY GET Requests
	public @ResponseBody String addNewPerson(@RequestParam String name) {
		PersonModel person = new PersonModel();
		person.setName(name);
		personRepository.save(person);
		return "Saved";
	}

	@GetMapping(path = "/updateperson") // Map ONLY GET Requests
	public @ResponseBody String addNewPerson(@RequestParam Integer id, @RequestParam String name) {
		PersonModel person = personRepository.findOne(id);
		person.setName(name);
		personRepository.save(person);
		return "Updated";
	}
	
	@GetMapping(path = "/removeperson") // Map ONLY GET Requests
	public @ResponseBody String removePerson(@RequestParam Integer id) {
		PersonModel person = personRepository.findOne(id);
		personRepository.delete(person);
		return "Saved";
	}
	
	
	@GetMapping(path = "/allperson")
	public @ResponseBody Iterable<PersonModel> getAllPerson() {
		return personRepository.findAll();
	}

}
