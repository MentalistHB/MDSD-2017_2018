package io.swagger.api;

import io.swagger.model.FolderCreate;
import io.swagger.service.FileService;
import io.swagger.service.FolderService;
import io.swagger.model.Folder;
import io.swagger.model.File;
import io.swagger.model.FileEdit;

import io.swagger.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

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
			@ApiParam(value = "Store a folder in data storage", required = true) @ModelAttribute FolderCreate folder) {

		Folder actual = folderService.create(token, folderId, folder);
		return new ResponseEntity<Folder>(actual, HttpStatus.OK);
	}

	public ResponseEntity<Void> deleteFile(
			@ApiParam(value = "Token of the current user", required = true) @PathVariable("token") String token,
			@ApiParam(value = "Id of the parent folder", required = true) @PathVariable("folderId") String folderId,
			@ApiParam(value = "Id of the file", required = true) @PathVariable("fileId") String fileId) {
		// do some magic!
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Void> deleteFolder(
			@ApiParam(value = "Id of the folder to delete", required = true) @PathVariable("folderId") String folderId,
			@ApiParam(value = "token of the current user", required = true) @PathVariable("token") String token) {
		// do some agic!
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Folder> editFile(
			@ApiParam(value = "Token of the current user", required = true) @PathVariable("token") String token,
			@ApiParam(value = "Id of the parent folder", required = true) @PathVariable("folderId") String folderId,
			@ApiParam(value = "Id of the file", required = true) @PathVariable("fileId") String fileId,
			@ApiParam(value = "Edit a file name in data storage", required = true) @RequestBody FileEdit file) {
		// do some magic!
          try {
			fileService.edit(token, folderId, fileId, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Folder>(new Folder(), HttpStatus.OK);
	}

	public ResponseEntity<Folder> editFolder(
			@ApiParam(value = "Id of the folder to edit", required = true) @PathVariable("folderId") String folderId,
			@ApiParam(value = "token of the current user", required = true) @PathVariable("token") String token,
			@ApiParam(value = "Edit a folder in data storage", required = true) @RequestBody FolderCreate folder) {
		// do some magic!
		folderService.edit(token, folderId, folder);

		return new ResponseEntity<Folder>(new Folder(), HttpStatus.OK);
	}

	public ResponseEntity<File> getFile(
			@ApiParam(value = "Token of the current user", required = true) @PathVariable("token") String token,
			@ApiParam(value = "Id of the parent folder", required = true) @PathVariable("folderId") String folderId,
			@ApiParam(value = "Id of the file", required = true) @PathVariable("fileId") String fileId) {
		// do some magic!
		
		
	  

		fileService.getFile(token, folderId, fileId);
		return new ResponseEntity<File>(new File(), HttpStatus.OK);
	}

	public ResponseEntity<Folder> getFolder(
			@ApiParam(value = "Id of the folder to retrieve", required = true) @PathVariable("folderId") String folderId,
			@ApiParam(value = "token of the current user", required = true) @PathVariable("token") String token) {
		// do some magic!
        HttpHeaders headers = new HttpHeaders();

	   	 List<Folder> folder = null;
		try {
			folder=	folderService.getFolder(folderId ,token);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		System.out.println(folder);
	    if(folder != null) return new ResponseEntity<>(new  Folder(), headers,HttpStatus.OK);
	    
	      else return new ResponseEntity<>(headers, HttpStatus.EXPECTATION_FAILED); 
			
	   	
	}

	public ResponseEntity<File> uploadFile(
			@ApiParam(value = "Token of the current user", required = true) @PathVariable("token") String token,
			@ApiParam(value = "Id of the parent folder", required = true) @PathVariable("folderId") String folderId,
			@ApiParam(value = "file detail") @RequestPart("file")  MultipartFile file) throws IOException {

		File uploadedFile = fileService.upload(token, folderId, file);

		return new ResponseEntity<File>(uploadedFile, HttpStatus.OK);
	}

}
