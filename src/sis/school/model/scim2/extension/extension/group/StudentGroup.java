package sis.school.model.scim2.extension.extension.group;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.extension.code.Code.SchoolGroupType;
import sis.school.model.scim2.extension.element.Reference;

@JsonPropertyOrder({ "schoolGroupType", "schoolYear", "courseCodes", "subjectCodes" })
public class StudentGroup {

	private SchoolGroupType schoolGroupType;
	private int schoolYear;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Reference> courseCodes;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Reference> subjectCodes;

	public StudentGroup() {
	}

	public StudentGroup(SchoolGroupType schoolGroupType, int schoolYear, List<Reference> courseCodes,
			List<Reference> subjectCodes) {
		super();
		this.schoolGroupType = schoolGroupType;
		this.schoolYear = schoolYear;
		this.courseCodes = courseCodes;
		this.subjectCodes = subjectCodes;
	}

	public SchoolGroupType getSchoolGroupType() {
		return schoolGroupType;
	}

	public void setSchoolGroupType(SchoolGroupType schoolGroupType) {
		this.schoolGroupType = schoolGroupType;
	}

	public int getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(int schoolYear) {
		this.schoolYear = schoolYear;
	}

	public List<Reference> getCourseCodes() {
		return courseCodes;
	}

	public void setCourseCodes(List<Reference> courseCodes) {
		this.courseCodes = courseCodes;
	}

	public List<Reference> getSubjectCodes() {
		return subjectCodes;
	}

	public void setSubjectCodes(List<Reference> subjectCodes) {
		this.subjectCodes = subjectCodes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseCodes == null) ? 0 : courseCodes.hashCode());
		result = prime * result + ((schoolGroupType == null) ? 0 : schoolGroupType.hashCode());
		result = prime * result + schoolYear;
		result = prime * result + ((subjectCodes == null) ? 0 : subjectCodes.hashCode());
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
		StudentGroup other = (StudentGroup) obj;
		if (courseCodes == null) {
			if (other.courseCodes != null)
				return false;
		} else if (!courseCodes.equals(other.courseCodes))
			return false;
		if (schoolGroupType != other.schoolGroupType)
			return false;
		if (schoolYear != other.schoolYear)
			return false;
		if (subjectCodes == null) {
			if (other.subjectCodes != null)
				return false;
		} else if (!subjectCodes.equals(other.subjectCodes))
			return false;
		return true;
	}
}
