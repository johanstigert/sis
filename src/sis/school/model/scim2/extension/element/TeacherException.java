package sis.school.model.scim2.extension.element;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

<<<<<<< HEAD
import sis.school.model.scim2.core.element.Reference;

=======
>>>>>>> branch 'master' of https://github.com/johanstigert/sis.git
/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "participates", "teachingLengthStudent", "dateTimeRange", "value", "$ref", "display" })
public class TeacherException extends Reference {

	private boolean participates;
	private int teachingLengthTeacher;
	private DateTimeRange dateTimeRange;

	public TeacherException() {
	}

	public TeacherException(boolean participates, int teachingLengthTeacher, DateTimeRange dateTimeRange) {
		super();
		this.participates = participates;
		this.teachingLengthTeacher = teachingLengthTeacher;
		this.dateTimeRange = dateTimeRange;
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
		result = prime * result + ((dateTimeRange == null) ? 0 : dateTimeRange.hashCode());
		result = prime * result + (participates ? 1231 : 1237);
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
		if (dateTimeRange == null) {
			if (other.dateTimeRange != null)
				return false;
		} else if (!dateTimeRange.equals(other.dateTimeRange))
			return false;
		if (participates != other.participates)
			return false;
		if (teachingLengthTeacher != other.teachingLengthTeacher)
			return false;
		return true;
	}
}
