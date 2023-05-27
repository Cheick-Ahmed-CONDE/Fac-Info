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
import com.api.model.Etudiant;
import com.api.model.Evenement;
import com.api.repository.EtudiantRepository;
import com.api.service.EtudiantService;

@Service
public class EtudiantSerImple implements EtudiantService{
	
	@Autowired
	private EtudiantRepository etudiantRepository;

	/************************************************************
	 * ******************Ajout d'un etudiant********************
	 */
	
	@Override
	public EtudiantDto add(EtudiantDto etudiantDto) {
		EtudiantDto response = new EtudiantDto();
		if (etudiantDto == null) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez reinseigner les champs");
			return response;
		}
		if (etudiantRepository.existsByMatricule(etudiantDto.getMatricule())) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Ce matricule exist deja");
			return response;
		}
		if (etudiantRepository.existsByTelephone(etudiantDto.getTelephone())) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Ce numero de telephone exist deja");
			return response;
		}
		Etudiant etudiant = MapperDto.toEtudiantDto(etudiantDto);
		Etudiant etudiantSave = etudiantRepository.save(etudiant);
		response=MapperDto.toEtudiant(etudiantSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Enregistrement effectuer avec success");
		return response;
	}
	
	/*******************************************************************
	 * ******************Modification de l'etudiant*********************
	 */
	
	@Override
	public EtudiantDto update(EtudiantDto etudiantDto, int id) {
		EtudiantDto response = new EtudiantDto();
		if (etudiantDto == null || id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez reinseigner les champs");
			return response;
		}
		
		Optional<Etudiant> etudiantOptional = etudiantRepository.findById(id);
		if(!etudiantOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cet etudiant n'exist pas");
			return response;
		}
		etudiantDto.setId(id);
		Etudiant etudiant = MapperDto.toEtudiantDto(etudiantDto);
		Etudiant etudiantSave = etudiantRepository.save(etudiant);
		response=MapperDto.toEtudiant(etudiantSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("La modification à été effectuée avec success");
		return response;
	}
	
	/***************************************************************
	 * ********************Supprimer l'etudiant********************
	 */
	
	@Override
	public EtudiantDto supprimer(int id) {
		EtudiantDto response = new EtudiantDto();
		System.err.println("**************************"+id);
		if (id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'Id ne peut pas etre nul");
			return response;
		}
		Optional<Etudiant> etudiantOptional = etudiantRepository.findById(id);
		if (!etudiantOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cet etudiant n'exist pas");
			return response;
		}
		
		etudiantRepository.deleteById(id);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Suppression effectuée avec success");
		return response;
	}
	
	/******************************************************************************
	 * ******************Recuperation de la liste des etudiants********************
	 */
	
	@Override
	public List<EtudiantDto> listeEtudiant(){
		List<Etudiant> listeEtudiant = etudiantRepository.findAll();
		List<EtudiantDto> listeEtudiantDto = new ArrayList<>(); 
		listeEtudiant.forEach(val->{
			listeEtudiantDto.add(MapperDto.toEtudiant(val));
		});
		return listeEtudiantDto;
	}
	
	/**************************************************************************
	 * ******************Recuperation par Id de l'evenement********************
	 */
	
	@Override
	public EtudiantDto getByIdEtudiant(int id) {
		EtudiantDto response = new EtudiantDto();
		if(id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne doit pas etre nul");
			return response;
		}
		Optional<Etudiant> etudiantOptional = etudiantRepository.findById(id);
		if(!etudiantOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cet etudiant exist pas");
			return response;
		}
		Optional<Etudiant> etudiant = etudiantRepository.findById(id);
		return MapperDto.toEtudiant(etudiant.get());
	}
}
