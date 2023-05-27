package com.api.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.EtudiantDto;
import com.api.dto.EvenementDto;
import com.api.exception.ExceptionApi;
import com.api.mapperDto.MapperDto;
import com.api.model.Evenement;
import com.api.repository.EvenementRepository;
import com.api.service.EvenementService;

@Service
public class EvenementSerImple implements EvenementService{
	
	@Autowired
	private EvenementRepository evenementRepository;
	
	/************************************************************
	 * ******************Ajout d'un evenement********************
	 */
	@Override
	public EvenementDto add(EvenementDto evenementDto) {
		EvenementDto response = new EvenementDto();
		if(evenementDto == null) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez renseigner les Champs");
			return response;
		}
		/*Optional<Evenement> evenementOptional = evenementRepository.findById(evenementDto.getId());
		if(evenementOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cet etudiant exist deja");
			return response;
		}
		*/
		Evenement evenement = MapperDto.toEvenementDto(evenementDto);
		Evenement evenementSave = evenementRepository.save(evenement);
		response = MapperDto.toEvenement(evenementSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Enregistrement effectué avec succes");
		return response;		
	}
	
	/********************************************************************
	 * ******************Modification de l'evenement*********************
	 */
	
	@Override
	public EvenementDto update(EvenementDto evenementDto, int id){
		EvenementDto response = new EvenementDto();
		if(evenementDto == null || id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez renseigner les champs!");
			return response;
		}
		Optional<Evenement> evenementOptional = evenementRepository.findById(id);
		if(!evenementOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cet etudiant n'a pas été trouver");
			return response;
		}
		
		evenementDto.setId(id);
		Evenement evenement = MapperDto.toEvenementDto(evenementDto);
		Evenement evenementSave = evenementRepository.save(evenement);
		response = MapperDto.toEvenement(evenementSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Modification effectué avec succes");
		return response;
	}
	
	/***************************************************************
	 * ********************Supprimer l'evenement********************
	 */
	
	@Override
	public EvenementDto supprimer(int id) {
		System.err.println("********************"+id);
		EvenementDto response = new EvenementDto();
		if (id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'Id ne peut pas etre nul");
			return response;
		}
		Optional<Evenement> evenementOptional = evenementRepository.findById(id);
		if(!evenementOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cet evenement exist pas");
			return response;
		}
		evenementRepository.deleteById(id);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Suppression effectuée avec succes");
		return response;
	}
	
	/*******************************************************************************
	 * ******************Recuperation de la liste des evenements********************
	 */
	
	@Override
	public List<EvenementDto> listeEvenement(){
		List<Evenement> listeEvenement = evenementRepository.findAll();
		List<EvenementDto> listeEvenementDto = new ArrayList<>();
		listeEvenement.forEach(val->{
			listeEvenementDto.add(MapperDto.toEvenement(val));
		});
		return listeEvenementDto;
	}
	
	/**************************************************************************
	 * ******************Recuperation par Id de l'evenement********************
	 */
	
	@Override
	public EvenementDto getById(int id) {
		EvenementDto response = new EvenementDto();
		if(id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne doit pas etre nul");
			return response;
		}
		Optional<Evenement> evenementOptional = evenementRepository.findById(id);
		if(!evenementOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cet evenement exist pas");
			return response;
		}
		Optional<Evenement> evenement = evenementRepository.findById(id);
		return MapperDto.toEvenement(evenement.get());
	}
}
