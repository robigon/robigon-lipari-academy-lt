/**
 * Gestisce le utilities legate al database.
 * - lettura del file di configurazione
 */

package it.lipari.academy.database;

import java.io.FileInputStream;
import java.util.Properties;

public class DatabaseUtils {

	
	public static final String MYSQL_URL_KEY = "mysql_url"; 
	public static final String MYSQL_DRIVER_KEY = "mysql_driver"; 
	public static final String MYSQL_USER_KEY = "mysql_user"; 
	public static final String MYSQL_PASSWORD_KEY = "mysql_password"; 
	
	private DatabaseUtils() {}
	
	public static DatabaseConfig readConfigFile() throws Exception {
		/*
		 * 1. collegamento al file properties
		 * 2. lettura delle configurazioni
		 * 3. restituzione delle info
		 */
		Properties mysqlProps = new Properties();
		DatabaseConfig cfg = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("resources/database.properties");
			mysqlProps.load(fis);
			cfg = new DatabaseConfig(
					mysqlProps.getProperty(MYSQL_URL_KEY),
					mysqlProps.getProperty(MYSQL_DRIVER_KEY),
					mysqlProps.getProperty(MYSQL_USER_KEY),
					mysqlProps.getProperty(MYSQL_PASSWORD_KEY));
			
		} finally {
			if (fis != null) {
				fis.close();				
			}
		}
		return cfg;
	}

}
