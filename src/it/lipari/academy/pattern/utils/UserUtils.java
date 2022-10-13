package it.lipari.academy.pattern.utils;

import it.lipari.academy.model.dto.UserDto;
import it.lipari.academy.model.vo.User;

public class UserUtils {

	private UserUtils() {}
	
	public static UserDto fromVoToDto(User user) {
		UserDto retUser = new UserDto();
		retUser.setId(user.getId());
		retUser.setName(user.getName());
		retUser.setLastName(user.getLastName());
		retUser.setCf(user.getCf());
		retUser.setEmail(user.getEmail());
		retUser.setPassword(user.getPassword());
		retUser.setUsername(user.getUsername());
		return retUser;
	}

	
}