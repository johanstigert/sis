package sis.school.model.scim2.extension;

import static sis.school.model.scim2.extension.element.Constant.BASE_URI;
import static sis.school.model.scim2.extension.element.Constant.DATE_TIME_FORMAT;
import static sis.school.model.scim2.extension.element.Constant.TIMEZONE;
import static sis.school.model.scim2.extension.element.Constant.URN_CALENDAREVENT;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.Meta;
import sis.school.model.scim2.core.Resource;
import sis.school.model.scim2.core.element.Reference;
import sis.school.model.scim2.core.schema.ResourceType;
import sis.school.model.scim2.extension.element.Exception;
import sis.school.model.scim2.extension.element.TeacherException;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "schemas", "id", "cancelled", "comment", "startDateTime", "endDateTime", "teachingLengthTeacher", "teachingLengthStudent", "rooms", "resources", "studentExceptions", "teacherExceptions", "groupExceptions", "activity", "meta" })
public class CalendarEvent extends Resource {

	private boolean cancelled;
	private String comment;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_FORMAT, timezone = TIMEZONE)
	private Date startDateTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_FORMAT, timezone = TIMEZONE)
	private Date endDateTime;
	private int teachingLengthTeacher;
	private int teachingLengthStudent;
	private List<Reference> rooms;
	private List<Reference> resources;
	private List<Exception> studentExceptions;
	private List<TeacherException> teacherExceptions;
	private List<Exception> groupExceptions;
	private Reference activity;

	public CalendarEvent() {
	}

	public CalendarEvent(String id) {
		super(id);
	}

	public CalendarEvent(boolean cancelled, String comment, String startDateTime, String endDateTime, int teachingLengthTeacher, int teachingLengthStudent, List<Reference> rooms, List<Reference> resources, List<Exception> studentExceptions, List<TeacherException> teacherExceptions, List<Exception> groupExceptions, Reference activity) {
		super();
		this.cancelled = cancelled;
		this.comment = comment;
		this.teachingLengthTeacher = teachingLengthTeacher;
		this.teachingLengthStudent = teachingLengthStudent;
		this.rooms = rooms;
		this.resources = resources;
		this.studentExceptions = studentExceptions;
		this.teacherExceptions = teacherExceptions;
		this.groupExceptions = groupExceptions;
		this.activity = activity;
		DateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
		try {
			if (startDateTime != null) {
				this.startDateTime = sdf.parse(startDateTime);
			}
			if (endDateTime != null) {
				this.endDateTime = sdf.parse(endDateTime);
			}
		} catch (ParseException e) {
		}
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public int getTeachingLengthTeacher() {
		return teachingLengthTeacher;
	}

	public void setTeachingLengthTeacher(int teachingLengthTeacher) {
		this.teachingLengthTeacher = teachingLengthTeacher;
	}

	public int getTeachingLengthStudent() {
		return teachingLengthStudent;
	}

	public void setTeachingLengthStudent(int teachingLengthStudent) {
		this.teachingLengthStudent = teachingLengthStudent;
	}

	public List<Reference> getRooms() {
		return rooms;
	}

	public void setRooms(List<Reference> rooms) {
		this.rooms = rooms;
	}

	public List<Reference> getResources() {
		return resources;
	}

	public void setResources(List<Reference> resources) {
		this.resources = resources;
	}

	public List<Exception> getStudentExceptions() {
		return studentExceptions;
	}

	public void setStudentExceptions(List<Exception> studentExceptions) {
		this.studentExceptions = studentExceptions;
	}

	public List<TeacherException> getTeacherExceptions() {
		return teacherExceptions;
	}

	public void setTeacherExceptions(List<TeacherException> teacherExceptions) {
		this.teacherExceptions = teacherExceptions;
	}

	public List<Exception> getGroupExceptions() {
		return groupExceptions;
	}

	public void setGroupExceptions(List<Exception> groupExceptions) {
		this.groupExceptions = groupExceptions;
	}

	public Reference getActivity() {
		return activity;
	}

	public void setActivity(Reference activity) {
		this.activity = activity;
	}

	public void addRoom(Reference room) {
		if (this.rooms == null)
			this.rooms = new ArrayList<Reference>();
		this.rooms.add(room);
	}

	public void addResource(Reference resource) {
		if (this.resources == null)
			this.resources = new ArrayList<Reference>();
		this.resources.add(resource);
	}

	public void addStudentExceptions(Exception exception) {
		if (this.studentExceptions == null)
			this.studentExceptions = new ArrayList<Exception>();
		this.studentExceptions.add(exception);
	}

	public void addTeacherExceptions(TeacherException exception) {
		if (this.teacherExceptions == null)
			this.teacherExceptions = new ArrayList<TeacherException>();
		this.teacherExceptions.add(exception);
	}

	public void addGroupExceptions(Exception exception) {
		if (this.groupExceptions == null)
			this.groupExceptions = new ArrayList<Exception>();
		this.groupExceptions.add(exception);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((activity == null) ? 0 : activity.hashCode());
		result = prime * result + (cancelled ? 1231 : 1237);
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((endDateTime == null) ? 0 : endDateTime.hashCode());
		result = prime * result + ((groupExceptions == null) ? 0 : groupExceptions.hashCode());
		result = prime * result + ((resources == null) ? 0 : resources.hashCode());
		result = prime * result + ((rooms == null) ? 0 : rooms.hashCode());
		result = prime * result + ((startDateTime == null) ? 0 : startDateTime.hashCode());
		result = prime * result + ((studentExceptions == null) ? 0 : studentExceptions.hashCode());
		result = prime * result + ((teacherExceptions == null) ? 0 : teacherExceptions.hashCode());
		result = prime * result + teachingLengthStudent;
		result = prime * result + teachingLengthTeacher;
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
		CalendarEvent other = (CalendarEvent) obj;
		if (activity == null) {
			if (other.activity != null)
				return false;
		} else if (!activity.equals(other.activity))
			return false;
		if (cancelled != other.cancelled)
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (endDateTime == null) {
			if (other.endDateTime != null)
				return false;
		} else if (!endDateTime.equals(other.endDateTime))
			return false;
		if (groupExceptions == null) {
			if (other.groupExceptions != null)
				return false;
		} else if (!groupExceptions.equals(other.groupExceptions))
			return false;
		if (resources == null) {
			if (other.resources != null)
				return false;
		} else if (!resources.equals(other.resources))
			return false;
		if (rooms == null) {
			if (other.rooms != null)
				return false;
		} else if (!rooms.equals(other.rooms))
			return false;
		if (startDateTime == null) {
			if (other.startDateTime != null)
				return false;
		} else if (!startDateTime.equals(other.startDateTime))
			return false;
		if (studentExceptions == null) {
			if (other.studentExceptions != null)
				return false;
		} else if (!studentExceptions.equals(other.studentExceptions))
			return false;
		if (teacherExceptions == null) {
			if (other.teacherExceptions != null)
				return false;
		} else if (!teacherExceptions.equals(other.teacherExceptions))
			return false;
		if (teachingLengthStudent != other.teachingLengthStudent)
			return false;
		if (teachingLengthTeacher != other.teachingLengthTeacher)
			return false;
		return true;
	}

	public static ResourceType getResourceType() {
		ResourceType type = new ResourceType("CalendarEvent", "/CalendarEvents", "Kalenderpost", URN_CALENDAREVENT, null);
		type.setMeta(new Meta("ResourceType", null, null, BASE_URI + "/ResourceTypes/CalendarEvent", null));
		return type;
	}
}
