package io.swagger.api;

import io.swagger.model.User;
import io.swagger.model.UserLogin;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-12-11T17:49:32.673+01:00")

@Controller
public class UsersApiController implements UsersApi {

	public ResponseEntity<User> createUser(
			@ApiParam(value = "Created user object", required = true) @RequestBody UserLogin body) {

		// do some magic!
		// new User() has to be set with the right user object
		return new ResponseEntity<User>(new User(), HttpStatus.OK);
	}

	public ResponseEntity<User> loginUser(
			@ApiParam(value = "Created user object", required = true) @RequestBody UserLogin body) {

		// do some magic!
		// new User() has to be set with the right user object
		return new ResponseEntity<User>(new User(), HttpStatus.OK);
	}

	public ResponseEntity<Void> logoutUser(
			@ApiParam(value = "Token of the current user", required = true) @PathVariable("token") String token) {
		// do some magic!
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
