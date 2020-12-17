package com.myproject.demoSpring.service;

import com.myproject.demoSpring.dto.BiodataDto;
import com.myproject.demoSpring.entity.PersonEntity;

public interface PersonService {
	PersonEntity insertPerson(BiodataDto dto);
}
