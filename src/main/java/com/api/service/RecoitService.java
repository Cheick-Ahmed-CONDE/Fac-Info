package com.api.service;

import java.util.List;

import com.api.dto.RecoitDto;

public interface RecoitService {

	public RecoitDto add(RecoitDto recoitDto);
	public RecoitDto update(RecoitDto RDto, int id);
	public RecoitDto supprimer(int id);
	public List<RecoitDto> listeRDto();
	public RecoitDto getById(int id);
}
