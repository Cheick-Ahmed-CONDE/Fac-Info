package com.api.service;

import java.util.List;

import com.api.dto.FormationDto;

public interface FormationService {
	
	public FormationDto add(FormationDto formationDto);
	public FormationDto update(FormationDto formationDto, int id);
	public FormationDto supprimer(int id);
	public List<FormationDto> listeFormation();
	public FormationDto getById(int id);

}
