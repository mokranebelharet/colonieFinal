package presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import AD.AtelierDAOImpl;
import AD.DAOException;
import AD.EnfantDAOImpl;
import entite.Atelier;
import entite.Enfant;

public class ExecAdrien {

	public static void main(String[] args) throws ParseException, DAOException {

		EnfantDAOImpl.getInstance().insert(new Enfant());
		EnfantDAOImpl.getInstance().selectAll();
		AtelierDAOImpl.getInstance().insert(new Atelier());
		AtelierDAOImpl.getInstance().selectAll();
	}
}
