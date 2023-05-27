package com.api.service;

import java.util.List;

import com.api.dto.InformationDto;

public interface InformationService {
	
	public InformationDto add(InformationDto informationDto);
	public InformationDto update(InformationDto informationDto, int id);
	public InformationDto supprimer(int id);
	public List<InformationDto> listeInformation();
	public InformationDto getById(int id);

}
