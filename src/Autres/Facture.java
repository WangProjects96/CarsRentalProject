package Autres;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Facture {
	private static int num = 1;
	private int numclient;
	private int numero;
	private double prix;
	private Exemplaire exemp;
	private String nom, prenom;
	private boolean assure;
	private double devis;
	private int retard;

	public Facture(int numclient, Exemplaire e, String nom, String prenom, boolean assure, double devis,int retard) {
		this.numclient = numclient;
		this.numero = num;
		this.prix = 0;
		this.exemp = e;
		this.nom = nom;
		this.prenom = prenom;
		this.assure = assure;
		this.devis = devis;
		this.prix = 0;
		this.retard=retard;
		this.setPrix();
		num++;

		this.toTxt();
		PDFTools.generatePDF(this);
	}
	
	public int getNumero(){
		return this.numero;
	}

	public void setPrix() {
		this.prix = devis;
		double d = 0;
		if (exemp.getAbime() && !assure) {

			switch (exemp.getVehicule().getClass().getName()) {
			case "Vehicule.Moto":
				d += 1000;
				break;

			case "Vehicule.Auto":
				d += 1500;
				break;

			case "Vehicule.AutoDeLuxe":
				d += 3000;
				break;

			default:
				break;
			}

		}

		if (exemp.getCarburant() < 4) {
			d += 15 * (exemp.getCarburant() % 4);
		}
		this.prix+=100*retard;
		this.prix += d;
	}

	public Facture() {
	}

	public int getNumclient() {
		return numclient;
	}

	public void setNumclient(int numclient) {
		this.numclient = numclient;
	}

	public double getPrix() {
		return prix;
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

	public String toString() {
		StringBuilder st = new StringBuilder();
		st.append("Mr " + this.nom + " " + this.prenom + " \n");
		st.append("Voiture: " + exemp.toString() + " \n");
		st.append("Devis: " + devis + " \n");
		st.append("Nouveau prix : " + prix + " \n");
		return st.toString();
	}

	public void toTxt() {
		try {
			File f = new File("C:/Users/X250/workspace/ProjetJavaSwing/Facture/Facture n°" + this.numero + ".txt");
			FileWriter fw = new FileWriter(f);
			fw.write(this.toString());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void toPdf() {

	}

}
