package skola.model.scim2.extension.element;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import static skola.model.scim2.extension.element.Constant.URN_DATUMINTERVALL;

@JsonPropertyOrder({ "value", "$ref", "display", URN_DATUMINTERVALL, "timeplanned" })
public class TeacherAssignment {

	private String value;

	@JsonProperty("$ref")
	private String ref;
	private String display;

	@JsonProperty(URN_DATUMINTERVALL)
	private DateRange dateInterval;
	private int timeplanned;

	public TeacherAssignment() {
	}
	
	public TeacherAssignment(String value, String ref, String display, DateRange dateInterval, int timeplanned) {
		this.value = value;
		this.ref = ref;
		this.display = display;
		this.dateInterval = dateInterval;
		this.timeplanned = timeplanned;
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
		return dateInterval;
	}

	public void setDateInterval(DateRange dateInterval) {
		this.dateInterval = dateInterval;
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
		int result = 1;
		result = prime * result + ((dateInterval == null) ? 0 : dateInterval.hashCode());
		result = prime * result + ((display == null) ? 0 : display.hashCode());
		result = prime * result + ((ref == null) ? 0 : ref.hashCode());
		result = prime * result + timeplanned;
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
		TeacherAssignment other = (TeacherAssignment) obj;
		if (dateInterval == null) {
			if (other.dateInterval != null)
				return false;
		} else if (!dateInterval.equals(other.dateInterval))
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
		if (timeplanned != other.timeplanned)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
