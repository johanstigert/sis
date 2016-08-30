package sis.school.model.scim2.user.element;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.extension.element.DateRange;
import sis.school.model.scim2.extension.element.GroupReference;
import sis.school.model.scim2.user.Employee;

/**
 * 
 * @see Employee
 *
 */
@JsonPropertyOrder({ "employmentPercent", "employmentTime", "isTeacher", "schoolUnit", "signature" })
public class Employment {

	private int employmentPercent;
	private DateRange employmentTime;
	private boolean isTeacher;
	private GroupReference schoolUnit;
	private String signature;

	public Employment(int employmentPercent, DateRange employmentTime, boolean isTeacher, GroupReference schoolUnit,
			String signature) {
		super();
		this.employmentPercent = employmentPercent;
		this.employmentTime = employmentTime;
		this.isTeacher = isTeacher;
		this.schoolUnit = schoolUnit;
		this.signature = signature;
	}

	public int getEmploymentPercent() {
		return employmentPercent;
	}

	public void setEmploymentPercent(int employmentPercent) {
		this.employmentPercent = employmentPercent;
	}

	public DateRange getEmploymentTime() {
		return employmentTime;
	}

	public void setEmploymentTime(DateRange employmentTime) {
		this.employmentTime = employmentTime;
	}

	public boolean isTeacher() {
		return isTeacher;
	}

	public void setTeacher(boolean isTeacher) {
		this.isTeacher = isTeacher;
	}

	public GroupReference getSchoolUnit() {
		return schoolUnit;
	}

	public void setSchoolUnit(GroupReference schoolUnit) {
		this.schoolUnit = schoolUnit;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employmentPercent;
		result = prime * result + ((employmentTime == null) ? 0 : employmentTime.hashCode());
		result = prime * result + (isTeacher ? 1231 : 1237);
		result = prime * result + ((schoolUnit == null) ? 0 : schoolUnit.hashCode());
		result = prime * result + ((signature == null) ? 0 : signature.hashCode());
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
		Employment other = (Employment) obj;
		if (employmentPercent != other.employmentPercent)
			return false;
		if (employmentTime == null) {
			if (other.employmentTime != null)
				return false;
		} else if (!employmentTime.equals(other.employmentTime))
			return false;
		if (isTeacher != other.isTeacher)
			return false;
		if (schoolUnit == null) {
			if (other.schoolUnit != null)
				return false;
		} else if (!schoolUnit.equals(other.schoolUnit))
			return false;
		if (signature == null) {
			if (other.signature != null)
				return false;
		} else if (!signature.equals(other.signature))
			return false;
		return true;
	}
}
