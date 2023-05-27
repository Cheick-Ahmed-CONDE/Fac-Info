package com.api.dto;

import java.time.LocalDate;
import java.util.Date;

public class OccuperDto extends ResponseDto{

	private int id;
	private Date Date_Occuper;
	private int id_salle;
	private int id_niveau;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_salle() {
		return id_salle;
	}

	public void setId_salle(int id_salle) {
		this.id_salle = id_salle;
	}

	public int getId_niveau() {
		return id_niveau;
	}

	public void setId_niveau(int id_niveau) {
		this.id_niveau = id_niveau;
	}

	public Date getDate_Occuper() {
		return Date_Occuper;
	}

	public void setDate_Occuper(Date date_Occuper) {
		Date_Occuper = date_Occuper;
	}

}
