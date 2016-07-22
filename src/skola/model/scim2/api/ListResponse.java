package skola.model.scim2.api;

import java.util.List;

// https://tools.ietf.org/html/rfc7644#section-3.4.2
public class ListResponse {

	private String[] schemas;
	private int itemsPerPage;
	private int totalResults;
	private int startIndex;
	private List<? extends skola.model.scim2.core.Resource> Resource;

	public ListResponse() {
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

	public List<? extends skola.model.scim2.core.Resource> getResource() {
		return Resource;
	}

	public void setResource(List<? extends skola.model.scim2.core.Resource> resource) {
		Resource = resource;
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
}