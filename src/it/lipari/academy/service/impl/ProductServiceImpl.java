package it.lipari.academy.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import it.lipari.academy.model.dto.ProductDto;
import it.lipari.academy.model.vo.Product;
import it.lipari.academy.pattern.utils.ProductUtils;
import it.lipari.academy.repository.ProductRepository;
import it.lipari.academy.service.ProductService;

public class ProductServiceImpl implements ProductService{
	private final ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = new ProductRepository();
		}

	@Override
	public List<ProductDto> esInsertProduct() throws Exception {
		List<ProductDto> dtoList = new ArrayList<>();
		List<Product> response = productRepository.esInsertProduct();
		
		response.stream().forEach(
				  u -> {
					  dtoList.add( ProductUtils.fromVoToDto(u));
				  }
				);
		return dtoList;
	}
	/*@Override
	public ProductDto updateProduct(Integer id_product, String code, String description, Double cost,
			Integer availability, Integer create_user, Date create_time, Integer last_update_user, Date last_update_time)
			throws Exception {
		Product p = productRepository.updateProduct(id_product, code, description,cost, availability,create_time,create_user,last_update_user,last_update_time);
		ProductDto response = ProductUtils.fromVoToDto(p);
		
		return response;
	}
	*/

	@Override
	public ProductDto updateProduct(Integer id_product, String code, String description, Double cost,
			Integer availability, Integer create_user, Integer create_time, Integer last_update_user,
			Integer last_update_time) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}

	
	
	
	

