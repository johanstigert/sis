package skola.model.scim2.extension;

import static skola.model.scim2.extension.element.Constant.BASE_URI;
import static skola.model.scim2.extension.element.Constant.URN_ACTIVITY;
import static skola.model.scim2.extension.element.Constant.URN_DATUMINTERVALL;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import skola.model.scim2.core.Meta;
import skola.model.scim2.core.Resource;
import skola.model.scim2.core.schema.ResourceType;
import skola.model.scim2.extension.element.DateRange;
import skola.model.scim2.extension.element.Reference;
import skola.model.scim2.extension.element.TeacherAssignment;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "schemas", "id", "externalId", "displayName", "school", "course", "type", URN_DATUMINTERVALL,
		"groups", "students", "teacherAssignments", "parentactivity", "meta" })
public class Activity extends Resource {

	private String displayName;
	private String school;
	private String course;
	private String type;

	@JsonProperty(URN_DATUMINTERVALL)
	private DateRange dateInterval;
	private List<Reference> groups;
	private List<Reference> students;
	private List<TeacherAssignment> teacherAssignments;
	private String parentactivity;

	public Activity() {
	}

	public Activity(String id) {
		super(id);
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public DateRange getDateInterval() {
		return dateInterval;
	}

	public void setDateInterval(DateRange dateInterval) {
		this.dateInterval = dateInterval;
	}

	public List<Reference> getGroups() {
		return groups;
	}

	public void setGroups(List<Reference> groups) {
		this.groups = groups;
	}

	public void addGroup(Reference reference) {
		if (this.groups == null)
			this.groups = new ArrayList<Reference>();
		this.groups.add(reference);
	}

	public List<Reference> getStudents() {
		return students;
	}

	public void setStudents(List<Reference> students) {
		this.students = students;
	}

	public void addStudent(Reference reference) {
		if (this.students == null)
			this.students = new ArrayList<Reference>();
		this.students.add(reference);
	}

	public List<TeacherAssignment> getTeacherAssignments() {
		return teacherAssignments;
	}

	public void setTeacherAssignments(List<TeacherAssignment> teacherAssignments) {
		this.teacherAssignments = teacherAssignments;
	}

	public void addTeacherAssignment(TeacherAssignment teacherAssignment) {
		if (this.teacherAssignments == null)
			this.teacherAssignments = new ArrayList<TeacherAssignment>();
		this.teacherAssignments.add(teacherAssignment);
	}

	public String getParentactivity() {
		return parentactivity;
	}

	public void setParentactivity(String parentactivity) {
		this.parentactivity = parentactivity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((dateInterval == null) ? 0 : dateInterval.hashCode());
		result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + ((groups == null) ? 0 : groups.hashCode());
		result = prime * result + ((parentactivity == null) ? 0 : parentactivity.hashCode());
		result = prime * result + ((school == null) ? 0 : school.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		result = prime * result + ((teacherAssignments == null) ? 0 : teacherAssignments.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Activity other = (Activity) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (dateInterval == null) {
			if (other.dateInterval != null)
				return false;
		} else if (!dateInterval.equals(other.dateInterval))
			return false;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (groups == null) {
			if (other.groups != null)
				return false;
		} else if (!groups.equals(other.groups))
			return false;
		if (parentactivity == null) {
			if (other.parentactivity != null)
				return false;
		} else if (!parentactivity.equals(other.parentactivity))
			return false;
		if (school == null) {
			if (other.school != null)
				return false;
		} else if (!school.equals(other.school))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		if (teacherAssignments == null) {
			if (other.teacherAssignments != null)
				return false;
		} else if (!teacherAssignments.equals(other.teacherAssignments))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public static ResourceType getResourceType() {
		ResourceType type = new ResourceType("Activity", "/Activities", "Aktivitet", URN_ACTIVITY);
		type.setMeta(new Meta("ResourceType", null, null, BASE_URI + "/Activities", null));
		return type;
	}
}