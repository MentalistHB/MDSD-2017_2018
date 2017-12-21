package com.mdsd_2017_2018.files.rest.file;

import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdsd_2017_2018.files.rest.ApiConstant;
import com.mdsd_2017_2018.files.service.FileService;
import com.mdsd_2017_2018.files.transfert.FileTransfertObject;
import com.mdsd_2017_2018.files.transfert.NameTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description = "Rest resource for getting and deleting a single file."
		+ "A transfert object is given as JSON in body because of the spaces in the name as parameter in the url.")
@RestController
@RequestMapping(ApiConstant.ITEM_PATH)
public class FileResource {

	@Inject
	FileService fileService;

	@ApiOperation(value = "Get a file", notes = "Get one file given its name. Because of the reason in the header, the GET inteface becomes a POST interface", response = FileTransfertObject.class)
	@RequestMapping(method = RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON)
	public FileTransfertObject get(@ApiParam(required = true) @RequestBody NameTO nameTO) {

		return null;
	}

	@ApiOperation(value = "Delete a file", notes = "Delete one file given its name.")
	@RequestMapping(method = RequestMethod.DELETE)
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@ApiParam(required = true) @RequestBody NameTO nameTO) {

	}
}
