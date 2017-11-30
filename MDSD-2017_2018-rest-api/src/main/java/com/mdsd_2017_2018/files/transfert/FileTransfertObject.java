package com.mdsd_2017_2018.files.transfert;

import java.util.Date;

public class FileTransfertObject {

	private String name;
	private String url;
	private Long size;
	private String ext;
	private Date uploadDate;

	public FileTransfertObject() {
	}

	public FileTransfertObject(String name, String url, Long size, String ext, Date uploadDate) {
		this.name = name;
		this.url = url;
		this.size = size;
		this.ext = ext;
		this.uploadDate = uploadDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

}
