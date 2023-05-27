package com.api.service;

import java.util.List;

import com.api.dto.SalleDto;

public interface SalleService {

	public SalleDto add(SalleDto salleDto);
	public SalleDto update(SalleDto salleDto, int id);
	public SalleDto supprimer(int id);
	public List<SalleDto> listeSalle();
	public SalleDto getById(int id);
}
