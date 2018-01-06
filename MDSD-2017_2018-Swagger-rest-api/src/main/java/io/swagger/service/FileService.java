package io.swagger.service;

import java.io.IOException;
import java.io.InputStream;
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
import org.springframework.web.multipart.MultipartFile;

import com.mdsd_2017_2018.s3_transactions.service.FileTransaction;

import io.swagger.ApiConstant;
import io.swagger.model.File;
import io.swagger.model.FileEdit;
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

	
	public void deleteFile(String token, String folderId, String fileId){
		User user = userRepository.findByToken(token);

		if (user == null) {
			throw new ForbiddenException();
		}
		Folder folder = folderRepository.findOne(folderId);

		if (folder == null) {
			throw new NotFoundException();
		}
		
		File file = fileRepository.findOne(fileId);
		if (file == null) {
			throw new NotFoundException();
		}
		System.out.println("file = " + file.toString());
		fileTransaction = new FileTransaction();
		fileTransaction.delete(file.getPath());
		fileRepository.delete(file);
	}
	
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
		if (multipartFile.getSize() >= ApiConstant.max_file_size) {
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
		String url = folder.getUrl() + multipartFile.getOriginalFilename();
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

	public File get(String token, String folderId, String fileId) {

		User user = userRepository.findByToken(token);
		if (user == null) {
			throw new ForbiddenException();
		}
		Folder folder = folderRepository.findOne(folderId);

		if (folder == null) {
			throw new NotFoundException();
		}
		File file = fileRepository.findOne(fileId);
		if (file == null) {
			throw new NotFoundException();
		}

		return file;
	}

	public Folder edit(String token, String folderId, String fileId, FileEdit fileEdit) {

		User user = userRepository.findByToken(token);
		if (user == null) {
			throw new ForbiddenException();
		}
		Folder folder = folderRepository.findOne(folderId);

		if (folder == null) {
			throw new NotFoundException();
		}
		File file = fileRepository.findOne(fileId);
		if (file == null) {
			throw new NotFoundException();
		}

		String new_path = folder.getPath() + fileEdit.getName();
		String new_url = folder.getUrl() + fileEdit.getName();

		fileTransaction = new FileTransaction();
		fileTransaction.rename(file.getPath(), new_path);

		file.setName(fileEdit.getName());
		file.setPath(new_path);
		file.setUrl(new_url);

		fileRepository.save(file);

		return folderRepository.findOne(folderId);
	}

	public List<File> findAllSubFromRoot(String rootId) {
		List<File> files = new ArrayList<>();

		if (rootId == null) {
			return null;
		}

		Folder root = folderRepository.findOne(rootId);
		if (root == null) {
			return null;
		}

		return getAllSub(root, files);

	}

	public List<File> getAllSub(Folder root, List<File> actual_list) {

		actual_list.addAll(root.getFiles());
		for (Folder sub_folder : root.getSubFolders()) {
			getAllSub(sub_folder, actual_list);
		}

		return actual_list;
	}

}
