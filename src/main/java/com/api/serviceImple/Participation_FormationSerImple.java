package com.api.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.Participation_FormationDto;
import com.api.exception.ExceptionApi;
import com.api.mapperDto.MapperDto;
import com.api.model.Formation;
import com.api.model.Niveau;
import com.api.model.Participation_Formation;
import com.api.repository.FormationRepository;
import com.api.repository.NiveauRepository;
import com.api.repository.Participation_FormationRepository;
import com.api.service.Participation_FormationService;

@Service
public class Participation_FormationSerImple implements Participation_FormationService{
	
	@Autowired
	private FormationRepository formationRepository;
	
	@Autowired
	private NiveauRepository niveauRepository;
	
	@Autowired
	private Participation_FormationRepository pfRepository;
	
	@Override
	public Participation_FormationDto add(Participation_FormationDto pfDto) {
		Participation_FormationDto response = new Participation_FormationDto();
		if (pfDto == null) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez reinseigner les champs");
			return response;
		}
		Optional<Formation> formation = formationRepository.findById(pfDto.getId_formation());
		if(!formation.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cette formation n'exist pas");
			return response;
		}
		Optional<Niveau> niveau = niveauRepository.findById(pfDto.getId_niveau());
		if(!niveau.isPresent()){
			response.setCode(ExceptionApi.error);
			response.setMessage("Ce niveau n'exist pas");
			return response;
		}
		Participation_Formation pf = MapperDto.toParticipation_FormationDto(pfDto, formation.get(), niveau.get());
		Participation_Formation pfSave = pfRepository.save(pf);
		response = MapperDto.toParticipation_Formation(pfSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Enregistrement effectué avec succes");
		return response;
	}

	@Override
	public Participation_FormationDto update(Participation_FormationDto pfDto, int id) {
		Participation_FormationDto response = new Participation_FormationDto();
		if(pfDto == null || id ==0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez reinseigner les champs");
			return response;
		}
		Optional<Participation_Formation> pfId = pfRepository.findById(id);
		if(!pfId.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cette participation formation n'exist pas");
			return response;
		}
		Optional<Formation> formation = formationRepository.findById(pfDto.getId_formation());
		if(!formation.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cette formation n'exist pas");
			return response;
		}
		Optional<Niveau> niveau = niveauRepository.findById(pfDto.getId_niveau());
		if(!niveau.isPresent()){
			response.setCode(ExceptionApi.error);
			response.setMessage("Ce niveau n'exist pas");
			return response;
		}
		pfDto.setId(id);
		Participation_Formation pf = MapperDto.toParticipation_FormationDto(pfDto, formation.get(), niveau.get());
		Participation_Formation pfSave = pfRepository.save(pf);
		response = MapperDto.toParticipation_Formation(pfSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Modification effectué avec succes");
		return response;
	}
	
	@Override 
	public Participation_FormationDto supprimer(int id) {
		Participation_FormationDto response = new Participation_FormationDto();
		if(id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne pas etre nul");
			return response;
		}
		Optional<Participation_Formation> pfId = pfRepository.findById(id);
		if(!pfId.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cette participation formation n'exist pas");
			return response;
		}
		pfRepository.deleteById(id);
		response.setCode(ExceptionApi.succes); 
		response.setMessage("Suppression effectué avec succes");
		return response;
	}
	
	@Override
	public List<Participation_FormationDto> listePfDto(){
		List<Participation_Formation> listePf = pfRepository.findAll();
		List<Participation_FormationDto> listePfDto = new ArrayList<>();
		listePf.forEach(val->{
			listePfDto.add(MapperDto.toParticipation_Formation(val));
		});
		return listePfDto;
	}
	
	@Override
	public Participation_FormationDto getById(int id) {
		Participation_FormationDto response = new Participation_FormationDto();
		if(id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne pas etre nul");
			return response;
		}
		Optional<Participation_Formation> pfId = pfRepository.findById(id);
		if(!pfId.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cette participation formation n'exist pas");
			return response;
		}
		Optional<Participation_Formation> pf = pfRepository.findById(id);
		return MapperDto.toParticipation_Formation(pf.get()); 
	}
}
