package skola.model.scim2.group;

// https://github.com/girgen/skolschema/blob/master/group-kursgrupp.json
// https://github.com/girgen/skolschema/blob/master/group-subject.json
public class Course implements IGroupType {

	private String schoolForm;
	private String courseCode;
	private String subjectCode;

	public Course() {
	}

	public Course(String schoolForm, String courseCode, String subjectCode) {
		this.schoolForm = schoolForm;
		this.courseCode = courseCode;
		this.subjectCode = subjectCode;
	}

	public String getSchoolForm() {
		return schoolForm;
	}

	public void setSchoolForm(String schoolForm) {
		this.schoolForm = schoolForm;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseCode == null) ? 0 : courseCode.hashCode());
		result = prime * result + ((schoolForm == null) ? 0 : schoolForm.hashCode());
		result = prime * result + ((subjectCode == null) ? 0 : subjectCode.hashCode());
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
		Course other = (Course) obj;
		if (courseCode == null) {
			if (other.courseCode != null)
				return false;
		} else if (!courseCode.equals(other.courseCode))
			return false;
		if (schoolForm == null) {
			if (other.schoolForm != null)
				return false;
		} else if (!schoolForm.equals(other.schoolForm))
			return false;
		if (subjectCode == null) {
			if (other.subjectCode != null)
				return false;
		} else if (!subjectCode.equals(other.subjectCode))
			return false;
		return true;
	}
}
