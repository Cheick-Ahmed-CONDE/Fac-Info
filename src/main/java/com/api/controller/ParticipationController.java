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

import com.api.dto.ParticipationDto;
import com.api.serviceImple.ParticipationSerImple;


@RestController
public class ParticipationController {
	
	@Autowired 
	private ParticipationSerImple pSerImple;
	
	@PostMapping("/participation")
	public ParticipationDto add(@RequestBody ParticipationDto dto) {
		return pSerImple.add(dto);
	}
	@PutMapping("/participation/update/{id}")
	public ParticipationDto update(@RequestBody ParticipationDto dto, @PathVariable int id) {
		return pSerImple.update(dto, id);
	}
	@DeleteMapping("/participation/supprimer/{id}")
	public ParticipationDto supprimer(@PathVariable int id) {
		return pSerImple.supprimer(id);
	}
	@GetMapping("/participation/liste")
	public List<ParticipationDto> listepDto(){
		return pSerImple.listepDto();
	}
	@GetMapping("/participation/getById/{id}")
	public ParticipationDto getById(@PathVariable int id) {
		return pSerImple.getById(id);
	}

}
