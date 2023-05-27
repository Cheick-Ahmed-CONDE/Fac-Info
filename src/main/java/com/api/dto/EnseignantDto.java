package com.api.dto;

public class EnseignantDto extends ResponseDto{

	private int id_enseignant;
	private String nom;
	private String prenom;
	private String telephone;
	private String email;
	private String formation_donner;
	private String type_enseignant;
	
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
