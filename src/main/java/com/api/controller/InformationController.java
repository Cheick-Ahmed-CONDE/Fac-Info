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

import com.api.dto.InformationDto;
import com.api.serviceImple.InformationSerImple;

@RestController
public class InformationController {
	
	@Autowired
	private InformationSerImple informationSerImple;
	
	@PostMapping("/information")
	public InformationDto add(@RequestBody InformationDto dto) {
		return informationSerImple.add(dto);
	}

	@PutMapping("/information/id/{id}")
	public InformationDto update(@RequestBody InformationDto dto,@PathVariable int id) {
		return informationSerImple.update(dto, id);
	}
	
	@DeleteMapping("/information/supprimer/{id}")
	public InformationDto supprimer(@PathVariable int id) {
		return informationSerImple.supprimer(id);
	}
	
	@GetMapping("/information/liste")
	public List<InformationDto> listeFormation(){
		return informationSerImple.listeInformation();
	}
	
	@GetMapping("/information/getByid/{id}")
	public InformationDto getById(@PathVariable int id) {
		return informationSerImple.getById(id);
	}
}
