package metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import AD.AtelierDAOImpl;
import AD.DAOException;
import AD.EnfantDAOImpl;
import entite.Atelier;
import entite.Enfant;

public class AtelierServiceImpl implements AtelierService {

	// singleton //////////////////////////////////////////////////////
	private static AtelierService instance = null;

	private AtelierServiceImpl() {
	}

	public static synchronized AtelierService getInstance() {
		if (instance == null) {
			instance = new AtelierServiceImpl();
		}
		return instance;
	} //////////////////////////////////////////////////////////////////

	// @Override

	public void ajoutEnfant(Enfant enfant) throws AtelierServiceException {
		try {
			EnfantDAOImpl.getInstance().insert(enfant);
		} catch (DAOException e) {
			throw new AtelierServiceException("Erreur lors de l'ajout d'un enfant");
		}
	}

	@Override
	public void ajoutAtelier(Atelier atelier) throws AtelierServiceException {
		try {
			AtelierDAOImpl.getInstance().insert(atelier);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new AtelierServiceException("Erreur lors de l'ajout d'un enfant");
		}
	}

	@Override
	public List<Enfant> getListEnfant() throws AtelierServiceException {
		List<Enfant> lst = null;
		try {
			lst = EnfantDAOImpl.getInstance().selectAll();
		} catch (DAOException e) {
			throw new AtelierServiceException("Erreur lors de la récupération de la liste des Enfants");
		}
		return lst;
	}

	@Override
	public List<Atelier> getListAtelier() throws AtelierServiceException {
		List<Atelier> lst = new ArrayList<Atelier>();
		try {
			lst = AtelierDAOImpl.getInstance().selectAll();

		} catch (DAOException e) {
			e.printStackTrace();
			throw new AtelierServiceException("Erreur lors de la récupération de la liste des Enfants");
		}
		return lst;
	}

	/*
	 * @Override public Integer ageMoyenAtelier() { // TODO Auto-generated
	 * method stub return null; }
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

	}/*
		 * // @Override // public Integer ageMoyenAtelier() { // Integer
		 * sommeAge = 0; // for (Enfant element : ((((((blabla))))))) { //
		 * sommeAge = sommeAge + element.getAge(); // } // Integer
		 * moyenneAgeAtelier = sommeAge / ((((blabla)))).size(); // }
		 * 
		 * @Override public List<Enfant> getListEnfantDansAtelier() throws
		 * AtelierServiceException { List<Enfant> enfantDansAtelier = new
		 * ArrayList<Enfant>();
		 * 
		 * return null; }
		 */
}