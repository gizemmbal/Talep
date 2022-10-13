package com.example.talep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.talep.model.ModelTable;
import com.example.talep.model.Talep;
import com.example.talep.service.Service;

@RestController
@RequestMapping("api/v1")

public class Controller {

	@Autowired
	Service service;

	@GetMapping("/returnTaleps")
	public List<Talep> returnTaleps() {
		List<Talep> returnTaleps_service = service.returnTaleps_service();
		return returnTaleps_service;
	}

	@GetMapping("/returnTables")
	public List<ModelTable> returnTables() {
		return service.returnTables_service();
	}

	@GetMapping("/returnTalep")
	public Talep returnTalep(@RequestParam Long id) {
		return service.returnTalepService(id);
	}

	@PostMapping("/insertTalep")
	public void insertTalep(@RequestBody Talep talep) {
		service.insertTalepService(talep);
	}

	@PostMapping("/insertTable")
	public void insertTable(@RequestBody ModelTable table) {
		service.insertTableService(table);
	}

	@PostMapping("/insertBothService")
	public void insertBothService(@RequestParam String data, @RequestParam String talep_konusu,
			@RequestParam String talep_durumu, @RequestParam String talep_aciklamasi) {
		service.insertBothService(data, talep_konusu, talep_durumu, talep_aciklamasi);
	}

	@PostMapping("/insert2BothService")
	public void insert2BothService(@RequestParam String data1, @RequestParam String data2, @RequestParam Long id) {
		service.insert2BothService(data1, data2, id);
	}

	@DeleteMapping("/deleteTalep")
	public void deleteTalep(@RequestParam Long id) {
		service.deleteTalepService(id);
	}

	@PutMapping("/updateTalep")
	public void updateTalepDurumu(@RequestParam Long id, @RequestParam String talepDurumu) {
		service.updateTalepDurumuService(id, talepDurumu);
	}

//	@PutMapping("/updateModelTableTalep")
//	public void updateModelTableTalep(@RequestParam Long id) {
//		service.updateModelTableTalep(id);
//	}

	@PutMapping("/updateAllTaleps")
	public void updateAllTalepDurumuToOnaylandı() {
		service.updateAllTalepDurumuToOnaylandıService();
	}

	@GetMapping("/getbyDurum")
	public List<Talep> displayTalepsByDurum(@RequestParam String talepDurumu) {
		return service.displayTalepsByDurumService(talepDurumu);
	}

	@GetMapping("/getAllKonu")
	public List<String> getAllKonu() {
		return service.displayAllTalepKonuService();
	}

	@GetMapping("/findBetweenId")
	public List<Talep> findBetweenId(@RequestParam Long id1, @RequestParam Long id2) {
		return service.findBetweenIdService(id1, id2);
	}

	// #################################################

	@GetMapping("/getDummyTalep")
	public ResponseEntity<Talep> getDummyTalep() {
		Talep talep = service.setDummyTalep();
		return new ResponseEntity<>(talep, HttpStatus.OK);
	}

	@GetMapping("/getDBwithParam") // http://localhost:8080/api/v1/a?talep=my_value
	public List<Talep> getDBwithParam(@RequestParam String talep) {
		return service.returnTaleps_service();
	}

}
