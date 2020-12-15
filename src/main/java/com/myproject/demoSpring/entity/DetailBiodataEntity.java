package com.myproject.demoSpring.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detail_biodata_entity")
public class DetailBiodataEntity {
	@Id
	@Column
	private Integer id;

	@Column
	private String domisili;

	@Column
	private Integer usia;

	@Column
	private Date tanggalLahir;

	@Column
	private String hobi;

	@Column
	private String jenisKelamin;
}
