package sis.school.model.scim2.extension.extension;

import java.text.ParseException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.element.Reference;
import sis.school.model.scim2.extension.code.Code.SchoolType;
import sis.school.model.scim2.extension.element.DateRange;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonIgnoreProperties({ "schoolUnitCode" })
@JsonPropertyOrder({ "schoolType", "programCode", "schoolYear", "startDate", "endDate", "schoolUnit" })
public class Enrolment extends DateRange {

	private String schoolUnit;
	private SchoolType schoolType;
	private String programCode;
	private int schoolYear;

	public Enrolment() {
	}

	public Enrolment(String schoolUnit, SchoolType schoolType, String programCode, int schoolYear, String startYyyymmdd, String endYyyymmdd) throws ParseException {
		super(startYyyymmdd, endYyyymmdd);
		this.schoolUnit = schoolUnit;
		this.schoolType = schoolType;
		this.programCode = programCode;
		this.schoolYear = schoolYear;
	}

	public String getSchoolUnit() {
		return schoolUnit;
	}

	public void setSchoolUnit(String schoolUnit) {
		this.schoolUnit = schoolUnit;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((programCode == null) ? 0 : programCode.hashCode());
		result = prime * result + ((schoolType == null) ? 0 : schoolType.hashCode());
		result = prime * result + ((schoolUnit == null) ? 0 : schoolUnit.hashCode());
		result = prime * result + schoolYear;
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
		Enrolment other = (Enrolment) obj;
		if (programCode == null) {
			if (other.programCode != null)
				return false;
		} else if (!programCode.equals(other.programCode))
			return false;
		if (schoolType != other.schoolType)
			return false;
		if (schoolUnit == null) {
			if (other.schoolUnit != null)
				return false;
		} else if (!schoolUnit.equals(other.schoolUnit))
			return false;
		if (schoolYear != other.schoolYear)
			return false;
		return true;
	}
}