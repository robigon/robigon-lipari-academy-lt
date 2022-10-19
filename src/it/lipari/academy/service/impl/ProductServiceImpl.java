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
	public List<ProductDto> esSelectProduct() throws Exception {
		List<ProductDto> dtoList = new ArrayList<>();
		List<Product> response = productRepository.esSelectProduct();
		
		response.stream().forEach(
				  u -> {
					  dtoList.add( ProductUtils.fromVoToDto(u));
				  }
				);
		return dtoList;
	}
/*
	@Override
	public ProductDto updateProduct(Integer id_product, String code, String description, Double cost,
			Integer availability, Date create_user, Integer create_time, Date last_update_user,
			Integer last_update_time) throws Exception {
		Product u = ProductRepository.updateProduct(id_product,code, description,cost,availability,create_user,create_time,last_update_user,last_update_time);
	
	
	}*/

	@Override
	public ProductDto updateProduct(Integer id_product, String code, String description, Double cost,
			Integer availability, Date create_user, Integer create_time, Date last_update_user,
			Integer last_update_time) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}

	
	
	
	

