package io.swagger.service;

import java.util.UUID;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.User;
import io.swagger.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void logout(UUID token) {

		// get user by token
		User user = userRepository.findByToken(token);

		// check if the user exists
		if (user == null) {
			throw new NotFoundException();
		}

		user.setToken(null);
		userRepository.save(user);

	}
}
