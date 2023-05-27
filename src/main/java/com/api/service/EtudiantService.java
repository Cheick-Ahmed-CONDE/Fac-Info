package com.api.service;

import java.util.List;

import com.api.dto.EtudiantDto;

public interface EtudiantService {
	
	public EtudiantDto add(EtudiantDto etudiantDto);
	public EtudiantDto update(EtudiantDto etudiantDto, int id);
	public EtudiantDto supprimer(int id);
	public List<EtudiantDto> listeEtudiant();
	public EtudiantDto getByIdEtudiant(int id);
}
