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

import com.api.dto.EnseignantDto;
import com.api.serviceImple.EnseignantSerImple;


@RestController
public class EnseignantController {
	
	@Autowired
	private EnseignantSerImple enseignantSerImple;
	
	@PostMapping("/enseignant")
		public EnseignantDto add(@RequestBody EnseignantDto dto) {
		return enseignantSerImple.add(dto);
	}
	
	@PutMapping("/enseignant/id/{id}")
		public EnseignantDto update(@RequestBody EnseignantDto dto,@PathVariable int id) {
		return enseignantSerImple.update(dto, id);
	}
	
	@DeleteMapping("/enseignant/delete/{id}")
		public EnseignantDto supprimer(@PathVariable int id) {
		return enseignantSerImple.supprimer(id);
	}
	
	@GetMapping("/enseignant/liste")
		public List<EnseignantDto> listeEnseignant(){
			return enseignantSerImple.listeEnseignant();
		}
	
	@GetMapping("/enseignant/getById/id/{id}")
		public EnseignantDto getByIdEnseignant(@PathVariable int id) {
		return enseignantSerImple.getByIdEnseignant(id);
	}
}
