package com.api.dto;


import java.util.Date;

public class FormationDto extends ResponseDto{
	
	private int id;
	private String type_formation;
	private String description;
	private Date date_debut;
	private Date date_fin;
	private int Id_enseignant;
	
	
	public int getId_enseignant() {
		return Id_enseignant;
	}
	public void setId_enseignant(int id_enseignant) {
		Id_enseignant = id_enseignant;
	}
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
	

}
