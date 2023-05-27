package com.api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany; 

@Entity 
public class Evenement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type_evenement;
	private String description;
	private Date date_debut;
	private Date date_fin;
	
	
	@OneToMany(mappedBy = "evenement")
	List<Participation> listeParticipation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType_evenement() {
		return type_evenement;
	}
	public void setType_evenement(String type_evenement) {
		this.type_evenement = type_evenement;
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
	public List<Participation> getListeParticipation() {
		return listeParticipation;
	}
	public void setListeParticipation(List<Participation> listeParticipation) {
		this.listeParticipation = listeParticipation;
	}
	
}
