package Conteneurs;

import java.util.ArrayList;
import java.util.Date;

import Autres.Emprunteur;
import Autres.Location;

public class Locations {
	private static ArrayList<Location> location = new ArrayList<Location>();

	public Locations() {
		this.location = new ArrayList<Location>();
	}

	public static void add(Location l) {
		location.add(l);
	}

	public static void supprimer(Location l) {
		location.remove(l);
	}

	public static ArrayList<Location> getByDate(Date d) { // a tester, pas sur
		ArrayList<Location> l1 = new ArrayList<Location>();
		for (Location l : location) {
			if (l.getDateDebut().equals(d)) {
				l1.add(l);
			}
		}
		return l1;
	}
	
	public static ArrayList<Location> enCours(){
		ArrayList<Location> l1= new ArrayList<Location>();
		for (Location l : location) {
			if (l.enCour()) {
				l1.add(l);
			}
		}
		return l1;
	}


	public static String toString1() {
		StringBuilder s = new StringBuilder();
		for (Location e : location) {
			s.append(e.toString()).append('\n');
		}
		return s.toString();
	}

}
