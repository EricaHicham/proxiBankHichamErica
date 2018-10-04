package dao.proxiBankHichamErica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import exceptions.MybusinessException;
import modele.Personne;

public class CustomerDaoImplementation extends jdbcUtil implements CustomerDao {

	@Override
	public int createCustomer(Client c) throws MybusinessException {
		Connection cn = null;
		PreparedStatement st = null;
		int reponse = -1;
		try {
			cn = seConnecter();
			String sql = "INSERT INTO personne (id, nom, prenom, adresse, email, conseiller ) values(?,?,?,?,?,?)";

			st = cn.prepareStatement(sql);
			st.setInt(1, c.getId());
			st.setString(2, ; c.getNom)
			st.setString(3, p.getPrenom());
			st.setInt(4, c.getAge());
			reponse = st.executeUpdate(); 

			cn.commit();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
			try {
				if (cn != null)
					cn.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			throw new MybusinessException("Erreur lors de la créaion de Personne");
		} finally {
			seDeconnecter(cn, st, null);
		}
		return reponse;
	}

	@Override
	public int deleteCustomer(Client c) throws MybusinessException {
		public int deletePerson(Personne p) throws MybusinessException {
			Connection cn = null;
			PreparedStatement st = null;
			int result = -1;
			try {
				cn = seConnecter();
				String sql = "delete from Personne where id=?";
				st = cn.prepareStatement(sql);
				st.setInt(1, p.getId());
				result = st.executeUpdate();
				cn.commit();
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
				try {
					if (cn != null)
						cn.rollback();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				throw new MybusinessException("Attention erreur lors de la suppresion d'une persoone");

			} finally {
				seDeconnecter(cn, st, null);
			}

			return result;
		}
	}

	@Override
	public Client findById(int id) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Personne p = new Personne();
		try {
			cn = seConnecter();
			String sql = "select id, nom, prenom, age from personne where id=? ";
			st = cn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				p.setNom(rs.getString("nom"));
				p.setPrenom(rs.getString("prenom"));
				p.setId(rs.getInt("id"));
				p.setAge(rs.getInt("age"));
			}
			cn.commit();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
			try {
				if (cn != null)
					cn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				try {
					throw new MybusinessException("erruer findid");
				} catch (MybusinessException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		} finally {
			seDeconnecter(cn, st, rs);
		}
	}

	@Override
	public Client findCustomer(Client c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyCustomer(Client c) throws MybusinessException {
		Connection cn = null;
		PreparedStatement st = null;
		int result = -1;

		try {
			cn = seConnecter();
			String sql = "update personne set nom=?, prenom=?, age=? where id=?";
			st = cn.prepareCall(sql);
			st.setString(1, p.getNom());
			st.setString(2, p.getPrenom());
			st.setInt(3, p.getAge());
			st.setInt(4, p.getId());
			result = st.executeUpdate();
			cn.commit();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
			try {
				if (cn != null)
					cn.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
				throw new MybusinessException("erreur lors de la MAJ personne");
			}

		} finally {
			seDeconnecter(cn, st, null);
		}

		return result;
	}

	@Override
	public List<Client> findAllPerson() {
		// TODO Auto-generated method stub
		return null;
	}

}
