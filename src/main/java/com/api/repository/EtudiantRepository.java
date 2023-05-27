package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>{

	boolean existsByMatricule(String number);
	boolean existsByTelephone(String tel);
}
