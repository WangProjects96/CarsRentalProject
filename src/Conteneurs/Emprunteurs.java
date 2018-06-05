package Conteneurs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Autres.Adresse;
import Autres.Emprunteur;
import Vehicules.Vehicule;

public class Emprunteurs {
	private static ArrayList<Emprunteur> emprunteurs = new ArrayList<Emprunteur>();

	/*
	 * public Emprunteurs(){ this.emprunteurs=new ArrayList<Emprunteur>(); }
	 */

	public static void charger() {
		try {
			File f = new File("C:/Users/X250/workspace/ProjetJavaSwing/emprunteurs.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			try {
				String line = br.readLine();
				Vehicule vehicule = null;
				Adresse adresse;
				while (line != null) {
					System.out.println(line);
					String[] decoupe = line.split(" ; ");
					adresse = new Adresse(Integer.parseInt(decoupe[2]), decoupe[3], Integer.parseInt(decoupe[4]),
							decoupe[5]);
					new Emprunteur(decoupe[0], decoupe[1], adresse);
					line = br.readLine();
				}
				br.close();
				System.out.println(emprunteurs.size());
				fr.close();
			} catch (IOException exception) {
				System.out.println("Erreur lors de la lecture : " + exception.getMessage());
			}
		} catch (FileNotFoundException exception) {
			System.out.println("Le fichier n'a pas été trouvé");
		}
	}

	public static void sauvegarder() {
		File f = new File("C:/Users/X250/workspace/ProjetJavaSwing/emprunteurs.txt");
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			for (Emprunteur e : emprunteurs) {
				fw.write(e.getNom() + " ; " + e.getPrenom() + " ; " + e.getAdresse().getNumero() + " ; "
						+ e.getAdresse().getRue() + " ; " + e.getAdresse().getCp() + " ; " + e.getAdresse().getVille()
						+ "\n");
			}

			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Emprunteur> getNonResa() {
		ArrayList<Emprunteur> liste = new ArrayList<Emprunteur>();
		for (Emprunteur e : emprunteurs) {
			if (e.isEmpty() == false) {
				liste.add(e);
			}
		}
		return liste;
	}

	public static Emprunteur rechercher(String nom) {
		for (Emprunteur e : emprunteurs) {
			if (e.getNom().equals(nom)) {
				return e;
			}
		}
		return null;
	}

	public static void supprimer(Emprunteur emprunteur) {
		for (int i = 0; i < emprunteurs.size(); i++) {
			if (emprunteurs.get(i).equals(emprunteur)) {
				emprunteurs.remove(i);
			}
		}
	}

	public static void modifier(Emprunteur emprunteur, Adresse  adresse) {
		for (int i = 0; i < emprunteurs.size(); i++) {
			if (emprunteurs.get(i).equals(emprunteur)) {
				emprunteurs.get(i).setAdresse(adresse);
			}
		}
	}

	public static void add(Emprunteur emprunteur) {
		emprunteurs.add(emprunteur);
	}

	public ArrayList<Emprunteur> getByName(String s) {
		ArrayList<Emprunteur> emprunteur = new ArrayList<Emprunteur>();
		for (Emprunteur e : emprunteurs) {
			if (e.getNom() == s) {
				emprunteur.add(e);
			}
		}
		return emprunteur;
	}

	public ArrayList<Emprunteur> getByVehicule(Vehicule v) {
		ArrayList<Emprunteur> emprunteur = new ArrayList<Emprunteur>();
		for (Emprunteur e : emprunteurs) {
			if (e.empruntV(v)) {
				emprunteur.add(e);
			}
		}
		return emprunteur;
	}

	public static ArrayList<Emprunteur> getEmprunteurs() {
		return emprunteurs;
	}

	public static String toString1() {
		StringBuilder s = new StringBuilder();
		System.out.println(emprunteurs.size());
		for (Emprunteur e : emprunteurs) {
			s.append(e.toString()).append('\n');
		}
		return s.toString();
	}
}
