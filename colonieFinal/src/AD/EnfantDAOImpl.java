package AD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import entite.Enfant;

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

		return null;
	}

	@Override
	public void supprimer(Enfant enfant) throws DAOException {

	}

}
