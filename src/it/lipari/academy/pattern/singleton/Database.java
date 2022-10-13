package it.lipari.academy.pattern.singleton;

public class Database {

	private static Database _istance;
	
	private Database() {
		init();
	}
	
	public static Database getIstance() {
		if(_istance== null) {
			_istance = new Database();
		}
		return _istance;
	}
	
	private void init() {
		// TODO: inizializzazione del database: creazione di una collezione di utenti
	}
}
