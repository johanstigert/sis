package skola.model.scim2.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import skola.model.scim2.core.User;
import skola.model.scim2.extension.Person;
import skola.model.scim2.extension.element.StudentNode;

import static skola.model.scim2.extension.element.Constant.URN_PERSON;
import static skola.model.scim2.extension.element.Constant.URN_STUDENT;

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
}
