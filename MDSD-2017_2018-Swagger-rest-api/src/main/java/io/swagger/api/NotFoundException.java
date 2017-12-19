package io.swagger.api;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-12-11T17:49:32.673+01:00")

public class NotFoundException extends ApiException {

	private static final long serialVersionUID = -8000903005649088467L;
	
	@SuppressWarnings("unused")
	private int code;
	public NotFoundException (int code, String msg) {
		super(code, msg);
		this.code = code;
	}
}
