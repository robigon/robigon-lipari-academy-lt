package it.lipari.academy.pattern.utils;

import it.lipari.academy.model.dto.UserDto;
import it.lipari.academy.model.vo.FiltraUtenti;
import it.lipari.academy.model.vo.User;

public class UserUtils {

	private UserUtils() {}
	
	public static UserDto fromVoToDto(User u) {
		UserDto retUser = new UserDto();
		retUser.setId(u.getId());
		retUser.setName(u.getName());
		retUser.setLastName(u.getLastName());
		retUser.setCf(u.getCf());
		retUser.setEmail(u.getEmail());
		retUser.setPassword(u.getPassword());
		retUser.setUsername(u.getUsername());
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