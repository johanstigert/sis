package skola.model.scim2.user;

import static skola.model.scim2.extension.element.Constant.URN_PERSON;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import skola.model.scim2.core.User;
import skola.model.scim2.extension.Person;
import skola.model.scim2.extension.element.DateRangeSpan;
import skola.model.scim2.extension.element.GroupReference;

@JsonPropertyOrder({ "schemas", "id", "externalId", "userName", "name", "emails", "employeeType", "datespans", URN_PERSON,
		"parentGroup", "groups", "signature", "meta" })
public class Employee extends User {

	private String employeeType;
	private List<DateRangeSpan> datespans;
	private GroupReference parentGroup;
	private String signature;
	
	@JsonProperty(URN_PERSON)
	private Person person;

	public Employee() {
	}

	public Employee(String id) {
		super(id);
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public List<DateRangeSpan> getDatespans() {
		return datespans;
	}

	public void setDatespans(List<DateRangeSpan> dateSpans) {
		this.datespans = dateSpans;
	}

	public void addDateSpan(DateRangeSpan datespan) {
		if (this.datespans == null)
			datespans = new ArrayList<DateRangeSpan>();
		datespans.add(datespan);
	}

	public GroupReference getParentGroup() {
		return parentGroup;
	}

	public void setParentGroup(GroupReference parentGroup) {
		this.parentGroup = parentGroup;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((datespans == null) ? 0 : datespans.hashCode());
		result = prime * result + ((employeeType == null) ? 0 : employeeType.hashCode());
		result = prime * result + ((parentGroup == null) ? 0 : parentGroup.hashCode());
		result = prime * result + ((signature == null) ? 0 : signature.hashCode());
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
		Employee other = (Employee) obj;
		if (datespans == null) {
			if (other.datespans != null)
				return false;
		} else if (!datespans.equals(other.datespans))
			return false;
		if (employeeType == null) {
			if (other.employeeType != null)
				return false;
		} else if (!employeeType.equals(other.employeeType))
			return false;
		if (parentGroup == null) {
			if (other.parentGroup != null)
				return false;
		} else if (!parentGroup.equals(other.parentGroup))
			return false;
		if (signature == null) {
			if (other.signature != null)
				return false;
		} else if (!signature.equals(other.signature))
			return false;
		return true;
	}
}
