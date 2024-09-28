package com.example.my_thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.my_thymeleaf.dto.PersonDto;
import com.example.my_thymeleaf.entity.Person;
import com.example.my_thymeleaf.mapper.PersonMapper;
import com.example.my_thymeleaf.repository.PersonRepository;

import jakarta.transaction.Transactional;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public List<PersonDto> findAll() {
		return personRepository.findAll()
				.stream()
				.map(person -> PersonMapper.map(person))
				.toList();
	}
	
	public PersonDto getById(Long id) {
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Person not foun id: " + id));
		return PersonMapper.map(person);
	}
	
	@Transactional
	public PersonDto save(PersonDto personDto) {
		Person person = PersonMapper.map(personDto);
		personRepository.save(person);
		return PersonMapper.map(person);
	}
}
