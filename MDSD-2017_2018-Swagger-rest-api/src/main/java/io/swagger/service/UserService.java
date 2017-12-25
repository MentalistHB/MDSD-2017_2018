package io.swagger.service;

import java.util.Date;
import java.util.UUID;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.ApiConstant;
import io.swagger.model.Folder;
import io.swagger.model.User;
import io.swagger.model.UserLogin;
import io.swagger.repository.FolderRepository;
import io.swagger.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FolderRepository folderRepository;

	public void logout(String token) {

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

		Folder home = new Folder();
		home.setId(UUID.randomUUID().toString());
		home.setCreateDate(new Date());
		home.setName(userLogin.getUsername());
		home.setParent(null);
		home.setUrl(ApiConstant.s3_server + "/" + userLogin.getUsername());
		home.setPath(userLogin.getUsername() + "/");

		home = folderRepository.save(home);

		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setUsername(userLogin.getUsername());
		user.setPassword(userLogin.getPassword());
		user.setHome(home);

		return userRepository.saveAndFlush(user);
	}

	public User login(UserLogin userLogin) {

		User actual = userRepository.findByUsernameAndPassword(userLogin.getUsername(), userLogin.getPassword());

		if (actual == null) {
			throw new ForbiddenException();
		}

		actual.setToken(UUID.randomUUID().toString());

		return userRepository.saveAndFlush(actual);
	}
}
