
package com.api.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.EnseignantDto;
import com.api.dto.EtudiantDto;
import com.api.exception.ExceptionApi;
import com.api.mapperDto.MapperDto;
import com.api.model.Enseignant;
import com.api.model.Etudiant;
import com.api.repository.EnseignantRepository;
import com.api.service.EnseignantService;

@Service
public class EnseignantSerImple implements EnseignantService{
	
	@Autowired
	private EnseignantRepository enseignantRepository;
	
	/************************************************************
	 * ******************Ajout de l'eseignant********************
	 */
	@Override
	public EnseignantDto add(EnseignantDto enseignantDto) {
		EnseignantDto response = new EnseignantDto();
		if(enseignantDto == null) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez renseigner les champs");
		}
		if(enseignantRepository.existsByTelephone(enseignantDto.getTelephone())) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Ce numero de telephone exist deja");
		}
		if(enseignantRepository.existsByEmail(enseignantDto.getEmail())) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cet email exist deja");
		}
		
		Enseignant enseignant = new Enseignant();
		Enseignant enseignantSave = enseignantRepository.save(enseignant);
		response = MapperDto.toEnseignant(enseignantSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("L'enregistrement effectué avec succes");
		return response;	
	}
	
	/************************************************* *******************
	 * ******************Modification de L'enseignant********************
	 */

	@Override
	public EnseignantDto update(EnseignantDto enseignantDto, int id) {
		EnseignantDto response = new EnseignantDto();
		if(enseignantDto == null || id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez renseigner les champs");
		}
		Optional<Enseignant> enseignantOptional = enseignantRepository.findById(id);
		if(!enseignantOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cet enseignant exist deja");
		}
		enseignantDto.setId_enseignant(id);
		Enseignant enseignant = new Enseignant();
		Enseignant enseignantSave = enseignantRepository.save(enseignant);
		response = MapperDto.toEnseignant(enseignantSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Modification effectuer avec succes");
		return response;
	}
	
	/*******************************************************************
	 * ******************Suppresssion de l'enseignant*******************
	 */
	@Override
	public EnseignantDto supprimer(int id) {
		EnseignantDto response = new EnseignantDto();
		if(id == 0 ) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne peut pas etre nul");
		}
		if(enseignantRepository.existsById(id)) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cet enseignant n'exist pas");
		}
		enseignantRepository.deleteById(id);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Suppression effectuer avec succes");
		return response;
	}
	
	/********************************************************************************
	 * ******************Recuperation de la liste des enseignants********************
	 */
	
	@Override
	public List<EnseignantDto> listeEnseignant(){
		List<Enseignant> listeEnseignant = enseignantRepository.findAll();
		List<EnseignantDto> listeEnseignantDto = new ArrayList<>();
		listeEnseignant.forEach(val->{
			listeEnseignantDto.add(MapperDto.toEnseignant(val)); 
		});
		return listeEnseignant();
	}
	
	/***************************************************************************
	 * ******************Recuperation d'un enseignant par Id********************
	 */
	
	@Override
	public EnseignantDto getByIdEnseignant(int id) {
		EnseignantDto response = new EnseignantDto();
		if(id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne doit pas etre nul");
			return response;
		}
		Optional<Enseignant> enseignantOptional = enseignantRepository.findById(id);
		if(!enseignantOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cet enseignant exist pas");
			return response;
		}
		Optional<Enseignant> enseignant = enseignantRepository.findById(id);
		return MapperDto.toEnseignant(enseignant.get());
	}
}
