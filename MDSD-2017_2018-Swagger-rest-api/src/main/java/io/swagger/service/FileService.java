package io.swagger.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.mdsd_2017_2018.s3_transactions.service.FileTransaction;

import io.swagger.model.File;
import io.swagger.model.Folder;
import io.swagger.model.User;
import io.swagger.repository.FileRepository;
import io.swagger.repository.FolderRepository;
import io.swagger.repository.UserRepository;

@Service
@Transactional
public class FileService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FolderRepository folderRepository;
	@Autowired
	private FileRepository fileRepository;

	private FileTransaction fileTransaction;

	public File upload(String token, String folderId, MultipartFile multipartFile) throws IOException {

		User user = userRepository.findByToken(token);

		if (user == null) {
			throw new ForbiddenException();
		}

		Folder folder = folderRepository.findOne(folderId);

		if (folder == null) {
			throw new NotFoundException();
		}

		// check the size of the file
		if (multipartFile.getSize() >= 30000000) {
			throw new BadRequestException();
		}

		// check if the file already exists
		File file = fileRepository.findByName(multipartFile.getOriginalFilename());
		if (file == null) {
			file = new File();
			file.setId(UUID.randomUUID().toString());
		}

		// generate and save the file entity
		file.setName(multipartFile.getOriginalFilename());
		file.setParent(folder.getId().toString());
		file.setUploadDate(new Date());
		file.setPath(folder.getPath() + multipartFile.getOriginalFilename());
		String url = folder.getUrl() + "/" + multipartFile.getOriginalFilename();
		file.setUrl(url);

		file = fileRepository.save(file);

		folder.addFile(file);
		folder = folderRepository.save(folder);

		// upload the file onto the server
		long size = multipartFile.getSize();
		InputStream inputStream = multipartFile.getInputStream();
		fileTransaction = new FileTransaction();
		fileTransaction.upload(file.getPath(), inputStream, size);

		return file;
	}

}
