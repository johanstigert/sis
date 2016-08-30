package sis.school.model.scim2.group;

import java.util.List;

import sis.school.model.scim2.extension.element.Responsible;

/**
 * 
 * ©TimeEdit 2016
 *
 */
// https://github.com/girgen/skolschema/blob/master/klass.json
public class Class implements IGroupType {

	private String schoolform;
	private List<Responsible> responsibles;

	public Class() {
	}

	public Class(String schoolform, List<Responsible> responsibles) {
		this.schoolform = schoolform;
		this.responsibles = responsibles;
	}

	public String getSchoolform() {
		return schoolform;
	}

	public void setSchoolform(String schoolform) {
		this.schoolform = schoolform;
	}

	public List<Responsible> getResponsibles() {
		return responsibles;
	}

	public void setResponsibles(List<Responsible> responsibles) {
		this.responsibles = responsibles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((responsibles == null) ? 0 : responsibles.hashCode());
		result = prime * result + ((schoolform == null) ? 0 : schoolform.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Class other = (Class) obj;
		if (responsibles == null) {
			if (other.responsibles != null)
				return false;
		} else if (!responsibles.equals(other.responsibles))
			return false;
		if (schoolform == null) {
			if (other.schoolform != null)
				return false;
		} else if (!schoolform.equals(other.schoolform))
			return false;
		return true;
	}
}
