package com.myproject.demoSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.demoSpring.dto.PendidikanDto;
import com.myproject.demoSpring.entity.PendidikanEntity;
import com.myproject.demoSpring.entity.PersonEntity;
import com.myproject.demoSpring.repository.PendidikanRepository;
import com.myproject.demoSpring.repository.PersonRepository;

@RestController
@RequestMapping("/pendidikan")
public class PendidikanController {
	@Autowired
	private PendidikanRepository pendidikanRepository;

	@Autowired
	private PersonRepository personRepository;

	@PostMapping("/insert")
	public ResponseEntity<?> insert(@RequestBody PendidikanDto dto) {
		PendidikanEntity pendidikanEntity = new PendidikanEntity();
		pendidikanEntity.setId(2);
		pendidikanEntity.setInstitusi(dto.getInstitusi());
		pendidikanEntity.setJenjang(dto.getJenjang());
		pendidikanRepository.save(pendidikanEntity);
		pendidikanEntity.setKodePendidikan("E" + pendidikanEntity.getId());

		PersonEntity personEntity = personRepository.findByKodePerson(dto.getKodePerson());
		pendidikanEntity.setPersonEntity(personEntity);

		pendidikanRepository.save(pendidikanEntity);

		return ResponseEntity.ok(pendidikanEntity);
	}

	@GetMapping("/get")
	public ResponseEntity<?> get() {
		List<PendidikanEntity> pendidikanEntities = pendidikanRepository.findAll();
		return ResponseEntity.ok(pendidikanEntities);
	}
}
