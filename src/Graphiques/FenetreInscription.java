package Graphiques;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Autres.Adresse;
import Autres.Emprunteur;
import Conteneurs.Emprunteurs;
import Graphiques.FenetreAccueil.Action;

public class FenetreInscription extends JFrame {
	private String nomFenetre = "Inscription utilisateur";
	private int largeur = 600, longueur = 500;
	private Font f;

	private JButton boutonInscrire;
	private JButton boutonRetour;
	private JLabel statusLabelPrenom;
	private JLabel statusLabelNom;
	private JLabel statusLabelAdresseNum;
	private JLabel statusLabelAdresseRue;
	private JLabel statusLabelAdresseCp;
	private JLabel statusLabelAdresseVille;
	private JLabel statusLabelErreurSaisie;
	private JTextField zoneTextPrenom;
	private JTextField zoneTextNom;
	private JTextField zoneTextAdresseNum;
	private JTextField zoneTextAdresseRue;
	private JTextField zoneTextAdresseCp;
	private JTextField zoneTextAdresseVille;
	private JPanel PanelPrenom;
	private JPanel PanelNom;
	private JPanel PanelAdresseNum;
	private JPanel PanelAdresseRue;
	private JPanel PanelAdresseCp;
	private JPanel PanelAdresseVille;
	private JPanel PanelBouton;
	private JPanel PanelErreurSaisie;

	private GridLayout gl;

	private Action a;
	private FenetreAccueil fMenu;
	private Adresse adre;
	private Emprunteur emp;
	private Container contentPane;

	public void lancer() {
		this.setTitle(nomFenetre);
		this.setSize(largeur, longueur);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		f = new Font("ARIAL", Font.BOLD, 20);

		contentPane = getContentPane();

		statusLabelPrenom = new JLabel("Votre prénom");
		statusLabelNom = new JLabel("Votre Nom");
		statusLabelAdresseNum = new JLabel("Numéro de rue");
		statusLabelAdresseRue = new JLabel("Nom de rue");
		statusLabelAdresseCp = new JLabel("Code postal");
		statusLabelAdresseVille = new JLabel("     Ville     ");
		statusLabelErreurSaisie = new JLabel("");

		zoneTextPrenom = new JTextField();
		zoneTextNom = new JTextField();
		zoneTextAdresseNum = new JTextField();
		zoneTextAdresseRue = new JTextField();
		zoneTextAdresseCp = new JTextField();
		zoneTextAdresseVille = new JTextField();

		zoneTextNom.setPreferredSize(new Dimension(200, 20));
		zoneTextPrenom.setPreferredSize(new Dimension(200, 20));
		zoneTextAdresseNum.setPreferredSize(new Dimension(200, 20));
		zoneTextAdresseRue.setPreferredSize(new Dimension(200, 20));
		zoneTextAdresseCp.setPreferredSize(new Dimension(200, 20));
		zoneTextAdresseVille.setPreferredSize(new Dimension(200, 20));

		PanelPrenom = new JPanel();
		PanelNom = new JPanel();
		PanelAdresseNum = new JPanel();
		PanelAdresseRue = new JPanel();
		PanelAdresseCp = new JPanel();
		PanelAdresseVille = new JPanel();
		PanelBouton = new JPanel();
		PanelErreurSaisie = new JPanel();

		boutonInscrire = new JButton("S'inscrire");
		boutonRetour = new JButton("Retour");
		a = new Action();

		statusLabelPrenom.setFont(f);
		PanelPrenom.add(statusLabelPrenom);
		PanelPrenom.add(zoneTextPrenom);
		contentPane.add(PanelPrenom);

		statusLabelNom.setFont(f);
		PanelNom.add(statusLabelNom);
		PanelNom.add(zoneTextNom);
		contentPane.add(PanelNom);

		statusLabelAdresseNum.setFont(f);
		PanelAdresseNum.add(statusLabelAdresseNum);
		PanelAdresseNum.add(zoneTextAdresseNum);
		contentPane.add(PanelAdresseNum);

		statusLabelAdresseRue.setFont(f);
		PanelAdresseRue.add(statusLabelAdresseRue);
		PanelAdresseRue.add(zoneTextAdresseRue);
		contentPane.add(PanelAdresseRue);

		statusLabelAdresseCp.setFont(f);
		PanelAdresseCp.add(statusLabelAdresseCp);
		PanelAdresseCp.add(zoneTextAdresseCp);
		contentPane.add(PanelAdresseCp);

		statusLabelAdresseVille.setFont(f);
		PanelAdresseVille.add(statusLabelAdresseVille);
		PanelAdresseVille.add(zoneTextAdresseVille);
		contentPane.add(PanelAdresseVille);

		boutonInscrire.setForeground(Color.BLACK);
		boutonInscrire.setBackground(Color.WHITE);
		boutonRetour.setForeground(Color.BLACK);
		boutonRetour.setBackground(Color.WHITE);
		Border line = new LineBorder(Color.BLACK);
		Border margin = new EmptyBorder(5, 15, 5, 15);
		Border compound = new CompoundBorder(line, margin);
		boutonInscrire.setBorder(compound);
		boutonRetour.setBorder(compound);

		boutonInscrire.addActionListener(a);
		boutonRetour.addActionListener(a);
		PanelBouton.add(boutonInscrire);
		PanelBouton.add(boutonRetour);
		contentPane.add(PanelBouton);

		PanelErreurSaisie.add(statusLabelErreurSaisie);
		contentPane.add(PanelErreurSaisie);

		gl = new GridLayout(4, 2);
		this.setLayout(gl);

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
			if (event.getSource() == boutonInscrire) {
				try {
					adre = new Adresse(Integer.parseInt(zoneTextAdresseNum.getText()), zoneTextAdresseRue.getText(),
							Integer.parseInt(zoneTextAdresseCp.getText()), zoneTextAdresseVille.getText());
					emp = new Emprunteur(zoneTextNom.getText(), zoneTextPrenom.getText(), adre);
					Emprunteurs.sauvegarder();
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
