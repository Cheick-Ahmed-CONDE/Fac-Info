package com.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne; 

@Entity  
public class Inscrire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date date_inscription;

	@ManyToOne
	@JoinColumn(name = "id_etudiant")
	private Etudiant etudiant;
	
	@ManyToOne
	@JoinColumn(name = "id_Niveau")
	private Niveau niveau;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_inscription() {
		return date_inscription;
	}

	public void setDate_inscription(Date date_inscription) {
		this.date_inscription = date_inscription;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
}
