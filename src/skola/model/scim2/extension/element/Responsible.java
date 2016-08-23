package skola.model.scim2.extension.element;

import static skola.model.scim2.extension.element.Constant.URN_DATUMINTERVALL;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * ©TimeEdit 2016
 *
 */
public class Responsible {

	private String value;
	@JsonProperty("$ref")
	private String ref;
	private String formatted;
	@JsonProperty(URN_DATUMINTERVALL)
	private DateRange dateRange;

	public Responsible() {
	}

	public Responsible(String value, String ref, String formatted, DateRange dateRange) {
		super();
		this.value = value;
		this.ref = ref;
		this.formatted = formatted;
		this.dateRange = dateRange;
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

	public String getFormatted() {
		return formatted;
	}

	public void setFormatted(String formatted) {
		this.formatted = formatted;
	}

	public DateRange getDateRange() {
		return dateRange;
	}

	public void setDateRange(DateRange dateRange) {
		this.dateRange = dateRange;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateRange == null) ? 0 : dateRange.hashCode());
		result = prime * result + ((formatted == null) ? 0 : formatted.hashCode());
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
		Responsible other = (Responsible) obj;
		if (dateRange == null) {
			if (other.dateRange != null)
				return false;
		} else if (!dateRange.equals(other.dateRange))
			return false;
		if (formatted == null) {
			if (other.formatted != null)
				return false;
		} else if (!formatted.equals(other.formatted))
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
