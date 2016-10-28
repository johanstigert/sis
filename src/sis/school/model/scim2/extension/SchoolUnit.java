package sis.school.model.scim2.extension;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.Resource;
import sis.school.model.scim2.core.element.Reference;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "schemas", "id", "name", "schoolUnitCode", "schoolTypes", "school", "meta" })
public class SchoolUnit extends Resource {

	private String name;
	private String schoolUnitCode;
	private List<String> schoolTypes;
	private Reference school;

	public SchoolUnit() {
	}

	public SchoolUnit(String id) {
		super(id);
	}

	public SchoolUnit(String name, String schoolUnitCode, List<String> schoolTypes, Reference school) {
		super();
		this.name = name;
		this.schoolUnitCode = schoolUnitCode;
		this.schoolTypes = schoolTypes;
		this.school = school;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchoolUnitCode() {
		return schoolUnitCode;
	}

	public void setSchoolUnitCode(String schoolUnitCode) {
		this.schoolUnitCode = schoolUnitCode;
	}

	public List<String> getSchoolTypes() {
		return schoolTypes;
	}

	public void setSchoolTypes(List<String> schoolTypes) {
		this.schoolTypes = schoolTypes;
	}

	public Reference getSchool() {
		return school;
	}

	public void setSchool(Reference school) {
		this.school = school;
	}

	// public void addSchool(Reference school) {
	// if (this.school == null) {
	// this.school = new ArrayList<Reference>();
	// }
	// this.school.add(school);
	// }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((schoolTypes == null) ? 0 : schoolTypes.hashCode());
		result = prime * result + ((schoolUnitCode == null) ? 0 : schoolUnitCode.hashCode());
		result = prime * result + ((school == null) ? 0 : school.hashCode());
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
		SchoolUnit other = (SchoolUnit) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (schoolTypes == null) {
			if (other.schoolTypes != null)
				return false;
		} else if (!schoolTypes.equals(other.schoolTypes))
			return false;
		if (schoolUnitCode == null) {
			if (other.schoolUnitCode != null)
				return false;
		} else if (!schoolUnitCode.equals(other.schoolUnitCode))
			return false;
		if (school == null) {
			if (other.school != null)
				return false;
		} else if (!school.equals(other.school))
			return false;
		return true;
	}
}
