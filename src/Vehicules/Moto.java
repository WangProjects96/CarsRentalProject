package Vehicules;

public class Moto extends Vehicule {
	private int cylindree;

	public Moto(String marque, int cylindree, double prix) {
		super(marque, prix);
		this.cylindree = cylindree;
	}

	@Override
	public String toString() {
		return new StringBuilder(super.toString()).append(" ").append(this.cylindree).toString();
	}

	public int getCylindree() {
		return cylindree;
	}

	public void setCylindree(int cylindree) {
		this.cylindree = cylindree;
	}

	@Override
	public Vehicule clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
