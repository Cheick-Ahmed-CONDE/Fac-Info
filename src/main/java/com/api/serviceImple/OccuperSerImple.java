package com.api.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.OccuperDto;
import com.api.exception.ExceptionApi;
import com.api.mapperDto.MapperDto;
import com.api.model.Niveau;
import com.api.model.Occuper;
import com.api.model.Salle;
import com.api.repository.NiveauRepository;
import com.api.repository.OccuperRepository;
import com.api.repository.SalleRepository;
import com.api.service.OccuperService;

@Service
public class OccuperSerImple implements OccuperService{
	
	@Autowired
	private OccuperRepository occuperRepository;

	@Autowired
	private SalleRepository sallerepository;
	
	@Autowired
	private NiveauRepository niveauRepository;
	
	@Override
	public OccuperDto add(OccuperDto occuperDto) {
		OccuperDto response = new OccuperDto();
		if(occuperDto == null) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez reiseigner les champs");
			return response;
		}
		Optional<Salle> salleOptional = sallerepository.findById(occuperDto.getId_salle());
		if(!salleOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cette salle n'existe pas");
			return response;
		}
		Optional<Niveau> niveauOptional = niveauRepository.findById(occuperDto.getId_niveau());
		if(!niveauOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Ce niveau n'existe pas");
			return response;
		}
		Occuper occuper = MapperDto.toOcupperDto(occuperDto, niveauOptional.get(), salleOptional.get());
		Occuper occuperSave = occuperRepository.save(occuper);
		response = MapperDto.toOccuper(occuperSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Enregistrement effectué avec succes");
		return response;
	}
	
	@Override
	public OccuperDto update(OccuperDto occuperDto, int id) {
		OccuperDto response = new OccuperDto();
		if(occuperDto == null || id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez reinseigner les champs");
			return response;
		}
		Optional<Occuper> occuperOptional = occuperRepository.findById(id);
		if(!occuperOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id n'existe pas");
			return response;
		}
		Optional<Niveau> niveauOptional = niveauRepository.findById(occuperDto.getId_niveau());
		if(!niveauOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Ce niveau n'existe pas");
			return response;
		}
		Optional<Salle> salleOptional = sallerepository.findById(occuperDto.getId_salle());
		if(!salleOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cette salle n'existe pas");
			return response;
		}
		occuperDto.setId(id);
		Occuper occuper = MapperDto.toOcupperDto(occuperDto, niveauOptional.get(), salleOptional.get());
		Occuper occuperSave = occuperRepository.save(occuper);
		response = MapperDto.toOccuper(occuperSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Modification effectué avec succes");
		return response;
	}
	
	@Override
	public OccuperDto supprimer(int id) {
		OccuperDto response = new OccuperDto();
		if(id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne doit pas etre nul");
			return response;
		}
		Optional<Occuper> occuperOptional = occuperRepository.findById(id);
		if(!occuperOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'occupation n'existe pas");
			return response;
		}
		occuperRepository.deleteById(id);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Suppression effectuée avec succes");
		return response;
	}
	
	@Override
	public List<OccuperDto> listeOccuper(){
		List<Occuper> listeOccuper = occuperRepository.findAll();
		List<OccuperDto> listeOccuperDto = new ArrayList<>();
		listeOccuper.forEach(val->{
			listeOccuperDto.add(MapperDto.toOccuper(val));
		});
		return listeOccuperDto;
	}
	
	@Override
	public OccuperDto getById(int id) {
		OccuperDto response = new OccuperDto();
		if(id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne doit pas etre nul");
			return response;
		}
		Optional<Occuper> occuperOptional = occuperRepository.findById(id);
		if(!occuperOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'occupation n'existe pas");
			return response;
		}
		Optional<Occuper> occuper = occuperRepository.findById(id);
		return MapperDto.toOccuper(occuper.get());
	}
}
