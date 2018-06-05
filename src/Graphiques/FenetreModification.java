package Graphiques;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Autres.Adresse;
import Autres.Emprunteur;
import Autres.Exemplaire;
import Conteneurs.Emprunteurs;
import Conteneurs.Exemplaires;
import Graphiques.FenetreRetournerLocation.Action;

public class FenetreModification extends JFrame {
	private String nomFenetre = "Modification";
	private int largeur = 1000, longueur = 700;
	private Container contentPane;

	private Action a;

	private JButton boutonSetEmp;
	private JButton boutonSetEx;
	private JButton boutonRetour;

	private JLabel statusLabelAdresseNum;
	private JLabel statusLabelAdresseRue;
	private JLabel statusLabelAdresseCp;
	private JLabel statusLabelAdresseVille;
	private JLabel statusLabelKm;
	private JLabel statusLabelErreurSaisie;

	private JTextField zoneTextAdresseNum;
	private JTextField zoneTextAdresseRue;
	private JTextField zoneTextAdresseCp;
	private JTextField zoneTextAdresseVille;
	private JTextField zoneTextKm;

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
	private Adresse adre;

	private JPanel panel1;
	private JPanel panel2;

	public FenetreModification() {
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

		statusLabelAdresseNum = new JLabel("Nuémro de rue : ");
		statusLabelAdresseRue = new JLabel("Nom de rue : ");
		statusLabelAdresseCp = new JLabel("Code postal : ");
		statusLabelAdresseVille = new JLabel("Ville : ");
		statusLabelKm = new JLabel("Kilometrage : ");

		zoneTextAdresseNum = new JTextField();
		zoneTextAdresseRue = new JTextField();
		zoneTextAdresseCp = new JTextField();
		zoneTextAdresseVille = new JTextField();
		zoneTextKm = new JTextField();

		boutonSetEmp = new JButton("Modifier l'emprunteur");
		boutonSetEx = new JButton("Modifier le kilometrage");
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
		panel2.setBounds(500, 25, 350, 160);

		boutonSetEmp.setBounds(125, 425, 200, 50);
		boutonSetEx.setBounds(575, 425, 200, 50);
		boutonRetour.setBounds(125, 525, 200, 50);
		statusLabelErreurSaisie.setBounds(575, 525, 200, 50);

		statusLabelAdresseNum.setBounds(50, 200, 200, 20);
		statusLabelAdresseRue.setBounds(50, 250, 200, 20);
		statusLabelAdresseCp.setBounds(50, 300, 200, 20);
		statusLabelAdresseVille.setBounds(50, 350, 200, 20);
		statusLabelKm.setBounds(500, 200, 200, 20);

		zoneTextAdresseNum.setBounds(175, 200, 200, 20);
		zoneTextAdresseRue.setBounds(175, 250, 200, 20);
		zoneTextAdresseCp.setBounds(175, 300, 200, 20);
		zoneTextAdresseVille.setBounds(175, 350, 200, 20);
		zoneTextKm.setBounds(625, 200, 200, 20);

		// zoneTextAdresseNum.setPreferredSize(new Dimension(200, 20));
		// zoneTextAdresseRue.setPreferredSize(new Dimension(200, 20));
		// zoneTextAdresseCp.setPreferredSize(new Dimension(200, 20));
		// zoneTextAdresseVille.setPreferredSize(new Dimension(200, 20));

		boutonSetEmp.setForeground(Color.BLACK);
		boutonSetEmp.setBackground(Color.WHITE);
		boutonSetEx.setForeground(Color.BLACK);
		boutonSetEx.setBackground(Color.WHITE);
		boutonRetour.setForeground(Color.BLACK);
		boutonRetour.setBackground(Color.WHITE);
		Border line = new LineBorder(Color.BLACK);
		Border margin = new EmptyBorder(5, 15, 5, 15);
		Border compound = new CompoundBorder(line, margin);
		boutonSetEmp.setBorder(compound);
		boutonSetEx.setBorder(compound);
		boutonRetour.setBorder(compound);

		boutonSetEmp.addActionListener(a);
		boutonSetEx.addActionListener(a);
		boutonRetour.addActionListener(a);

		contentPane.add(panel1);
		contentPane.add(boutonSetEmp);
		contentPane.add(panel2);
		contentPane.add(boutonSetEx);
		contentPane.add(boutonRetour);
		contentPane.add(statusLabelAdresseNum);
		contentPane.add(statusLabelAdresseRue);
		contentPane.add(statusLabelAdresseCp);
		contentPane.add(statusLabelAdresseVille);
		contentPane.add(statusLabelKm);
		contentPane.add(zoneTextAdresseNum);
		contentPane.add(zoneTextAdresseRue);
		contentPane.add(zoneTextAdresseCp);
		contentPane.add(zoneTextAdresseVille);
		contentPane.add(zoneTextKm);

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
			if (event.getSource() == boutonSetEmp) {
				try {
					adre = new Adresse(Integer.parseInt(zoneTextAdresseNum.getText()), zoneTextAdresseRue.getText(),
							Integer.parseInt(zoneTextAdresseCp.getText()), zoneTextAdresseVille.getText());
					emprunteurs.modifier(emp.get(emprunteursList.getSelectedIndex()), adre);
					fermer();
				} catch (Exception e) {
					statusLabelErreurSaisie.setText("Erreur de saisie");
					statusLabelErreurSaisie.setForeground(Color.RED);
				}

			} else if (event.getSource() == boutonSetEx) {
				try {
					try {
						exemplaires.modifier(vNormal.get(exemplairesList.getSelectedIndex()),
								Double.parseDouble(zoneTextKm.getText()));
					} catch (RuntimeException e) {
						// TODO: handle exception
					}
					try {
						exemplaires.modifier(vLuxe.get(exemplairesList.getSelectedIndex()),
								Double.parseDouble(zoneTextKm.getText()));
					} catch (RuntimeException e) {
						// TODO: handle exception
					}
					try {
						exemplaires.modifier(moto.get(exemplairesList.getSelectedIndex()),
								Double.parseDouble(zoneTextKm.getText()));
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
