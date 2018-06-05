package Graphiques;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class FenetreAccueil extends JFrame {
	private String nomFenetre = "Accueil";
	private int largeur = 600, longueur = 400;
	private Font f;

	private JLabel statusLabelMessage;
	private JButton boutonInscription;
	private JButton boutonLocationAuto;
	private JButton boutonLocationAutoLuxe;
	private JButton boutonLocationMoto;
	private JButton boutonRetournerVehicule;
	private JButton boutonModification;
	private JButton boutonSuppression;
	private Container contentPane;

	private FenetreInscription fLoc;
	private FenetreModification fMod;
	private FenetreSuppression fSup;
	private FenetreLocAuto fAuto;
	private FenetreLocAutoLuxe fAutoLuxe;
	private FenetreLocMoto fMoto;
	private FenetreRetournerLocation fRetourner;

	public FenetreAccueil() {
		super();
	}

	public void lancer() {
		this.setTitle(nomFenetre);
		this.setSize(largeur, longueur);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);

		f = new Font("ARIAL", Font.BOLD, 20);

		contentPane = getContentPane();

		statusLabelMessage = new JLabel();
		Action a = new Action();

		boutonInscription = new JButton("Inscription");
		boutonModification = new JButton("Modifications");
		boutonSuppression = new JButton("Suppressions");
		boutonLocationAuto = new JButton("Louer une voiture");
		boutonLocationAutoLuxe = new JButton("Louer une voiture de Luxe");
		boutonLocationMoto = new JButton("Louer une Moto");
		boutonRetournerVehicule = new JButton("Retourner un véhicule");

		statusLabelMessage.setBounds(50, 25, 200, 100);
		statusLabelMessage
				.setText("<html><body>Bienvenue sur <p>" + "notre platforme de <p>" + "réservation</body></html>");
		statusLabelMessage.setFont(f);

		boutonInscription.setFont(f);
		boutonInscription.addActionListener(a);
		boutonInscription.setBounds(50, 150, 200, 50);
		

		boutonModification.addActionListener(a);
		boutonModification.setBounds(50, 210, 200, 50);
		
		boutonSuppression.addActionListener(a);
		boutonSuppression.setBounds(50, 270, 200, 50);

		boutonLocationAuto.addActionListener(a);
		boutonLocationAuto.setBounds(350, 25, 200, 50);

		boutonLocationAutoLuxe.addActionListener(a);
		boutonLocationAutoLuxe.setBounds(350, 100, 200, 50);

		boutonLocationMoto.addActionListener(a);
		boutonLocationMoto.setBounds(350, 175, 200, 50);

		boutonRetournerVehicule.addActionListener(a);
		boutonRetournerVehicule.setBounds(350, 250, 200, 50);

		contentPane.add(statusLabelMessage);
		contentPane.add(boutonInscription);
		contentPane.add(boutonModification);
		contentPane.add(boutonSuppression);
		contentPane.add(boutonLocationAuto);
		contentPane.add(boutonLocationAutoLuxe);
		contentPane.add(boutonLocationMoto);
		contentPane.add(boutonRetournerVehicule);

		boutonInscription.setForeground(Color.BLACK);
		boutonInscription.setBackground(Color.WHITE);
		boutonModification.setForeground(Color.BLACK);
		boutonModification.setBackground(Color.WHITE);
		boutonSuppression.setForeground(Color.BLACK);
		boutonSuppression.setBackground(Color.WHITE);
		boutonLocationAuto.setForeground(Color.BLACK);
		boutonLocationAuto.setBackground(Color.WHITE);
		boutonLocationAutoLuxe.setForeground(Color.BLACK);
		boutonLocationAutoLuxe.setBackground(Color.WHITE);
		boutonLocationMoto.setForeground(Color.BLACK);
		boutonLocationMoto.setBackground(Color.WHITE);
		boutonRetournerVehicule.setForeground(Color.BLACK);
		boutonRetournerVehicule.setBackground(Color.WHITE);
		Border line = new LineBorder(Color.BLACK);
		Border margin = new EmptyBorder(5, 15, 5, 15);
		Border compound = new CompoundBorder(line, margin);
		boutonInscription.setBorder(compound);
		boutonModification.setBorder(compound);
		boutonSuppression.setBorder(compound);
		boutonLocationAuto.setBorder(compound);
		boutonLocationAutoLuxe.setBorder(compound);
		boutonLocationMoto.setBorder(compound);
		boutonRetournerVehicule.setBorder(compound);

		// Nous demandons maintenant à notre objet de se positionner au centre
		this.setLocationRelativeTo(null);
		// Termine le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Et enfin, la rendre visible
		this.setVisible(true);
	}

	public void fermer() {
		this.dispose();
	}

	class Action extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == boutonLocationAuto) {
				fAuto = new FenetreLocAuto();
				fAuto.lancer();
			} else if (event.getSource() == boutonInscription) {
				fLoc = new FenetreInscription();
				fLoc.lancer();
			} else if (event.getSource() == boutonModification) {
				fMod = new FenetreModification();
				fMod.lancer();
			} else if (event.getSource() == boutonSuppression) {
				fSup = new FenetreSuppression();
				fSup.lancer();
			} else if (event.getSource() == boutonLocationAutoLuxe) {
				fAutoLuxe = new FenetreLocAutoLuxe();
				fAutoLuxe.lancer();
			} else if (event.getSource() == boutonLocationMoto) {
				fMoto = new FenetreLocMoto();
				fMoto.lancer();
			} else if (event.getSource() == boutonRetournerVehicule) {
				fRetourner = new FenetreRetournerLocation();
				fRetourner.lancer();
			}

		}
	}

}
