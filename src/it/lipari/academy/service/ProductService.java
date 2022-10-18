package it.lipari.academy.service;

import java.sql.Date;
import java.util.List;

import it.lipari.academy.model.dto.ProductDto;

public interface ProductService {
	//ProductDto esInsertProduct(Integer id_product, String code, String description, double cost,  Integer availabity,  Integer create_user,  Date create_time,  Integer last_update_user,  Date last_update_time  ) throws Exception;
	List <ProductDto> esInsertProduct() throws Exception;
	//ProductDto updateProduct (Integer id_product, String code, String description, Double cost, Integer availability, Integer create_user, Integer integer, Integer last_update_user, Integer integer2) throws Exception;
	ProductDto updateProduct(Integer id_product, String code, String description, Double cost, Integer availability,
			Integer create_user, Integer create_time, Integer last_update_user, Integer last_update_time) throws Exception;
	
	
}
