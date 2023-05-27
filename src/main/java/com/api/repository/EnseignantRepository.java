package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.api.model.Client;
import com.api.model.Enseignant; 
 
 
public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> { 
	
	boolean existsByTelephone(String number);
	boolean existsByEmail(String email);
}
