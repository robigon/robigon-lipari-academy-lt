package it.lipari.academy.pattern.utils;

import it.lipari.academy.model.dto.UserDto;
import it.lipari.academy.model.vo.FiltraUtenti;
import it.lipari.academy.model.vo.User;

public class UserUtils {

	private UserUtils() {}
	
	public static UserDto fromVoToDto(FiltraUtenti f) {
		UserDto retUser = new UserDto();
		retUser.setId(f.getId());
		retUser.setName(f.getName());
		retUser.setLastName(f.getLastName());
		retUser.setCf(f.getCf());
		retUser.setEmail(f.getEmail());
		retUser.setPassword(f.getPassword());
		retUser.setUsername(f.getUsername());
		return retUser;
	}

	
}