package io.swagger.service;

import java.util.UUID;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.User;
import io.swagger.model.UserLogin;
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

	public User create(UserLogin userLogin) {

		User actual = userRepository.findByUsername(userLogin.getUsername());

		if (actual != null) {
			throw new BadRequestException();
		}

		User user = new User();
		user.setId(UUID.randomUUID());
		user.setUsername(userLogin.getUsername());
		user.setPassword(userLogin.getPassword());
		return userRepository.save(user);
	}

	public User login(UserLogin userLogin) {
		
		User actual = userRepository.findByUsernameAndPassword(userLogin.getUsername(), userLogin.getPassword());

		if (actual == null) {
			throw new ForbiddenException();
		}
		
		actual.setToken(UUID.randomUUID());
		
		return userRepository.save(actual);
	}
}
