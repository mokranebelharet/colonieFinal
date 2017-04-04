package AD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private Connection con = null;

	protected Connection getConnection() throws DAOException {
		// chargement du pilote
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new DAOException("Probl�me de driver");
		}
		// connection a la base de donn�es
		try {
			String DBurl = "jdbc:mysql://localhost:3306/colonie";
			con = DriverManager.getConnection(DBurl, "root", "root");
		} catch (SQLException e) {
			throw new DAOException("Probl�me de connection � la base de donn�es");
		}
		return con;
	}

	protected void closeConnection() throws DAOException {
		try {
			con.close();
		} catch (SQLException e) {
			throw new DAOException("probl�me de fermeture de connection");
		}
	}
}
