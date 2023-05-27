
package com.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Etudiant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String telephone; 
	private String email; 
	private String departement; 
	private String faculte; 
	private String matricule; 
	private String photo;
	
		
	@OneToMany(mappedBy = "etudiant")
	private List<Inscrire> listInscrit;
	
	/*@OneToMany(mappedBy = "etudiant")
	private List<Recoit> listRecoit;*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public String getFaculte() {
		return faculte;
	}
	public void setFaculte(String faculte) {
		this.faculte = faculte;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public List<Inscrire> getListInscrit() {
		return listInscrit;
	}
	public void setListInscrit(List<Inscrire> listInscrit) {
		this.listInscrit = listInscrit;
	}
}
