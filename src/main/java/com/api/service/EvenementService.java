package com.api.service;

import java.util.List;

import com.api.dto.EvenementDto;

public interface EvenementService {
	
	public EvenementDto add(EvenementDto evenementDto);
	public List<EvenementDto> listeEvenement();
	public EvenementDto update(EvenementDto evenementDto, int id);
	public EvenementDto supprimer(int id);
	public EvenementDto getById(int id);

}
