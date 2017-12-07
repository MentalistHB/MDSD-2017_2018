package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Folder;




/**
 * FolderSubFolders
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-12-06T23:44:45.828+01:00")

public class FolderSubFolders   {
  private Folder folder = null;

  public FolderSubFolders folder(Folder folder) {
    this.folder = folder;
    return this;
  }

   /**
   * Get folder
   * @return folder
  **/
  @ApiModelProperty(value = "")
  public Folder getFolder() {
    return folder;
  }

  public void setFolder(Folder folder) {
    this.folder = folder;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FolderSubFolders folderSubFolders = (FolderSubFolders) o;
    return Objects.equals(this.folder, folderSubFolders.folder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(folder);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FolderSubFolders {\n");
    
    sb.append("    folder: ").append(toIndentedString(folder)).append("\n");
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

