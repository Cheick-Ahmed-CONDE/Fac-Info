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

import com.api.dto.OccuperDto;
import com.api.serviceImple.OccuperSerImple;

@RestController
public class OccuperController {
	
	@Autowired
	private OccuperSerImple occuperSerImple;

	@PostMapping("/occuper")
	public OccuperDto add(@RequestBody OccuperDto dto) {
		return occuperSerImple.add(dto);
	}
	
	@PutMapping("/occuper/{id}")
	public OccuperDto update(@RequestBody OccuperDto dto, @PathVariable int id) {
		return occuperSerImple.update(dto, id);
	}
	
	@DeleteMapping("/occuper/supprimer/{id}")
	public OccuperDto supprimer(@PathVariable int id) {
		return occuperSerImple.supprimer(id);
	}
	
	@GetMapping("/occuper/liste")
	public List<OccuperDto> listeOccuper(){
		return occuperSerImple.listeOccuper();
	}
	
	@GetMapping("/occuper/getById/{id}")
	public OccuperDto getById(@PathVariable int id) {
		return occuperSerImple.getById(id);
	}
}
