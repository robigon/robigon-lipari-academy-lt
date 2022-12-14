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

	/**
	 * Recupero della lista degl iutenti
	 * 
	 * @return
	 * @throws Exception
	 * @throws
	 */
	public List<User> findAll() throws DataException
	
	{

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
					.executeQuery("select id_user as id, username, password, name, last_name, email, cf from user ");
			while (rs.next()) {
				users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("last_name"), rs.getString("cf"),
						rs.getString("username"), rs.getString("email"), rs.getString("password")));
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
						"select id_user as id, username, password, name, last_name, email, cf from user where id_user = ? ");
				pstmt.setInt(1, id);

				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("last_name"), rs.getString("cf"),
							rs.getString("username"), rs.getString("email"), rs.getString("password"));

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

}