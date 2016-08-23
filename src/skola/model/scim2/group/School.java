package skola.model.scim2.group;

import java.util.List;

/**
 * 
 * ©TimeEdit 2016
 *
 */
// https://github.com/girgen/skolschema/blob/master/group-skola.json
public class School implements IGroupType {

	private List<String> schoolUnits;

	public School() {
	}

	public List<String> getSchoolUnits() {
		return schoolUnits;
	}

	public void setSchoolUnits(List<String> schoolUnits) {
		this.schoolUnits = schoolUnits;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((schoolUnits == null) ? 0 : schoolUnits.hashCode());
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
		School other = (School) obj;
		if (schoolUnits == null) {
			if (other.schoolUnits != null)
				return false;
		} else if (!schoolUnits.equals(other.schoolUnits))
			return false;
		return true;
	}
}
