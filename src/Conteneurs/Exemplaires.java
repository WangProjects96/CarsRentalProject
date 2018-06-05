package Conteneurs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Autres.Exemplaire;
import Vehicules.Vehicule;

public class Exemplaires implements Comparator {

	private static List<Exemplaire> exemplaire = new ArrayList<Exemplaire>();
	private static List<Exemplaire> exemplaireDispo = new ArrayList<Exemplaire>();

	public static void add(Exemplaire e) {
		exemplaire.add(e);
		exemplaireDispo.add(e);
	}

	public static void addDisp(Exemplaire e) {
		exemplaireDispo.add(e);
	}

	public static void louer(Exemplaire e) {
		exemplaireDispo.remove(e);
	}

	public static void supprimer(Exemplaire e) {
		exemplaire.remove(e);
		try {
			exemplaireDispo.remove(e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void modifier(Exemplaire ex, Double d) {
		for (Exemplaire e : exemplaire) {
			if (e.getNumero() == ex.getNumero()) {
				e.setKilometrage(d);
			}
		}
		for (Exemplaire e : exemplaireDispo) {
			if (e.getNumero() == ex.getNumero()) {
				e.setKilometrage(d);
			}
		}
	}

	public static void supprimerMarque(Vehicule v) {
		for (Exemplaire e : exemplaire) {
			if (e.getVehicule() == v) {
				supprimer(e);
			}
		}
		for (Exemplaire e : exemplaireDispo) {
			if (e.getVehicule() == v) {
				supprimer(e);
			}
		}
	}

	public static ArrayList<Exemplaire> getMoto() {
		ArrayList<Exemplaire> moto = new ArrayList<Exemplaire>();
		for (Exemplaire e : exemplaire) {
			if (e.getVehicule().getClass().getName() == "Vehicules.Moto") {
				moto.add(e);
			}
		}
		return moto;
	}

	public static ArrayList<Exemplaire> getVoiture() {
		ArrayList<Exemplaire> voiture = new ArrayList<Exemplaire>();
		for (Exemplaire e : exemplaire) {
			if (e.getVehicule().getClass().getName() == "Vehicules.Auto") {
				voiture.add(e);
			}
		}
		return voiture;
	}

	public static ArrayList<Exemplaire> getVoitureLuxe() {
		ArrayList<Exemplaire> voitureluxe = new ArrayList<Exemplaire>();
		for (Exemplaire e : exemplaire) {
			if (e.getVehicule().getClass().getName() == "Vehicules.AutoDeLuxe") {
				voitureluxe.add(e);
			}
		}
		return voitureluxe;
	}

	public static ArrayList<Exemplaire> getMotoDispo() {
		ArrayList<Exemplaire> moto = new ArrayList<Exemplaire>();
		for (Exemplaire e : exemplaireDispo) {
			if (e.getVehicule().getClass().getName() == "Vehicules.Moto") {
				moto.add(e);
			}
		}
		return moto;
	}

	public static ArrayList<Exemplaire> getVoitureDispo() {
		ArrayList<Exemplaire> voiture = new ArrayList<Exemplaire>();
		for (Exemplaire e : exemplaireDispo) {
			if (e.getVehicule().getClass().getName() == "Vehicules.Auto") {
				voiture.add(e);
			}
		}
		return voiture;
	}

	public static ArrayList<Exemplaire> getVoitureLuxeDispo() {
		ArrayList<Exemplaire> voitureluxe = new ArrayList<Exemplaire>();
		for (Exemplaire e : exemplaireDispo) {
			if (e.getVehicule().getClass().getName() == "Vehicules.AutoDeLuxe") {
				voitureluxe.add(e);
			}
		}
		return voitureluxe;
	}

	public void rechercheKm(double kmMax) {
		for (Exemplaire e : exemplaireDispo) {
			if (e.getKilometrage() < kmMax) {
				System.out.println(e.toString() + "\n");
			}
		}
	}

	public void rechercheMarque(String marque) {
		for (Exemplaire e : exemplaireDispo) {
			if (e.getMarque().equals(marque)) {
				System.out.println(e.toString() + " \n");
			}
		}
	}

	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Exemplaire e1 = (Exemplaire) o1;
		Exemplaire e2 = (Exemplaire) o2;

		return e1.compareTo(e2);
	}

	public static String toString1() {
		return exemplaire.toString();
	}

	public static String toString2() {
		return exemplaireDispo.toString();
	}

}
