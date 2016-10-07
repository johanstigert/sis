package sis.school.model.scim2.extension;

import static sis.school.model.scim2.extension.element.Constant.BASE_URI;
import static sis.school.model.scim2.extension.element.Constant.URN_SUBJECT;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.Meta;
import sis.school.model.scim2.core.Resource;
import sis.school.model.scim2.core.schema.ResourceType;

@JsonPropertyOrder({ "schemas", "id", "subjectCode", "name", "subjectShortName", "official", "meta" })
public class Subject extends Resource {

	private String subjectCode;
	private String name;
	private String subjectShortName;
	private boolean official;

	public Subject() {
	}

	public Subject(String id) {
		super(id);
	}

	public Subject(String subjectCode, String name, String subjectShortName, boolean official) {
		super();
		this.subjectCode = subjectCode;
		this.name = name;
		this.subjectShortName = subjectShortName;
		this.official = official;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubjectShortName() {
		return subjectShortName;
	}

	public void setSubjectShortName(String subjectShortName) {
		this.subjectShortName = subjectShortName;
	}

	public boolean isOfficial() {
		return official;
	}

	public void setOfficial(boolean official) {
		this.official = official;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (official ? 1231 : 1237);
		result = prime * result + ((subjectCode == null) ? 0 : subjectCode.hashCode());
		result = prime * result + ((subjectShortName == null) ? 0 : subjectShortName.hashCode());
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
		Subject other = (Subject) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (official != other.official)
			return false;
		if (subjectCode == null) {
			if (other.subjectCode != null)
				return false;
		} else if (!subjectCode.equals(other.subjectCode))
			return false;
		if (subjectShortName == null) {
			if (other.subjectShortName != null)
				return false;
		} else if (!subjectShortName.equals(other.subjectShortName))
			return false;
		return true;
	}

	public static ResourceType getResourceType() {
		ResourceType type = new ResourceType("Subject", "/Subjects", "Subject", URN_SUBJECT, null);
		type.setMeta(new Meta("ResourceType", null, null, BASE_URI + "/ResourceTypes/Subject", null));
		return type;
	}
}
