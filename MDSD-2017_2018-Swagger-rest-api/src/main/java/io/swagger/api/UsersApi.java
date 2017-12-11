package io.swagger.api;

import io.swagger.model.User;
import io.swagger.model.UserLogin;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-12-11T16:10:26.464+01:00")

@Api(value = "users", description = "the users API")
public interface UsersApi {

    @ApiOperation(value = "Create user", notes = "This can only be done by the logged in user.", response = User.class, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = User.class),
        @ApiResponse(code = 401, message = "Bad request", response = User.class) })
    @RequestMapping(value = "/users",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<User> createUser(

@ApiParam(value = "Created user object" ,required=true ) @RequestBody User body

);


    @ApiOperation(value = "Logs user into the system", notes = "", response = User.class, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = User.class),
        @ApiResponse(code = 400, message = "Bad request", response = User.class),
        @ApiResponse(code = 403, message = "Forbidden", response = User.class) })
    @RequestMapping(value = "/users/login",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<User> loginUser(

@ApiParam(value = "Created user object" ,required=true ) @RequestBody UserLogin body

);


    @ApiOperation(value = "Logs out current logged in user session", notes = "", response = Void.class, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class),
        @ApiResponse(code = 400, message = "Bad request", response = Void.class) })
    @RequestMapping(value = "/users/logout",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> logoutUser();

}
