package Autres;

import java.util.Comparator;
import java.util.Random;

import Conteneurs.Exemplaires;
import Vehicules.Vehicule;

public class Exemplaire implements Cloneable, Comparator {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (abime ? 1231 : 1237);
		result = prime * result + carburant;
		result = prime * result + (disponible ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(kilometrage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + numero;
		result = prime * result + valeur;
		result = prime * result + ((vehicule == null) ? 0 : vehicule.hashCode());
		return result;
	}

	private static final double RATIO_KILOMETRAGE = 0.1;
	private static final int CARBU_MAX = 4;
	private static final int KILOMETRE_REDUCTION = 50000;

	private boolean abime;
	private int numero;
	private Vehicule vehicule;
	private double kilometrage;
	private double kilometrageN;
	private boolean disponible;
	private int carburant;
	private int valeur, min = 0, maxC = 4, maxA = 5, maxK = 10000;

	public Exemplaire(Vehicule vehicule, double kilometrage) {
		abime = false;
		carburant = CARBU_MAX;
		this.vehicule = vehicule;
		this.kilometrage = kilometrage;
		this.disponible = false;
		this.numero = this.vehicule.addEx(this);
		Exemplaires.add(this);
	}

	public void retourner(int km, boolean abime, int carburant) {
		this.carburant = carburant;
		this.abime = abime;
		this.kilometrage += km;
		this.disponible = true;
		Exemplaires.addDisp(this);
	}

	public void louer() {
		this.disponible = false;
		Exemplaires.louer(this);
	}

	public int getNumero() {
		return numero;
	}

	public void fairePlein() {
		this.carburant = 4;
	}

	public Vehicule getVehicule() {
		return this.vehicule;
	}

	public double getKilometrage() {
		return this.kilometrage;
	}

	public String toString() {
		return new StringBuilder().append(this.numero).append(" ").append(this.vehicule.toString()).append(" ")
				.append(this.kilometrage).toString();
	}

	public double getPrix() {
		return this.vehicule.getPrix();
	}

	public double getModul() {
		return (this.kilometrage % KILOMETRE_REDUCTION) * this.vehicule.getPrix() * RATIO_KILOMETRAGE;
	}

	public boolean getAbime() {
		// TODO Auto-generated method stub
		return abime;
	}

	public Object getMarque() {
		// TODO Auto-generated method stub
		return vehicule.getMarque();
	}

	public void setAbime(boolean abime) {
		this.abime = abime;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public void setKilometrage(double kilometrage) {
		this.kilometrage = kilometrage;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public boolean getDisponile() {
		return disponible;
	}

	public void setCarburant(int carburant) {
		this.carburant = carburant;
	}

	public int compareTo(Exemplaire e2) {
		// TODO Auto-generated method stub
		return ((String) this.getMarque()).compareTo((String) e2.getMarque());
	}

	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Exemplaire e1 = (Exemplaire) o1;
		Exemplaire e2 = (Exemplaire) o2;
		return e1.compareTo(e2);
	}

	public int getCarburant() {
		// TODO Auto-generated method stub
		return carburant;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exemplaire other = (Exemplaire) obj;
		if (abime != other.abime)
			return false;
		if (carburant != other.carburant)
			return false;
		if (disponible != other.disponible)
			return false;
		if (Double.doubleToLongBits(kilometrage) != Double.doubleToLongBits(other.kilometrage))
			return false;
		if (numero != other.numero)
			return false;
		if (valeur != other.valeur)
			return false;
		if (vehicule == null) {
			if (other.vehicule != null)
				return false;
		} else if (!vehicule.equals(other.vehicule))
			return false;
		return true;
	}

}
