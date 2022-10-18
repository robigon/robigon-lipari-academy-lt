package it.lipari.academy.pattern.utils;

import it.lipari.academy.model.dto.ProductDto;
import it.lipari.academy.model.vo.Product;

	
	public class ProductUtils {
	
	private ProductUtils() {}
		
		public static ProductDto fromVoToDto(Product p) {
			ProductDto retProduct = new ProductDto();
			retProduct.setId_product(p.getId_product());
			retProduct.setCode(p.getCode());
			retProduct.setDescription(p.getDescription());
			retProduct.setCost(p.getCost());
			retProduct.setAvailabity(p.getAvailabity());
			retProduct.setCreate_user(p.getCreate_user());
			retProduct.setCreate_time(p.getCreate_time());
			retProduct.setLast_update_user(p.getLast_update_user());
			retProduct.setLast_update_time(p.getLast_update_time());

			return retProduct;
		}


	}

