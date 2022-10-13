package com.example.talep.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Talep")
public class Talep {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@Column
	private String talepKonusu;
	@Column
	private String talepDurumu;// I might do boolean?
	@Column
	private String talepAciklamasi;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ModelTable> modelTable = new ArrayList<>();

	// Contructor
	public Talep() {
		this.setTalepAciklamasi(talepAciklamasi);
		this.setTalepDurumu(talepDurumu);
		this.setTalepKonusu(talepKonusu);
		this.setId(Id);
		this.setModelTable(modelTable);
	}

	public Talep(@JsonProperty("konu") String talepKonusu, @JsonProperty("durum") String talepDurumu,
			@JsonProperty("aciklama") String talepAciklamasi) {
		this.setTalepAciklamasi(talepAciklamasi);
		this.setTalepDurumu(talepDurumu);
		this.setTalepKonusu(talepKonusu);
		this.setId(Id);
		this.setModelTable(modelTable);
	}

//	public Talep(String talepKonusu, String talepDurumu, String talepAciklamasi, List<ModelTable> table) {
//		this.setTalepAciklamasi(talepAciklamasi);
//		this.setTalepDurumu(talepDurumu);
//		this.setTalepKonusu(talepKonusu);
//		this.setId(Id);
//		this.setModelTable(table);
//	}

	public String getTalepKonusu() {
		return talepKonusu;
	}

	public void setTalepKonusu(String talepKonusu) {
		this.talepKonusu = talepKonusu;
	}

	public String getTalepDurumu() {
		return talepDurumu;
	}

	public void setTalepDurumu(String talepDurumu) {
		this.talepDurumu = talepDurumu;
	}

	public String getTalepAciklamasi() {
		return talepAciklamasi;
	}

	public void setTalepAciklamasi(String talepAciklamasi) {
		this.talepAciklamasi = talepAciklamasi;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public List<ModelTable> getModelTable() {
		return modelTable;
	}

	public void setModelTable(List<ModelTable> modelTable) {
		this.modelTable = modelTable;
	}
}
