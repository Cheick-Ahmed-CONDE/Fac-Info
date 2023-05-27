package com.api.service;

import java.util.List;

import com.api.dto.Participation_FormationDto;

public interface Participation_FormationService {
	
	public Participation_FormationDto add(Participation_FormationDto pfDto);
	public Participation_FormationDto update(Participation_FormationDto pfDto, int id);
	public Participation_FormationDto supprimer(int id);
	public List<Participation_FormationDto> listePfDto();
	public Participation_FormationDto getById(int id);

}
