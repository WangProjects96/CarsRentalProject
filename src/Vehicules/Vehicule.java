package Vehicules;

import java.util.ArrayList;

import Autres.Exemplaire;
import Conteneurs.Vehicules;

public class Vehicule implements Cloneable {
	private String marque;
	private double prix;
	private ArrayList<Exemplaire> liste;
	private int cpt;

	public Vehicule(String marque, double prix) {
		this.marque = marque;
		this.prix = prix;
		liste = new ArrayList<Exemplaire>();
		cpt = 0;
		Vehicules.add(this);
	}

	public String getMarque() {
		return this.marque;
	}

	@Override
	public String toString() {
		return new StringBuilder(this.marque).toString();
	}

	public double getPrix() {
		return this.prix;
	}

	public int addEx(Exemplaire exemplaire) {
		liste.add(exemplaire);
		cpt++;
		return cpt;
	}

	public ArrayList<Exemplaire> getListe() {
		return liste;
	}

	public void setListe(ArrayList<Exemplaire> liste) {
		this.liste = liste;
	}

	public int getCpt() {
		return cpt;
	}

	public void setCpt(int cpt) {
		this.cpt = cpt;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

}
