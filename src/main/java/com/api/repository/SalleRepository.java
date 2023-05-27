package com.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Salle;

public interface SalleRepository extends JpaRepository<Salle, Integer>{

	
	boolean existsByNumSalle(String number);
}
