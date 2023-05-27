package com.api.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.InscrireDto;
import com.api.exception.ExceptionApi;
import com.api.mapperDto.MapperDto;
import com.api.model.Etudiant;
import com.api.model.Inscrire;
import com.api.model.Niveau;
import com.api.repository.EtudiantRepository;
import com.api.repository.InscrireRepository;
import com.api.repository.NiveauRepository;
import com.api.service.InscrireSer;

@Service
public class InscrireSerImple implements InscrireSer{
	
	@Autowired
	private InscrireRepository inscrireRepository;
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private NiveauRepository niveauRepository;
	
	@Override
	public InscrireDto add(InscrireDto inscrireDto) {
		InscrireDto response = new InscrireDto();
		if(inscrireDto == null) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez reinseigner le champ");
		}
		/*Optional<Inscrire> inscrireOptional = inscrireRepository.findById(inscrireDto.getId());
		if(!inscrireOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cette inscription ");
			return response;
		}*/
		Optional<Etudiant> etudiantOptional = etudiantRepository.findById(inscrireDto.getId_etudiant());
		if(!etudiantOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Ce etudiant n'existe deja");
			return response;
		}
		Optional<Niveau> niveauOptional = niveauRepository.findById(inscrireDto.getId_niveau());
		if(!niveauOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Ce niveau est n'exist pas");
			return response;
		}
		Inscrire inscrire = MapperDto.toInscrireDto(inscrireDto, etudiantOptional.get(), niveauOptional.get());
		Inscrire inscrireSave = inscrireRepository.save(inscrire);
		response = MapperDto.toInscrire(inscrireSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Inscription reussi");
		return response;
	}

	@Override
	public InscrireDto update(InscrireDto inscrireDto, int id) {
		InscrireDto response = new InscrireDto();
		if(inscrireDto == null || id ==0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Veuillez reinseigner les champs");
			return response;
		}
		if(id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne peut pas nul");
			return response;
		}
		
		Optional<Etudiant> etudiantOptional = etudiantRepository.findById(inscrireDto.getId_etudiant());
		if(!etudiantOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cet etudiant n'existe pas");
			return response;
		}
		Optional<Niveau> niveauOptional = niveauRepository.findById(inscrireDto.getId_niveau());
		if(!niveauOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Ce niveau n'existe pas");
			return response;
		}
		
		inscrireDto.setId(id);
		Inscrire inscrire = MapperDto.toInscrireDto(inscrireDto, etudiantOptional.get(), niveauOptional.get());
		Inscrire inscrireSave = inscrireRepository.save(inscrire);
		response = MapperDto.toInscrire(inscrireSave);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Modification effectuée avec reussi");
		return response;	
	}
	
	@Override
	public InscrireDto supprimer(int id) {
		InscrireDto response = new InscrireDto();
		if(id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne doit pas etre nul");
			return response;
		}
		Optional<Inscrire> inscrireOptional = inscrireRepository.findById(id);
		if(!inscrireOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cette inscription n'existe pas");
			return response;
		}
		inscrireRepository.deleteById(id);
		response.setCode(ExceptionApi.succes);
		response.setMessage("Suppression effectuée avec succes");
		return response;
	}
	
	@Override
	public List<InscrireDto> listeInscrire(){
		List<Inscrire> inscrire = inscrireRepository.findAll();
		List<InscrireDto> inscrireDto = new ArrayList<>();
		inscrire.forEach(val->{
			inscrireDto.add(MapperDto.toInscrire(val));
		});
		return inscrireDto;
	}
	
	@Override
	public InscrireDto getById(int id) {
		InscrireDto response = new InscrireDto();
		if(id == 0) {
			response.setCode(ExceptionApi.error);
			response.setMessage("L'id ne doit pas etre nul");
			return response;
		}
		Optional<Inscrire> inscrireOptional = inscrireRepository.findById(id);
		if(!inscrireOptional.isPresent()) {
			response.setCode(ExceptionApi.error);
			response.setMessage("Cette inscription n'existe pas");
			return response;
		}
		Optional<Inscrire> inscrire = inscrireRepository.findById(id);
		return MapperDto.toInscrire(inscrire.get());
	}
}