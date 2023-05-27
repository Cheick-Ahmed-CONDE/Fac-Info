package com.api.service;

import java.util.List;

import com.api.dto.OccuperDto;

public interface OccuperService {

	public OccuperDto add(OccuperDto occuperDto);
	public OccuperDto update(OccuperDto occuperDto, int id);
	public OccuperDto supprimer(int id);
	public List<OccuperDto> listeOccuper();
	public OccuperDto getById(int id);
}
