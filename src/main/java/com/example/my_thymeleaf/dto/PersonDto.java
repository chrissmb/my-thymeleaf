package com.example.my_thymeleaf.dto;

import java.time.LocalDate;

public record PersonDto(
		Long id, 
		String name, 
		LocalDate birthday, 
		Double height) {

}
