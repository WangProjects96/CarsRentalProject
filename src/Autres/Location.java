package Autres;

import java.util.ArrayList;
import java.util.Date;

import Conteneurs.Locations;
import Vehicules.Vehicule;

public class Location {

	private long CONST_DURATION_OF_DAY = 1000l * 60 * 60 * 24;
	private final int PRIX_ASSURANCE = 600;

	private static int n = 0;
	private int numero;
	private Date debut;
	private Date fin;
	private int duree;
	private Emprunteur emprunteur;
	private Exemplaire exemplaire;
	private double devis;
	private boolean assurance;
	private Facture facture;
	private double prixBase;
	private boolean enCour;
	private int retard;

	public Location(Date debut, Date fin, Emprunteur e, Exemplaire exemplaire, boolean assu) {
		this.exemplaire = exemplaire;
		n++;
		this.numero = n;
		this.assurance = assu;
		this.debut = debut;
		this.fin = fin;
		duree = getNbj(this.debut, this.fin);
		this.emprunteur = e;
		devis = this.calculPrix();
		enCour=true;
		this.facture = new Facture();
		this.exemplaire.louer();
		this.emprunteur.louer(this.exemplaire);
		Locations.add(this);
	}

	private double calculPrix() {
		int remise = 0;
		double k = exemplaire.getKilometrage();
		double tmp = k;
		while (tmp > 50000) {
			remise++;
			tmp -= 50000;
		}

		prixBase = (exemplaire.getVehicule().getPrix() * duree * (1 - (remise * 0.1)));
		if (assurance) {
			return PRIX_ASSURANCE + prixBase;
		}

		return prixBase;
	}
	
	public String getNom(){
		return this.emprunteur.getNom();
	}
	
	
	
	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

	public boolean enCour(){
		return enCour;
	}

	public void retournerE(int kilometrage, boolean abime, int carburant, Date D) { // carburant
																			// <=
																			// 4
		exemplaire.retourner(kilometrage, abime, carburant);
		emprunteur.retourner(exemplaire);
		retard = getNbj(this.fin, D);
		this.facture = new Facture(this.emprunteur.getId(), exemplaire, this.emprunteur.getNom(),
				this.emprunteur.getPrenom(), this.assurance, this.devis,retard);
	}

	public Date getDateDebut() {
		return debut;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Emprunteur getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Emprunteur emprunteur) {
		this.emprunteur = emprunteur;
	}

	public double getDevis() {
		return devis;
	}

	public void setDevis(double devis) {
		this.devis = devis;
	}

	public boolean isAssurance() {
		return assurance;
	}

	public void setAssurance(boolean assurance) {
		this.assurance = assurance;
	}

	private int getNbj(Date d1, Date d2) {
		long diff = Math.abs(d1.getTime() - d2.getTime());
		long nbj = (long) diff / CONST_DURATION_OF_DAY;

		return (int) nbj;
	}

	@Override
	public String toString() {
		return "Location [numero=" + numero + ", debut=" + debut + ", fin=" + fin + ", duree=" + duree
				+ "\n emprunteur=" + emprunteur.toString() + "\n exemplaire=" + exemplaire.toString() + "\n devis="
				+ devis + ", assurance=" + assurance + "]";
	}

	public Facture getFacture() {
		// TODO Auto-generated method stub
		return facture;
	}

}
