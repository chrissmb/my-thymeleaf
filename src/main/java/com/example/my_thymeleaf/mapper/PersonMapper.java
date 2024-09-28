package com.example.my_thymeleaf.mapper;

import com.example.my_thymeleaf.dto.PersonDto;
import com.example.my_thymeleaf.entity.Person;

public class PersonMapper {

	public static PersonDto map(Person person) {
		if (person == null) {
			return null;
		}
		return new PersonDto(person.getId(), person.getName(), person.getBirthday(), person.getHeith());
	}
	
	public static Person map(PersonDto personDto) {
		if (personDto == null) {
			return null;
		}
		return new Person(personDto.id(), personDto.name(), personDto.birthday(), personDto.height());
	}
}
