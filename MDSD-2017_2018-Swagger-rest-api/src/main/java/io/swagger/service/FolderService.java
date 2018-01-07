package io.swagger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdsd_2017_2018.s3_transactions.service.FileTransaction;

import io.swagger.model.File;
import io.swagger.model.Folder;
import io.swagger.model.FolderCreate;
import io.swagger.model.User;
import io.swagger.repository.FileRepository;
import io.swagger.repository.FolderRepository;
import io.swagger.repository.UserRepository;

@Service
@Transactional
public class FolderService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FolderRepository folderRepository;
	@Autowired
	private FileRepository fileRepository;
	@Inject
	private FileService fileService;

	private FileTransaction fileTransaction;

	public void delete(String token, String folderId){
		User user = userRepository.findByToken(token);

		if (user == null) {
			throw new ForbiddenException();
		}
		Folder folder = folderRepository.findOne(folderId);

		if (folder == null) {
			throw new NotFoundException();
		}
		if (folder.getParent() == null){
			throw new ForbiddenException();
		}
		fileTransaction = new FileTransaction();
		fileTransaction.delete(folder.getPath());
		folderRepository.delete(folder);
	}
	
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

	public Folder get(String folderId, String token) {

		User user = userRepository.findByToken(token);

		if (user == null) {
			throw new ForbiddenException();
		}

		Folder folder = folderRepository.findOne(folderId);

		if (folder == null) {
			throw new NotFoundException();
		}

		return folder;
	}

	public Folder edit(String folderId, String token, FolderCreate folder) {

		User user = userRepository.findByToken(token);

		if (user == null) {
			throw new ForbiddenException();
		}

		Folder actual = folderRepository.findOne(folderId);

		if (actual == null) {
			throw new NotFoundException();
		}

		if (actual.getParent() == null) {
			throw new BadRequestException();
		}

		Folder parent = folderRepository.findOne(actual.getParent());

		if (parent == null) {
			throw new BadRequestException();
		}

		List<File> old_files = fileService.findAllSubFromRoot(folderId);
		List<String> old_paths = new ArrayList<>();

		for (File f : old_files) {
			old_paths.add(f.getPath());
		}
		String old_path = actual.getPath();

		String new_path = parent.getPath() + folder.getName() + "/";
		String new_url = parent.getUrl() + folder.getName() + "/";

		actual.setPath(new_path);
		actual.setUrl(new_url);
		actual.setName(folder.getName());

		actual = update_recursive(actual, parent);

		List<File> new_files = fileService.findAllSubFromRoot(folderId);

		moveFiles(old_files, old_paths, new_files);

		fileTransaction = new FileTransaction();
		System.out.println(old_path);

		fileTransaction.delete(old_path);

		return actual;
	}

	private Folder update_recursive(Folder folder, Folder parent) {

		String new_path, new_url;

		if (parent == null) {
			new_path = folder.getName() + "/";
			new_url = folder.getName() + "/";
		} else {
			new_path = parent.getPath() + folder.getName() + "/";
			new_url = parent.getUrl() + folder.getName() + "/";
		}

		folder.setPath(new_path);
		folder.setUrl(new_url);

		List<File> files = new ArrayList<>();

		// files
		for (File file : folder.getFiles()) {
			file.setPath(folder.getPath() + file.getName());
			file.setUrl(folder.getUrl() + file.getName());
			files.add(fileRepository.save(file));
		}

		folder.setFiles(files);

		// save folder
		folder = folderRepository.save(folder);

		// folders
		for (int i = 0; i < folder.getSubFolders().size(); i++) {

			// get sub folder
			Folder sub_folder = folder.getSubFolders().get(i);

			// set sub folder in parent
			folder.getSubFolders().set(i, update_recursive(sub_folder, folder));
		}

		return folder;
	}

	public void moveFiles(List<File> old_files, List<String> old_paths, List<File> new_files) {

		fileTransaction = new FileTransaction();

		int i = 0;

		for (File old_file : old_files) {
			for (File new_file : new_files) {
				if (old_file.getId().equals(new_file.getId())) {
					fileTransaction.rename(old_paths.get(i), new_file.getPath());
				}
			}
			i++;
		}
	}

	public List<Folder> findAllSubFolderFromParent(String rootId) {
		List<Folder> sub_folders = new ArrayList<>();

		if (rootId == null) {
			return null;
		}

		Folder root = folderRepository.findOne(rootId);
		if (root == null) {
			return null;
		}

		return getAllSub(root, sub_folders);

	}

	public List<Folder> getAllSub(Folder root, List<Folder> actual_list) {

		actual_list.addAll(root.getSubFolders());
		for (Folder sub_folder : root.getSubFolders()) {
			getAllSub(sub_folder, actual_list);
		}

		return actual_list;
	}

	public boolean match_user_folder(User user, Folder folder) {
		List<Folder> folders = findAllSubFolderFromParent(user.getHome().getId());

		for (Folder sub_folder : folders) {
			if (sub_folder.getId().equals(folder.getId())) {
				return true;
			}
		}

		return false;

	}

}
