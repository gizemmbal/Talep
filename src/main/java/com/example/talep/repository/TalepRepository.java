package com.example.talep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.talep.model.Talep;

@Repository
public interface TalepRepository extends JpaRepository<Talep, Long> {
//
//	// Using an in-memory Map
//	// to store the object data
//	private Map<Long, Talep> repository;
//
//	public TalepRepository() {
//		this.repository = new HashMap<>();
//	}
//
//	// Implementation for save method
//	@Override
//	public void save(Talep talep) {
//		repository.put(talep.getTalepKonusu(), talep);
//	}

//
//	// Implementation for findStudentById method
//	@Override
//	public Student findStudentById(Long id) {
//		return repository.get(id);
//	}
}