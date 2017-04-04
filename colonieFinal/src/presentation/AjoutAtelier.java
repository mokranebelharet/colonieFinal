package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entite.Atelier;
import metier.AtelierServiceException;
import metier.AtelierServiceImpl;

public class AjoutAtelier extends JDialog implements ActionListener {

	Font font = new Font("Arial", Font.BOLD, 14);

	JButton bouton = new JButton("Créer");

	Integer[] liste = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
	JComboBox jc = new JComboBox(liste);

	JTextField answerNom, answerDateDebut, answerDateFin, answerNbMax, answerAgeMax;

	public AjoutAtelier() {

		// le nom:
		JPanel panNom = new JPanel();
		// panNom.setBackground(Color.white);
		panNom.setPreferredSize(new Dimension(220, 60));
		answerNom = new JTextField();
		answerNom.setPreferredSize(new Dimension(150, 25));
		answerNom.setBackground(Color.YELLOW);
		panNom.setBorder(BorderFactory.createTitledBorder("Nom "));
		panNom.add(answerNom);

		// date de dÃ©but:
		JPanel panDateDebut = new JPanel();
		// panDateDebut.setBackground(Color.white);
		panDateDebut.setPreferredSize(new Dimension(220, 60));
		answerDateDebut = new JTextField();
		answerDateDebut.setPreferredSize(new Dimension(150, 25));
		answerDateDebut.setBackground(Color.YELLOW);
		panDateDebut.setBorder(BorderFactory.createTitledBorder("Date de début"));
		panDateDebut.add(answerDateDebut);

		// date de fin:
		JPanel panDateFin = new JPanel();
		// panDateFin.setBackground(Color.white);
		panDateFin.setPreferredSize(new Dimension(220, 60));
		answerDateFin = new JTextField();
		answerDateFin.setPreferredSize(new Dimension(150, 25));
		answerDateFin.setBackground(Color.YELLOW);
		panDateFin.setBorder(BorderFactory.createTitledBorder("Date de fin"));
		panDateFin.add(answerDateFin);

		// Nombre maximal de places:
		JPanel panNbMax = new JPanel();
		// panNbMax.setBackground(Color.white);
		panNbMax.setPreferredSize(new Dimension(220, 60));
		answerNbMax = new JTextField();
		answerNbMax.setPreferredSize(new Dimension(150, 25));
		answerNbMax.setBackground(Color.YELLOW);
		panNbMax.setBorder(BorderFactory.createTitledBorder("Nombre maximal de place"));
		panNbMax.add(answerNbMax);

		// Age max:
		JPanel panAgeMax = new JPanel();
		// panAgeMax.setBackground(Color.white);
		panAgeMax.setPreferredSize(new Dimension(220, 60));
		answerAgeMax = new JTextField();
		panAgeMax.setBorder(BorderFactory.createTitledBorder("Sélectionnez un âge maximal"));
		panAgeMax.add(jc);

		this.setTitle("Nouvel Atelier");
		this.setSize(550, 300);
		// this.setDefaultCloseOperation(3);
		// this.setResizable(false);
		this.setVisible(true);

		this.getContentPane().setLayout(new FlowLayout());

		JPanel content = new JPanel();
		content.setPreferredSize(new Dimension(450, 200));
		content.add(bouton);

		this.getContentPane().add(panNom, BorderLayout.CENTER);
		this.getContentPane().add(panDateDebut, BorderLayout.CENTER);
		this.getContentPane().add(panDateFin, BorderLayout.CENTER);
		this.getContentPane().add(panNbMax, BorderLayout.CENTER);
		this.getContentPane().add(panAgeMax, BorderLayout.CENTER);
		this.getContentPane().add(content, BorderLayout.SOUTH);

		bouton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String nom = answerNom.getText();
		Date dateDebut = AtelierServiceImpl.getInstance().convertDdn(answerDateDebut.getText());
		Date dateFin = AtelierServiceImpl.getInstance().convertDdn(answerDateFin.getText());
		Integer nbMax = Integer.parseInt(answerNbMax.getText());
		Integer ageLim = (int) (jc.getSelectedItem());

		try {
			AtelierServiceImpl.getInstance().ajoutAtelier(new Atelier(nbMax, nom, dateDebut, dateFin, ageLim));
		} catch (AtelierServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		this.setVisible(false);

	}

}
