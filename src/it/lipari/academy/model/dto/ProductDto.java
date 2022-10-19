package it.lipari.academy.model.dto;

import java.sql.Date;

public class ProductDto {
	private Integer id_product;
	private String code;
	private String description;
	private Double cost;
	private Integer availability;
	private Integer create_user;
	private Date create_time;
	private Integer last_update_user;
	private Date last_update_time;

	
	public ProductDto() {
		
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


	public Integer getAvailability() {
		return availability;
	}


	public void setAvailability(Integer availability) {
		this.availability = availability;
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
	
	@Override
	public String toString() {
		return "UserDto{" +
				"id_product=" + id_product +
				", code='" + code + '\'' +
				", description='" + description + '\'' +
				", cost='" + cost + '\'' +
				", availability='" + availability + '\'' +
				", create_user='" + create_user + '\'' +
				", create_time='" + create_time + '\'' +
				", last_update_user=" + last_update_user +'\'' +
				", last_update_time=" + last_update_time +
				'}';
	}
}
