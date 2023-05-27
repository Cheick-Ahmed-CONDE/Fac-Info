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

import com.api.dto.InscrireDto;
import com.api.serviceImple.InscrireSerImple;

@RestController
public class InscrireController {
	
	@Autowired 
	private InscrireSerImple inscrireSerImple;
	
	@PostMapping("/inscrire")
	public InscrireDto add(@RequestBody InscrireDto dto) {
		return inscrireSerImple.add(dto);
	}
	
	@PutMapping("/inscrire/{id}")
	public InscrireDto update(@RequestBody InscrireDto dto, @PathVariable int id) {
		return inscrireSerImple.update(dto, id);
	}
	
	@DeleteMapping("/inscrire/supprimer{id}")
	public InscrireDto supprimer(@PathVariable int id) {
		return inscrireSerImple.supprimer(id);
	}
	
	@GetMapping("/inscrire/liste")
	public List<InscrireDto> listeInscrire(){
		return inscrireSerImple.listeInscrire();
	}
	
	@GetMapping("/inscrire/getById/{id}")
	public InscrireDto getById(@PathVariable int id) {
		return inscrireSerImple.getById(id);
	}
}
