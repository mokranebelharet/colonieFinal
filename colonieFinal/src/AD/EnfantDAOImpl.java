package AD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entite.Atelier;
import entite.Enfant;
import metier.AtelierServiceImpl;

public class EnfantDAOImpl extends DAO implements EnfantDAO {
	// Singleton
	private static EnfantDAO instance = null;

	private EnfantDAOImpl() {

	}

	public static synchronized EnfantDAO getInstance() {
		if (instance == null) {
			instance = new EnfantDAOImpl();
		}
		return instance;
	}

	@Override
	public void insert(Enfant enfant) throws DAOException {
		Connection con = getConnection();
		ResultSet rs = null;

		// creation et execution de la requete
		String requete = "INSERT INTO enfant (nomEnfant, prenomEnfant, ddnEnfant) " + "VALUES (?,?,?)";
		PreparedStatement stmt = null;
		SimpleDateFormat sdf = new SimpleDateFormat();
		try {
			stmt = con.prepareStatement(requete);
			stmt.setString(1, enfant.getNomEnfant());
			stmt.setString(2, enfant.getPrenomEnfant());
			stmt.setString(3, sdf.format(enfant.getDdnEnfant()));
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Problème dans votre requète SQL");
		}

		closeConnection();

	}

	@Override
	public List<Enfant> selectAll() throws DAOException {


		List<Enfant> listEnfant = new ArrayList<Enfant>();

		Connection con = getConnection();
		ResultSet rs = null;

		// creation et execution de la requete
		String requete = "SELECT * FROM enfant";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(requete);
		} catch (SQLException e) {
			throw new DAOException("Problème dans votre requète SQL");
		}

		// parcours du résultat
		try {
			while (rs.next()) {
				Enfant c = new Enfant();
				c.setId(rs.getInt("id"));
				c.setNomEnfant(rs.getString("nomEnfant"));
				c.setPrenomEnfant(rs.getString("prenomEnfant"));
				c.setDdnEnfant(AtelierServiceImpl.getInstance().convertDdn(rs.getString("ddnEnfant")));
				
				listEnfant.add(c);
			}
		} catch (SQLException e) {
			throw new DAOException("Problème dans l'extraction du résultat");
		}

		closeConnection();

		return listEnfant;

	
		
	}

	@Override
	public void supprimer(Enfant enfant) throws DAOException {

	}

}
