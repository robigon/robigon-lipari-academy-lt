package it.lipari.academy.model.vo;

public class FiltraUtenti {
	
	private String name;
	private String lastName;
	private String username;
	private String email;

	
	public FiltraUtenti() {
	}

	public FiltraUtenti(String name,String lastName, String username, String email ) {
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCf() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	
}