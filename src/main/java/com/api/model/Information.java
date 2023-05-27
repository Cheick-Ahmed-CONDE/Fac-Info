package com.api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany; 


@Entity 
public class Information {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String motif;
	private Date date_pub;
	
	@OneToMany(mappedBy = "information")
	private List<Recoit> listeRecoit; 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public Date getDate_pub() {
		return date_pub;
	}
	public void setDate_pub(Date date_pub) {
		this.date_pub = date_pub;
	}
	public List<Recoit> getListeRecoit() {
		return listeRecoit;
	}
	public void setListeRecoit(List<Recoit> listeRecoit) {
		this.listeRecoit = listeRecoit;
	}
	
}
