package Graphiques;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Autres.Emprunteur;
import Autres.Exemplaire;
import Autres.Location;
import Conteneurs.Emprunteurs;
import Conteneurs.Exemplaires;
import Graphiques.FenetreAccueil.Action;

public class FenetreLocAutoLuxe extends JFrame {
	private String nomFenetre = "Louer une voiture de luxe";
	private int largeur = 400, longueur = 600;
	private boolean assu = false;
	private Container contentPane;

	private JButton boutonLouer;
	private JButton boutonRetour;
	private JLabel statusLabelUtilisateur;
	private JLabel statusLabelVehicule;
	private JLabel statusLabelJourDeb;
	private JLabel statusLabelMoisDeb;
	private JLabel statusLabelAnneeDeb;
	private JLabel statusLabelJourFin;
	private JLabel statusLabelMoisFin;
	private JLabel statusLabelAnneeFin;
	private JLabel statusLabelAssurance;
	private JLabel statusLabelErreurSaisie;

	private JPanel PanelAssurance;
	private JPanel PanelBouton;

	private JComboBox users;
	private JComboBox voituresLuxe;
	private JComboBox jourDeb;
	private JComboBox moisDeb;
	private JComboBox anneeDeb;
	private JComboBox jourFin;
	private JComboBox moisFin;
	private JComboBox anneeFin;

	private JRadioButton jrOui;
	private JRadioButton jrNon;
	private ButtonGroup bg;
	private Location loc;
	private FenetreAccueil fMenu;
	private Date dateDebut;
	private Date dateFin;

	private Action a;

	private ArrayList<Emprunteur> emp = Emprunteurs.getEmprunteurs();
	private ArrayList<Exemplaire> ex = Exemplaires.getVoitureLuxeDispo();

	public void lancer() {
		this.setTitle(nomFenetre);
		this.setSize(largeur, longueur);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);

		a = new Action();

		contentPane = getContentPane();

		users = new JComboBox();
		voituresLuxe = new JComboBox();
		jourDeb = new JComboBox();
		moisDeb = new JComboBox();
		anneeDeb = new JComboBox();
		jourFin = new JComboBox();
		moisFin = new JComboBox();
		anneeFin = new JComboBox();

		statusLabelUtilisateur = new JLabel("Utilisateur : ");
		statusLabelVehicule = new JLabel("Exemplaire : ");
		statusLabelJourDeb = new JLabel("Jour Début : ");
		statusLabelMoisDeb = new JLabel("Mois Début : ");
		statusLabelAnneeDeb = new JLabel("Annee Début : ");
		statusLabelJourFin = new JLabel("Jour fin : ");
		statusLabelMoisFin = new JLabel("Mois fin : ");
		statusLabelAnneeFin = new JLabel("Annee fin : ");
		statusLabelAssurance = new JLabel("Assurance : ");
		statusLabelErreurSaisie = new JLabel("");

		PanelAssurance = new JPanel();
		PanelBouton = new JPanel();

		bg = new ButtonGroup();
		jrOui = new JRadioButton("Oui");
		jrNon = new JRadioButton("Non");
		jrNon.setSelected(true);

		boutonLouer = new JButton("Louer");
		boutonRetour = new JButton("Retour");

		for (Emprunteur emprunteur : emp) {
			users.addItem(emprunteur.getNom());
		}

		for (Exemplaire exemplaire : ex) {
			voituresLuxe.addItem(exemplaire.toString());
		}

		for (int i = 1; i < 31; i++) {
			jourDeb.addItem(i);
			jourFin.addItem(i);
		}

		for (int i = 1; i < 13; i++) {
			moisDeb.addItem(i);
			moisFin.addItem(i);
		}

		for (int i = Calendar.getInstance().get(Calendar.YEAR); i < 2100; i++) {
			anneeDeb.addItem(i);
			anneeFin.addItem(i);
		}

		bg.add(jrOui);
		bg.add(jrNon);

		PanelAssurance.add(jrOui);
		PanelAssurance.add(jrNon);

		statusLabelUtilisateur.setBounds(20, 25, 200, 30);
		users.setBounds(100, 25, 250, 25);

		statusLabelVehicule.setBounds(20, 75, 200, 30);
		voituresLuxe.setBounds(100, 75, 250, 25);

		statusLabelJourDeb.setBounds(20, 125, 200, 30);
		jourDeb.setBounds(100, 125, 250, 25);

		statusLabelMoisDeb.setBounds(20, 175, 200, 30);
		moisDeb.setBounds(100, 175, 250, 25);

		statusLabelAnneeDeb.setBounds(20, 225, 200, 30);
		anneeDeb.setBounds(100, 225, 250, 25);

		statusLabelJourFin.setBounds(20, 275, 200, 30);
		jourFin.setBounds(100, 275, 250, 25);

		statusLabelMoisFin.setBounds(20, 325, 200, 30);
		moisFin.setBounds(100, 325, 250, 25);

		statusLabelAnneeFin.setBounds(20, 375, 200, 30);
		anneeFin.setBounds(100, 375, 250, 25);

		statusLabelAssurance.setBounds(20, 425, 200, 30);
		PanelAssurance.setBounds(100, 425, 150, 25);

		PanelBouton.setBounds(20, 475, 150, 50);
		statusLabelErreurSaisie.setBounds(200, 475, 200, 30);

		boutonLouer.setForeground(Color.BLACK);
		boutonLouer.setBackground(Color.WHITE);
		boutonRetour.setForeground(Color.BLACK);
		boutonRetour.setBackground(Color.WHITE);
		Border line = new LineBorder(Color.BLACK);
		Border margin = new EmptyBorder(5, 15, 5, 15);
		Border compound = new CompoundBorder(line, margin);
		boutonLouer.setBorder(compound);
		boutonRetour.setBorder(compound);

		boutonLouer.addActionListener(a);
		boutonRetour.addActionListener(a);
		PanelBouton.add(boutonLouer);
		PanelBouton.add(boutonRetour);

		contentPane.add(statusLabelUtilisateur);
		contentPane.add(users);
		contentPane.add(statusLabelVehicule);
		contentPane.add(voituresLuxe);
		contentPane.add(statusLabelJourDeb);
		contentPane.add(jourDeb);
		contentPane.add(statusLabelMoisDeb);
		contentPane.add(moisDeb);
		contentPane.add(statusLabelAnneeDeb);
		contentPane.add(anneeDeb);
		contentPane.add(statusLabelJourFin);
		contentPane.add(jourFin);
		contentPane.add(statusLabelMoisFin);
		contentPane.add(moisFin);
		contentPane.add(statusLabelAnneeFin);
		contentPane.add(anneeFin);
		contentPane.add(statusLabelAssurance);
		contentPane.add(PanelAssurance);
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
			if (event.getSource() == boutonLouer) {
				try {
					dateDebut = new Date((int) anneeDeb.getSelectedItem(), (int) moisDeb.getSelectedItem(),
							(int) jourDeb.getSelectedItem());
					dateFin = new Date((int) anneeFin.getSelectedItem(), (int) moisFin.getSelectedItem(),
							(int) jourFin.getSelectedItem());
					if (jrOui.isSelected()) {
						assu = true;
					}
					loc = new Location(dateDebut, dateFin, emp.get(users.getSelectedIndex()),
							ex.get(voituresLuxe.getSelectedIndex()), assu);
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
