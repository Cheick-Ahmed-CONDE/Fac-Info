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

import com.api.dto.Participation_FormationDto;
import com.api.serviceImple.Participation_FormationSerImple;

@RestController
public class Participation_FormationController {
	
	@Autowired
	private Participation_FormationSerImple pfSerimple;
	
	@PostMapping("/participation_Formation")
	public Participation_FormationDto add(@RequestBody Participation_FormationDto dto) {
		return pfSerimple.add(dto);
	}
	
	@PutMapping("/participation_Formation/update/{id}")
	public Participation_FormationDto update(@RequestBody Participation_FormationDto dto, @PathVariable int id) {
		return pfSerimple.update(dto, id);
	}
	
	@DeleteMapping("/Participation_Formation/supprimer/{id}")
	public Participation_FormationDto supprimer(@PathVariable int id) {
		return pfSerimple.supprimer(id);
	}
	
	@GetMapping("/Participation_Formation/liste")
	public List<Participation_FormationDto> listePfDto(){
		return pfSerimple.listePfDto();
	}
	
	@GetMapping("/Participation_Formation/getById/{id}")
	public Participation_FormationDto getById(@PathVariable int id) {
		return pfSerimple.getById(id);
	}
}
