package it.lipari.academy.service.impl;

import java.util.ArrayList;
import java.util.List;

import it.lipari.academy.model.dto.UserDto;
import it.lipari.academy.model.vo.FiltraUtenti;
import it.lipari.academy.model.vo.User;
import it.lipari.academy.pattern.utils.UserUtils;
import it.lipari.academy.repository.UserRepository;
import it.lipari.academy.service.UserService;

public class UserServiceImpl implements UserService {

	
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public List<UserDto> filtra() throws Exception{
		
		List<UserDto> dtoList = new ArrayList<>();
		List<FiltraUtenti> response = userRepository.filtra();
		
		response.stream().forEach(
				  u -> {
					  dtoList.add( UserUtils.fromVoToDto(u));
				  }
				);
		return dtoList;
	}


	@Override
	public UserDto updateFiscalCode(Integer userId, String cf) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*@Override
	public UserDto updateFiscalCode(Integer userId, String cf) throws Exception {
		
		User u = userRepository.updateFiscalCode(userId, cf);
		UserDto response = UserUtils.fromVoToDto(u);
		
		return response;
		
	}*/
}
