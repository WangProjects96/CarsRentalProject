package Conteneurs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Autres.Emprunteur;
import Vehicules.Auto;
import Vehicules.AutoDeLuxe;
import Vehicules.Moto;
import Vehicules.Vehicule;

public class Vehicules {
	private static List<Vehicule> vehicules = new ArrayList<Vehicule>();
	private static Moto m;
	private static Auto a;
	private static AutoDeLuxe adl;

	/*
	 * public Vehicules() { this.vehicules = ; }
	 */

	public void charger(String fichier) {
		try {
			File f = new File(fichier);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			try {
				String vehicule;
				String line = br.readLine();
				String[] decoupe = line.split(" ");
				vehicule = decoupe[0];
				line = br.readLine();
				while (line != null && vehicule.equals("MOTOS")) {
					// System.out.println(line);
					decoupe = line.split(" ");
					line = br.readLine();
					if (line.equals("AUTOS")) {
						vehicule = line;
						line = br.readLine();
					}
					new Moto(decoupe[0], Integer.parseInt(decoupe[1]), Double.parseDouble(decoupe[2]));
				}
				while (line != null && vehicule.equals("AUTO")) {
					// System.out.println(line);
					decoupe = line.split(" ");
					line = br.readLine();
					if (line.equals("AUTODELUXE")) {
						vehicule = line;
						line = br.readLine();
					}
					new Auto(decoupe[0], decoupe[1], Double.parseDouble(decoupe[2]));
				}
				while (line != null && vehicule.equals("AUTODELUXE")) {
					// System.out.println(line);
					decoupe = line.split(" ");
					line = br.readLine();

					new AutoDeLuxe(decoupe[0], decoupe[1], Double.parseDouble(decoupe[2]));
				}
				br.close();
				fr.close();
			} catch (IOException exception) {
				System.out.println("Erreur lors de la lecture : " + exception.getMessage());
			}
		} catch (FileNotFoundException exception) {
			System.out.println("Le fichier n'a pas été trouvé");
		}
	}

	public static void sauvegarder() {
		File f = new File("C:/Users/X250/workspace/ProjetJavaSwing/vehicules.txt");
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			fw.write("MOTO");
			for (Vehicule v : vehicules) {

				if (v.getClass().getName().equals("Vehicule.Moto"))
					m = (Moto) v;
				fw.write(m.getMarque() + " ; " + m.getCylindree() + "\n");
			}
			fw.write("AUTO");
			for (Vehicule v : vehicules) {

				if (v.getClass().getName().equals("Vehicule.Auto"))
					a = (Auto) v;
				fw.write(a.getMarque() + " ; " + a.getModele() + "\n");
			}
			fw.write("AUTODELUXE");
			for (Vehicule v : vehicules) {

				if (v.getClass().getName().equals("Vehicule.AutoDeLuxe"))
					adl = (AutoDeLuxe) v;
				fw.write(adl.getMarque() + " ; " + adl.getModele() + "\n");
			}
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<Vehicule> getMoto() {
		ArrayList<Vehicule> resultat = new ArrayList<Vehicule>();
		for (Vehicule v : vehicules) {
			if (v.getClass().getName().equals("Vehicule.Moto")) {
				resultat.add(v);
			}
		}
		return resultat;
	}

	public static ArrayList<Vehicule> getAuto() {
		ArrayList<Vehicule> resultat = new ArrayList<Vehicule>();
		for (Vehicule v : vehicules) {
			if (v.getClass().getName().equals("Vehicule.Moto")) {
				resultat.add(v);
			}
		}
		return resultat;
	}

	public static ArrayList<Vehicule> getAutoDeLuxe() {
		ArrayList<Vehicule> resultat = new ArrayList<Vehicule>();
		for (Vehicule v : vehicules) {
			if (v.getClass().getName().equals("Vehicule.Moto")) {
				resultat.add(v);
			}
		}
		return resultat;
	}

	public static ArrayList<Vehicule> getVehicules() {
		ArrayList<Vehicule> resultat = new ArrayList<Vehicule>();
		for (Vehicule v : vehicules) {
			resultat.add(v);
		}
		return resultat;
	}

	public static Moto getM() {
		return m;
	}

	public static void setM(Moto m) {
		Vehicules.m = m;
	}

	public static Auto getA() {
		return a;
	}

	public static void setA(Auto a) {
		Vehicules.a = a;
	}


	public static AutoDeLuxe getAdl() {
		return adl;
	}

	public static void setAdl(AutoDeLuxe adl) {
		Vehicules.adl = adl;
	}

	public static void setVehicules(List<Vehicule> vehicules) {
		Vehicules.vehicules = vehicules;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Vehicule v : vehicules) {
			s.append(v.toString()).append('\n');
		}
		return s.toString();
	}

	public static void add(Vehicule vehicule) {
		vehicules.add(vehicule);
	}

	public static void supprimer(Vehicule v) {
		vehicules.remove(v);
		Exemplaires.supprimerMarque(v);
	}

}
