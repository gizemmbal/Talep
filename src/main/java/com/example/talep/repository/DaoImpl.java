package com.example.talep.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.talep.model.Talep;

@Component
public class DaoImpl implements Dao {

	@Override
	public void insertTalep(Talep talep, List<Talep> DB) {
		DB.add(talep);
	}

	// Deletes the first Talep from DB that has talepKonusu
	@Override
	public void deleteTalepbyKonu(String talepKonusu, List<Talep> DB) {

		// For loop using Stream
		for (Talep talep : DB) {
			if (talep.getTalepKonusu().equalsIgnoreCase(talepKonusu)) {
				DB.remove(talep);
			} else {
				System.out.println("Talep is not available");
			}
		}

		// My old class for loop
		// for (int i = 0; i < DB.size(); i++) {
		// if (DB.get(i).getTalepKonusu().equalsIgnoreCase(talepKonusu)) {
		// DB.remove(i);
		// } else {
		// System.out.print("Talep is not available");
		// }
		// }

	}

	// Updates talepDurumu to given TalepDurumu by searching talepKonusu
	@Override
	public void updateTalepDurumubyKonu(String talepKonusu, String talepDurumu, List<Talep> DB) {

		for (Talep talep : DB) {
			if (talep.getTalepKonusu().equalsIgnoreCase(talepKonusu)) {

				if (talep.getTalepDurumu().equalsIgnoreCase(talepDurumu)) {
					System.out.println("Talep already has the given talepDurumu : " + talepDurumu);
				} else {
					talep.setTalepDurumu(talepDurumu);
				}

			} else {
				System.out.println("Talep with given Konu is not available");
			}
		}
	}

	// Updates all talepDurumu to Onaylandı
	@Override
	public void updateAllTalepDurumuToOnaylandı(List<Talep> DB) {
		for (Talep talep : DB) {
			if (talep.getTalepDurumu().equalsIgnoreCase("Bekleyen")) {
				talep.setTalepDurumu("Onaylandı");
			} else {
				System.out.print("Talep with given Durum is not available");
			}
		}
	}

}
