package sis.school.model.scim2.extension.element;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonIgnoreProperties({ "minutesPlanned", "type", "primary" })
@JsonPropertyOrder({ "value", "$ref", "display", "startDate", "endDate", "timeplanned" })
public class TeacherAssignment extends Assignment {

	private int timeplanned;

	public TeacherAssignment() {
	}

	public TeacherAssignment(String value, String ref, String display, int timeplanned, String startDate, String endDate) {
		super(value, ref, display, startDate, endDate);
		this.timeplanned = timeplanned;
	}

	public int getTimeplanned() {
		return timeplanned;
	}

	public void setTimeplanned(int timeplanned) {
		this.timeplanned = timeplanned;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + timeplanned;
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
		TeacherAssignment other = (TeacherAssignment) obj;
		if (timeplanned != other.timeplanned)
			return false;
		return true;
	}
}
