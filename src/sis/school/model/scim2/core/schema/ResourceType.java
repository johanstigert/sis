package sis.school.model.scim2.core.schema;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.Resource;
import sis.school.model.scim2.core.element.SchemaExtension;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "name", "endpoint", "description", "schema", "schemaExtensions", "meta" })
public class ResourceType extends Resource {

	private String name;
	private String endpoint;
	private String description;
	private String schema;
	private List<SchemaExtension> schemaExtensions;

	public ResourceType() {
	}

	public ResourceType(String name, String endpoint, String description, String schema,
			List<SchemaExtension> schemaExtensions) {
		super();
		this.name = name;
		this.endpoint = endpoint;
		this.description = description;
		this.schema = schema;
		this.schemaExtensions = schemaExtensions;
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

	public List<SchemaExtension> getSchemaExtensions() {
		return schemaExtensions;
	}

	public void setSchemaExtensions(List<SchemaExtension> schemaExtensions) {
		this.schemaExtensions = schemaExtensions;
	}

	public void addSchemaExtension(SchemaExtension schemaExtension) {
		if (this.schemaExtensions == null) {
			this.schemaExtensions = new ArrayList<SchemaExtension>();
		}
		this.schemaExtensions.add(schemaExtension);
	}
}
