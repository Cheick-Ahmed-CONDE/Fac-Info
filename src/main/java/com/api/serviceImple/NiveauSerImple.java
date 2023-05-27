package com.api.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.NiveauDto;
import com.api.exception.ExceptionApi;
import com.api.mapperDto.MapperDto;
import com.api.model.Niveau;
import com.api.repository.NiveauRepository;
import com.api.service.NiveauService;

@Service
public class NiveauSerImple implements NiveauService{
	
	@Autowired
	private NiveauRepository niveauRepository;

	@Override
	public NiveauDto add(NiveauDto niveauDto) {
		NiveauDto response = new NiveauDto();
		if(niveauDto == null) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillew reinseigner les champs");
			return response;
		}
		Niveau niveau = MapperDto.toNiveauDto(niveauDto);
		Niveau niveauSave = niveauRepository.save(niveau);
		response = MapperDto.toNiveau(niveauSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Enregistrement effectué avec succes");
		return response;
	}
	
	@Override
	public NiveauDto update(NiveauDto niveauDto, int id) {
		NiveauDto response = new NiveauDto();
		if(niveauDto == null || id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez reinseigner les champs");
			return response;
		}
		Optional<Niveau> niveauOptional = niveauRepository.findById(id);
		if(!niveauOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Ce niveau n'existe pas");
			return response;
		}
		niveauDto.setId_Niveau(id);
		Niveau niveau = MapperDto.toNiveauDto(niveauDto);
		Niveau niveauSave = niveauRepository.save(niveau);
		response = MapperDto.toNiveau(niveauSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Modification effectué avec succes");
		return response;
	}
	
	@Override
	public NiveauDto supprimer(int id) {
		NiveauDto response = new NiveauDto();
		if(id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne doit pas etre nul");
			return response;
		}
		Optional<Niveau> niveauOptional = niveauRepository.findById(id);
		if(!niveauOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Ce niveau n'existe pas");
			return response;
		}
		niveauRepository.deleteById(id);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Suppresion effectuée avec succes");
		return response;
	}
	
	@Override
	public List<NiveauDto> listeNiveau(){
		List<Niveau> listeNiveau = niveauRepository.findAll();
		List<NiveauDto> listeNiveauDto = new ArrayList<>();
		listeNiveau.forEach(val->{
			listeNiveauDto.add(MapperDto.toNiveau(val));
		});
		return listeNiveauDto;
	}
	
	@Override
	public NiveauDto getById(int id) {
		NiveauDto response = new NiveauDto();
		if(id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne doit pas etre nul");
			return response;
		}
		Optional<Niveau> niveauOptional = niveauRepository.findById(id);
		if(!niveauOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Ce niveau n'existe pas");
			return response;
		}
		return MapperDto.toNiveau(niveauOptional.get());
	}
}
