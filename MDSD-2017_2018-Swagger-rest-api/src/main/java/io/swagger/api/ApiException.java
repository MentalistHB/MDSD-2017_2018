package io.swagger.api;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-12-11T17:49:32.673+01:00")

public class ApiException extends Exception {

	private static final long serialVersionUID = -2174637728997742359L;

	@SuppressWarnings("unused")
	private int code;

	public ApiException(int code, String msg) {
		super(msg);
		this.code = code;
	}
}
