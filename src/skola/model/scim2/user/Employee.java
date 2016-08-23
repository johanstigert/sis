package skola.model.scim2.user;

import static skola.model.scim2.extension.element.Constant.BASE_URI;
import static skola.model.scim2.extension.element.Constant.URN_EMPLOYEE;
import static skola.model.scim2.extension.element.Constant.URN_PERSON;
import static skola.model.scim2.extension.element.Constant.URN_STUDENT;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import skola.model.scim2.core.Meta;
import skola.model.scim2.core.User;
import skola.model.scim2.core.schema.Attribute;
import skola.model.scim2.core.schema.ResourceType;
import skola.model.scim2.core.schema.Schema;
import skola.model.scim2.extension.Person;
import skola.model.scim2.extension.element.DateRangeSpan;
import skola.model.scim2.extension.element.GroupReference;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "schemas", "id", "externalId", "userName", "name", "emails", "employeeType", "datespans",
		URN_PERSON, "parentGroup", "groups", "signature", "meta" })
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

	public static Schema getSchema() {
		Schema schema = new Schema();
		schema.setId(URN_EMPLOYEE);
		schema.setName("Employee");
		schema.setDescription("Schema representation of an employee");

		// "schemas", "id", "externalId", "userName", "name", "emails",
		// "employeeType", "datespans",
		// URN_PERSON, "parentGroup", "groups", "signature", "meta"

		schema.addAttribute(new Attribute("id", "string", false, "Unique identifier for the employee.", false, null,
				false, null, "immutable", "default", "global"));
		schema.addAttribute(new Attribute("externalId", "string", false, "Unique identifier for the employee.", false,
				null, false, null, "immutable", "default", "global"));
		schema.addAttribute(new Attribute("userName", "string", false, "", true, null, false, null, "readWrite",
				"default", "none"));

		List<Attribute> sub1 = new ArrayList<Attribute>();
		sub1.add(new Attribute("formatted", "string", false, "", true, null, false, null, "readWrite", "default",
				"none"));
		sub1.add(new Attribute("familyName", "string", false, "", true, null, false, null, "readWrite", "default",
				"none"));
		sub1.add(new Attribute("givenName", "string", false, "", true, null, false, null, "readWrite", "default",
				"none"));
		sub1.add(new Attribute("middleName", "string", false, "", true, null, false, null, "readWrite", "default",
				"none"));
		sub1.add(new Attribute("honorificPrefix", "string", false, "", true, null, false, null, "readWrite", "default",
				"none"));
		sub1.add(new Attribute("honorificSuffix", "string", false, "", true, null, false, null, "readWrite", "default",
				"none"));
		schema.addAttribute(
				new Attribute("name", "complex", false, "", true, sub1, false, null, "readWrite", "default", "none"));

		List<Attribute> sub2 = new ArrayList<Attribute>();
		sub2.add(
				new Attribute("value", "string", false, "", true, null, false, null, "readWrite", "default", "global"));
		sub2.add(new Attribute("type", "string", false, "", true, null, false, null, "readWrite", "default", "none"));
		sub2.add(new Attribute("primary", "boolean", false, "", true, null, false, null, "readWrite", "default",
				"none"));
		schema.addAttribute(
				new Attribute("emails", "complex", true, "", true, sub2, false, null, "readWrite", "default", "none"));

		schema.addAttribute(new Attribute("employeeType", "string", true, "", true, null, false, null, "readWrite",
				"default", "none"));

		List<Attribute> sub3 = new ArrayList<Attribute>();
		sub3.add(
				new Attribute("start", "dateTime", false, "", true, null, false, null, "readWrite", "default", "none"));
		sub3.add(new Attribute("end", "dateTime", false, "", true, null, false, null, "readWrite", "default", "none"));
		sub3.add(new Attribute("yearWorkTime", "integer", false, "", true, null, false, null, "readWrite", "default",
				"none"));
		schema.addAttribute(new Attribute("datespans", "complex", true, "", true, sub3, false, null, "readWrite",
				"default", "none"));

		schema.addAttribute(new Attribute(URN_PERSON, "complex", true, "", true, sub3, false, null, "readWrite",
				"default", "none"));

		// w , "parentGroup", "groups", "signature", "meta"

		// ---
		// List<Attribute> sub3 = new ArrayList<Attribute>();
		sub3.add(new Attribute("value", "string", false, "", true, null, false, null, "immutable", "default", "none"));
		sub3.add(
				new Attribute("$ref", "reference", false, "", true, null, false, null, "immutable", "default", "none"));
		sub3.add(
				new Attribute("display", "string", false, "", true, null, false, null, "immutable", "default", "none"));
		sub3.add(new Attribute("type", "string", false, "", true, null, false, null, "immutable", "default", "none"));
		schema.addAttribute(new Attribute("groups", "complex", true, "A list of groups to which the student belongs",
				true, sub3, false, null, "readWrite", "default", "none"));

		List<Attribute> sub4 = new ArrayList<Attribute>();
		sub4.add(new Attribute("schoolUnitId", "string", false, "", true, null, false, null, "readWrite", "default",
				"none"));
		sub4.add(new Attribute("schoolType", "string", false, "", true, null, false, null, "readWrite", "default",
				"none"));

		List<Attribute> sub5 = new ArrayList<Attribute>();
		sub5.add(
				new Attribute("school", "complex", false, "", true, sub4, false, null, "immutable", "default", "none"));

		schema.addAttribute(new Attribute(URN_STUDENT, "complex", true, "", true, sub5, false, null, "immutable",
				"default", "none"));

		List<Attribute> sub6 = new ArrayList<Attribute>();
		sub6.add(new Attribute("pnr", "string", false, "", true, null, false, null, "readWrite", "default", "global"));
		List<Attribute> sub7 = new ArrayList<Attribute>();
		sub7.add(new Attribute("number", "string", false, "", true, null, false, null, "readWrite", "default",
				"global"));
		sub7.add(new Attribute("type", "string", false, "", true, null, false, null, "readWrite", "default", "global"));
		sub6.add(
				new Attribute("phones", "complex", false, "", true, sub7, false, null, "readWrite", "default", "none"));
		sub6.add(new Attribute("protected", "boolean", false, "", true, null, false, null, "readWrite", "default",
				"none"));
		schema.addAttribute(new Attribute(URN_PERSON, "complex", true, "", true, sub6, false, null, "immutable",
				"default", "none"));

		return schema;
	}

	public static ResourceType getResourceType() {
		ResourceType type = new ResourceType("Employee", "/Employees", "Anställd", URN_EMPLOYEE);
		type.setMeta(new Meta("ResourceType", null, null, BASE_URI + "/Employees", null));
		return type;
	}
}
