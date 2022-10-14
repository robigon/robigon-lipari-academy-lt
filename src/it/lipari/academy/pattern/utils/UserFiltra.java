package it.lipari.academy.pattern.utils;

import it.lipari.academy.model.dto.UserDto;
import it.lipari.academy.model.vo.User;

public class UserFiltra {

	private UserFiltra() {}
	
	public static UserDto fromVoToDto(User u) {
		UserDto retUser = new UserDto();
		retUser.setName(u.getName());
		retUser.setLastName(u.getLastName());
		retUser.setEmail(u.getEmail());
		retUser.setUsername(u.getUsername());
		return retUser;
	}

	
}