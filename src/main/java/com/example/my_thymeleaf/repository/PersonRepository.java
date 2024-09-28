package com.example.my_thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.my_thymeleaf.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
