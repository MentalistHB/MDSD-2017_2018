package com.mdsd_2017_2018.files.rest.file;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mdsd_2017_2018.files.rest.ApiConstant;
import com.mdsd_2017_2018.files.service.FileService;
import com.mdsd_2017_2018.files.transfert.FileTransfertObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description = "Rest resource for uploading a file and list all files")
@RestController
@RequestMapping(ApiConstant.COLLECTION_PATH)
public class FileRootResource {

	@Inject
	FileService fileService;

	@ApiOperation(value = "Upload a file",
			notes = "Upload one file as Multipart.",
			response = FileTransfertObject.class)
	@RequestMapping(method = RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public FileTransfertObject create(@ApiParam(required = false) @RequestParam("file") MultipartFile file) {

		return null;
	}

	@ApiOperation(value = "List all files", notes = "List all files optionally by name, page and size for each page.", response = FileTransfertObject.class, responseContainer = "List")
	@RequestMapping(method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public List<FileTransfertObject> list(
			@ApiParam(required = false) @RequestParam(value = "name", defaultValue = "") String name,
			@ApiParam(required = false) @RequestParam(value = "page", defaultValue = "1") Integer page,
			@ApiParam(required = false) @RequestParam(value = "size", defaultValue = "15") Integer size) {

		return null;
	}
}
