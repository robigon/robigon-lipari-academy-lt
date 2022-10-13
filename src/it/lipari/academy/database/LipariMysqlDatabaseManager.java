/**
 * Classe manager per la gestione del database MySQL.
 * 1. attiva il driver
 * 2. crea connessioni a MySQL a beneficio dei repository
 */
package it.lipari.academy.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LipariMysqlDatabaseManager {

	private static LipariMysqlDatabaseManager _instance;
	
	private String databaseUrl;
	private String databaseDriver;
	private String databaseUsername;
	private String databasePassword;
	
	private LipariMysqlDatabaseManager() {
		this.init();
	}
	
	
	public static synchronized LipariMysqlDatabaseManager getInstance() {
		
		if(_instance == null) {
			_instance = new LipariMysqlDatabaseManager();
		}
		return _instance;
	}
	
	
	private void init() {
		try {
			DatabaseConfig cfg = DatabaseUtils.readConfigFile();
			this.databaseUrl = cfg.getDatabaseUrl();
			this.databaseDriver = cfg.getDatabaseDriver();
			this.databaseUsername = cfg.getDatabaseUsername();
			this.databasePassword = cfg.getDatabasePassword();
			
			/*
			 * Viene istanziata tramite Reflection, una nuova istanza della classe Driver,
			 * Passata come string al mentodo forName(); 
			 */
			 Class.forName(this.databaseDriver);
			
			 System.out.println("Driver succesfully loaded");
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection openMysqlConnection() throws SQLException {
		return DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
	}
	
	public static void main(String[] args) {
		try {
			LipariMysqlDatabaseManager.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
