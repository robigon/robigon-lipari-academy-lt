package it.lipari.academy.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import it.lipari.academy.model.dto.ProductDto;

public interface ProductService {
	List <ProductDto> esSelectProduct() throws Exception;
	
	/*ProductDto updateProduct(Integer id_product, java.lang.String code, java.lang.String description,
					Double cost, Integer availability, Integer create_user, Date create_time, Integer last_update_user,
					Date last_update_time) throws Exception;*/

	ProductDto updateProduct(Integer id_product, String code, String description, Double cost, Integer availability,
			Integer create_user, Timestamp create_time)
			throws Exception;
}
