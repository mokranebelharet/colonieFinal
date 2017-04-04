package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.metal.MetalButtonUI;

import entite.Atelier;
import entite.Enfant;
import metier.AtelierServiceException;
import metier.AtelierServiceImpl;

public class Fenetre extends JFrame implements ActionListener {
	JLabel slogan = new JLabel("Colonie : le logiciel de gestion ");
	Font font = new Font("kokonor", Font.BOLD, 24);

	JButton boutonAtelier = new JButton("Ajouter");
	JButton boutonEnfant = new JButton("Ajouter");
	JButton boutonListAtelier = new JButton("Lister ");
	JButton boutonListEnfant = new JButton(" Lister");
	JButton boutonGerAtelier = new JButton("Gérer");
	JButton boutonGerEnfant = new JButton("Gérer");

	public Fenetre() {
		super();

		slogan.setFont(font);

		boutonAtelier.setPreferredSize(new Dimension(150, 50));
		boutonEnfant.setPreferredSize(new Dimension(150, 50));
		boutonListAtelier.setPreferredSize(new Dimension(150, 50));
		boutonListEnfant.setPreferredSize(new Dimension(150, 50));
		boutonGerAtelier.setPreferredSize(new Dimension(150, 50));
		boutonGerEnfant.setPreferredSize(new Dimension(150, 50));

		JPanel content = new JPanel();
		content.setPreferredSize(new Dimension(250, 200));
		content.setBorder(BorderFactory.createTitledBorder("Atelier"));
		content.add(boutonAtelier);
		content.add(boutonListAtelier);
		content.add(boutonGerAtelier);

		JPanel content2 = new JPanel();
		content2.setPreferredSize(new Dimension(250, 200));
		content2.setBorder(BorderFactory.createTitledBorder("Enfant"));
		content2.add(boutonEnfant);
		content2.add(boutonListEnfant);
		content2.add(boutonGerEnfant);

		JPanel content3 = new JPanel();
		content3.setPreferredSize(new Dimension(450, 50));
		content3.add(slogan);

		this.setTitle("Colonie");
		this.setSize(600, 300);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		// La boÃ®te ne devra pas Ãªtre redimensionnable
		// this.setResizable(false);
		this.setVisible(true);

		this.getContentPane().setLayout(new FlowLayout());

		// this.add(boutonAtelier);
		// this.add(boutonEnfant);
		this.getContentPane().add(content3, BorderLayout.CENTER);
		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(content2, BorderLayout.CENTER);

		boutonAtelier.addActionListener(this);
		boutonEnfant.addActionListener(this);
		boutonListAtelier.addActionListener(this);
		boutonListEnfant.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AjoutAtelier atelier;
		AjoutEnfant enfant;
		List<Atelier> liste = new ArrayList<Atelier>();
		List<Enfant> listEnf = new ArrayList<Enfant>();
		if (e.getSource().equals(boutonAtelier))
			atelier = new AjoutAtelier();
		else if (e.getSource().equals(boutonEnfant))
			enfant = new AjoutEnfant();
		else if (e.getSource().equals(boutonListAtelier))
			try {
				liste = AtelierServiceImpl.getInstance().getListAtelier();
				for (Atelier elt : liste) {
					System.out.println(elt.getNomAtelier());
				}
			} catch (AtelierServiceException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		else if (e.getSource().equals(boutonListEnfant))
			try {
				listEnf = AtelierServiceImpl.getInstance().getListEnfant();
				for (Enfant elt : listEnf) {
					System.out.println(elt.getNomEnfant() + " " +elt.getPrenomEnfant());
				}
			} catch (AtelierServiceException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		

	}

}
