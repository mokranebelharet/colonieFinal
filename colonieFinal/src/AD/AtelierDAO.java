package AD;

import java.util.List;

import entite.Atelier;

public interface AtelierDAO {
	public void insert(Atelier atelier) throws DAOException;

	public List<Atelier> selectAll() throws DAOException;

	public void supprimer(Atelier atelier) throws DAOException;

}
