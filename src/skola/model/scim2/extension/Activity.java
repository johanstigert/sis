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
import skola.model.scim2.extension.element.Assignment;
import skola.model.scim2.extension.element.Code.ActivityType;
import skola.model.scim2.extension.element.DateRange;
import skola.model.scim2.extension.element.TeacherAssignment;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "schemas", "id", "externalId", "displayName", "schoolUnit", "course", "type", URN_DATUMINTERVALL,
		"groupAssignments", "studentAssignments", "teacherAssignments", "timePlanned", "parentactivity", "meta" })
public class Activity extends Resource {

	private String displayName;
	private String schoolUnit;
	private String course;

	private ActivityType activityType;
	@JsonProperty(URN_DATUMINTERVALL)
	private DateRange dateInterval;
	private List<Assignment> groupAssignments;
	private List<Assignment> studentAssignments;
	private List<TeacherAssignment> teacherAssignments;

	private int timePlanned;
	private String parentactivity; // TODO: Flera ParentActivity?

	public Activity() {
	}

	public Activity(String id) {
		super(id);
	}

	public void addStudentAssignment(Assignment studentAssignment) {
		if (this.studentAssignments == null)
			this.studentAssignments = new ArrayList<Assignment>();
		this.studentAssignments.add(studentAssignment);
	}

	public void addGroupAssignment(Assignment groupAssignment) {
		if (this.groupAssignments == null)
			this.groupAssignments = new ArrayList<Assignment>();
		this.groupAssignments.add(groupAssignment);
	}

	public void addTeacherAssignment(TeacherAssignment teacherAssignment) {
		if (this.teacherAssignments == null)
			this.teacherAssignments = new ArrayList<TeacherAssignment>();
		this.teacherAssignments.add(teacherAssignment);
	}

	public String getCourse() {
		return course;
	}

	public DateRange getDateInterval() {
		return dateInterval;
	}

	public String getDisplayName() {
		return displayName;
	}

	public List<Assignment> getGroupAssignments() {
		return groupAssignments;
	}

	public String getParentactivity() {
		return parentactivity;
	}

	public String getSchoolUnit() {
		return schoolUnit;
	}

	public List<Assignment> getStudentAssignments() {
		return studentAssignments;
	}

	public List<TeacherAssignment> getTeacherAssignments() {
		return teacherAssignments;
	}

	public ActivityType getActivityType() {
		return activityType;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public void setDateInterval(DateRange dateInterval) {
		this.dateInterval = dateInterval;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setGroupAssignments(List<Assignment> groupAssignments) {
		this.groupAssignments = groupAssignments;
	}

	public void setParentactivity(String parentactivity) {
		this.parentactivity = parentactivity;
	}

	public void setSchoolUnit(String school) {
		this.schoolUnit = school;
	}

	public void setStudentAssignments(List<Assignment> studentAssignments) {
		this.studentAssignments = studentAssignments;
	}

	public void setTeacherAssignments(List<TeacherAssignment> teacherAssignments) {
		this.teacherAssignments = teacherAssignments;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public int getTimePlanned() {
		return timePlanned;
	}

	public void setTimePlanned(int timePlanned) {
		this.timePlanned = timePlanned;
	}

	public static ResourceType getResourceType() {
		ResourceType type = new ResourceType("Activity", "/Activities", "Aktivitet", URN_ACTIVITY);
		type.setMeta(new Meta("ResourceType", null, null, BASE_URI + "/Activities", null));
		return type;
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
		if (groupAssignments == null) {
			if (other.groupAssignments != null)
				return false;
		} else if (!groupAssignments.equals(other.groupAssignments))
			return false;
		if (parentactivity == null) {
			if (other.parentactivity != null)
				return false;
		} else if (!parentactivity.equals(other.parentactivity))
			return false;
		if (schoolUnit == null) {
			if (other.schoolUnit != null)
				return false;
		} else if (!schoolUnit.equals(other.schoolUnit))
			return false;
		if (studentAssignments == null) {
			if (other.studentAssignments != null)
				return false;
		} else if (!studentAssignments.equals(other.studentAssignments))
			return false;
		if (teacherAssignments == null) {
			if (other.teacherAssignments != null)
				return false;
		} else if (!teacherAssignments.equals(other.teacherAssignments))
			return false;
		if (activityType == null) {
			if (other.activityType != null)
				return false;
		} else if (!activityType.equals(other.activityType))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((dateInterval == null) ? 0 : dateInterval.hashCode());
		result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + ((groupAssignments == null) ? 0 : groupAssignments.hashCode());
		result = prime * result + ((parentactivity == null) ? 0 : parentactivity.hashCode());
		result = prime * result + ((schoolUnit == null) ? 0 : schoolUnit.hashCode());
		result = prime * result + ((studentAssignments == null) ? 0 : studentAssignments.hashCode());
		result = prime * result + ((teacherAssignments == null) ? 0 : teacherAssignments.hashCode());
		result = prime * result + ((activityType == null) ? 0 : activityType.hashCode());
		return result;
	}
}