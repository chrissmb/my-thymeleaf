package com.example.my_thymeleaf.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PersonDto(
		Long id,

		@NotBlank
		@Size(min = 2, max = 254)
		String name,

		LocalDate birthday,

		Double height) {

}
