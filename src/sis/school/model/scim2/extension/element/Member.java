package sis.school.model.scim2.extension.element;

import static sis.school.model.scim2.extension.element.Constant.URN_DATUMINTERVALL;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "value", "$ref", "display", URN_DATUMINTERVALL })
public class Member {

	private String value;

	@JsonProperty("$ref")
	private String ref;
	private String display;
	@JsonProperty(URN_DATUMINTERVALL)
	private List<DateRange> dateIntervals;

	public Member() {
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public List<DateRange> getDateIntervals() {
		return dateIntervals;
	}

	public void setDateIntervals(List<DateRange> dateIntervals) {
		this.dateIntervals = dateIntervals;
	}

	public void addDateInterval(DateRange interval) {
		if (this.dateIntervals == null)
			this.dateIntervals = new ArrayList<DateRange>();
		this.dateIntervals.add(interval);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateIntervals == null) ? 0 : dateIntervals.hashCode());
		result = prime * result + ((display == null) ? 0 : display.hashCode());
		result = prime * result + ((ref == null) ? 0 : ref.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Member other = (Member) obj;
		if (dateIntervals == null) {
			if (other.dateIntervals != null)
				return false;
		} else if (!dateIntervals.equals(other.dateIntervals))
			return false;
		if (display == null) {
			if (other.display != null)
				return false;
		} else if (!display.equals(other.display))
			return false;
		if (ref == null) {
			if (other.ref != null)
				return false;
		} else if (!ref.equals(other.ref))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
