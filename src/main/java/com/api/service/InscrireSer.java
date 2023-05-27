package com.api.service;

import java.util.List;

import com.api.dto.InscrireDto;

public interface InscrireSer {
	
	public InscrireDto add(InscrireDto inscrireDto);
	public InscrireDto update(InscrireDto inscrireDto, int id);
	public InscrireDto supprimer(int id);
	public List<InscrireDto> listeInscrire();
	public InscrireDto getById(int id);

}
