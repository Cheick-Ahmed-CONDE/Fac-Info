package com.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany; 

@Entity 
public class Enseignant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_enseignant;
	private String nom;
	private String prenom;
	private String telephone;
	private String email;
	private String formation_donner;
	private String type_enseignant;
	
	@OneToMany(mappedBy = "enseignant")
	private List<Formation> listeFormations;
	
	public List<Formation> getListeFormations() {
		return listeFormations;
	}
	public void setListeFormations(List<Formation> listeFormations) {
		this.listeFormations = listeFormations;
	}
	public int getId_enseignant() {
		return id_enseignant;
	}
	public void setId_enseignant(int id_enseignant) {
		this.id_enseignant = id_enseignant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFormation_donner() {
		return formation_donner;
	}
	public void setFormation_donner(String formation_donner) {
		this.formation_donner = formation_donner;
	}
	public String getType_enseignant() {
		return type_enseignant;
	}
	public void setType_enseignant(String type_enseignant) {
		this.type_enseignant = type_enseignant;
	}
	
}
