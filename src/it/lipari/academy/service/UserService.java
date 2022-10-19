package it.lipari.academy.service;

import java.util.List;

import it.lipari.academy.exception.DataException;
import it.lipari.academy.model.dto.UserDto;

public interface UserService {

	List<UserDto> findAll() throws Exception;

	UserDto updateFiscalCode(Integer userId, String cf) throws Exception;

	void createUser(String name, String lastName, String cf, String username, String email, String password, int active) throws Exception;

	void logicDelete(Integer id) throws Exception;

	UserDto findUserById(Integer id) throws Exception;
}