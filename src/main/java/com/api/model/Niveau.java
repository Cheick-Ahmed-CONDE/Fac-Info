package com.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Niveau {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Niveau;
	private String niveau;
	
	@OneToMany(mappedBy = "niveau")
	private List<Participation_Formation> listePaticipationFormation;
	
	@OneToMany(mappedBy = "niveau")
	private List<Occuper> listeOccuper;
	
	@OneToMany(mappedBy = "niveau")
	private List<Recoit> listRecoit;
	
	@OneToMany(mappedBy = "niveau")
	private List<Inscrire> listeInscrire;
	
	@OneToMany(mappedBy = "niveau")
	private List<Participation> listParticipation;
	
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
	public List<Participation_Formation> getListePaticipationFormation() {
		return listePaticipationFormation;
	}
	public void setListePaticipationFormation(List<Participation_Formation> listePaticipationFormation) {
		this.listePaticipationFormation = listePaticipationFormation;
	}
	public List<Occuper> getListeOccuper() {
		return listeOccuper;
	}
	public void setListeOccuper(List<Occuper> listeOccuper) {
		this.listeOccuper = listeOccuper;
	}
	public List<Recoit> getListRecoit() {
		return listRecoit;
	}
	public void setListRecoit(List<Recoit> listRecoit) {
		this.listRecoit = listRecoit;
	}
	public List<Inscrire> getListeInscrire() {
		return listeInscrire;
	}
	public void setListeInscrire(List<Inscrire> listeInscrire) {
		this.listeInscrire = listeInscrire;
	}
	public List<Participation> getListParticipation() {
		return listParticipation;
	}
	public void setListParticipation(List<Participation> listParticipation) {
		this.listParticipation = listParticipation;
	}

}
