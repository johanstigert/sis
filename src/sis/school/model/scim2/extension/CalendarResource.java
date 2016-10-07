package sis.school.model.scim2.extension;

<<<<<<< HEAD
import static sis.school.model.scim2.extension.element.Constant.BASE_URI;
import static sis.school.model.scim2.extension.element.Constant.URN_RESOURCE;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.Meta;
import sis.school.model.scim2.core.Resource;
import sis.school.model.scim2.core.element.Reference;
import sis.school.model.scim2.core.schema.ResourceType;

@JsonPropertyOrder({ "schemas", "id", "name", "description", "schoolGroup", "meta" })
public class CalendarResource extends Resource {

	private String name;
	private String description;
	private Reference schoolGroup;

	public CalendarResource() {
	}

	public CalendarResource(String id) {
		super(id);
	}

	public CalendarResource(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

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

	public Reference getSchoolGroup() {
		return schoolGroup;
	}

	public void setSchoolGroup(Reference schoolGroup) {
		this.schoolGroup = schoolGroup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CalendarResource other = (CalendarResource) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public static ResourceType getResourceType() {
		ResourceType type = new ResourceType("Resource", "/Resources", "Resource", URN_RESOURCE, null);
		type.setMeta(new Meta("ResourceType", null, null, BASE_URI + "/ResourceTypes/Resource", null));
		return type;
=======
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.Resource;

@JsonPropertyOrder({ "schemas", "id", "name", "description", "meta" })
public class CalendarResource extends Resource {

	private String id;
	private String name;
	private String description;

	public CalendarResource(String id) {
	}

	public CalendarResource(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CalendarResource other = (CalendarResource) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
>>>>>>> branch 'master' of https://github.com/johanstigert/sis.git
	}
}
