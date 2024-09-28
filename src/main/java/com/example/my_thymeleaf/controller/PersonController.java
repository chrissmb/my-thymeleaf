package com.example.my_thymeleaf.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.my_thymeleaf.dto.PersonDto;
import com.example.my_thymeleaf.service.PersonService;

@Controller
@RequestMapping("person")
public class PersonController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
	private static final String PERSON_LIST = "person/list";
	private static final String PERSON_FORM = "person/form";
	
	@Autowired
	private PersonService personService;
	
	@GetMapping
	public ModelAndView listPerson() {
		ModelAndView modelAndView = new ModelAndView(PERSON_LIST);
		List<PersonDto> persons = personService.findAll();
		modelAndView.addObject("persons", persons);
		return modelAndView;
	}
	
	@GetMapping("edit")
	public ModelAndView newPerson() {
		ModelAndView modelAndView = new ModelAndView(PERSON_FORM);
		PersonDto personDto = new PersonDto(null, null, null, null);
		modelAndView.addObject("person", personDto);
		return modelAndView;
	}
	
	@GetMapping("edit/{id}")
	public ModelAndView editPerson(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView(PERSON_FORM);
		PersonDto personDto = personService.getById(id);
		modelAndView.addObject("person", personDto);
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView savePerson(PersonDto personDto) {
		LOGGER.info("Saving person: {}", personDto);
		ModelAndView modelAndView = new ModelAndView("redirect:person");
		personService.save(personDto);
		return modelAndView;
	}
}
