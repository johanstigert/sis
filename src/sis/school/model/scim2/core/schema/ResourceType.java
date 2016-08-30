package sis.school.model.scim2.core.schema;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.Resource;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "name", "endpoint", "description", "schema", "meta" })
public class ResourceType extends Resource {

	// TODO: schemaExtensions

	private String name;
	private String endpoint;
	private String description;
	private String schema;

	public ResourceType() {
	}

	public ResourceType(String name, String endpoint, String description, String schema) {
		super();
		this.name = name;
		this.endpoint = endpoint;
		this.description = description;
		this.schema = schema;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}
}
