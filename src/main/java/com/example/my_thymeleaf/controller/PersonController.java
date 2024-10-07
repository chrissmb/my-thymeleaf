package com.example.my_thymeleaf.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.my_thymeleaf.dto.PersonDto;
import com.example.my_thymeleaf.service.PersonService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("person")
public class PersonController implements WebMvcConfigurer {

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
	public String newPerson(PersonDto personDto) {
		return PERSON_FORM;
	}
	
	@GetMapping("edit/{id}")
	public ModelAndView editPerson(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView(PERSON_FORM);
		PersonDto personDto = personService.getById(id);
		modelAndView.addObject("personDto", personDto);
		return modelAndView;
	}
	
	@PostMapping
	public String savePerson(@Valid PersonDto personDto, BindingResult bindingResult) {
		LOGGER.info("Saving person: {}", personDto);
		if (bindingResult.hasErrors()) {
			LOGGER.info("Person invalid: {}", bindingResult.getAllErrors());
			return PERSON_FORM;
		}
		personService.save(personDto);
		return "redirect:person";
	}
}
