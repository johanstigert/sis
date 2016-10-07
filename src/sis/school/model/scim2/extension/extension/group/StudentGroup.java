package sis.school.model.scim2.extension.extension.group;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.element.Reference;
import sis.school.model.scim2.extension.code.Code.StudentGroupType;

@JsonIgnoreProperties({ "students", "teachers", "schoolTypes" })
@JsonPropertyOrder({ "studentGroupType", "schoolYear", "courses", "subjects" })
public class StudentGroup {

	private StudentGroupType studentGroupType;
	private int schoolYear;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Reference> courses;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Reference> subjects;

	public StudentGroup() {
	}

	public StudentGroup(StudentGroupType studentGroupType, int schoolYear, List<Reference> courses,
			List<Reference> subjects) {
		super();
		this.studentGroupType = studentGroupType;
		this.schoolYear = schoolYear;
		this.courses = courses;
		this.subjects = subjects;
	}

	public StudentGroupType getStudentGroupType() {
		return studentGroupType;
	}

	public void setStudentGroupType(StudentGroupType studentGroupType) {
		this.studentGroupType = studentGroupType;
	}

	public int getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(int schoolYear) {
		this.schoolYear = schoolYear;
	}

	public List<Reference> getCourses() {
		return courses;
	}

	public void setCourses(List<Reference> courses) {
		this.courses = courses;
	}

	public List<Reference> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Reference> subjects) {
		this.subjects = subjects;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courses == null) ? 0 : courses.hashCode());
		result = prime * result + schoolYear;
		result = prime * result + ((studentGroupType == null) ? 0 : studentGroupType.hashCode());
		result = prime * result + ((subjects == null) ? 0 : subjects.hashCode());
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
		if (courses == null) {
			if (other.courses != null)
				return false;
		} else if (!courses.equals(other.courses))
			return false;
		if (schoolYear != other.schoolYear)
			return false;
		if (studentGroupType != other.studentGroupType)
			return false;
		if (subjects == null) {
			if (other.subjects != null)
				return false;
		} else if (!subjects.equals(other.subjects))
			return false;
		return true;
	}
}
