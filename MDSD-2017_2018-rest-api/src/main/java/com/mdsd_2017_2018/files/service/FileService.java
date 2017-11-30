package com.mdsd_2017_2018.files.service;

import java.io.InputStream;
import java.util.List;

import javax.inject.Named;

import com.mdsd_2017_2018.files.transfert.FileTransfertObject;

@Named
public class FileService {

	/**
	 * list all file
	 *
	 * @param fileName
	 *
	 * @return
	 * 
	 * 		throws BadRequestException in case
	 * 			the page and the size are negative or 0
	 */
	public List<FileTransfertObject> list(String fileName) {

		return null;
	}

	/**
	 * get file
	 *
	 * @param fileName
	 *
	 * @return
	 * 
	 * 		throws NotFoundException if the file name is not found
	 */
	public FileTransfertObject get(String fileName) {

		return null;
	}

	/**
	 * create file
	 *
	 * @param file
	 *
	 * @return
	 * 
	 */
	public FileTransfertObject upload(InputStream file) {

		return null;
	}

	/**
	 * delete file
	 *
	 * @param fileName
	 *
	 * @return
	 * 
	 * 		throws NotFoundException if the file name is not found
	 */
	public void delete(String fileName) {

	}
}
