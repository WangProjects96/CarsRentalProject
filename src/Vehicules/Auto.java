package Vehicules;

public class Auto extends Vehicule {
	private String modele;

	public Auto(String marque, String modele, double prix) {
		super(marque,prix);
		this.modele = modele;
	}

	@Override
	public String toString() {
		return new StringBuilder(super.toString()).append(" ").append(this.modele).toString();
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	@Override
	public Vehicule clone() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
