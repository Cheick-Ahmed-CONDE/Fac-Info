package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.SalleDto;
import com.api.serviceImple.SalleSerImple;

@RestController
public class SalleController {
	
	@Autowired SalleSerImple salleSerImple;

	@PostMapping("/salle")
	public SalleDto add(@RequestBody SalleDto dto) {
		return salleSerImple.add(dto);
	}
	
	@PutMapping("/salle/update/{id}")
	public SalleDto update(@RequestBody SalleDto dto, @PathVariable int id) {
		return salleSerImple.update(dto, id);
	}
	
	@DeleteMapping("/salle/supprimer/{id}")
	public SalleDto supprimer(@PathVariable int id) {
		return salleSerImple.supprimer(id);
	}
	
	@GetMapping("/salle/liste")
	public List<SalleDto> listeSalle(){
		return salleSerImple.listeSalle();
	}
	
	@GetMapping("/salle/getById/{id}")
	public SalleDto gettById(@PathVariable int id) {
		return salleSerImple.getById(id);
	}
}
