package io.swagger.api;

import io.swagger.model.User;
import io.swagger.model.UserLogin;
import io.swagger.service.UserService;
import io.swagger.annotations.*;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-12-11T17:49:32.673+01:00")

@CrossOrigin(origins = "*")
@Controller
public class UsersApiController implements UsersApi {

	@Inject
	private UserService userService;

	public ResponseEntity<User> createUser(
			@ApiParam(value = "Created user object", required = true) @RequestBody @Valid UserLogin body) {

		User user = userService.create(body);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	public ResponseEntity<User> loginUser(
			@ApiParam(value = "Created user object", required = true) @RequestBody UserLogin body) {

		User user = userService.login(body);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	public ResponseEntity<Void> logoutUser(
			@ApiParam(value = "Token of the current user", required = true) @PathVariable("token") String token) {

		userService.logout(token);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
