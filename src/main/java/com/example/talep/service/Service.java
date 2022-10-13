package com.example.talep.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.talep.model.ModelTable;
import com.example.talep.model.Talep;
import com.example.talep.repository.ModelTableRepository;
import com.example.talep.repository.TalepRepository;

@Component // @Repository,@Service de olabilir
public class Service {

	@Autowired
	TalepRepository talepRepository;
	@Autowired
	ModelTableRepository tableRepository;

	public void insertTalepService(Talep talep) {
		talepRepository.save(talep);
	}

	public void insertTableService(ModelTable table) {
		tableRepository.save(table);
	}

	public void insertBothService(String data, String talep_konusu, String talep_durumu, String talep_aciklamasi) {

//		ModelTable table = new ModelTable();
//		Talep talep = new Talep(talep_konusu, talep_durumu, talep_aciklamasi);
//		table.setTalep(talep);

		Talep talep = new Talep(talep_konusu, talep_durumu, talep_aciklamasi);
		Talep talepDb = talepRepository.save(talep);
		ModelTable table = new ModelTable(data, talepDb);
		tableRepository.save(table);
	}

	public void insert2BothService(String data1, String data2, Long id) {

		Talep talep = talepRepository.findById(id).get();
		ModelTable table1 = new ModelTable(data1, talep);
		ModelTable table2 = new ModelTable(data2, talep);
		tableRepository.save(table1);
		tableRepository.save(table2);
	}

	// Returns DB
	public List<Talep> returnTaleps_service() {
		return talepRepository.findAll();
	}

	public List<ModelTable> returnTables_service() {
		return tableRepository.findAll();
	}

	// Try-catch used in returnTalepService
	public Talep returnTalepService(Long id) {
		Optional<Talep> talep = talepRepository.findById(id);
		try {
			talep.isPresent();
			return talepRepository.findById(id).get();

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	// Throw used in returnTalepService
//	public Talep returnTalepService(Long id) {
//		Optional<Talep> talep = talepRepository.findById(id);
//		if (talep.isPresent()) {
//			return talepRepository.findById(id).get();
//		} else {
//			throw new MyException("exception");
//		}
//	}

	public void deleteTalepService(Long id) {
		talepRepository.deleteById(id);
	}

	public void updateTalepDurumuService(Long id, String talepDurumu) {
		Talep talep = returnTalepService(id);
		talep.setTalepDurumu(talepDurumu);
		talepRepository.save(talep);
	}

	public void updateAllTalepDurumuToOnaylandıService() {
		List<Talep> returnTalepsService = returnTaleps_service();
		for (Talep talep : returnTalepsService) {
			talep.setTalepDurumu("Onaylandı");
			talepRepository.save(talep);
		}
	}

	// Displays Taleps with stated talepDurumu
	public List<Talep> displayTalepsByDurumService(String talepDurumu) {

		List<Talep> returnTalepsService = returnTaleps_service();
		List<Talep> myList = new ArrayList<>();
		for (Talep talep : returnTalepsService) {
			if (talep.getTalepDurumu().equalsIgnoreCase(talepDurumu)) {
				// List<Talep> saveAll = talepRepository.saveAll(returnTalepsService);
				myList.add(talep);
			}
		}
		return myList;
	}

// ##################################

	// Displays all talepKonusu
	public List<String> displayAllTalepKonuService() {
		List<Talep> returnTalepsService = returnTaleps_service();
		List<String> myList = new ArrayList<>();
		for (Talep talep : returnTalepsService) {
			if (!myList.contains(talep.getTalepKonusu())) {
				myList.add(talep.getTalepKonusu());
			}
		}
		return myList;
	}

	public List<Talep> findBetweenIdService(Long id1, Long id2) {
		List<Talep> returnTalepsService = returnTaleps_service();
		List<Talep> myList = new ArrayList<>();
		for (Talep talep : returnTalepsService) {
			if (id1 <= talep.getId() && talep.getId() <= id2) {
				myList.add(talep);
			}
		}
		return myList;
	}

	// Creates dummy Talep
	public Talep setDummyTalep() {
		Talep talep = new Talep();
		talep.setTalepAciklamasi("Dummy Talep açıklamam bu");
		talep.setTalepDurumu("Dummy Talep durumum Beklemede");
		talep.setTalepKonusu("Dummy Talep Konum bu");
		return talep;
	}

//	@SuppressWarnings("deprecation")
//	public void updateModelTableTalep(Long id) {
//		if (tableRepository.existsById(id)) {
//			if (talepRepository.existsById(id)) {
//				tableRepository.getById(id).setTalep(talepRepository.getById(id));
//			}
//		}
//
//	}

}
