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

import com.api.dto.EtudiantDto;
import com.api.serviceImple.EtudiantSerImple;

@RestController
public class EtudiantController {
	
	@Autowired
	private EtudiantSerImple etudiantSerImple;
	
	@PostMapping("/etudiant")
	public EtudiantDto add(@RequestBody EtudiantDto dto) {
		return etudiantSerImple.add(dto); 
	}

	@PutMapping("/etudiant/id/{id}")
	public EtudiantDto update(@RequestBody EtudiantDto dto, @PathVariable int id) {
		return etudiantSerImple.update(dto,id);
	}
	
	@DeleteMapping("/etudiant/id/{id}")
	public EtudiantDto supprimer(@PathVariable int id) {
		return etudiantSerImple.supprimer(id);
	}
	
	@GetMapping("/etudiant/liste")
	public List<EtudiantDto> listeEtudiant() {
		return etudiantSerImple.listeEtudiant();
	}	
	
	@GetMapping("/etudiant/getById/{id}")
	public EtudiantDto getByIdEtudiant(@PathVariable int id) {
		return etudiantSerImple.getByIdEtudiant(id);
	}
}

