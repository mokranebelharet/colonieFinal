package metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entite.Atelier;
import entite.Enfant;

public class AtelierServiceMock implements AtelierService {

	List<Enfant> listeEnfantVide = new ArrayList<Enfant>();
	List<Atelier> listeAtelierVide = new ArrayList<Atelier>();
	List<Enfant> listeEnfantDansAtelierVide = new ArrayList<Enfant>();

	@Override
	public void ajoutEnfant(Enfant enf) {
		System.out.println("Enfant ajouté !");
	}

	@Override
	public void ajoutAtelier(Atelier at) {
		System.out.println("Atelier ajouté !");
	}

	@Override
	public List<Enfant> getListEnfant() throws AtelierServiceException {
		System.out.println("Voici la liste des enfants");
		return listeEnfantVide;
	}

	@Override
	public List<Atelier> getListAtelier() throws AtelierServiceException {
		System.out.println("Voici la liste des ateliers");
		return listeAtelierVide;
	}

	@Override
	public Integer supprimerEnfant(Enfant enf) throws AtelierServiceException {
		System.out.println("Enfant retiré de la colonie !");
		return 2;
	}

	@Override
	public Integer supprimerAtelier(Atelier at) throws AtelierServiceException {
		System.out.println("Atelier retiré de la colonie !");
		return 1;
	}

	/*
	 * @Override public Integer ageMoyenAtelier() { Integer ageMoyenAtelierMock
	 * = 3; return ageMoyenAtelierMock; }
	 */
	/*
	 * @Override public List<Enfant> getListEnfantDansAtelier() throws
	 * AtelierServiceException {
	 * System.out.println("Voici la liste des enfants présent dans l'atelier !"
	 * ); return listeEnfantDansAtelierVide; }
	 */
	public Date convertDdn(String ddn) {
		Date d = new Date();
		try {
			d = new SimpleDateFormat("dd/mm/yyyy").parse(ddn);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;

	}

}
