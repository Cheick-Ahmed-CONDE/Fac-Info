package com.api.mapperDto;

import com.api.dto.EnseignantDto;
import com.api.dto.EtudiantDto;
import com.api.dto.EvenementDto;
import com.api.dto.FormationDto;
import com.api.dto.InformationDto;
import com.api.dto.InscrireDto;
import com.api.dto.NiveauDto;
import com.api.dto.OccuperDto;
import com.api.dto.ParticipationDto;
import com.api.dto.Participation_FormationDto;
import com.api.dto.RecoitDto;
import com.api.dto.SalleDto;
import com.api.model.Enseignant;
import com.api.model.Etudiant;
import com.api.model.Evenement;
import com.api.model.Formation;
import com.api.model.Information;
import com.api.model.Inscrire;
import com.api.model.Niveau;
import com.api.model.Occuper;
import com.api.model.Participation;
import com.api.model.Participation_Formation;
import com.api.model.Recoit;
import com.api.model.Salle;

public class MapperDto {
	
	
	/**************************************************
	 * ******************Enseignant********************
	 */
	public static Enseignant toEnseignantDto(EnseignantDto enseignantDto) {
		Enseignant enseignant = new Enseignant();
		enseignant.setId_enseignant(enseignantDto.getId_enseignant());
		enseignant.setNom(enseignantDto.getNom());
		enseignant.setPrenom(enseignantDto.getPrenom());
		enseignant.setTelephone(enseignantDto.getTelephone());
		enseignant.setEmail(enseignantDto.getEmail());
		enseignant.setFormation_donner(enseignantDto.getFormation_donner());
		enseignant.setType_enseignant(enseignantDto.getType_enseignant());
		return enseignant;
	}
	public static EnseignantDto toEnseignant(Enseignant enseignant) {
		EnseignantDto enseignantDto = new EnseignantDto();
		enseignantDto.setId_enseignant(enseignant.getId_enseignant());
		enseignantDto.setNom(enseignant.getNom());
		enseignantDto.setPrenom(enseignant.getPrenom());
		enseignantDto.setTelephone(enseignant.getTelephone());
		enseignantDto.setEmail(enseignant.getEmail());
		enseignantDto.setFormation_donner(enseignant.getFormation_donner());
		enseignantDto.setType_enseignant(enseignant.getType_enseignant());
		return enseignantDto;
	}
	
	/************************************************
	 * ******************Etudiant********************
	 */
	 
	public static Etudiant toEtudiantDto(EtudiantDto etudiantDto){
		Etudiant etudiant = new Etudiant();
		etudiant.setId(etudiantDto.getId());
		etudiant.setNom(etudiantDto.getNom());
		etudiant.setPrenom(etudiantDto.getPrenom());
		etudiant.setTelephone(etudiantDto.getTelephone());
		etudiant.setEmail(etudiantDto.getEmail());
		etudiant.setDepartement(etudiantDto.getDepartement());
		etudiant.setFaculte(etudiantDto.getFaculte());
		etudiant.setMatricule(etudiantDto.getMatricule());
		etudiant.setPhoto(etudiantDto.getPhoto());
		return etudiant;		
	}
	public static EtudiantDto toEtudiant(Etudiant etudiant) {
		EtudiantDto etudiantDto = new EtudiantDto();
		etudiantDto.setId(etudiant.getId());
		etudiantDto.setNom(etudiant.getNom());
		etudiantDto.setPrenom(etudiant.getPrenom());
		etudiantDto.setTelephone(etudiant.getTelephone());
		etudiantDto.setEmail(etudiant.getEmail());
		etudiantDto.setDepartement(etudiant.getDepartement());
		etudiantDto.setFaculte(etudiant.getFaculte());
		etudiantDto.setMatricule(etudiant.getMatricule());
		etudiantDto.setPhoto(etudiant.getPhoto());
		return etudiantDto;
	}
	
	/*************************************************
	 * ******************Evenement********************
	 */
	public static Evenement toEvenementDto(EvenementDto evenementDto) {
		Evenement evenement = new Evenement();
		evenement.setId(evenementDto.getId());
		evenement.setType_evenement(evenementDto.getType_evenement());
		evenement.setDescription(evenementDto.getDescription());
		evenement.setDate_debut(evenementDto.getDate_debut());
		evenement.setDate_fin(evenementDto.getDate_fin());
		return evenement;
	}
	public static EvenementDto toEvenement(Evenement evenement) {
		EvenementDto evenementDto = new EvenementDto();
		evenementDto.setId(evenement.getId());
		evenementDto.setType_evenement(evenement.getType_evenement());
		evenementDto.setDescription(evenement.getDescription());
		evenementDto.setDate_debut(evenement.getDate_debut());
		evenementDto.setDate_fin(evenement.getDate_fin());
		return evenementDto;
	}
	/*************************************************
	 * ******************Formation********************
	 */
	
	public static Formation toFormationDto(FormationDto formationDto,Enseignant enseignant) {
		Formation formation = new Formation();
		formation.setId(formationDto.getId());
		formation.setType_formation(formationDto.getType_formation());
		formation.setDescription(formationDto.getDescription());
		formation.setDate_debut(formationDto.getDate_debut());
		formation.setDate_fin(formationDto.getDate_fin());
		formation.setEnseignant(enseignant);
		return formation; 
	}
	public static FormationDto toFormation(Formation formation) {
		FormationDto formationDto = new FormationDto();
		formationDto.setId(formation.getId());
		formationDto.setType_formation(formation.getType_formation());
		formationDto.setDescription(formation.getDescription());
		formationDto.setDate_debut(formation.getDate_debut());
		formationDto.setDate_fin(formation.getDate_fin());
		formationDto.setId_enseignant(formation.getEnseignant().getId_enseignant());
		return formationDto;
	}
	/***************************************************
	 * ******************Information********************
	 */
	public static Information toInformationDto(InformationDto informationDto) {
		Information information = new Information();
		information.setId(informationDto.getId());
		information.setMotif(informationDto.getMotif());
		information.setDate_pub(informationDto.getDate_pub());
		return information;
	}
	public static InformationDto toInformation(Information information) {
		InformationDto informationDto = new InformationDto();
		informationDto.setId(information.getId());
		informationDto.setMotif(information.getMotif());
		informationDto.setDate_pub(information.getDate_pub());
		return informationDto;
	}
	/************************************************
	 * ******************Inscrire********************
	 */
	public static Inscrire toInscrireDto(InscrireDto inscrireDto, Etudiant etudiant, Niveau niveau) {
		Inscrire inscrire = new Inscrire();
		inscrire.setId(inscrireDto.getId());
		inscrire.setDate_inscription(inscrireDto.getDate_inscription());
		inscrire.setEtudiant(etudiant);
		inscrire.setNiveau(niveau);
		return inscrire;
	}
	public static InscrireDto toInscrire(Inscrire inscrire) {
		InscrireDto inscrireDto = new InscrireDto();
		inscrireDto.setId(inscrire.getId());
		inscrireDto.setDate_inscription(inscrire.getDate_inscription());
		inscrireDto.setId_etudiant(inscrire.getEtudiant().getId());
		inscrireDto.setId_niveau(inscrire.getNiveau().getId_Niveau());
		return inscrireDto;
	}
	/**********************************************
	 * ******************Niveau********************
	 */
	public static Niveau toNiveauDto(NiveauDto niveauDto) {
		Niveau niveau = new Niveau();
		niveau.setId_Niveau(niveauDto.getId_Niveau());
		niveau.setNiveau(niveauDto.getNiveau());
		return niveau;
	}
	public static NiveauDto toNiveau(Niveau niveau) {
		NiveauDto niveauDto = new NiveauDto();
		niveauDto.setId_Niveau(niveau.getId_Niveau());
		niveauDto.setNiveau(niveau.getNiveau());
		return niveauDto;
	}
	/***********************************************
	 * ******************Occuper********************
	 */
	public static Occuper toOcupperDto(OccuperDto occuperDto,Niveau niveau, Salle salle) {
		Occuper occuper = new Occuper();
		occuper.setId(occuperDto.getId());
		occuper.setDate_Occuper(occuperDto.getDate_Occuper());
		occuper.setNiveau(niveau);
		occuper.setSalle(salle);
		return occuper;
	}
	public static OccuperDto toOccuper(Occuper occuper) {
		OccuperDto occuperDto = new OccuperDto();
		occuperDto.setId(occuper.getId());
		occuperDto.setDate_Occuper(occuper.getDate_Occuper());
		occuperDto.setId_niveau(occuper.getNiveau().getId_Niveau());
		occuperDto.setId_salle(occuper.getSalle().getId());
		return occuperDto;
	}
	/***************************************************************
	 * ******************Participation_Formation********************
	 */
	public static Participation_Formation toParticipation_FormationDto(Participation_FormationDto pfDto,Formation formation, Niveau niveau) {
		Participation_Formation pf = new Participation_Formation();
		pf.setId(pfDto.getId());
		pf.setDate_acceptation(pfDto.getDate_acceptation());
		pf.setFormation(formation);
		pf.setNiveau(niveau);
		return pf;
	}
	public static Participation_FormationDto toParticipation_Formation(Participation_Formation pf) {
		Participation_FormationDto pfDto = new Participation_FormationDto();
		pfDto.setId(pf.getId());
		pfDto.setDate_acceptation(pf.getDate_acceptation());
		pfDto.setId_formation(pfDto.getId_formation());
		pfDto.setId_niveau(pfDto.getId_niveau());
		return pfDto;
	}
	/*****************************************************
	 * ******************Participation********************
	 */
	public static Participation toParticipationDto(ParticipationDto participationDto,Evenement evenement, Niveau niveau) {
		Participation participation = new Participation();
		participation.setId(participationDto.getId());
		participation.setEvenement(evenement);
		participation.setNiveau(niveau);
		return participation;
	}
	public static ParticipationDto toParticipation(Participation participation) {
		ParticipationDto participationDto = new ParticipationDto();
		participationDto.setId(participation.getId());
		participationDto.setId_evenement(participation.getEvenement().getId());
		participationDto.setId_niveau(participation.getNiveau().getId_Niveau());
		return participationDto;
	}
	/**********************************************
	 * ******************Recoit********************
	 */
	public static Recoit toRecoitDto(RecoitDto recoitDtio, Niveau niveau,Information information) {
		Recoit recoit = new Recoit();
		recoit.setId(recoitDtio.getId());
		recoit.setNiveau(niveau);
		recoit.setInformation(information);
		return recoit;
	}
	public static RecoitDto toRecoit(Recoit recoit) {
		RecoitDto recoitDto = new RecoitDto();
		recoitDto.setId(recoit.getId());
		recoitDto.setId_niveau(recoit.getNiveau().getId_Niveau());
		recoitDto.setId_information(recoit.getInformation().getId());
		return recoitDto;
	}
	/*********************************************
	 * ******************Salle********************
	 */
	public static Salle toSalleDto(SalleDto salleDto) {
		Salle salle = new Salle();
		salle.setId(salleDto.getId());
		salle.setNumSalle(salleDto.getNumSalle());
		salle.setSalle_Oc(salleDto.getSalle_Oc());
		salle.setSalle_NO(salleDto.getSalle_NO());
		return salle;
	}
	public static SalleDto toSalle(Salle salle) {
		SalleDto salleDto = new SalleDto();
		salleDto.setId(salle.getId());
		salleDto.setNumSalle(salle.getNumSalle());
		salleDto.setSalle_Oc(salle.getSalle_Oc());
		salleDto.setSalle_NO(salle.getSalle_NO());
		return salleDto;
	}
}
