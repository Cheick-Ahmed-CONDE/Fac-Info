package com.api.dto;

public class SalleDto extends ResponseDto{
	
	private int id;
	private String numSalle;
	private String salle_Oc;
	private String salle_NO;
	
	
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
	public String getSalle_Oc() {
		return salle_Oc;
	}
	public void setSalle_Oc(String salle_Oc) {
		this.salle_Oc = salle_Oc;
	}
	public String getSalle_NO() {
		return salle_NO;
	}
	public void setSalle_NO(String salle_NO) {
		this.salle_NO = salle_NO;
	}

}
