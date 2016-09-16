package sis.school.model.scim2.extension.extension;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.extension.code.Code.SchoolType;
import sis.school.model.scim2.extension.element.DateRange;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "schoolUnitCode", "schoolType", "programCode", "schoolYear", "dateRange" })
public class Enrolment {

	private String schoolUnitCode;
	private SchoolType schoolType;
	private String programCode;
	private int schoolYear;
	private DateRange dateRange;

	public Enrolment() {
	}

	public Enrolment(String schoolUnitCode, SchoolType schoolType, String programCode, int schoolYear,
			DateRange dateRange) {
		super();
		this.schoolUnitCode = schoolUnitCode;
		this.schoolType = schoolType;
		this.programCode = programCode;
		this.schoolYear = schoolYear;
		this.dateRange = dateRange;
	}

	public String getSchoolUnitCode() {
		return schoolUnitCode;
	}

	public void setSchoolUnitCode(String schoolUnitCode) {
		this.schoolUnitCode = schoolUnitCode;
	}

	public SchoolType getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(SchoolType schoolType) {
		this.schoolType = schoolType;
	}

	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	public int getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(int schoolYear) {
		this.schoolYear = schoolYear;
	}

	public DateRange getDateRange() {
		return dateRange;
	}

	public void setDateRange(DateRange dateRange) {
		this.dateRange = dateRange;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateRange == null) ? 0 : dateRange.hashCode());
		result = prime * result + ((programCode == null) ? 0 : programCode.hashCode());
		result = prime * result + ((schoolType == null) ? 0 : schoolType.hashCode());
		result = prime * result + ((schoolUnitCode == null) ? 0 : schoolUnitCode.hashCode());
		result = prime * result + schoolYear;
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
		Enrolment other = (Enrolment) obj;
		if (dateRange == null) {
			if (other.dateRange != null)
				return false;
		} else if (!dateRange.equals(other.dateRange))
			return false;
		if (programCode == null) {
			if (other.programCode != null)
				return false;
		} else if (!programCode.equals(other.programCode))
			return false;
		if (schoolType == null) {
			if (other.schoolType != null)
				return false;
		} else if (!schoolType.equals(other.schoolType))
			return false;
		if (schoolUnitCode == null) {
			if (other.schoolUnitCode != null)
				return false;
		} else if (!schoolUnitCode.equals(other.schoolUnitCode))
			return false;
		if (schoolYear != other.schoolYear)
			return false;
		return true;
	}
}