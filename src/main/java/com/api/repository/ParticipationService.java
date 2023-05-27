package com.api.repository;

import java.util.List;

import com.api.dto.ParticipationDto;

public interface ParticipationService {

	public ParticipationDto add(ParticipationDto participationDto);
	public ParticipationDto update(ParticipationDto participationDto, int id);
	public ParticipationDto supprimer(int id);
	public List<ParticipationDto> listepDto();
	public ParticipationDto getById(int id);
}
