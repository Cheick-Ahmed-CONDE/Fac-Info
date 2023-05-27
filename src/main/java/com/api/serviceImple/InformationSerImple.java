package com.api.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.InformationDto;
import com.api.exception.ExceptionApi;
import com.api.mapperDto.MapperDto;
import com.api.model.Information;
import com.api.repository.InformationRepository;
import com.api.service.InformationService;

@Service
public class InformationSerImple implements InformationService{
	
	@Autowired
	private InformationRepository informationRepository;

	@Override
	public InformationDto add(InformationDto informationDto) {
		InformationDto response = new InformationDto();
		if(informationDto == null) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez reisengner les champs");
			return response;
		}
	    Information information = MapperDto.toInformationDto(informationDto);
	    Information informationSave = informationRepository.save(information);
	    response = MapperDto.toInformation(informationSave);
	    response.setCode(ExceptionApi.succes);
	    response.setMessage("Enregistrement effectué avec succes");
		return response;
	}
	
	@Override
	public InformationDto update(InformationDto informationDto, int id) {
		InformationDto response = new InformationDto();
		if(informationDto == null || id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez reisengner les champs");
			return response;
		}
		Optional<Information> informationOptional = informationRepository.findById(id);
		if(!informationOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cette information n'exist pas");
			return response;
		}
		informationDto.setId(id);
		Information information = MapperDto.toInformationDto(informationDto);
	    Information informationSave = informationRepository.save(information);
	    response = MapperDto.toInformation(informationSave);
	    response.setCode(ExceptionApi.succes);
	    response.setMessage("Modification effectué avec succes");
		return response;
	}
	
	@Override
	public InformationDto supprimer(int id) {
		InformationDto response = new InformationDto();
		if(id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne pas etre nul");
			return response;
		}
		Optional<Information> informationOptional = informationRepository.findById(id);
		if(!informationOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cette information n'exist pas");
			return response;
		}
		informationRepository.deleteById(id);
		response.setCode(ExceptionApi.succes);
	    response.setMessage("Suppresion effectué avec succes");
		return response;
	}
	
	@Override
	public List<InformationDto> listeInformation(){
		List<Information> listeInformation = informationRepository.findAll();
		List<InformationDto> listeInformationDto = new ArrayList<>();
		listeInformation.forEach(val->{
			listeInformationDto.add(MapperDto.toInformation(val));
		});
		return listeInformationDto;
	}
	
	@Override
	public InformationDto getById(int id) {
		Optional<Information> informationOptional = informationRepository.findById(id);
		return MapperDto.toInformation(informationOptional.get());
	}
}
