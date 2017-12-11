package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Folder;
import io.swagger.model.FolderFiles;
import io.swagger.model.FolderSubFolders;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;




/**
 * Folder
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-12-11T17:49:32.673+01:00")

public class Folder   {
  private String id = null;

  private Folder parent = null;

  private List<FolderSubFolders> subFolders = new ArrayList<FolderSubFolders>();

  private List<FolderFiles> files = new ArrayList<FolderFiles>();

  private String name = null;

  private DateTime createDate = null;

  private String url = null;

  public Folder id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Folder parent(Folder parent) {
    this.parent = parent;
    return this;
  }

   /**
   * Get parent
   * @return parent
  **/
  @ApiModelProperty(value = "")
  public Folder getParent() {
    return parent;
  }

  public void setParent(Folder parent) {
    this.parent = parent;
  }

  public Folder subFolders(List<FolderSubFolders> subFolders) {
    this.subFolders = subFolders;
    return this;
  }

  public Folder addSubFoldersItem(FolderSubFolders subFoldersItem) {
    this.subFolders.add(subFoldersItem);
    return this;
  }

   /**
   * Get subFolders
   * @return subFolders
  **/
  @ApiModelProperty(value = "")
  public List<FolderSubFolders> getSubFolders() {
    return subFolders;
  }

  public void setSubFolders(List<FolderSubFolders> subFolders) {
    this.subFolders = subFolders;
  }

  public Folder files(List<FolderFiles> files) {
    this.files = files;
    return this;
  }

  public Folder addFilesItem(FolderFiles filesItem) {
    this.files.add(filesItem);
    return this;
  }

   /**
   * Get files
   * @return files
  **/
  @ApiModelProperty(value = "")
  public List<FolderFiles> getFiles() {
    return files;
  }

  public void setFiles(List<FolderFiles> files) {
    this.files = files;
  }

  public Folder name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "MDSD", value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Folder createDate(DateTime createDate) {
    this.createDate = createDate;
    return this;
  }

   /**
   * Get createDate
   * @return createDate
  **/
  @ApiModelProperty(value = "")
  public DateTime getCreateDate() {
    return createDate;
  }

  public void setCreateDate(DateTime createDate) {
    this.createDate = createDate;
  }

  public Folder url(String url) {
    this.url = url;
    return this;
  }

   /**
   * Get url
   * @return url
  **/
  @ApiModelProperty(value = "")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Folder folder = (Folder) o;
    return Objects.equals(this.id, folder.id) &&
        Objects.equals(this.parent, folder.parent) &&
        Objects.equals(this.subFolders, folder.subFolders) &&
        Objects.equals(this.files, folder.files) &&
        Objects.equals(this.name, folder.name) &&
        Objects.equals(this.createDate, folder.createDate) &&
        Objects.equals(this.url, folder.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, parent, subFolders, files, name, createDate, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Folder {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
    sb.append("    subFolders: ").append(toIndentedString(subFolders)).append("\n");
    sb.append("    files: ").append(toIndentedString(files)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    createDate: ").append(toIndentedString(createDate)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

