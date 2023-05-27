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

import com.api.dto.NiveauDto;
import com.api.model.Niveau;
import com.api.serviceImple.NiveauSerImple;

@RestController
public class NiveauController {
	
	@Autowired
	private NiveauSerImple niveauSerImple;
	
	@PostMapping("/niveau")
	public NiveauDto add(@RequestBody NiveauDto dto) {
		return niveauSerImple.add(dto);
	}
	
	@PutMapping("/niveau/{id}")
	public NiveauDto update(@RequestBody NiveauDto dto, @PathVariable int id) {
		return niveauSerImple.update(dto, id);
	}
	
	@DeleteMapping("/niveau/supprimer/{id}")
	public NiveauDto supprimer(@PathVariable int id) {
		return niveauSerImple.supprimer(id);
	}
	
	@GetMapping("/niveau/listeNiveau")
	public List<NiveauDto> listeNiveau(){
		return niveauSerImple.listeNiveau();
	}
	
	@GetMapping("/niveau/getById/{id}")
	public NiveauDto getById(@PathVariable int id) {
		return niveauSerImple.getById(id);
	}
}
