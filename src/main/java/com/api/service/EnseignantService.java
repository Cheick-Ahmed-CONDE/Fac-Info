package com.api.service;

import java.util.List;

import com.api.dto.EnseignantDto;

public interface EnseignantService {
	
	public EnseignantDto add(EnseignantDto enseignantDto);
	public EnseignantDto update(EnseignantDto enseignantDto, int id);
	public EnseignantDto supprimer(int id);
	public List<EnseignantDto> listeEnseignant();
	public EnseignantDto getByIdEnseignant(int id);
}
