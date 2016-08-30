package sis.school.model.scim2.user;

import static sis.school.model.scim2.extension.element.Constant.BASE_URI;
import static sis.school.model.scim2.extension.element.Constant.URN_PERSON;
import static sis.school.model.scim2.extension.element.Constant.URN_STUDENT;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.Meta;
import sis.school.model.scim2.core.User;
import sis.school.model.scim2.core.schema.Attribute;
import sis.school.model.scim2.core.schema.ResourceType;
import sis.school.model.scim2.core.schema.Schema;
import sis.school.model.scim2.extension.Person;
import sis.school.model.scim2.extension.element.StudentNode;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "schemas", "id", "externalId", "userName", "name", "emails", "groups", URN_PERSON, URN_STUDENT,
		"meta" })
public class Student extends User {

	@JsonProperty(URN_PERSON)
	private Person person;

	@JsonProperty(URN_STUDENT)
	private StudentNode student;

	public Student() {
	}

	public Student(String id) {
		super(id);
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public StudentNode getStudent() {
		return student;
	}

	public void setStudent(StudentNode student) {
		this.student = student;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		Student other = (Student) obj;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

	public static Schema getSchema() {
		Schema schema = new Schema();
		schema.setId(URN_STUDENT);
		schema.setName("Student");
		schema.setDescription("Schema representation of a student");

		schema.addAttribute(new Attribute("id", "string", false, "Unique identifier for the student.", false, null,
				false, null, "immutable", "default", "global"));
		schema.addAttribute(new Attribute("externalId", "string", false, "Unique identifier for the student.", false,
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

		List<Attribute> sub3 = new ArrayList<Attribute>();
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
		ResourceType type = new ResourceType("Student", "/Students", "Student", URN_STUDENT);
		type.setMeta(new Meta("ResourceType", null, null, BASE_URI + "/Students", null));
		return type;
	}
}
