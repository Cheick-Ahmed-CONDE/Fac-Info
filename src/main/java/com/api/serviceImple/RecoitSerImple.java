package com.api.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.RecoitDto;
import com.api.exception.ExceptionApi;
import com.api.mapperDto.MapperDto;
import com.api.model.Information;
import com.api.model.Niveau;
import com.api.model.Recoit;
import com.api.repository.InformationRepository;
import com.api.repository.NiveauRepository;
import com.api.repository.RecoitRepository;
import com.api.service.RecoitService;



	@Service
	public class RecoitSerImple implements RecoitService{
	
	@Autowired
	private RecoitRepository recoitRepository;
	
	@Autowired 
	private NiveauRepository niveauRepository;
	
	@Autowired
	private InformationRepository informationRepository;
		 
	@Override
	public RecoitDto add (RecoitDto recoitDto) {
		RecoitDto response = new RecoitDto();
		if (recoitDto ==null) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez renseigner les champs");
			return response;
		}
		Optional<Niveau> niveau = niveauRepository.findById(recoitDto.getId_niveau()); 
		if (!niveau.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("le Niveau n'existe pas");
			return response;
		}
		Optional<Information> information = informationRepository.findById(recoitDto.getId_information());
		if(!information.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'information n'existe pas");
			return response;
		}
		Recoit recoit = MapperDto.toRecoitDto(recoitDto, niveau.get(), information.get());
		Recoit recoitSave = recoitRepository.save(recoit);
		response = MapperDto.toRecoit(recoitSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Enregistrement effectuée avec succes");
		return response;
	}
	
	@Override
	public RecoitDto update(RecoitDto recoitDto, int id) {
		RecoitDto response = new RecoitDto();
		if(recoitDto == null || id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez renseigner les champs");
			return response;
		}
		Optional<Niveau> niveau = niveauRepository.findById(recoitDto.getId_niveau()); 
		if (!niveau.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("le Niveau n'existe pas");
			return response;
		}
		Optional<Information> information = informationRepository.findById(recoitDto.getId_information());
		if(!information.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'information n'existe pas");
			return response;
		}
		recoitDto.setId(id);
		Recoit recoit = MapperDto.toRecoitDto(recoitDto, niveau.get(), information.get());
		Recoit recoitSave = recoitRepository.save(recoit);
		response = MapperDto.toRecoit(recoitSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Modification effectuée avec succes");
		return response;
	}
	
	@Override
	public RecoitDto supprimer(int id) {
		RecoitDto response = new RecoitDto();
		if(id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne doit pas etre nul");
			return response;
		}
		Optional<Recoit> recoit = recoitRepository.findById(id);
		if(!recoit.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Ce recoit n'exist pas");
			return response;
		}
		recoitRepository.deleteById(id);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Suppression effectuée avec success");
		return response;
	}
	
	@Override
	public List<RecoitDto> listeRDto(){
		List<Recoit> listRecoit = recoitRepository.findAll();
		List<RecoitDto> listeRecoiDto = new ArrayList<>();
		listRecoit.forEach(val->{
			listeRecoiDto.add(MapperDto.toRecoit(val));
		});
		return listeRecoiDto;
	}
	
	@Override
	public RecoitDto getById(int id) {
		RecoitDto response = new RecoitDto();
		if(id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne doit pas etre nul");
			return response;
		}
		Optional<Recoit> recoit = recoitRepository.findById(id);
		if(!recoit.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Ce recoit n'exist pas");
			return response;
		}
		Optional<Recoit> resoitGetById = recoitRepository.findById(id);
		return MapperDto.toRecoit(resoitGetById.get());
	}
}
