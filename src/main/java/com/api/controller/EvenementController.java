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

import com.api.dto.EvenementDto;
import com.api.serviceImple.EvenementSerImple;

@RestController
public class EvenementController {
	
	@Autowired
	private EvenementSerImple evenementSerImple;
	
	@PostMapping("/evenement")
	public EvenementDto add(@RequestBody EvenementDto dto) {
		return evenementSerImple.add(dto);
	}

	@PutMapping("/evenement/id/{id}")
	public EvenementDto update(@RequestBody EvenementDto dto,@PathVariable int id) {
		return evenementSerImple.update(dto, id);
	}
	
	@DeleteMapping("/evenement/supprimer/{id}")
	public EvenementDto supprimer(@PathVariable int id) {
		return evenementSerImple.supprimer(id);
	}
	
	@GetMapping("/evenement/listeEvenement")
	public List<EvenementDto> listeEvenement(){
		return evenementSerImple.listeEvenement();
	}
	
	@GetMapping("/evenement/getById/{id}")
	public EvenementDto getById(int id) {
		return evenementSerImple.getById(id);
	}
}
