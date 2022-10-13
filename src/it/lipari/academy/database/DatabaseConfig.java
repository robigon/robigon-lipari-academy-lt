package it.lipari.academy.database;

public class DatabaseConfig {

	private final String databaseUrl;
	private final String databaseDriver;
	private final String databaseUsername;
	private final String databasePassword;

	public DatabaseConfig(final String databaseUrl, final String databaseDriver, final String databaseUsername,
			final String databasePassword) {
		this.databaseUrl = databaseUrl;
		this.databaseDriver = databaseDriver;
		this.databaseUsername = databaseUsername;
		this.databasePassword = databasePassword;
	}

	public String getDatabaseUrl() {
		return databaseUrl;
	}

	public String getDatabaseDriver() {
		return databaseDriver;
	}

	public String getDatabaseUsername() {
		return databaseUsername;
	}

	public String getDatabasePassword() {
		return databasePassword;
	}
}
