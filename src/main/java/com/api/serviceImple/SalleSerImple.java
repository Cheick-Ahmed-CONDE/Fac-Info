package com.api.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.SalleDto;
import com.api.exception.ExceptionApi;
import com.api.mapperDto.MapperDto;
import com.api.model.Salle;
import com.api.repository.SalleRepository;
import com.api.service.SalleService;

@Service
public class SalleSerImple implements SalleService{
	
	@Autowired
	private SalleRepository salleRepository;
	
	@Override
	public SalleDto add(SalleDto salleDto) {
		SalleDto response = new SalleDto();
		if(salleDto == null) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez reiseingner les champs");
			return response;
		}
		if(salleDto.getNumSalle()==null) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez saisir un numero de salle");
			return response;
		}
		if(salleRepository.existsByNumSalle(salleDto.getNumSalle()))
		{
			response.setCode(ExceptionApi.error);
			response.setMessage("Ce numero de classe exist deja");
			return response;
		}
		
		Salle salle = MapperDto.toSalleDto(salleDto);
		Salle salleSave = salleRepository.save(salle);
		response = MapperDto.toSalle(salleSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Enregistrement effectué avec succes");
		return response;
	}

	@Override
	public SalleDto update(SalleDto salleDto, int id) {
		SalleDto response = new SalleDto();
		if(salleDto == null || id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez reiseingner les champs");
			return response;
		}
		Optional<Salle> salleOptional = salleRepository.findById(id);
		if(!salleOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cette salle n'exist pas");
			return response;
		}
		salleDto.setId(id);
		Salle salle = MapperDto.toSalleDto(salleDto);
		Salle salleSave = salleRepository.save(salle);
		response = MapperDto.toSalle(salleSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Modification effectué avec succes");
		return response;
	}
	
	@Override
	public SalleDto supprimer(int id) {
		SalleDto response = new SalleDto();
		if(id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne doit pas etre nul");
			return response;
		}
		Optional<Salle> salleOptional = salleRepository.findById(id);
		if(!salleOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cette salle n'exist pas");
			return response;
		}
		salleRepository.deleteById(id);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Suppression effectué avec succes");
		return response;
	}
	
	@Override
	public List<SalleDto> listeSalle(){
		List<Salle> listeSalle = salleRepository.findAll();
		List<SalleDto> listeSalleDto = new ArrayList<>();
		listeSalle.forEach(val->{
			listeSalleDto.add(MapperDto.toSalle(val));
		});
		return listeSalleDto;
	}
	
	@Override
	public SalleDto getById(int id) {
		SalleDto response = new SalleDto();
		if(id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne doit pas etre nul");
			return response;
		}
		Optional<Salle> salleOptional = salleRepository.findById(id);
		if(!salleOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cette salle n'exist pas");
			return response;
		}
		Optional<Salle> salle = salleRepository.findById(id);
		return MapperDto.toSalle(salle.get());
	}
}
