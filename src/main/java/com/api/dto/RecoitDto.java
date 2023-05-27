package com.api.dto;

public class RecoitDto extends ResponseDto{
	private int id;
	private int id_niveau;
	private int id_information;
	
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
	public int getId_information() {
		return id_information;
	}
	public void setId_information(int id_information) {
		this.id_information = id_information;
	}
}
