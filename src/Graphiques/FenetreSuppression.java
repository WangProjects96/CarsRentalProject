package Graphiques;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Autres.Emprunteur;
import Autres.Exemplaire;
import Autres.Location;
import Conteneurs.Emprunteurs;
import Conteneurs.Exemplaires;
import Conteneurs.Vehicules;
import Graphiques.FenetreModification.Action;
import Vehicules.Auto;
import Vehicules.Vehicule;

public class FenetreSuppression extends JFrame {

	private String nomFenetre = "Supprimer";
	private int largeur = 800, longueur = 525;
	private Container contentPane;

	private JButton boutonSuppEx;
	private JButton boutonSuppEmp;
	private JButton boutonRetour;
	private JLabel statusLabelErreurSaisie;

	private Action a;

	private ArrayList<Exemplaire> vNormal = Exemplaires.getVoitureDispo();
	private ArrayList<Exemplaire> vLuxe = Exemplaires.getVoitureLuxeDispo();
	private ArrayList<Exemplaire> moto = Exemplaires.getMotoDispo();
	private ArrayList<Emprunteur> emp = Emprunteurs.getEmprunteurs();

	DefaultListModel<String> listModelEmprunteurs;
	DefaultListModel<String> listModelExemplaires;
	private JList<String> exemplairesList;
	private JList<String> emprunteursList;

	private Exemplaires exemplaires;
	private Emprunteurs emprunteurs;

	private JPanel panel1;
	private JPanel panel2;

	public FenetreSuppression() {
		super();
	}

	public void lancer() {
		this.setTitle(nomFenetre);
		this.setSize(largeur, longueur);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		a = new Action();
		contentPane = getContentPane();

		panel1 = new JPanel();
		panel2 = new JPanel();

		boutonSuppEmp = new JButton("Supprimer un utilisateur");
		boutonSuppEx = new JButton("Supprimer un véhicule");
		boutonRetour = new JButton("Retour");
		statusLabelErreurSaisie = new JLabel("");

		listModelEmprunteurs = new DefaultListModel<>();
		listModelExemplaires = new DefaultListModel<>();

		for (Emprunteur emprunteur : emp) {
			listModelEmprunteurs.addElement(emprunteur.toString());
		}

		for (Exemplaire exemplaire : vNormal) {
			listModelExemplaires.addElement(exemplaire.toString());
		}

		for (Exemplaire exemplaire : vLuxe) {
			listModelExemplaires.addElement(exemplaire.toString());
		}

		for (Exemplaire exemplaire : moto) {
			listModelExemplaires.addElement(exemplaire.toString());
		}

		emprunteursList = new JList<>(listModelEmprunteurs);
		exemplairesList = new JList<>(listModelExemplaires);

		JScrollPane pane = new JScrollPane(emprunteursList);
		JScrollPane scrollPanex = new JScrollPane(pane);
		pane.setPreferredSize(new Dimension(350, 150));

		JScrollPane pane2 = new JScrollPane(exemplairesList);
		JScrollPane scrollPanex2 = new JScrollPane(pane2);
		pane2.setPreferredSize(new Dimension(350, 150));

		panel1.add(scrollPanex);
		panel1.setBounds(50, 25, 350, 160);

		panel2.add(scrollPanex2);
		panel2.setBounds(50, 215, 350, 160);

		boutonSuppEmp.setBounds(500, 75, 200, 50);
		boutonSuppEx.setBounds(500, 265, 200, 50);
		boutonRetour.setBounds(50, 400, 200, 50);
		statusLabelErreurSaisie.setBounds(300, 400, 200, 50);

		boutonSuppEmp.setForeground(Color.BLACK);
		boutonSuppEmp.setBackground(Color.WHITE);
		boutonSuppEx.setForeground(Color.BLACK);
		boutonSuppEx.setBackground(Color.WHITE);
		boutonRetour.setForeground(Color.BLACK);
		boutonRetour.setBackground(Color.WHITE);
		Border line = new LineBorder(Color.BLACK);
		Border margin = new EmptyBorder(5, 15, 5, 15);
		Border compound = new CompoundBorder(line, margin);
		boutonSuppEmp.setBorder(compound);
		boutonSuppEx.setBorder(compound);
		boutonRetour.setBorder(compound);

		boutonSuppEmp.addActionListener(a);
		boutonSuppEx.addActionListener(a);
		boutonRetour.addActionListener(a);

		contentPane.add(panel1);
		contentPane.add(boutonSuppEmp);
		contentPane.add(panel2);
		contentPane.add(boutonSuppEx);
		contentPane.add(boutonRetour);
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

	// exemplaires.supprimer(untruc);
	class Action extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == boutonSuppEmp) {
				try {
					emprunteurs.supprimer(emp.get(emprunteursList.getSelectedIndex()));
				} catch (Exception e) {
					statusLabelErreurSaisie.setText("Erreur de saisie");
					statusLabelErreurSaisie.setForeground(Color.RED);
				}

			} else if (event.getSource() == boutonSuppEx) {
				try {
					try {
						exemplaires.supprimer(vNormal.get(exemplairesList.getSelectedIndex()));

					} catch (RuntimeException e) {
						// TODO: handle exception
					}
					try {
						exemplaires.supprimer(vLuxe.get(exemplairesList.getSelectedIndex()));

					} catch (RuntimeException e) {
						// TODO: handle exception
					}
					try {
						exemplaires.supprimer(moto.get(exemplairesList.getSelectedIndex()));

					} catch (RuntimeException e) {
						// TODO: handle exception
					}

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
