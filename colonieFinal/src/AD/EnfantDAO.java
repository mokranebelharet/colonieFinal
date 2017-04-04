package AD;

import java.util.List;

import entite.Enfant;

public interface EnfantDAO {
	public void insert(Enfant enfant) throws DAOException;

	public List<Enfant> selectAll() throws DAOException;

	public void supprimer(Enfant enfant) throws DAOException;

}