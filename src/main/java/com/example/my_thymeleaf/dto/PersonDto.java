package com.example.my_thymeleaf.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public record PersonDto(
		Long id, 
		String name, 
		@DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate birthday, 
		Double height) {

}
