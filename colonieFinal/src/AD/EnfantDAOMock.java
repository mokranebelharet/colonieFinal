package AD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entite.Enfant;

public class EnfantDAOMock implements EnfantDAO {

	@Override
	public void insert(Enfant enfant) throws DAOException {
		System.out.println("Et Hop un enfant ajouté à la base de données");

	}

	@Override
	public List<Enfant> selectAll() throws DAOException {
		System.out.println("selection enfants");
		return null;
	}

	@Override
	public void supprimer(Enfant enfant) throws DAOException {
		System.out.println("et hop un enfant supprimer de la base de données");

	}

}