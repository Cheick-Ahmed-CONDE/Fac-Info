package com.api.dto;

public class NiveauDto extends ResponseDto{
	
	private int id_Niveau;
	private String niveau;
	
	
	public int getId_Niveau() {
		return id_Niveau;
	}
	public void setId_Niveau(int id_Niveau) {
		this.id_Niveau = id_Niveau;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

}
