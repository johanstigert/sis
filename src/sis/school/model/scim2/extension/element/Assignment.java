package sis.school.model.scim2.extension.element;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "value", "$ref", "display", "dateRange" })
public class Assignment {

	private String value;

	@JsonProperty("$ref")
	private String ref;
	private String display;

	private DateRange dateRange;

	public Assignment() {
	}

	public Assignment(String value, String ref, String display, DateRange dateInterval) {
		this.value = value;
		this.ref = ref;
		this.display = display;
		this.dateRange = dateInterval;
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

	public DateRange getDateInterval() {
		return dateRange;
	}

	public void setDateInterval(DateRange dateInterval) {
		this.dateRange = dateInterval;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateRange == null) ? 0 : dateRange.hashCode());
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
		Assignment other = (Assignment) obj;
		if (dateRange == null) {
			if (other.dateRange != null)
				return false;
		} else if (!dateRange.equals(other.dateRange))
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
