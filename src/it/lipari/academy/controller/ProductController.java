package it.lipari.academy.controller;

import java.util.List;

import it.lipari.academy.model.dto.ProductDto;
import it.lipari.academy.model.response.BaseResponse;
import it.lipari.academy.service.ProductService;

public class ProductController {
	
private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	public BaseResponse <List<ProductDto>> esSelectProduct(){
		List<ProductDto> result = null;
		BaseResponse<List<ProductDto>> response = new BaseResponse<>();
		try {
			result = productService.esSelectProduct();
			
			response.setOkStatus(true);
			response.setBody(result);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			response.setOkStatus(false);
			response.setBody(null);
			response.addError(e.getMessage());
		}
		
		return response;
		
	}
	
	
	
/*
public BaseResponse<ProductDto> updateProduct(Integer id_product, String code, String description, Double cost, Integer availability, Integer create_user, Integer create_time, Integer last_update_user,  Integer last_update_time ) {
	
	BaseResponse<ProductDto> responseproductupdate = new BaseResponse<>();
	
	try {
		ProductDto dto = productService.updateProduct(id_product, code, description, cost, availability, create_user, create_time, last_update_user, last_update_time);
		responseproductupdate.setOkStatus(true);
		responseproductupdate.setBody(dto);
		
	} catch (Exception e) {
		e.printStackTrace();
		
		responseproductupdate.setOkStatus(false);
		responseproductupdate.setBody(null);
		responseproductupdate.addError(e.getMessage());
	}
	return responseproductupdate;*/
}










	
	
	
	
	
	
	
	
	
