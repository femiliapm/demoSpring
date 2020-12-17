package com.myproject.demoSpring.service;

import com.myproject.demoSpring.dto.BiodataDto;
import com.myproject.demoSpring.entity.DetailBiodataEntity;

public interface BiodataService {
	DetailBiodataEntity insertAll(BiodataDto dto);
}
