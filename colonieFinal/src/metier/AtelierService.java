package metier;

import java.util.Date;
import java.util.List;

import entite.Atelier;
import entite.Enfant;

public interface AtelierService {

	/**
	 * Permet d'ajouter des enfants a la base de donnees
	 * 
	 * @param enf
	 *            : enfant ajouté
	 * @throws AtelierServiceException
	 */
	void ajoutEnfant(Enfant enf) throws AtelierServiceException;

	/**
	 * Permet d'ajouter des ateliers a la base de donnees
	 * 
	 * @param at
	 *            : atelier ajouté
	 * @throws AtelierServiceException
	 */
	void ajoutAtelier(Atelier at) throws AtelierServiceException;

	/**
	 * Permet de retourner la liste de tous les enfants de la base de donnees
	 * 
	 * @return liste des enfants
	 * @throws AtelierServiceException
	 */
	List<Enfant> getListEnfant() throws AtelierServiceException;

	/**
	 * Permet de retourner la liste de tous les ateliers de la base de donnees
	 * 
	 * @return liste des ateliers
	 * @throws AtelierServiceException
	 */
	List<Atelier> getListAtelier() throws AtelierServiceException;

	/**
	 * Permet a l'utilisateur de supprimer un enfant de la colonie
	 * 
	 * @param enf
	 *            : enfant qui va etre supprimé
	 * @throws AtelierServiceException
	 */
	Integer supprimerEnfant(Enfant enf) throws AtelierServiceException;

	/**
	 * Permet a l'utilisateur de supprimer un atelier de la colonie
	 * 
	 * @param at
	 *            : atelier qui va etre supprimé
	 * @throws AtelierServiceException
	 */
	Integer supprimerAtelier(Atelier at) throws AtelierServiceException;

	// Integer ageMoyenAtelier();

	// List<Enfant> getListEnfantDansAtelier() throws AtelierServiceException;

	Date convertDdn(String ddn);
}
