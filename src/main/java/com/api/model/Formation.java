package com.api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany; 

@Entity 
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type_formation;
	private String description;
	private Date date_debut;
	private Date date_fin;
	
	@ManyToOne
	@JoinColumn(name = "id_enseignant")
	private Enseignant enseignant;
	
	@OneToMany(mappedBy = "formation")
	private List<Participation_Formation> listParticipationFormation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType_formation() {
		return type_formation;
	}
	public void setType_formation(String type_formation) {
		this.type_formation = type_formation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public List<Participation_Formation> getListParticipationFormation() {
		return listParticipationFormation;
	}
	public void setListParticipationFormation(List<Participation_Formation> listParticipationFormation) {
		this.listParticipationFormation = listParticipationFormation;
	}
		
}
