package com.api.dto;

import java.util.Date;

public class Participation_FormationDto extends ResponseDto{

	private int id;
	private Date date_acceptation;
	private int id_formation;
	private int id_niveau;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_formation() {
		return id_formation;
	}

	public void setId_formation(int id_formation) {
		this.id_formation = id_formation;
	}

	public int getId_niveau() {
		return id_niveau;
	}

	public void setId_niveau(int id_niveau) {
		this.id_niveau = id_niveau;
	}

	public Date getDate_acceptation() {
		return date_acceptation;
	}

	public void setDate_acceptation(Date date_acceptation) {
		this.date_acceptation = date_acceptation;
	}
}
