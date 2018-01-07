package io.swagger.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiParam;
import io.swagger.model.File;
import io.swagger.model.FileEdit;
import io.swagger.model.Folder;
import io.swagger.model.FolderCreate;
import io.swagger.service.FileService;
import io.swagger.service.FolderService;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-12-11T17:49:32.673+01:00")

@CrossOrigin(origins = "*")
@Controller
public class TokenApiController implements TokenApi {

	@Inject
	private FileService fileService;
	@Inject
	private FolderService folderService;

	public ResponseEntity<Folder> createFolder(
			@ApiParam(value = "Id of the folder to create", required = true) @PathVariable("folderId") String folderId,
			@ApiParam(value = "token of the current user", required = true) @PathVariable("token") String token,
			@ApiParam(value = "Store a folder in data storage", required = true) @RequestBody FolderCreate folder) {

		Folder actual = folderService.create(token, folderId, folder);
		return new ResponseEntity<Folder>(actual, HttpStatus.OK);
	}

	public ResponseEntity<Void> deleteFile(
			@ApiParam(value = "Token of the current user", required = true) @PathVariable("token") String token,
			@ApiParam(value = "Id of the parent folder", required = true) @PathVariable("folderId") String folderId,
			@ApiParam(value = "Id of the file", required = true) @PathVariable("fileId") String fileId) {
		fileService.delete(token, folderId, fileId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Void> deleteFolder(
			@ApiParam(value = "Id of the folder to delete", required = true) @PathVariable("folderId") String folderId,
			@ApiParam(value = "token of the current user", required = true) @PathVariable("token") String token) {
		folderService.delete(token, folderId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Folder> editFile(
			@ApiParam(value = "Token of the current user", required = true) @PathVariable("token") String token,
			@ApiParam(value = "Id of the parent folder", required = true) @PathVariable("folderId") String folderId,
			@ApiParam(value = "Id of the file", required = true) @PathVariable("fileId") String fileId,
			@ApiParam(value = "Edit a file name in data storage", required = true) @Valid @RequestBody FileEdit file) {

		Folder folder = fileService.edit(token, folderId, fileId, file);
		return new ResponseEntity<Folder>(folder, HttpStatus.OK);
	}

	public ResponseEntity<Folder> editFolder(
			@ApiParam(value = "Id of the folder to edit", required = true) @PathVariable("folderId") String folderId,
			@ApiParam(value = "token of the current user", required = true) @PathVariable("token") String token,
			@ApiParam(value = "Edit a folder in data storage", required = true) @RequestBody FolderCreate folder) {

		Folder actual = folderService.edit(folderId, token, folder);
		return new ResponseEntity<Folder>(actual, HttpStatus.OK);
	}

	public ResponseEntity<File> getFile(
			@ApiParam(value = "Token of the current user", required = true) @PathVariable("token") String token,
			@ApiParam(value = "Id of the parent folder", required = true) @PathVariable("folderId") String folderId,
			@ApiParam(value = "Id of the file", required = true) @PathVariable("fileId") String fileId) {

		File file = fileService.get(token, folderId, fileId);
		return new ResponseEntity<File>(file, HttpStatus.OK);
	}

	public ResponseEntity<Folder> getFolder(
			@ApiParam(value = "Id of the folder to retrieve", required = true) @PathVariable("folderId") String folderId,
			@ApiParam(value = "token of the current user", required = true) @PathVariable("token") String token) {

		Folder folder = folderService.get(folderId, token);
		return new ResponseEntity<Folder>(folder, HttpStatus.OK);
	}

	public ResponseEntity<File> uploadFile(
			@ApiParam(value = "Token of the current user", required = true) @PathVariable("token") String token,
			@ApiParam(value = "Id of the parent folder", required = true) @PathVariable("folderId") String folderId,
			@ApiParam(value = "file detail") @RequestPart("file") @Valid MultipartFile file) throws IOException {

		File uploadedFile = fileService.upload(token, folderId, file);

		return new ResponseEntity<File>(uploadedFile, HttpStatus.OK);
	}

}
