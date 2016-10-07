package sis.school.model.scim2.api;

import static sis.school.model.scim2.extension.element.Constant.URN_LISTRESPONSE;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import sis.school.model.scim2.extension.UserExtended;

/**
 * 
 * ©TimeEdit 2016
 *
 */
// https://tools.ietf.org/html/rfc7644#section-3.4.2
public class ListUserResponse {

	private String[] schemas;
	private int itemsPerPage;
	private int totalResults;
	private int startIndex;
	@JsonProperty("Resources")
	private List<UserExtended> resources;

	public ListUserResponse() {
		schemas = new String[1];
		schemas[0] = URN_LISTRESPONSE;
	}

	public String[] getSchemas() {
		return schemas;
	}

	public void setSchemas(String[] schemas) {
		this.schemas = schemas;
	}

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	public int getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public List<UserExtended> getResource() {
		return resources;
	}

	public void setResource(List<UserExtended> resource) {
		resources = resource;
	}
}
