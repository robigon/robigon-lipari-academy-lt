package it.lipari.academy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.PreparedQuery;

import it.lipari.academy.database.LipariMysqlDatabaseManager;
import it.lipari.academy.exception.DataException;
import it.lipari.academy.model.vo.User;

public class UserRepository {

	public void createUser(String name, String lastName, String cf, String username, String email, String password, int active) throws Exception {
		Connection conn = null;

		try {
			conn = LipariMysqlDatabaseManager.getInstance().openMysqlConnection();
			conn.setAutoCommit(false);

			//String name, String lastName, String cf, String username, String email, String password, int active
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user (name, last_name, cf, username, email, password, active) VALUES (?,?,?,?,?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, lastName);
			pstmt.setString(3, cf);
			pstmt.setString(4, username);
			pstmt.setString(5, email);
			pstmt.setString(6, password);
			pstmt.setInt(7, active);

			int affectedRows = pstmt.executeUpdate();
			if (affectedRows != 1) {
				throw new DataException("Utente non creato");
			}
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw new DataException("Errore durante la connessione al database", e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public User findUserById(Integer id) throws Exception {
		User user;
		Connection conn = null;
		try {
			conn = LipariMysqlDatabaseManager.getInstance().openMysqlConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("SELECT id_user, name, last_name, username, cf, email, password, active FROM user WHERE id_user = ?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("id_user"), rs.getString("name"), rs.getString("last_name"), rs.getString("cf"),
						rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getInt("active"));
			} else {
				throw new DataException("Utente con id: " + id + " non trovato");
			}

			conn.commit();
		}catch (Exception e) {
			conn.rollback();
			throw new DataException("Errore durante la connessione al database" + e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return user;
	}

	/**
	 * Recupero della lista degl iutenti
	 * 
	 * @return
	 * @throws Exception
	 * @throws
	 */
	public List<User> findAll() throws DataException {

		List<User> users = new ArrayList<User>();

		/**
		 * 1. apertura connessione JDBC 2. invio dello statement di lettura 3. recupero
		 * delle informazioni dal ResultSet 4. popolamento della lista di ritorno
		 */
		Connection conn = null;
		try {
			
			conn = LipariMysqlDatabaseManager.getInstance().openMysqlConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("select id_user as id, username, password, name, last_name, email, cf, active from user");
			while (rs.next()) {
				users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("last_name"), rs.getString("cf"),
						rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getInt("active")));
			}
			
		} catch (SQLException e) {
			
			throw new DataException("Errore durante la connessione al database", e);
		} catch (Exception ex) {
		
			throw new DataException("Errore generico");
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new DataException("Errore durante la chiusura della connessione", e);
				}
			}
		}
		return users;
	}

	public void updateUser(Integer id, String name, String lastName, String username, String password, String cf, String email, int active) throws Exception {
		Connection conn = null;

		try {
			conn = LipariMysqlDatabaseManager.getInstance().openMysqlConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("UPDATE user SET name = ?, last_name = ?, username = ?, password = ?, cf = ?, email = ?, active = ? WHERE id_user = ?");
			pstmt.setString(1, name);
			pstmt.setString(2, lastName);
			pstmt.setString(3, username);
			pstmt.setString(4, password);
			pstmt.setString(5, cf);
			pstmt.setString(6, email);
			pstmt.setInt(7, active);
			pstmt.setInt(8, id);

			int effectedRows = pstmt.executeUpdate();
			if (effectedRows != 1) {
				throw new Exception("Utente con id: " + id + " non trovato");
			}

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw new DataException("Errore durante la connessione al database", e);
		}finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public User updateFiscalCode(final Integer id, final String cf) throws Exception {

		User u = null;
		Connection conn = null;
		try {
			conn = LipariMysqlDatabaseManager.getInstance().openMysqlConnection();

			// Autocommit disattivato equivale ad aprire una transazione
			conn.setAutoCommit(false);
			
			// 1. update codice fiscale
			PreparedStatement pstmt = conn.prepareStatement("update user set cf = ? where id_user = ? ");
			pstmt.setString(1, cf);
			pstmt.setInt(2, id);

			int affectedRows = pstmt.executeUpdate();
			if (affectedRows == 1) {
				// 2. Recupero dell'utente
				pstmt = conn.prepareStatement(
						"select id_user as id, username, password, name, last_name, email, cf, active from user where id_user = ? ");
				pstmt.setInt(1, id);

				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("last_name"), rs.getString("cf"),
							rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getInt("active"));

				} else {
					throw new Exception("Utente non trovato con id: " + id);
				}

			} else {
				throw new Exception("Utente non trovato con id: " + id);
			}

			// Chiudere la transazione
			conn.commit();
			
		} catch (SQLException e) {
			// TODO: gestione cristiana delle eccezioni
			e.printStackTrace();
			conn.rollback();
			
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return u;
	}

	public void deleteUser(Integer id) throws Exception {
		Connection conn = null;

		try {
			conn = LipariMysqlDatabaseManager.getInstance().openMysqlConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM user WHERE id_user = ?");
			pstmt.setInt(1, id);

			int effectedRows = pstmt.executeUpdate();
			if (effectedRows != 1) {
				throw new DataException("Utente con id: " + id + " non trovato");
			}

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw new DataException("Errore durante la connessione al database", e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void logicDelete(Integer id) throws Exception {
		Connection conn = null;

		try {
			conn = LipariMysqlDatabaseManager.getInstance().openMysqlConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("update user set active = 0 where id_user = ?");
			pstmt.setInt(1, id);

			int affectedRows = pstmt.executeUpdate();
			if (affectedRows != 1) {
				throw new DataException("Utente non trovato con id: " + id);
			}
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw new Exception(e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}