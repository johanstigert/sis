package sis.school.model.scim2.extension;

import static sis.school.model.scim2.extension.element.Constant.BASE_URI;
import static sis.school.model.scim2.extension.element.Constant.DATE_FORMAT;
import static sis.school.model.scim2.extension.element.Constant.TIMEZONE;
import static sis.school.model.scim2.extension.element.Constant.URN_ACTIVITY;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.Meta;
import sis.school.model.scim2.core.Resource;
import sis.school.model.scim2.core.element.Reference;
import sis.school.model.scim2.core.schema.ResourceType;
import sis.school.model.scim2.extension.code.Code.ActivityType;
import sis.school.model.scim2.extension.element.Assignment;
import sis.school.model.scim2.extension.element.TeacherAssignment;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonIgnoreProperties({ "comment", "creatingSystem" })
@JsonPropertyOrder({ "schemas", "id", "activityType", "calendarEventsRequired", "minutesPlanned", "startDate", "endDate", "studentGroupAssignments", "studentAssignments", "teacherAssignments", "course", "subject", "parentActivity", "meta" })
public class Activity extends Resource {

	private ActivityType activityType;
	private boolean calendarEventsRequired;
	private int minutesPlanned;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT, timezone = TIMEZONE)
	private Date startDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT, timezone = TIMEZONE)
	private Date endDate;
	@JsonProperty("GroupAssignments")
	private List<Assignment> studentGroupAssignments;
	@JsonProperty("StudentAssignments")
	private List<Assignment> studentAssignments;
	@JsonProperty("TeacherAssignments")
	private List<TeacherAssignment> teacherAssignments;
	private Reference course;
	private Reference subject;
	private Reference parentActivity;

	public Activity() {
	}

	public Activity(String id) {
		super(id);
	}

	public Activity(ActivityType activityType, boolean calendarEventsRequired, int minutesPlanned, String startDate, String endDate, List<Assignment> studentGroupAssignments, List<Assignment> studentAssignments, List<TeacherAssignment> teacherAssignments, Reference course, Reference subject, Reference parentActivity) {
		super();
		this.activityType = activityType;
		this.calendarEventsRequired = calendarEventsRequired;
		this.minutesPlanned = minutesPlanned;
		this.studentGroupAssignments = studentGroupAssignments;
		this.studentAssignments = studentAssignments;
		this.teacherAssignments = teacherAssignments;
		this.course = course;
		this.subject = subject;
		this.parentActivity = parentActivity;
		DateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		try {
			this.startDate = sdf.parse(startDate);
			this.endDate = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public boolean isCalendarEventsRequired() {
		return calendarEventsRequired;
	}

	public void setCalendarEventsRequired(boolean calendarEventsRequired) {
		this.calendarEventsRequired = calendarEventsRequired;
	}

	public int getMinutesPlanned() {
		return minutesPlanned;
	}

	public void setMinutesPlanned(int minutesPlanned) {
		this.minutesPlanned = minutesPlanned;
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

	public List<Assignment> getStudentGroupAssignments() {
		return studentGroupAssignments;
	}

	public void setStudentGroupAssignments(List<Assignment> studentGroupAssignments) {
		this.studentGroupAssignments = studentGroupAssignments;
	}

	public List<Assignment> getStudentAssignments() {
		return studentAssignments;
	}

	public void setStudentAssignments(List<Assignment> studentAssignments) {
		this.studentAssignments = studentAssignments;
	}

	public List<TeacherAssignment> getTeacherAssignments() {
		return teacherAssignments;
	}

	public void setTeacherAssignments(List<TeacherAssignment> teacherAssignments) {
		this.teacherAssignments = teacherAssignments;
	}

	public Reference getCourse() {
		return course;
	}

	public void setCourse(Reference course) {
		this.course = course;
	}

	public Reference getSubject() {
		return subject;
	}

	public void setSubject(Reference subject) {
		this.subject = subject;
	}

	public Reference getParentActivity() {
		return parentActivity;
	}

	public void setParentActivity(Reference parentActivity) {
		this.parentActivity = parentActivity;
	}

	public void addStudentGroupAssignment(Assignment studentGroupAssignment) {
		if (this.studentGroupAssignments == null)
			this.studentGroupAssignments = new ArrayList<Assignment>();
		this.studentGroupAssignments.add(studentGroupAssignment);
	}

	public void addStudentAssignment(Assignment studentAssignment) {
		if (this.studentAssignments == null)
			this.studentAssignments = new ArrayList<Assignment>();
		this.studentAssignments.add(studentAssignment);
	}

	public void addTeacherAssignment(TeacherAssignment teacherAssignment) {
		if (this.teacherAssignments == null)
			this.teacherAssignments = new ArrayList<TeacherAssignment>();
		this.teacherAssignments.add(teacherAssignment);
	}

	public static ResourceType getResourceType() {
		ResourceType type = new ResourceType("Activity", "/Activities", "Aktivitet", URN_ACTIVITY, null);
		type.setMeta(new Meta("ResourceType", null, null, BASE_URI + "/ResourceTypes/Activity", null));
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((activityType == null) ? 0 : activityType.hashCode());
		result = prime * result + (calendarEventsRequired ? 1231 : 1237);
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + minutesPlanned;
		result = prime * result + ((parentActivity == null) ? 0 : parentActivity.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((studentAssignments == null) ? 0 : studentAssignments.hashCode());
		result = prime * result + ((studentGroupAssignments == null) ? 0 : studentGroupAssignments.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((teacherAssignments == null) ? 0 : teacherAssignments.hashCode());
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
		if (activityType != other.activityType)
			return false;
		if (calendarEventsRequired != other.calendarEventsRequired)
			return false;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (minutesPlanned != other.minutesPlanned)
			return false;
		if (parentActivity == null) {
			if (other.parentActivity != null)
				return false;
		} else if (!parentActivity.equals(other.parentActivity))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (studentAssignments == null) {
			if (other.studentAssignments != null)
				return false;
		} else if (!studentAssignments.equals(other.studentAssignments))
			return false;
		if (studentGroupAssignments == null) {
			if (other.studentGroupAssignments != null)
				return false;
		} else if (!studentGroupAssignments.equals(other.studentGroupAssignments))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (teacherAssignments == null) {
			if (other.teacherAssignments != null)
				return false;
		} else if (!teacherAssignments.equals(other.teacherAssignments))
			return false;
		return true;
	}
}