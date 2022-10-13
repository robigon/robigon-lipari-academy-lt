package it.lipari.academy;

import java.util.List;

import it.lipari.academy.controller.UserController;
import it.lipari.academy.model.dto.UserDto;
import it.lipari.academy.model.response.BaseResponse;
import it.lipari.academy.repository.UserRepository;
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
			} else {
				
			}
			
			BaseResponse<UserDto> userResponse = uC.updateFiscalCode(1, "LòSJNDFòSDNFJK");
			UserDto user = userResponse.getBody();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
