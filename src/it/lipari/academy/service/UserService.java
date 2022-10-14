package it.lipari.academy.service;

import java.util.List;

import it.lipari.academy.model.dto.UserDto;

public interface UserService {
	
	List <UserDto> filtra() throws Exception;

	//List<UserDto> findAll() throws Exception;

	UserDto updateFiscalCode(Integer userId, String cf) throws Exception;

}