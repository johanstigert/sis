package skola.model.scim2.core.schema;

import java.util.ArrayList;
import java.util.List;

import skola.model.scim2.core.Resource;

/**
 * 
 * ©TimeEdit 2016
 *
 */
public class Schema extends Resource {

	private String name;
	private String description;
	private List<Attribute> attributes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public void addAttribute(Attribute attribute) {
		if (this.attributes == null) {
			this.attributes = new ArrayList<Attribute>();
		}
		this.attributes.add(attribute);
	}
}
