package io.swagger.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class File implements Serializable {

	private static final long serialVersionUID = 3078938945094929253L;

	@Id
	private String id;
	private Folder parent;
	private String name;
	private String ext;
	private Date uploadDate;
	private String url;

	public File() {
	}

	public File(String id, Folder parent, String name, String ext, Date uploadDate, String url) {
		this.id = id;
		this.parent = parent;
		this.name = name;
		this.ext = ext;
		this.uploadDate = uploadDate;
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Folder getParent() {
		return parent;
	}

	public void setParent(Folder parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
