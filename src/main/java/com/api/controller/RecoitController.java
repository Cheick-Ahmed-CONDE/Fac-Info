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
import com.api.dto.RecoitDto;
import com.api.serviceImple.RecoitSerImple;

@RestController
public class RecoitController {
	
	@Autowired
	private RecoitSerImple recoitSerImple;

	@PostMapping("/recoit")
	public RecoitDto add(@RequestBody RecoitDto dto) {
		return recoitSerImple.add(dto);
	}
	
	@PutMapping("/recoit/update/{id}")
	public RecoitDto update(@RequestBody RecoitDto dto, @PathVariable int id) {
		return recoitSerImple.update(dto, id);
	}
	
	@DeleteMapping("/recoit/supprimer/{id}")
	public RecoitDto supprimer(@PathVariable int id) {
		return recoitSerImple.supprimer(id);
	}
	
	@GetMapping("/recoit/liste")
	public List<RecoitDto> listRecoit(){
		return recoitSerImple.listeRDto();
	}
	
	@GetMapping("/recoit/getById/{id}")
	public RecoitDto getById(@PathVariable int id) {
		return recoitSerImple.getById(id);
	}
}
