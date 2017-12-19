package io.swagger.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Folder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * User
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-12-11T17:49:32.673+01:00")

@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = -3661990521330716588L;

	@Id
	private UUID id = null;

	private String username = null;

	private String password = null;

	@OneToOne
	private Folder home = null;

	private UUID token = null;

	public User id(UUID id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "")
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public User username(String username) {
		this.username = username;
		return this;
	}

	/**
	 * Get username
	 * 
	 * @return username
	 **/
	@ApiModelProperty(value = "")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User password(String password) {
		this.password = password;
		return this;
	}

	/**
	 * Get password
	 * 
	 * @return password
	 **/
	@ApiModelProperty(value = "")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User home(Folder home) {
		this.home = home;
		return this;
	}

	/**
	 * Get home
	 * 
	 * @return home
	 **/
	@ApiModelProperty(value = "")
	public Folder getHome() {
		return home;
	}

	public void setHome(Folder home) {
		this.home = home;
	}

	public User token(UUID token) {
		this.token = token;
		return this;
	}

	/**
	 * Get token
	 * 
	 * @return token
	 **/
	@ApiModelProperty(value = "")
	public UUID getToken() {
		return token;
	}

	public void setToken(UUID token) {
		this.token = token;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return Objects.equals(this.id, user.id) && Objects.equals(this.username, user.username)
				&& Objects.equals(this.password, user.password) && Objects.equals(this.home, user.home)
				&& Objects.equals(this.token, user.token);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, password, home, token);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class User {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    username: ").append(toIndentedString(username)).append("\n");
		sb.append("    password: ").append(toIndentedString(password)).append("\n");
		sb.append("    home: ").append(toIndentedString(home)).append("\n");
		sb.append("    token: ").append(toIndentedString(token)).append("\n");
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
