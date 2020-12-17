package com.myproject.demoSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "pendidikan_entity")
@NoArgsConstructor
@AllArgsConstructor
public class PendidikanEntity {
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "kode_pendidikan", unique = true, length = 25, nullable = false)
	private String kodePendidikan;
	
	@Column(name = "jenjang")
	private String jenjang;
	
	@Column(name = "institusi")
	private String institusi;
	
	@ManyToOne
	@JoinColumn(name = "kode_person", referencedColumnName = "kode_person")
	private PersonEntity personEntity;
}
