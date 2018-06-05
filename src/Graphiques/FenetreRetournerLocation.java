package Graphiques;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Autres.Emprunteur;
import Autres.Location;
import Conteneurs.Emprunteurs;
import Conteneurs.Locations;
import Graphiques.FenetreLocAuto.Action;

public class FenetreRetournerLocation extends JFrame {
	private String nomFenetre = "Rendre un véhicule";
	private int largeur = 400, longueur = 500;
	private Container contentPane;
	private boolean abi = false;

	private JLabel statusLabelLocation;
	private JLabel statusLabelAbime;
	private JLabel statusLabelDistance;
	private JLabel statusLabelCarburant;
	private JLabel statusLabelErreurSaisie;
	private JLabel statusLabelJourRendu;
	private JLabel statusLabelMoisRendu;
	private JLabel statusLabelAnneeRendu;

	private JButton boutonRendre;
	private JButton boutonRetour;

	private JPanel PanelBouton;
	private JPanel PanelAbime;

	private JComboBox location;
	private JComboBox carburant;
	private JComboBox jourRendu;
	private JComboBox moisRendu;
	private JComboBox anneeRendu;

	private JTextField zoneTextDistance;

	private Action a;
	private Date dateRendu;

	private JRadioButton jrOui;
	private JRadioButton jrNon;
	private ButtonGroup bg;

	private Location loca;
	private Locations locations;

	private ArrayList<Location> loc = Locations.enCours();

	public FenetreRetournerLocation() {
		super();
	}

	public void lancer() {
		this.setTitle(nomFenetre);
		this.setSize(largeur, longueur);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		a = new Action();

		contentPane = getContentPane();

		location = new JComboBox();
		carburant = new JComboBox();
		jourRendu = new JComboBox();
		moisRendu = new JComboBox();
		anneeRendu = new JComboBox();

		statusLabelLocation = new JLabel("Location : ");
		statusLabelAbime = new JLabel("Abime : ");
		statusLabelDistance = new JLabel("Distance : ");
		statusLabelCarburant = new JLabel("Carburant : ");
		statusLabelJourRendu = new JLabel("Jour rendu : ");
		statusLabelMoisRendu = new JLabel("Mois rendu : ");
		statusLabelAnneeRendu = new JLabel("Annee rendu : ");
		statusLabelErreurSaisie = new JLabel("");

		zoneTextDistance = new JTextField();

		bg = new ButtonGroup();
		jrOui = new JRadioButton("Oui");
		jrNon = new JRadioButton("Non");
		jrNon.setSelected(true);

		boutonRendre = new JButton("Rendre");
		boutonRetour = new JButton("Retour");

		PanelBouton = new JPanel();
		PanelAbime = new JPanel();

		for (Location l : loc) {
			location.addItem("Location n° : " + l.getNumero() + " " + l.getEmprunteur().getNom() + " "
					+ l.getExemplaire().toString() + " Km");
		}

		for (int i = 0; i < 5; i++) {
			carburant.addItem(i);
		}

		for (int i = 1; i < 31; i++) {
			jourRendu.addItem(i);
		}

		for (int i = 1; i < 13; i++) {
			moisRendu.addItem(i);
		}

		for (int i = Calendar.getInstance().get(Calendar.YEAR); i < 2100; i++) {
			anneeRendu.addItem(i);
		}

		bg.add(jrOui);
		bg.add(jrNon);

		PanelAbime.add(jrOui);
		PanelAbime.add(jrNon);

		statusLabelLocation.setBounds(20, 25, 200, 30);
		location.setBounds(100, 25, 275, 25);

		statusLabelDistance.setBounds(20, 75, 200, 30);
		zoneTextDistance.setBounds(100, 75, 250, 25);

		statusLabelCarburant.setBounds(20, 125, 200, 30);
		carburant.setBounds(100, 125, 250, 25);

		statusLabelAbime.setBounds(20, 175, 200, 30);
		PanelAbime.setBounds(100, 175, 150, 25);

		statusLabelJourRendu.setBounds(20, 225, 200, 30);
		jourRendu.setBounds(100, 225, 250, 25);

		statusLabelMoisRendu.setBounds(20, 275, 200, 30);
		moisRendu.setBounds(100, 275, 250, 25);

		statusLabelAnneeRendu.setBounds(20, 325, 200, 30);
		anneeRendu.setBounds(100, 325, 250, 25);

		PanelBouton.setBounds(20, 375, 200, 50);
		statusLabelErreurSaisie.setBounds(220, 375, 200, 30);

		zoneTextDistance.setPreferredSize(new Dimension(200, 20));

		boutonRendre.setForeground(Color.BLACK);
		boutonRendre.setBackground(Color.WHITE);
		boutonRetour.setForeground(Color.BLACK);
		boutonRetour.setBackground(Color.WHITE);
		Border line = new LineBorder(Color.BLACK);
		Border margin = new EmptyBorder(5, 15, 5, 15);
		Border compound = new CompoundBorder(line, margin);
		boutonRendre.setBorder(compound);
		boutonRetour.setBorder(compound);

		boutonRendre.addActionListener(a);
		boutonRetour.addActionListener(a);
		PanelBouton.add(boutonRendre);
		PanelBouton.add(boutonRetour);

		contentPane.add(statusLabelLocation);
		contentPane.add(location);
		contentPane.add(statusLabelDistance);
		contentPane.add(zoneTextDistance);
		contentPane.add(statusLabelCarburant);
		contentPane.add(carburant);
		contentPane.add(statusLabelAbime);
		contentPane.add(PanelAbime);
		contentPane.add(statusLabelJourRendu);
		contentPane.add(jourRendu);
		contentPane.add(statusLabelMoisRendu);
		contentPane.add(moisRendu);
		contentPane.add(statusLabelAnneeRendu);
		contentPane.add(anneeRendu);
		contentPane.add(PanelBouton);
		contentPane.add(statusLabelErreurSaisie);

		// Nous demandons maintenant à notre objet de se positionner au centre
		this.setLocationRelativeTo(null);
		// Termine le processus lorsqu'on clique sur la croix rouge
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Et enfin, la rendre visible
		this.setVisible(true);
	}

	public void fermer() {
		this.dispose();
	}

	class Action extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == boutonRendre) {
				try {

					if (jrOui.isSelected()) {
						abi = true;
					}

					loca = loc.get(location.getSelectedIndex());
					dateRendu = new Date();
					Date D = new Date((int) anneeRendu.getSelectedItem(), (int) moisRendu.getSelectedItem(),
							(int) jourRendu.getSelectedItem());
					loca.retournerE(Integer.parseInt(zoneTextDistance.getText()), abi, carburant.getSelectedIndex(), D);
					locations.supprimer(loc.get(location.getSelectedIndex()));
					fermer();
				} catch (Exception e) {
					statusLabelErreurSaisie.setText("Erreur de saisie");
					statusLabelErreurSaisie.setForeground(Color.RED);
				}

			} else if (event.getSource() == boutonRetour) {
				fermer();
			}
		}
	}
}
