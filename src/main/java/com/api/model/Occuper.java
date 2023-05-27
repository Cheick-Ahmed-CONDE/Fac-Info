package com.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Occuper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date Date_Occuper;
	
	@ManyToOne
	@JoinColumn(name = "id_salle")
	private Salle salle;

	@ManyToOne
	@JoinColumn(name = "id_Niveau")
	private Niveau niveau;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_Occuper() {
		return Date_Occuper;
	}

	public void setDate_Occuper(Date date_Occuper) {
		Date_Occuper = date_Occuper;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	
}
