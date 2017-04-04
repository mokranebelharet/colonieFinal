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
import metier.AtelierServiceImpl;

public class AtelierDAOImpl extends DAO implements AtelierDAO {

	// Singleton
	private static AtelierDAO instance = null;

	private AtelierDAOImpl() {

	}

	public static synchronized AtelierDAO getInstance() {
		if (instance == null) {
			instance = new AtelierDAOImpl();
		}
		return instance;
	}

	@Override
	public void insert(Atelier atelier) throws DAOException {

		Connection con = getConnection();
		ResultSet rs = null;

		// creation et execution de la requete
		String requete = "INSERT INTO atelier (nbMaxEnfant, nomAtelier, dateDebut, dateFin, ageLimite) "
				+ "VALUES (?,?,?,?,?)";
		PreparedStatement stmt = null;
		SimpleDateFormat sdf = new SimpleDateFormat();
		try {
			stmt = con.prepareStatement(requete);
			stmt.setInt(1, atelier.getNbMaxEnfant());
			stmt.setString(2, atelier.getNomAtelier());
			stmt.setString(3, sdf.format(atelier.getDateDebut()));
			stmt.setString(4, sdf.format(atelier.getDateFin()));
			stmt.setInt(5, atelier.getAgeLimite());
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Problème dans votre requète SQL");
		}

		closeConnection();
	}

	@Override
	public List<Atelier> selectAll() throws DAOException {
		List<Atelier> listAtelier = new ArrayList<Atelier>();

		Connection con = getConnection();
		ResultSet rs = null;

		// creation et execution de la requete
		String requete = "SELECT * FROM atelier";
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
				Atelier c = new Atelier();
				c.setNumAtelier(rs.getInt("numAtelier"));
				c.setNbMaxEnfant(rs.getInt("nbMaxEnfant"));
				c.setNomAtelier(rs.getString("nomAtelier"));
				c.setDateDebut(AtelierServiceImpl.getInstance().convertDdn(rs.getString("dateDebut")));
				c.setDateFin(AtelierServiceImpl.getInstance().convertDdn(rs.getString("dateFin")));
				c.setAgeLimite(rs.getInt("ageLimite"));
				listAtelier.add(c);
			}
		} catch (SQLException e) {
			throw new DAOException("Problème dans l'extraction du résultat");
		}

		closeConnection();

		return listAtelier;

	}

	@Override
	public void supprimer(Atelier atelier) throws DAOException {

	}

}
