package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Information;

public interface InformationRepository extends JpaRepository<Information, Integer>{

}
