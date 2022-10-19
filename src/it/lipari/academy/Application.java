package it.lipari.academy;

import java.util.List;

import it.lipari.academy.controller.ProductController;
import it.lipari.academy.controller.UserController;
import it.lipari.academy.model.dto.ProductDto;
import it.lipari.academy.model.dto.UserDto;
import it.lipari.academy.model.response.BaseResponse;
import it.lipari.academy.repository.ProductRepository;
import it.lipari.academy.repository.UserRepository;
import it.lipari.academy.service.impl.ProductServiceImpl;
import it.lipari.academy.service.impl.UserServiceImpl;

public class Application {

	public static void main(String[] args) {

		try {

			UserController uC = new UserController(new UserServiceImpl(new UserRepository()));

			BaseResponse<List<UserDto>> response = uC.findAll();
			if(response.isOkStatus()) {
				List<UserDto> users = response.getBody();
				System.out.println("Stampa degli utenti in corso...");
				users.stream().forEach(u -> System.out.println(u));
			}

			BaseResponse<UserDto> userResponse = uC.updateFiscalCode(1, "LòSJNDFòSDNFJK");
			UserDto user = userResponse.getBody();

			BaseResponse<UserDto> logicalDeleteResponse = uC.logicalDelete(9);

			
			
	
			
			UserController aC = new UserController(new UserServiceImpl(new UserRepository()));
			BaseResponse<List<UserDto>> responseac = aC.filtra();
			
			if(responseac.isOkStatus()) {
				List<UserDto> users = responseac.getBody();
				System.out.println("Stampa utenti filtrati");
				users.stream().forEach(t -> System.out.println(t));
			} else {
				
			}
			ProductController pC = new ProductController(new ProductServiceImpl(new ProductRepository()));
			BaseResponse<List<ProductDto>> responsepc = pC.esSelectProduct();
			
			if(responseac.isOkStatus()) {
				List<ProductDto> users = responsepc.getBody();
				System.out.println("Stampa prodotti:");
				users.stream().forEach(t -> System.out.println(t));
			} else {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
	
}

	}
