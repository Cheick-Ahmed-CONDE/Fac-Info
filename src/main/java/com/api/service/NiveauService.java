package com.api.service;

import java.util.List;

import com.api.dto.NiveauDto;

public interface NiveauService {
	
	public NiveauDto add(NiveauDto niveauDto);
	public NiveauDto update(NiveauDto niveauDto, int id);
	public NiveauDto supprimer(int id);
	public List<NiveauDto> listeNiveau();
	public NiveauDto getById(int id);

}
