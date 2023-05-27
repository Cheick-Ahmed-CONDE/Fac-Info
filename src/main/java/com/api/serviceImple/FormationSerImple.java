package com.api.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.EnseignantDto;
import com.api.dto.FormationDto;
import com.api.exception.ExceptionApi;
import com.api.mapperDto.MapperDto;
import com.api.model.Enseignant;
import com.api.model.Formation;
import com.api.repository.EnseignantRepository;
import com.api.repository.FormationRepository;
import com.api.service.FormationService;

@Service
public class FormationSerImple implements FormationService{
	
	@Autowired EnseignantRepository enseignantRepository;
	
	@Autowired FormationRepository formationRepository;

	/************************************************************
	 * ******************Ajout de la formation********************
	 */
	
	@Override
	public FormationDto add(FormationDto formationDto) {
		FormationDto response = new FormationDto();
		if(formationDto == null) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez reisengner les champs");
			return response;
		}
		Optional<Enseignant> enseignantOptional = enseignantRepository.findById(formationDto.getId_enseignant());
		if(!enseignantOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cet enseignant n'exist pas");
			return response;
		}
		Formation formation = MapperDto.toFormationDto(formationDto, enseignantOptional.get());
		Formation formationSave = formationRepository.save(formation);
		response = MapperDto.toFormation(formationSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Enregistrement effectué avec succes");
		return response;
	}
	
	/********************************************************************
	 * ******************Modification de la formation********************
	 */
	
	@Override
	public FormationDto update(FormationDto formationDto, int id) {
		FormationDto response = new FormationDto();
		if(formationDto == null || id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez reinseigner les champs");
			return response;	
		}
		if(!formationRepository.findById(id).isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cette Formation n'exist pas");
			return response;
		}
		Optional<Enseignant> enseignantOptional = enseignantRepository.findById(formationDto.getId_enseignant());
		if(!enseignantOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cet enseignant n'exist pas");
			return response;
		}
		formationDto.setId(id);
		Formation formation = MapperDto.toFormationDto(formationDto, enseignantOptional.get());
		Formation formationSave = formationRepository.save(formation);
		response = MapperDto.toFormation(formationSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Modification effectuée avec succes");
		return response;
	}
	
	/********************************************************************
	 * ******************Suppression de la formation*********************
	 */
	
	@Override
	public FormationDto supprimer(int id) {
		FormationDto response = new FormationDto();
		if(id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne doit pas etre nul");
			return response;
		}
		Optional<Formation> formationOptional = formationRepository.findById(id);
		if(!formationOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cette formation n'exixts pas");
			return response;
		}
		formationRepository.deleteById(id);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Suppresion effectué avec succes");
		return response;
	}
	
	/******************************************************************************
	 * ******************Recuperation de la liste de formation*********************
	 */
	
	@Override
	public List<FormationDto> listeFormation(){
		List<Formation> listeFormation = formationRepository.findAll();
		List<FormationDto> listeFormationDto = new ArrayList<>();
		listeFormation.forEach(val->{
			listeFormationDto.add(MapperDto.toFormation(val));
		});
		return listeFormationDto;
	}
	
	/****************************************************************************
	 * ******************Recuperation par Id de la formation*********************
	 */
	
	@Override
	public FormationDto getById(int id) {
		Optional<Formation> formation = formationRepository.findById(id);
		return MapperDto.toFormation(formation.get());
	}
}
