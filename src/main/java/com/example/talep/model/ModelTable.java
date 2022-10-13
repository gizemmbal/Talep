package com.example.talep.model;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ModelTable")
public class ModelTable {

	public ModelTable(String data, Talep talep) {
		this.Data = data;
		this.talep = talep;
		// this.setId(talep.getId());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@Column
	private String Data;

	@ManyToOne
	@JoinColumn(name = "linkedTable")
	private Talep talep;

	public ModelTable() {
		this.setId(Id);
		this.setData(Data);
	}

//	public ModelTable(@JsonProperty("data") String data) {
//		this.setId(Id);
//		this.setData(data);
//	}

	public ModelTable(@JsonProperty("id") Long id, @JsonProperty("data") String data) {
		this.Id = id;
		this.Data = data;
	}

//	public ModelTable(@JsonProperty("id") Long id, @JsonProperty("data") String data,
//			@JsonProperty("talep") Talep talep) {
//		this.Id = id;
//		this.Data = data;
//		this.setTalep(talep);
//	}

	public ModelTable(String data, Optional<Talep> talep) {
		this.Data = data;
		this.setTalep(talep.get());
		this.setId(talep.get().getId());
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		this.Data = data;
	}

	public Talep getTalep() {
		return talep;
	}

	public void setTalep(Talep talep) {
		this.talep = talep;
	}

}