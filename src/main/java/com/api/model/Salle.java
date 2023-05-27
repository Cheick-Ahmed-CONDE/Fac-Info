package com.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Salle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String numSalle;
	private String salle_Oc;
	private String salle_NO;
	
	
	@OneToMany(mappedBy = "salle")
	private List<Occuper> listeOccuper;
	
	
	public String getSalle_Oc() {
		return salle_Oc;
	}
	public void setSalle_Oc(String salle_Oc) {
		this.salle_Oc = salle_Oc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNumSalle() {
		return numSalle;
	}
	public void setNumSalle(String numSalle) {
		this.numSalle = numSalle;
	}
	public String getSalle_NO() {
		return salle_NO;
	}
	public void setSalle_NO(String salle_NO) {
		this.salle_NO = salle_NO;
	}
	public List<Occuper> getListeOccuper() {
		return listeOccuper;
	}
	public void setListeOccuper(List<Occuper> listeOccuper) {
		this.listeOccuper = listeOccuper;
	}
}
