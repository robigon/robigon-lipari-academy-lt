package it.lipari.academy.model.vo;

public class User {

	private Integer id;
	private String name;
	private String lastName;
	private String cf;
	private String username;
	private String email;
	private String password;
	private int active;

	
	public User() {
	}

	public User(Integer id, String name, String lastName, String cf, String username, String email, String password, int active) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.cf = cf;
		this.username = username;
		this.email = email;
		this.password = password;
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
}