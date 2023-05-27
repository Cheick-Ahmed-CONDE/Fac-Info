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

import com.api.dto.FormationDto;
import com.api.serviceImple.FormationSerImple;

@RestController
public class FormationController {
	
	@Autowired FormationSerImple formationSerImple;

	@PostMapping("/formation")
	public FormationDto add(@RequestBody FormationDto dto) {
		return formationSerImple.add(dto);
	}
	
	@PutMapping("/formation/{id}")
	public FormationDto update(@RequestBody FormationDto dto,@PathVariable int id) {
		return formationSerImple.update(dto, id);
	}
	
	@DeleteMapping("/formation/delete/{id}")
	public FormationDto supprimer(@PathVariable int id) {
		return formationSerImple.supprimer(id);
	}
	
	@GetMapping("/formation/listeFormation")
	public List<FormationDto> listeFormation() {
		return formationSerImple.listeFormation();
	}
	
	@GetMapping("/formation/getById/{id}")
	public FormationDto getById(@PathVariable int id) {
		return formationSerImple.getById(id);
	}
}
