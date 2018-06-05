package Autres;

import Vehicules.Auto;
import Vehicules.Moto;
import Vehicules.Vehicule;

import java.util.Date;

import javax.swing.SwingUtilities;

import Conteneurs.Emprunteurs;
import Conteneurs.Exemplaires;
import Conteneurs.Vehicules;
import Graphiques.FenetreAccueil;

public class Application {
	private static final String FICHIER_EMPRUNTEUR = "emprunteurs.txt";
	private static final String FICHIER_VEHICULES = "vehicules.txt";
	private static final String FICHIER_FLOTTE = "flotte.txt";

	public static void main(String[] args) {
		Emprunteurs emprunteurs = new Emprunteurs();
		Vehicules vehicules = new Vehicules();
		Emprunteurs.charger();

		int nbm = Vehicules.getMoto().size(); // nombre de moto (Véhicules)
		int nbv = Vehicules.getAuto().size();
		int nbvL = Vehicules.getAutoDeLuxe().size();

		Auto v = new Auto("Audi", "A8", 500);
		Auto v1 = new Auto("Fiat", "Panda", 300);
		Moto v2 = new Moto("Kawa", 800, 500);
		Moto v3 = new Moto("BMW", 850, 600);
		Exemplaire a = new Exemplaire(v, 12000);
		Exemplaire a1 = new Exemplaire(v, 120000);
		Exemplaire a2 = new Exemplaire(v, 120000);
		Exemplaire a3 = new Exemplaire(v, 120000);

		Exemplaire b = new Exemplaire(v1, 0);
		Exemplaire b1 = new Exemplaire(v1, 12000);
		Exemplaire b2 = new Exemplaire(v1, 300);
		Exemplaire b3 = new Exemplaire(v1, 650);

		Exemplaire c = new Exemplaire(v2, 0);
		Exemplaire c1 = new Exemplaire(v2, 0);
		Exemplaire c2 = new Exemplaire(v2, 0);
		Exemplaire c3 = new Exemplaire(v2, 0);

		Exemplaire d = new Exemplaire(v3, 0);
		Exemplaire d1 = new Exemplaire(v3, 0);
		Exemplaire d2 = new Exemplaire(v3, 0);
		Exemplaire d3 = new Exemplaire(v3, 0);

		// System.out.println(a.toString());
		// System.out.println(b.toString());
		// System.out.println(c.toString());

		Adresse adre = new Adresse(2, "Marceau", 94210, "st Maur");
		Emprunteur e = new Emprunteur("Caron", "Fabien", adre);
		// System.out.println(e);
		Date D = new Date(2017, 11, 1);
		Date D2 = new Date(2017, 11, 6);
		// System.out.println(d);
		Location l = new Location(D, D2, e, a, true);
		// System.out.println(l.toString());
		// System.out.println(e.getEmprunt().toString());
		// System.out.println("chiotte");
		// System.out.println(Exemplaires.getVoitureDispo());
		Date D1 = new Date(2017, 11, 20);
		l.retournerE(12000, true, 4, D1);
		// System.out.println(e.getEmprunt().toString());
		// System.out.println(a.getAbime());
		// System.out.println(Emprunteurs.toString1());
		// System.out.println(l.getFacture().getPrix());
		// System.out.println(v.equals("Auto"));

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				FenetreAccueil f = new FenetreAccueil();
				f.lancer();
			}

		});

	}

}
