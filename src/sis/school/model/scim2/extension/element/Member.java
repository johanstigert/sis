package sis.school.model.scim2.extension.element;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "value", "$ref", "display", "dateRanges" })
public class Member {

	private String value;

	@JsonProperty("$ref")
	private String ref;
	private String display;
	private List<DateRange> dateRanges;

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

	public List<DateRange> getDateRanges() {
		return dateRanges;
	}

	public void setDateIntervals(List<DateRange> dateRanges) {
		this.dateRanges = dateRanges;
	}

	public void addDateInterval(DateRange dateRange) {
		if (this.dateRanges == null)
			this.dateRanges = new ArrayList<DateRange>();
		this.dateRanges.add(dateRange);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateRanges == null) ? 0 : dateRanges.hashCode());
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
		if (dateRanges == null) {
			if (other.dateRanges != null)
				return false;
		} else if (!dateRanges.equals(other.dateRanges))
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
