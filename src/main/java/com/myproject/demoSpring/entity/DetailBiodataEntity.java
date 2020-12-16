package com.myproject.demoSpring.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "detail_biodata_entity")
public class DetailBiodataEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@OneToOne
	@JoinColumn(name = "person_id")
	private PersonEntity personEntity;
}
