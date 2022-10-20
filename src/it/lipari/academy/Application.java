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

			/*BaseResponse<List<UserDto>> listBaseResponseFindAll = uC.findAll();
			List<UserDto> users = listBaseResponseFindAll.getBody();
			System.out.println("Stampa degli utenti in corso...");
			users.stream().forEach(u -> System.out.println(u));*/

			/*BaseResponse<UserDto> userDtoBaseResponseUpdateFiscalCode = uC.updateFiscalCode(1, "LòSJNDFòSDNFJK");
			UserDto userDto1 = userDtoBaseResponseUpdateFiscalCode.getBody();*/

			/*BaseResponse<Void> voidBaseResponseLogicalDelete = uC.logicalDelete(10);*/

			/*BaseResponse<UserDto> userDtoBaseResponseCreateUser = uC.createUser("Alessandro", "Canulli", "codiceFiscale", "CanAle97", "canale97.dev@gmail.com", "password", 0);*/

			/*BaseResponse<UserDto> userDtoBaseResponseFindUserById = uC.findUserById(4);
			UserDto userDto2 = userDtoBaseResponseFindUserById.getBody();
			System.out.println(userDto2);*/

			/*BaseResponse<Void> voidBaseResponseUpdateUser = uC.updateUser(12, "Erika", "Canulli", "EriCan", "ErikaCanulli", "cf12", "erikacanulli@gmail.com", 1);*/

			/*BaseResponse<Void> voidBaseResponseDeleteUser = uC.deleteUser(11);*/

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
