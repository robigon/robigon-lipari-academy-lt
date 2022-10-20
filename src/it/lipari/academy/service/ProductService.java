package it.lipari.academy.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import it.lipari.academy.model.dto.ProductDto;

public interface ProductService {
	List <ProductDto> esSelectProduct() throws Exception;
	
	ProductDto updateProduct(Integer id_product, String code, String description, Double cost, Integer availability,
			Integer create_user, Timestamp create_time)
			throws Exception;

	ProductDto insertProduct(Integer id_product, String code, String description, Double cost, Integer availability,
			Integer create_user, Timestamp create_time, Integer last_update_user, Timestamp last_update_time)
			throws Exception;

	ProductDto deleteProduct(Integer id_product) throws Exception;


	
}
