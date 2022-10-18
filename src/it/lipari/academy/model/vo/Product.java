package it.lipari.academy.model.vo;

import java.sql.Date;

public class Product {
	private Integer id_product;
	private String code;
	private String description;
	private Double cost;
	private Integer availability;
	private Integer create_user;
	private Date create_time;
	private Integer last_update_user;
	private Date last_update_time;
	
	public Product (Integer id_product, String code, String description, Double cost, Integer availability, Integer create_user, Date create_time, Integer last_update_user, Date last_update_time) {
		this.id_product = id_product;
		this.code = code;
		this.description = description;
		this.cost = cost;
		this.availability = availability;
		this.create_user = create_user;
		this.create_time = create_time;
		this.last_update_user = last_update_user;
		this.last_update_time = last_update_time;
		
	}

	public Integer getId_product() {
		return id_product;
	}

	public void setId_product(Integer id_product) {
		this.id_product = id_product;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Integer getAvailabity() {
		return availability;
	}

	public void setAvailabity(Integer availabity) {
		this.availability = availabity;
	}

	public Integer getCreate_user() {
		return create_user;
	}

	public void setCreate_user(Integer create_user) {
		this.create_user = create_user;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Integer getLast_update_user() {
		return last_update_user;
	}

	public void setLast_update_user(Integer last_update_user) {
		this.last_update_user = last_update_user;
	}

	public Date getLast_update_time() {
		return last_update_time;
	}

	public void setLast_update_time(Date last_update_time) {
		this.last_update_time = last_update_time;
	}
	
}
