package io.swagger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.swagger.model.File;
import io.swagger.model.Folder;
import io.swagger.model.FolderCreate;
import io.swagger.model.User;
import io.swagger.repository.FolderRepository;
import io.swagger.repository.UserRepository;

@Service
@Transactional
public class FolderService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FolderRepository folderRepository;

	public Folder create(String token, String folderId, FolderCreate folderCreate) {

		User user = userRepository.findByToken(token);

		if (user == null) {
			throw new ForbiddenException();
		}

		Folder parent = folderRepository.findOne(folderId);

		if (parent == null) {
			throw new NotFoundException();
		}

		// check if the folder already exists
		if (parent.hasSubFolder(folderCreate.getName())) {
			throw new BadRequestException();
		}

		Folder folder = new Folder();

		List<Folder> subFolders = new ArrayList<>();
		List<File> files = new ArrayList<>();

		folder.setId(UUID.randomUUID().toString());
		folder.setParent(parent.getId().toString());
		folder.setCreateDate(new Date());
		folder.setFiles(files);
		folder.setSubFolders(subFolders);
		folder.setName(folderCreate.getName());
		folder.setPath(parent.getPath() + folderCreate.getName() + "/");
		folder.setUrl(parent.getUrl() + folderCreate.getName() + "/");

		return folderRepository.save(folder);
	}

}
