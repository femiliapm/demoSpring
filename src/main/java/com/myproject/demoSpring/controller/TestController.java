package com.myproject.demoSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.demoSpring.entity.PersonEntity;
import com.myproject.demoSpring.repository.DetailBiodataRepository;
import com.myproject.demoSpring.repository.PersonRepository;

@RestController
@RequestMapping("/testing")
public class TestController {
	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private DetailBiodataRepository detailRepository;

	@GetMapping("/get")
	public ResponseEntity<?> read() {
		List<PersonEntity> personEntity = personRepository.findAll();

		HttpHeaders headers = new HttpHeaders();
		headers.add("status", "200");

		return ResponseEntity.ok().body(personEntity);
	}
}
