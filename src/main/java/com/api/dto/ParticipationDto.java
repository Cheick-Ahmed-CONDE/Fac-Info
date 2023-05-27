package com.api.dto;

public class ParticipationDto extends ResponseDto{
	private int id;
	private int id_niveau;
	private int id_evenement;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_niveau() {
		return id_niveau;
	}
	public void setId_niveau(int id_niveau) {
		this.id_niveau = id_niveau;
	}
	public int getId_evenement() {
		return id_evenement;
	}
	public void setId_evenement(int id_evenement) {
		this.id_evenement = id_evenement;
	}
}
