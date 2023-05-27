package com.api.dto;


import java.util.Date;

public class InscrireDto extends ResponseDto{

	private int id;
	private Date date_inscription;
	private int id_etudiant;
	private int id_niveau;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_etudiant() {
		return id_etudiant;
	}

	public void setId_etudiant(int id_etudiant) {
		this.id_etudiant = id_etudiant;
	}

	public int getId_niveau() {
		return id_niveau;
	}

	public void setId_niveau(int id_niveau) {
		this.id_niveau = id_niveau;
	}

	public Date getDate_inscription() {
		return date_inscription;
	}

	public void setDate_inscription(Date date_inscription) {
		this.date_inscription = date_inscription;
	}

	
}
