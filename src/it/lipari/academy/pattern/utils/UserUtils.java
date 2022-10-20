package it.lipari.academy.pattern.utils;

import it.lipari.academy.model.dto.UserDto;
import it.lipari.academy.model.vo.FiltraUtenti;
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
		retUser.setActive(user.getActive());
		return retUser;
	}
	public static UserDto fromVoToDto(FiltraUtenti t) {
		UserDto retUser = new UserDto();
		retUser.setId(t.getId());
		retUser.setName(t.getName());
		retUser.setLastName(t.getLastName());
		retUser.setCf(t.getCf());
		retUser.setEmail(t.getEmail());
		retUser.setPassword(t.getPassword());
		retUser.setUsername(t.getUsername());
		return retUser;

}

	
}