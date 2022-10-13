package com.example.talep.repository;

import java.util.List;

import com.example.talep.model.Talep;

public interface Dao {
	public void insertTalep(Talep talep, List<Talep> DB);

	public void deleteTalepbyKonu(String talepKonusu, List<Talep> DB);

	public void updateTalepDurumubyKonu(String talepKonusu, String talepDurumu, List<Talep> DB);

	public void updateAllTalepDurumuToOnaylandı(List<Talep> DB);
}
