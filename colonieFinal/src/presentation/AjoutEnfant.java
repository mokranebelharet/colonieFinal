package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entite.Enfant;
import metier.AtelierServiceException;
import metier.AtelierServiceImpl;

public class AjoutEnfant extends JDialog implements ActionListener {

	JLabel ajouterAtelier = new JLabel("Sélectionnez un atelier :");

	Font font = new Font("Arial", Font.BOLD, 14);

	// List<Atelier> liste = new ArrayList<Atelier>();
	String[] liste = { "Atelier1", "Atelier2", "Atelier3" };
	JComboBox jc = new JComboBox(liste);

	JButton bouton = new JButton("Ajouter");

	JTextField answerNom, answerPrenom, answerDdn;

	public AjoutEnfant() {

		JPanel panAtelier = new JPanel();
		// panAgeMax.setBackground(Color.white);
		panAtelier.setPreferredSize(new Dimension(220, 60));
		JTextField answerAtelier = new JTextField();

		panAtelier.setBorder(BorderFactory.createTitledBorder("Choisissez un atelier"));
		panAtelier.add(jc);

		// le nom:
		JPanel panNom = new JPanel();
		// panNom.setBackground(Color.white);
		panNom.setPreferredSize(new Dimension(220, 60));
		answerNom = new JTextField();
		answerNom.setPreferredSize(new Dimension(150, 25));
		answerNom.setBackground(Color.YELLOW);
		panNom.setBorder(BorderFactory.createTitledBorder("Nom de l'enfant"));
		panNom.add(answerNom);

		// le prÃ©nom:
		JPanel panPrenom = new JPanel();
		// panNom.setBackground(Color.white);
		panPrenom.setPreferredSize(new Dimension(220, 60));
		answerPrenom = new JTextField();
		answerPrenom.setPreferredSize(new Dimension(150, 25));
		answerPrenom.setBackground(Color.YELLOW);
		panPrenom.setBorder(BorderFactory.createTitledBorder("Prénom de l'enfant"));
		panPrenom.add(answerPrenom);

		// la date de naissance:
		JPanel panDdn = new JPanel();
		// panNom.setBackground(Color.white);
		panDdn.setPreferredSize(new Dimension(220, 60));
		answerDdn = new JTextField();
		answerDdn.setPreferredSize(new Dimension(150, 25));
		answerDdn.setBackground(Color.YELLOW);
		panDdn.setBorder(BorderFactory.createTitledBorder("Date de naissance "));
		panDdn.add(answerDdn);

		this.setTitle("Ajouter un enfant");
		this.setSize(300, 350);
		// this.setDefaultCloseOperation(3);
		// this.setResizable(false);
		this.setVisible(true);

		this.getContentPane().setLayout(new FlowLayout());

		JPanel content = new JPanel();
		content.setPreferredSize(new Dimension(450, 200));
		content.add(bouton);

		JPanel content2 = new JPanel();
		content2.setPreferredSize(new Dimension(450, 200));
		content2.add(panAtelier);

		this.getContentPane().add(panAtelier, BorderLayout.CENTER);
		this.getContentPane().add(panNom, BorderLayout.CENTER);
		this.getContentPane().add(panPrenom, BorderLayout.CENTER);
		this.getContentPane().add(panDdn, BorderLayout.CENTER);

		this.getContentPane().add(content, BorderLayout.SOUTH);

		bouton.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		String nom = answerNom.getText();
		String prenom = answerPrenom.getText();
		Date ddn = AtelierServiceImpl.getInstance().convertDdn(answerDdn.getText());
		// Integer nbMax = Integer.parseInt(answerNbMax.getText());
		// Integer ageLim = (int)(jc.getSelectedItem());

		try {
			AtelierServiceImpl.getInstance().ajoutEnfant(new Enfant(nom, prenom, ddn));
		} catch (AtelierServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		this.setVisible(false);

	}

}
