package dao.proxiBankHichamErica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class jdbcUtil {
	Connection seConnecter() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost/proxibanqueericahicham";
		String login = "root";
		String password = "";
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		Connection cn = DriverManager.getConnection(url, login, password);
		cn.setAutoCommit(false);

		return cn;

	}

	void seDeconnecter(Connection cn, PreparedStatement st, ResultSet rs) {
		try {
			if (cn != null)
				cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur lors de la fermeture de la connexion");
		}
		try {
			if (st != null)
				st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur lors de la fermeture du prepared statement");
		}
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("erreur lors de la fermeture du du resultset");
		}
	}
}
