package com.api.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.ParticipationDto;
import com.api.exception.ExceptionApi;
import com.api.mapperDto.MapperDto;
import com.api.model.Evenement;
import com.api.model.Niveau;
import com.api.model.Participation;
import com.api.repository.EvenementRepository;
import com.api.repository.NiveauRepository;
import com.api.repository.ParticipationRepository;
import com.api.repository.ParticipationService;

@Service
public class ParticipationSerImple implements ParticipationService { 
	
	@Autowired 
	private ParticipationRepository participationRepository;
	
	@Autowired
	private NiveauRepository niveauRepository;
	
	@Autowired
	private EvenementRepository evenementRepository;

	@Override
	public ParticipationDto add(ParticipationDto pDto) {
	
		ParticipationDto response = new ParticipationDto();
		if (pDto == null) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez renseigner les champs");
			return response;
		}
		Optional<Evenement> evenement = evenementRepository.findById(pDto.getId_evenement());
		if (!evenement.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("l'evenement existe pas");
			return response;
		}
		Optional<Niveau> niveau = niveauRepository.findById(pDto.getId_niveau());
		if(!niveau.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Ce Niveau n'existe pas");
			return response;
		}
		Participation p = MapperDto.toParticipationDto(pDto, evenement.get(), niveau.get());
		Participation pSave = participationRepository.save(p);
		response = MapperDto.toParticipation(pSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Enregistrement effectuée avec succes");
		return response;
	}

	@Override
	public ParticipationDto update(ParticipationDto pDto, int id) {
		ParticipationDto response = new ParticipationDto();
		if(pDto == null || id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne doit pas etre nul");
			return response;
		}
		Optional<Evenement> evenement = evenementRepository.findById(pDto.getId_evenement());
		if (!evenement.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("l'evenement existe deja");
			return response;
		}
		Optional<Niveau> niveau = niveauRepository.findById(pDto.getId_niveau());
		if(!niveau.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Ce Niveau n'existe pas");
			return response;
		}
		pDto.setId(id);
		Participation p = MapperDto.toParticipationDto(pDto, evenement.get(), niveau.get());
		Participation pSave = participationRepository.save(p);
		response = MapperDto.toParticipation(pSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Modification effectuée avec succes");
		return response;
		
	}
	
	@Override
	public ParticipationDto supprimer(int id) {
		ParticipationDto response = new ParticipationDto();
		if (id==0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("l'id ne pas etre nul");
			return response;
		}
		Optional<Participation> pId = participationRepository.findById(id);
		if(!pId.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cette participation n'existe pas");
			return response;
			
		}
	   participationRepository.deleteById(id);
	   response.setCode(ExceptionApi.succes);
	   response.setMessage("Suppression effectuée avec succes");
		return response;
	}
	
	@Override
	public List<ParticipationDto> listepDto() {
		List<Participation> listep = participationRepository.findAll();
		List<ParticipationDto> listepDto = new ArrayList<>();
		listep.forEach(val->{ 
		listepDto.add(MapperDto.toParticipation(val));
	});
		return listepDto;
}
	@Override
	public ParticipationDto getById(int id) {
		ParticipationDto response = new ParticipationDto();
		if(id==0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("l'id ne pas etre nul");
			return response;
			}
		Optional<Participation> pId = participationRepository.findById(id);
		if(!pId.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cette participation n'existe pas");
			return response;
		}
		Optional<Participation> p = participationRepository.findById(id);
		return MapperDto.toParticipation(p.get());
	}
}