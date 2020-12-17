package com.myproject.demoSpring.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class BiodataDto {
	private String firstName;
	private String lastName;
	private String nik;
	private String domisili;
	private Integer usia;
	private Date tanggalLahir;
	private String hobi;
	private String jenisKelamin;
	private Integer personId;
	private String kodePerson;
}
