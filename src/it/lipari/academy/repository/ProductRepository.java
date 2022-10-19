package it.lipari.academy.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.lipari.academy.database.LipariMysqlDatabaseManager;
import it.lipari.academy.exception.DataException;
import it.lipari.academy.model.vo.FiltraUtenti;
import it.lipari.academy.model.vo.Product;


public class ProductRepository {
	public List <Product> esSelectProduct( ) throws Exception 
		{

			List<Product> products = new ArrayList<Product>();

			Connection conn = null;
			try {
				//query per select
				conn = LipariMysqlDatabaseManager.getInstance().openMysqlConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select  id_product, code, description, cost, availability, create_user, create_time, last_update_user, last_update_time from product");
				while (rs.next()) {
					products.add(new Product(rs.getInt("id_product"), rs.getString("code"), rs.getString("description"), rs.getDouble("cost"),rs.getInt("availability"),rs.getInt("create_user"),rs.getDate("create_time"),rs.getInt("last_update_user"),rs.getDate("last_update_time")));
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
			return products;
		}

	
	public Product updateProduct(final Integer id_product, final String code, final String description, final double cost, final Integer availabity, final Date create_user, final Integer create_time, final Integer last_update_user, final Date last_update_time  ) throws Exception {
		Product p = null;
		
		Connection conn = null;
		
		try {
			
			conn= LipariMysqlDatabaseManager.getInstance().openMysqlConnection();
			conn.setAutoCommit(false);
					
		
		PreparedStatement pstmt = conn.prepareStatement("update product set code = ?, description = ? ,cost = ?, availability = ?, create_user=?, create_time=?, last_update_user=?, last_update_time=? where id_product = ?  ");
		pstmt.setInt(1, id_product);
		pstmt.setString(2, code);
		pstmt.setString(3, description);
		pstmt.setDouble(4, cost);
		pstmt.setInt(5, availabity);
		pstmt.setDate(6, create_user);
		pstmt.setInt(7, create_time);
		pstmt.setInt(8, last_update_user);
		pstmt.setDate(9, last_update_time);

		int affectedRows = pstmt.executeUpdate();
		if (affectedRows == 1) {
			// 2. Recupero dell'utente
			pstmt = conn.prepareStatement(
					"select id_product, code, description, cost, availabity, create_user, create_time, last_update_user, last_update_time from product where id_product = ? ");
			pstmt.setInt(1, id_product);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				p = new Product (rs.getInt("id_product"), rs.getString("code"), rs.getString("description"), rs.getDouble("cost"),
						rs.getInt("availabity"), rs.getInt("create_user"), rs.getDate("create_time"), rs.getInt("last_update_user"),rs.getDate("last_update_time"));

			} else {
				throw new Exception("Prodotto non trovato con id: " + id_product);
			}

		} else {
			throw new Exception("Prodotto non trovato con id: " + id_product);
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
	return p;
}
	
	/*public Product updateProduct (Integer id_product, String code, String description, Double cost, Integer availability, Integer create_user, Date create_time, Integer last_update_user, Date last_update_time) throws Exception
	{

		Product p = null;
		Connection conn = null;
		try {
			conn = LipariMysqlDatabaseManager.getInstance().openMysqlConnection();

			// Autocommit disattivato equivale ad aprire una transazione
			conn.setAutoCommit(false);
			
			// 1. update codice fiscale
			PreparedStatement pstmt = conn.prepareStatement("update product set id_product, code , description , cost, availability,create_user , create_time , last_update_user , last_update_time where id_user = ? ");
			pstmt.setInt(1, id_product);
			pstmt.setString(2,code);
			pstmt.setString(3, description);
			pstmt.setDouble(4, cost);
			pstmt.setInt(5, availability);
			pstmt.setInt(6,create_user);
			pstmt.setDate(7, create_time);
			pstmt.setInt(8, last_update_user);
			pstmt.setDate(9, last_update_time);
			
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows == 1) {
				// 2. Recupero del prodotto
				pstmt = conn.prepareStatement(
						"select product id_product, code , description , cost, availability ,create_user, create_time , last_update_user, last_update_time where id_user = ? ");
				pstmt.setInt(1, id_product);
				pstmt.setString(2,code);
				pstmt.setString(3, description);
				pstmt.setDouble(4, cost);
				pstmt.setInt(5, availability);
				pstmt.setInt(6,create_user);
				pstmt.setDate(7, create_time);
				pstmt.setInt(8, last_update_user);
				pstmt.setDate(9, last_update_time);
				
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					p = new Product(rs.getInt("id_product"), rs.getString("code"), rs.getString("description"), rs.getDouble("cost"),rs.getInt("availability"),rs.getInt("create_user"),rs.getDate("create_time"),rs.getInt("last_update_user"),rs.getDate("last_update_time"));
					

				} else {
					throw new Exception("Prodotto non trovato con id: " + id_product);
				}

			} else {
				throw new Exception("Prodotto non trovato con id: " + id_product);
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
		return p;
	}*/
	
}
