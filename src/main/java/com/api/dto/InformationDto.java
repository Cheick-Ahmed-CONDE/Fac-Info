package com.api.dto;

import java.util.Date;

public class InformationDto extends ResponseDto{
	
	private int id;
	private String motif;
	private Date date_pub;
	
	
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
	
}
