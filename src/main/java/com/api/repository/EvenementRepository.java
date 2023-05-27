package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {

}
