package skola.model.scim2.api;

import static skola.model.scim2.extension.element.Constant.URN_ERROR;

/**
 * 
 * ©TimeEdit 2016
 *
 */
// https://tools.ietf.org/html/rfc7644#section-3.12
public class ApiError {

	private String[] schemas;
	private String status;
	private String scimType;
	private String detail;

	public ApiError() {
	}

	public ApiError(String status, String scimType, String detail) {
		this.schemas = new String[1];
		this.schemas[0] = URN_ERROR;
		this.status = status;
		this.scimType = scimType;
		this.detail = detail;
	}

	public String[] getSchemas() {
		return schemas;
	}

	public void setSchemas(String[] schemas) {
		this.schemas = schemas;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getScimType() {
		return scimType;
	}

	public void setScimType(String scimType) {
		this.scimType = scimType;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
