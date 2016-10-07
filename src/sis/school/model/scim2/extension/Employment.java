package sis.school.model.scim2.extension;

<<<<<<< HEAD
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.Resource;
import sis.school.model.scim2.core.element.Reference;
import sis.school.model.scim2.extension.element.DateRange;

/**
 * 
 * @see Employee
 *
 */
@JsonPropertyOrder({ "schemas", "id", "employmentTime", "employmentPercent", "hoursPerYear", "isTeacher", "employedAt",
		"signature", "meta" })
public class Employment extends Resource {

	private DateRange employmentTime;
	private int employmentPercent;
	private int hoursPerYear;
	@JsonProperty("isTeacher")
	private boolean isTeacher;
	private Reference employedAt;
	private String signature;
	private List<Reference> users;
	private List<Reference> schools;

	public Employment() {
	}

	public Employment(String id) {
		super(id);
	}

	public Employment(DateRange employmentTime, int employmentPercent, int hoursPerYear, boolean isTeacher,
			Reference employedAt, String signature, List<Reference> users, List<Reference> schools) {
		super();
		this.employmentTime = employmentTime;
		this.employmentPercent = employmentPercent;
		this.hoursPerYear = hoursPerYear;
		this.isTeacher = isTeacher;
		this.employedAt = employedAt;
		this.signature = signature;
		this.users = users;
		this.setSchools(schools);
	}

	public DateRange getEmploymentTime() {
		return employmentTime;
	}

	public void setEmploymentTime(DateRange employmentTime) {
		this.employmentTime = employmentTime;
	}

	public int getEmploymentPercent() {
		return employmentPercent;
	}

	public void setEmploymentPercent(int employmentPercent) {
		this.employmentPercent = employmentPercent;
	}

	public int getHoursPerYear() {
		return hoursPerYear;
	}

	public void setHoursPerYear(int hoursPerYear) {
		this.hoursPerYear = hoursPerYear;
	}

	public boolean isTeacher() {
		return isTeacher;
	}

	public void setTeacher(boolean isTeacher) {
		this.isTeacher = isTeacher;
	}

	public Reference getEmployedAt() {
		return employedAt;
	}

	public void setEmployedAt(Reference employedAt) {
		this.employedAt = employedAt;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public List<Reference> getUsers() {
		return users;
	}

	public void setUsers(List<Reference> users) {
		this.users = users;
	}

	public List<Reference> getSchools() {
		return schools;
	}

	public void setSchools(List<Reference> schools) {
		this.schools = schools;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((employedAt == null) ? 0 : employedAt.hashCode());
		result = prime * result + employmentPercent;
		result = prime * result + ((employmentTime == null) ? 0 : employmentTime.hashCode());
		result = prime * result + hoursPerYear;
		result = prime * result + (isTeacher ? 1231 : 1237);
		result = prime * result + ((schools == null) ? 0 : schools.hashCode());
		result = prime * result + ((signature == null) ? 0 : signature.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Employment other = (Employment) obj;
		if (employedAt == null) {
			if (other.employedAt != null)
				return false;
		} else if (!employedAt.equals(other.employedAt))
			return false;
		if (employmentPercent != other.employmentPercent)
			return false;
		if (employmentTime == null) {
			if (other.employmentTime != null)
				return false;
		} else if (!employmentTime.equals(other.employmentTime))
			return false;
		if (hoursPerYear != other.hoursPerYear)
			return false;
		if (isTeacher != other.isTeacher)
			return false;
		if (schools == null) {
			if (other.schools != null)
				return false;
		} else if (!schools.equals(other.schools))
			return false;
		if (signature == null) {
			if (other.signature != null)
				return false;
		} else if (!signature.equals(other.signature))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
=======
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.Resource;
import sis.school.model.scim2.extension.element.DateRange;
import sis.school.model.scim2.extension.element.Reference;

/**
 * 
 * @see Employee
 *
 */
@JsonPropertyOrder({ "schemas", "id", "employmentTime", "employmentPercent", "hoursPerYear", "isTeacher", "employedAt",
		"signature", "meta" })
public class Employment extends Resource {

	private DateRange employmentTime;
	private int employmentPercent;
	private int hoursPerYear;
	private boolean isTeacher;
	private Reference employedAt;
	private String signature;

	public Employment() {
	}

	public Employment(String id) {
		super(id);
	}

	public Employment(DateRange employmentTime, int employmentPercent, int hoursPerYear, boolean isTeacher,
			Reference employedAt, String signature) {
		super();
		this.employmentTime = employmentTime;
		this.employmentPercent = employmentPercent;
		this.hoursPerYear = hoursPerYear;
		this.isTeacher = isTeacher;
		this.employedAt = employedAt;
		this.signature = signature;
	}

	public DateRange getEmploymentTime() {
		return employmentTime;
	}

	public void setEmploymentTime(DateRange employmentTime) {
		this.employmentTime = employmentTime;
	}

	public int getEmploymentPercent() {
		return employmentPercent;
	}

	public void setEmploymentPercent(int employmentPercent) {
		this.employmentPercent = employmentPercent;
	}

	public int getHoursPerYear() {
		return hoursPerYear;
	}

	public void setHoursPerYear(int hoursPerYear) {
		this.hoursPerYear = hoursPerYear;
	}

	public boolean isTeacher() {
		return isTeacher;
	}

	public void setTeacher(boolean isTeacher) {
		this.isTeacher = isTeacher;
	}

	public Reference getEmployedAt() {
		return employedAt;
	}

	public void setEmployedAt(Reference employedAt) {
		this.employedAt = employedAt;
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
		int result = super.hashCode();
		result = prime * result + employmentPercent;
		result = prime * result + ((employmentTime == null) ? 0 : employmentTime.hashCode());
		result = prime * result + hoursPerYear;
		result = prime * result + (isTeacher ? 1231 : 1237);
		result = prime * result + ((employedAt == null) ? 0 : employedAt.hashCode());
		result = prime * result + ((signature == null) ? 0 : signature.hashCode());
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
		Employment other = (Employment) obj;
		if (employmentPercent != other.employmentPercent)
			return false;
		if (employmentTime == null) {
			if (other.employmentTime != null)
				return false;
		} else if (!employmentTime.equals(other.employmentTime))
			return false;
		if (hoursPerYear != other.hoursPerYear)
			return false;
		if (isTeacher != other.isTeacher)
			return false;
		if (employedAt == null) {
			if (other.employedAt != null)
				return false;
		} else if (!employedAt.equals(other.employedAt))
			return false;
		if (signature == null) {
			if (other.signature != null)
				return false;
		} else if (!signature.equals(other.signature))
>>>>>>> branch 'master' of https://github.com/johanstigert/sis.git
			return false;
		return true;
	}
}
