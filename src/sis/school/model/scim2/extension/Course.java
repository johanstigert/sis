package sis.school.model.scim2.extension;

import static sis.school.model.scim2.extension.element.Constant.BASE_URI;
import static sis.school.model.scim2.extension.element.Constant.URN_COURSE;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.Meta;
import sis.school.model.scim2.core.Resource;
import sis.school.model.scim2.core.schema.ResourceType;

@JsonPropertyOrder({ "schemas", "id", "courseCode", "name", "subjectShortName", "official", "points", "meta" })
public class Course extends Resource {

	private String courseCode;
	private String name;
	private String subjectShortName;
	private boolean official;
	private int points;

	public Course() {
	}

	public Course(String id) {
		super(id);
	}

	public Course(String courseCode, String name, String subjectShortName, boolean official, int points) {
		this.courseCode = courseCode;
		this.name = name;
		this.subjectShortName = subjectShortName;
		this.official = official;
		this.points = points;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubjectShortName() {
		return subjectShortName;
	}

	public void setSubjectShortName(String subjectShortName) {
		this.subjectShortName = subjectShortName;
	}

	public boolean isOfficial() {
		return official;
	}

	public void setOfficial(boolean official) {
		this.official = official;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((courseCode == null) ? 0 : courseCode.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (official ? 1231 : 1237);
		result = prime * result + points;
		result = prime * result + ((subjectShortName == null) ? 0 : subjectShortName.hashCode());
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
		Course other = (Course) obj;
		if (courseCode == null) {
			if (other.courseCode != null)
				return false;
		} else if (!courseCode.equals(other.courseCode))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (official != other.official)
			return false;
		if (points != other.points)
			return false;
		if (subjectShortName == null) {
			if (other.subjectShortName != null)
				return false;
		} else if (!subjectShortName.equals(other.subjectShortName))
			return false;
		return true;
	}

	public static ResourceType getResourceType() {
		ResourceType type = new ResourceType("Course", "/Courses", "Course", URN_COURSE, null);
		type.setMeta(new Meta("ResourceType", null, null, BASE_URI + "/ResourceTypes/Course", null));
		return type;
	}
}
