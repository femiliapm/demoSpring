package com.myproject.demoSpring.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class DetailBiodataDto {
	private String domisili;
	private Integer usia;
	private Date tanggalLahir;
	private String hobi;
	private String jenisKelamin;
	private Integer personId;
}
