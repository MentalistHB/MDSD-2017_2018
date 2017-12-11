package io.swagger.api;

import io.swagger.model.FolderCreate;
import io.swagger.model.Folder;
import io.swagger.model.FileDelete;
import io.swagger.model.FileEdit;
import java.io.File;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-12-11T17:49:32.673+01:00")

@Controller
public class TokenApiController implements TokenApi {

    public ResponseEntity<Folder> createFolder(
@ApiParam(value = "Id of the folder to create",required=true ) @PathVariable("folderId") String folderId


,
        
@ApiParam(value = "token of the current user",required=true ) @PathVariable("token") String token


,
        

@ApiParam(value = "Store a folder in data storage" ,required=true ) @RequestBody FolderCreate folder

) {
        // do some magic!
        return new ResponseEntity<Folder>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteFile(
@ApiParam(value = "Token of the current user",required=true ) @PathVariable("token") String token


,
        
@ApiParam(value = "Id of the parent folder",required=true ) @PathVariable("folderId") String folderId


,
        

@ApiParam(value = "Delete a file in data storage" ,required=true ) @RequestBody FileDelete file

) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteFolder(
@ApiParam(value = "Id of the folder to delete",required=true ) @PathVariable("folderId") String folderId


,
        
@ApiParam(value = "token of the current user",required=true ) @PathVariable("token") String token


) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Folder> editFile(
@ApiParam(value = "Token of the current user",required=true ) @PathVariable("token") String token


,
        
@ApiParam(value = "Id of the parent folder",required=true ) @PathVariable("folderId") String folderId


,
        

@ApiParam(value = "Edit a file name in data storage" ,required=true ) @RequestBody FileEdit file

) {
        // do some magic!
        return new ResponseEntity<Folder>(HttpStatus.OK);
    }

    public ResponseEntity<Folder> editFolder(
@ApiParam(value = "Id of the folder to edit",required=true ) @PathVariable("folderId") String folderId


,
        
@ApiParam(value = "token of the current user",required=true ) @PathVariable("token") String token


,
        

@ApiParam(value = "Edit a folder in data storage" ,required=true ) @RequestBody FolderCreate folder

) {
        // do some magic!
        return new ResponseEntity<Folder>(HttpStatus.OK);
    }

    public ResponseEntity<File> getFile(
@ApiParam(value = "Token of the current user",required=true ) @PathVariable("token") String token


,
        
@ApiParam(value = "Id of the parent folder",required=true ) @PathVariable("folderId") String folderId


) {
        // do some magic!
        return new ResponseEntity<File>(HttpStatus.OK);
    }

    public ResponseEntity<Folder> getFolder(
@ApiParam(value = "Id of the folder to retrieve",required=true ) @PathVariable("folderId") String folderId


,
        
@ApiParam(value = "token of the current user",required=true ) @PathVariable("token") String token


) {
        // do some magic!
        return new ResponseEntity<Folder>(HttpStatus.OK);
    }

    public ResponseEntity<File> uploadFile(
@ApiParam(value = "Token of the current user",required=true ) @PathVariable("token") String token


,
        
@ApiParam(value = "Id of the parent folder",required=true ) @PathVariable("folderId") String folderId


,
        


@ApiParam(value = "file detail") @RequestPart("file") MultipartFile file
) {
        // do some magic!
        return new ResponseEntity<File>(HttpStatus.OK);
    }

}
