package Autres;

import java.util.ArrayList;

import Conteneurs.Emprunteurs;
import Vehicules.Vehicule;

public class Emprunteur {
	private static int compteur = 1;
	private int id;
	private String nom;
	private String prenom;
	private Adresse adresse;
	private double factureCumul;
	private ArrayList<Exemplaire> emprunt;

	public Emprunteur(String nom, String prenom, Adresse adresse) {
		this.id = compteur;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.factureCumul = 0;
		compteur++;
		this.emprunt = new ArrayList<Exemplaire>();
		Emprunteurs.add(this);

	}

	public boolean isEmpty() {
		if (emprunt.size() == 0) {
			return true;
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public static int getCompteur() {
		return compteur;
	}

	public ArrayList<Exemplaire> getEmprunt() {
		return emprunt;
	}

	public void louer(Exemplaire e) {
		emprunt.add(e);
	}

	public void addFac(Double p) {
		this.factureCumul += p;
	}

	public void ramener(Exemplaire e) {
		try {
			emprunt.remove(e);
		} catch (Exception e2) {
			// TODO: handle exception
		}

	}
	public void retourner(Exemplaire e){
		emprunt.remove(e);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(this.id).append(" ").append(this.prenom).append(" ").append(this.nom).append(" ")
				.append(this.adresse.toString());
		return s.toString();
	}

	public boolean empruntV(Vehicule v) {
		// TODO Auto-generated method stub
		for (Exemplaire e : emprunt) {
			if (e.getVehicule() == v)
				return true;
		}
		return false;
	}
}
