package sis.school.model.scim2.extension;

import static sis.school.model.scim2.extension.element.Constant.BASE_URI;
import static sis.school.model.scim2.extension.element.Constant.DATE_FORMAT;
import static sis.school.model.scim2.extension.element.Constant.TIMEZONE;
import static sis.school.model.scim2.extension.element.Constant.URN_EMPLOYMENT;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.Meta;
import sis.school.model.scim2.core.Resource;
import sis.school.model.scim2.core.element.Reference;
import sis.school.model.scim2.core.schema.ResourceType;

/**
 * 
 * @see Employee
 *
 */
@JsonIgnoreProperties({ "employmentTime" })
@JsonPropertyOrder({ "schemas", "id", "startDate", "endDate", "employmentPercent", "hoursPerYear", "isTeacher", "signature", "user", "school", "schoolunit", "meta" })
public class Employment extends Resource {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT, timezone = TIMEZONE)
	private Date startDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT, timezone = TIMEZONE)
	private Date endDate;
	private int employmentPercent;
	private int hoursPerYear;
	@JsonProperty("isTeacher")
	private boolean teacher;
	private String signature;
	private Reference user;
	private Reference school;
	private Reference schoolunit;

	public Employment() {
	}

	public Employment(String id) {
		super(id);
	}

	public Employment(Date startDate, Date endDate, int employmentPercent, int hoursPerYear, boolean teacher, String signature, Reference user, Reference school) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.hoursPerYear = hoursPerYear;
		this.teacher = teacher;
		this.signature = signature;
		this.user = user;
		this.school = school;
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

	public boolean getTeacher() {
		return teacher;
	}

	public void setTeacher(boolean teacher) {
		this.teacher = teacher;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Reference getUser() {
		return user;
	}

	public void setUser(Reference user) {
		this.user = user;
	}

	public Reference getSchool() {
		return school;
	}

	public void setSchool(Reference school) {
		this.school = school;
	}

	public Reference getSchoolunit() {
		return schoolunit;
	}

	public void setSchoolunit(Reference schoolunit) {
		this.schoolunit = schoolunit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + employmentPercent;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + hoursPerYear;
		result = prime * result + ((school == null) ? 0 : school.hashCode());
		result = prime * result + ((schoolunit == null) ? 0 : schoolunit.hashCode());
		result = prime * result + ((signature == null) ? 0 : signature.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + (teacher ? 1231 : 1237);
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (hoursPerYear != other.hoursPerYear)
			return false;
		if (school == null) {
			if (other.school != null)
				return false;
		} else if (!school.equals(other.school))
			return false;
		if (schoolunit == null) {
			if (other.schoolunit != null)
				return false;
		} else if (!schoolunit.equals(other.schoolunit))
			return false;
		if (signature == null) {
			if (other.signature != null)
				return false;
		} else if (!signature.equals(other.signature))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (teacher != other.teacher)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public static ResourceType getResourceType() {
		ResourceType type = new ResourceType("Employment", "/Employments", "Employment", URN_EMPLOYMENT, null);
		type.setMeta(new Meta("ResourceType", null, null, BASE_URI + "/ResourceTypes/Employment", null));
		return type;
	}
}
