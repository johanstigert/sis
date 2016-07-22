package skola.model.scim2.extension;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import skola.model.scim2.core.Resource;
import skola.model.scim2.extension.element.DateTimeRange;
import skola.model.scim2.extension.element.Exception;

@JsonPropertyOrder({ "schemas", "id", "externalId", "activity", "cancelled", "comment", "dateTimeRange",
		"teachingLengthTeacher", "teachingLengthGroup", "rooms", "resource", "studentExceptions", "teacherExceptions",
		"groupExceptions", "meta" })
public class CalendarEvent extends Resource {

	private String activity;
	private boolean cancelled;
	private String comment;
	private DateTimeRange dateTimeRange;
	private int teachingLengthTeacher;
	private int teachingLengthGroup;
	private List<String> rooms;
	private List<String> resource;
	private List<Exception> studentExceptions;
	private List<Exception> teacherExceptions;
	private List<Exception> groupExceptions;

	public CalendarEvent() {
	}
	
	public CalendarEvent(String id) {
		super(id);
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
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

	public int getTeachingLengthTeacher() {
		return teachingLengthTeacher;
	}

	public void setTeachingLengthTeacher(int teachingLengthTeacher) {
		this.teachingLengthTeacher = teachingLengthTeacher;
	}

	public int getTeachingLengthGroup() {
		return teachingLengthGroup;
	}

	public void setTeachingLengthGroup(int teachingLengthGroup) {
		this.teachingLengthGroup = teachingLengthGroup;
	}

	public List<String> getRooms() {
		return rooms;
	}

	public void setRooms(List<String> rooms) {
		this.rooms = rooms;
	}

	public void addRoom(String room) {
		if (this.rooms == null)
			this.rooms = new ArrayList<String>();
		this.rooms.add(room);
	}

	public List<String> getResource() {
		return resource;
	}

	public void setResource(List<String> resource) {
		this.resource = resource;
	}

	public void addResource(String resource) {
		if (this.resource == null)
			this.resource = new ArrayList<String>();
		this.resource.add(resource);
	}

	public List<Exception> getStudentExceptions() {
		return studentExceptions;
	}

	public void setStudentExceptions(List<Exception> studentExceptions) {
		this.studentExceptions = studentExceptions;
	}

	public void addStudentExceptions(Exception exception) {
		if (this.studentExceptions == null)
			this.studentExceptions = new ArrayList<Exception>();
		this.studentExceptions.add(exception);
	}

	public List<Exception> getTeacherExceptions() {
		return teacherExceptions;
	}

	public void setTeacherExceptions(List<Exception> teacherExceptions) {
		this.teacherExceptions = teacherExceptions;
	}

	public void addTeacherExceptions(Exception exception) {
		if (this.teacherExceptions == null)
			this.teacherExceptions = new ArrayList<Exception>();
		this.teacherExceptions.add(exception);
	}

	public List<Exception> getGroupExceptions() {
		return groupExceptions;
	}

	public void setGroupExceptions(List<Exception> groupExceptions) {
		this.groupExceptions = groupExceptions;
	}

	public void addGroupExceptions(Exception exception) {
		if (this.groupExceptions == null)
			this.groupExceptions = new ArrayList<Exception>();
		this.groupExceptions.add(exception);
	}

	public DateTimeRange getDateTimeRange() {
		return dateTimeRange;
	}

	public void setDateTimeRange(DateTimeRange dateTimeRange) {
		this.dateTimeRange = dateTimeRange;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((activity == null) ? 0 : activity.hashCode());
		result = prime * result + (cancelled ? 1231 : 1237);
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((dateTimeRange == null) ? 0 : dateTimeRange.hashCode());
		result = prime * result + ((groupExceptions == null) ? 0 : groupExceptions.hashCode());
		result = prime * result + ((resource == null) ? 0 : resource.hashCode());
		result = prime * result + ((rooms == null) ? 0 : rooms.hashCode());
		result = prime * result + ((studentExceptions == null) ? 0 : studentExceptions.hashCode());
		result = prime * result + ((teacherExceptions == null) ? 0 : teacherExceptions.hashCode());
		result = prime * result + teachingLengthGroup;
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
		if (dateTimeRange == null) {
			if (other.dateTimeRange != null)
				return false;
		} else if (!dateTimeRange.equals(other.dateTimeRange))
			return false;
		if (groupExceptions == null) {
			if (other.groupExceptions != null)
				return false;
		} else if (!groupExceptions.equals(other.groupExceptions))
			return false;
		if (resource == null) {
			if (other.resource != null)
				return false;
		} else if (!resource.equals(other.resource))
			return false;
		if (rooms == null) {
			if (other.rooms != null)
				return false;
		} else if (!rooms.equals(other.rooms))
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
		if (teachingLengthGroup != other.teachingLengthGroup)
			return false;
		if (teachingLengthTeacher != other.teachingLengthTeacher)
			return false;
		return true;
	}
}
