package AD;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entite.Atelier;
import entite.Enfant;

public class AtelierDAOMock implements AtelierDAO {

	@Override
	public void insert(Atelier atelier) throws DAOException {
		System.out.println("et hop un Atelier ajout� � la base de donn�es");

	}

	@Override
	public List<Atelier> selectAll() throws DAOException {
		SimpleDateFormat sdf = new SimpleDateFormat();
		List<Atelier> listeAtelier = new ArrayList<Atelier>();
		listeAtelier.add(new Atelier());
		System.out.println("voici la liste d'atelier");
		return listeAtelier;
	}

	@Override
	public void supprimer(Atelier atelier) throws DAOException {
		System.out.println("et hop, un atelier supprim� de la base de donn�es");

	}

}
