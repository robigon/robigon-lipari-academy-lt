package it.lipari.academy.service.impl;

import java.util.ArrayList;
import java.util.List;

import it.lipari.academy.model.dto.UserDto;
import it.lipari.academy.model.vo.User;
import it.lipari.academy.pattern.utils.UserUtils;
import it.lipari.academy.repository.UserRepository;
import it.lipari.academy.service.UserService;

public class UserServiceImpl implements UserService {

	
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void createUser(String name, String lastName, String cf, String username, String email, String password) throws Exception{
		userRepository.createUser(name, lastName, cf, username, email, password);
	}

	@Override
	public List<UserDto> findAll() throws Exception{
		
		List<UserDto> dtoList = new ArrayList<>();
		List<User> response = userRepository.findAll();
		
		response.stream().forEach(
				  u -> {
					  dtoList.add( UserUtils.fromVoToDto(u));
				  }
				);
		return dtoList;
	}
	
	@Override
	public UserDto updateFiscalCode(Integer userId, String cf) throws Exception {
		
		User u = userRepository.updateFiscalCode(userId, cf);
		UserDto response = UserUtils.fromVoToDto(u);
		
		return response;
		
	}
}
