package io.swagger.api;

import io.swagger.model.FolderCreate;
import io.swagger.model.Folder;
import io.swagger.model.File;
import io.swagger.model.FileDelete;
import io.swagger.model.FileEdit;

import io.swagger.annotations.*;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-12-11T17:49:32.673+01:00")

@Api(value = "{token}", description = "the {token} API")
public interface TokenApi {

	@ApiOperation(value = "Create a folder", notes = "This can only be done by the logged in user.", response = Folder.class, tags = {
			"Folder", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation", response = Folder.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Folder.class),
			@ApiResponse(code = 404, message = "Not found", response = Folder.class) })
	@RequestMapping(value = "/{token}/{folderId}", produces = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<Folder> createFolder(
			@ApiParam(value = "Id of the folder to create", required = true) @PathVariable("folderId") String folderId

			, @ApiParam(value = "token of the current user", required = true) @PathVariable("token") String token

			,

			@ApiParam(value = "Store a folder in data storage", required = true) @RequestBody FolderCreate folder

	);

	@ApiOperation(value = "Delete a file", notes = "This can only be done by the logged in user.", response = Void.class, tags = {
			"File", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 404, message = "Not found", response = Void.class) })
	@RequestMapping(value = "/{token}/{folderId}/files", produces = {
			"application/json" }, method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteFile(
			@ApiParam(value = "Token of the current user", required = true) @PathVariable("token") String token

			, @ApiParam(value = "Id of the parent folder", required = true) @PathVariable("folderId") String folderId

			,

			@ApiParam(value = "Delete a file in data storage", required = true) @RequestBody FileDelete file

	);

	@ApiOperation(value = "Delete a folder", notes = "This can only be done by the logged in user.", response = Void.class, tags = {
			"Folder", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
			@ApiResponse(code = 404, message = "Not found", response = Void.class) })
	@RequestMapping(value = "/{token}/{folderId}", produces = { "application/json" }, method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteFolder(
			@ApiParam(value = "Id of the folder to delete", required = true) @PathVariable("folderId") String folderId

			, @ApiParam(value = "token of the current user", required = true) @PathVariable("token") String token

	);

	@ApiOperation(value = "Edit a file name", notes = "This can only be done by the logged in user.", response = Folder.class, tags = {
			"File", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation", response = Folder.class),
			@ApiResponse(code = 400, message = "Bad request", response = Folder.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Folder.class),
			@ApiResponse(code = 404, message = "Not found", response = Folder.class) })
	@RequestMapping(value = "/{token}/{folderId}/files", produces = { "application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Folder> editFile(
			@ApiParam(value = "Token of the current user", required = true) @PathVariable("token") String token

			, @ApiParam(value = "Id of the parent folder", required = true) @PathVariable("folderId") String folderId

			,

			@ApiParam(value = "Edit a file name in data storage", required = true) @RequestBody FileEdit file

	);

	@ApiOperation(value = "Edit a folder", notes = "This can only be done by the logged in user.", response = Folder.class, tags = {
			"Folder", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation", response = Folder.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Folder.class),
			@ApiResponse(code = 404, message = "Not found", response = Folder.class) })
	@RequestMapping(value = "/{token}/{folderId}", produces = { "application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Folder> editFolder(
			@ApiParam(value = "Id of the folder to edit", required = true) @PathVariable("folderId") String folderId

			, @ApiParam(value = "token of the current user", required = true) @PathVariable("token") String token

			,

			@ApiParam(value = "Edit a folder in data storage", required = true) @RequestBody FolderCreate folder

	);

	@ApiOperation(value = "Get a file", notes = "This can only be done by the logged in user.", response = File.class, tags = {
			"File", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation", response = File.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = File.class),
			@ApiResponse(code = 404, message = "Not found", response = File.class) })
	@RequestMapping(value = "/{token}/{folderId}/files", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<File> getFile(
			@ApiParam(value = "Token of the current user", required = true) @PathVariable("token") String token

			, @ApiParam(value = "Id of the parent folder", required = true) @PathVariable("folderId") String folderId,
			@ApiParam(value = "Get a file from data storage", required = true) @RequestBody FileDelete file

	);

	@ApiOperation(value = "Get a folder", notes = "This can only be done by the logged in user.", response = Folder.class, tags = {
			"Folder", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation", response = Folder.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Folder.class),
			@ApiResponse(code = 404, message = "Not found", response = Folder.class) })
	@RequestMapping(value = "/{token}/{folderId}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<Folder> getFolder(
			@ApiParam(value = "Id of the folder to retrieve", required = true) @PathVariable("folderId") String folderId

			, @ApiParam(value = "token of the current user", required = true) @PathVariable("token") String token

	);

	@ApiOperation(value = "Upload a file", notes = "This can only be done by the logged in user.", response = File.class, tags = {
			"File", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation", response = File.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = File.class),
			@ApiResponse(code = 404, message = "Not found", response = File.class) })
	@RequestMapping(value = "/{token}/{folderId}/files", produces = { "application/json" }, consumes = {
			"multipart/form-data" }, method = RequestMethod.POST)
	ResponseEntity<File> uploadFile(
			@ApiParam(value = "Token of the current user", required = true) @PathVariable("token") String token

			, @ApiParam(value = "Id of the parent folder", required = true) @PathVariable("folderId") String folderId

			,

			@ApiParam(value = "file detail") @RequestPart("file") MultipartFile file) throws IOException;

}
