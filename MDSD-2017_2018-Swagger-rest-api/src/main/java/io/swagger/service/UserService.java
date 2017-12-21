package io.swagger.service;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.BadRequestException;

import io.swagger.model.User;
import io.swagger.repository.UserRepository;

@Named
public class UserService {

	@Inject
	private UserRepository userRepository;

	public void logout(UUID token) {

		System.out.println(token);
		
		// get user by token
		User user = userRepository.findByToken(token);

		// check if the user exists
		if (user == null) {
			throw new BadRequestException();
		}

		user.setToken(null);
		userRepository.save(user);

	}
}
