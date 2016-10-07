package sis.school.model.scim2.core.element;

public class SchemaExtension {

	private String schema;
	private boolean required;

	public SchemaExtension() {
	}

	public SchemaExtension(String schema, boolean required) {
		super();
		this.schema = schema;
		this.required = required;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}
}
