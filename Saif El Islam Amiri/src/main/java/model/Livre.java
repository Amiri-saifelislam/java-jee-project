package model;

public class Livre {
	int id;
	String auteur;
	String nom_livre;
	Categorie c;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getNom_livre() {
		return nom_livre;
	}
	public void setNom_livre(String nom_livre) {
		this.nom_livre = nom_livre;
	}
	public Categorie getC() {
		return c;
	}
	public void setC(Categorie c) {
		this.c = c;
	}
	
	
}
