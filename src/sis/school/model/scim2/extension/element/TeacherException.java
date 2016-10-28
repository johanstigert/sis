package sis.school.model.scim2.extension.element;

import static sis.school.model.scim2.extension.element.Constant.DATE_TIME_FORMAT;
import static sis.school.model.scim2.extension.element.Constant.TIMEZONE;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.element.Reference;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "participates", "teachingLengthStudent", "startDateTime", "endDateTime", "value", "$ref", "display" })
public class TeacherException extends Reference {

	private boolean participates;
	private int teachingLengthTeacher;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_FORMAT, timezone = TIMEZONE)
	private Date startDateTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_FORMAT, timezone = TIMEZONE)
	private Date endDateTime;

	public TeacherException() {
	}

	public TeacherException(boolean participates, int teachingLengthTeacher, String startDateTime, String endDateTime) {
		super();
		this.participates = participates;
		this.teachingLengthTeacher = teachingLengthTeacher;
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

	public boolean isParticipates() {
		return participates;
	}

	public void setParticipates(boolean participates) {
		this.participates = participates;
	}

	public int getTeachingLengthTeacher() {
		return teachingLengthTeacher;
	}

	public void setTeachingLengthTeacher(int teachingLengthTeacher) {
		this.teachingLengthTeacher = teachingLengthTeacher;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((endDateTime == null) ? 0 : endDateTime.hashCode());
		result = prime * result + (participates ? 1231 : 1237);
		result = prime * result + ((startDateTime == null) ? 0 : startDateTime.hashCode());
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
		TeacherException other = (TeacherException) obj;
		if (endDateTime == null) {
			if (other.endDateTime != null)
				return false;
		} else if (!endDateTime.equals(other.endDateTime))
			return false;
		if (participates != other.participates)
			return false;
		if (startDateTime == null) {
			if (other.startDateTime != null)
				return false;
		} else if (!startDateTime.equals(other.startDateTime))
			return false;
		if (teachingLengthTeacher != other.teachingLengthTeacher)
			return false;
		return true;
	}
}
