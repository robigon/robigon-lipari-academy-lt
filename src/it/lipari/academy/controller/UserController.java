package it.lipari.academy.controller;

import java.util.List;

import it.lipari.academy.model.dto.UserDto;
import it.lipari.academy.model.response.BaseResponse;
import it.lipari.academy.service.UserService;

public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService=userService;
	}

	public BaseResponse<List<UserDto>> findAll() {

		List<UserDto> result = null;
		BaseResponse<List<UserDto>> response = new BaseResponse<>();
		try {
			result = userService.findAll();

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

	public BaseResponse<UserDto> updateFiscalCode(Integer userId, String cf) {

		BaseResponse<UserDto> response = new BaseResponse<>();

		try {
			UserDto dto = userService.updateFiscalCode(userId, cf);
			response.setOkStatus(true);
			response.setBody(dto);

		} catch (Exception e) {
			e.printStackTrace();

			response.setOkStatus(false);
			response.setBody(null);
			response.addError(e.getMessage());
		}
		return response;
	}

	public BaseResponse<Void> logicalDelete(Integer id){

		BaseResponse<Void> response = new BaseResponse<>();

		try {
			userService.logicDelete(id);
			response.setOkStatus(true);

		} catch (Exception e) {
			e.printStackTrace();

			response.setOkStatus(false);
			response.setBody(null);
			response.addError(e.getMessage());
		}
		return response;
	}
}