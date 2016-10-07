package sis.school.model.scim2.extension.element;

import java.util.ArrayList;
import java.util.List;

public class GroupMembers {

	private List<GroupMember> employees;
	private List<GroupMember> students;

	public GroupMembers() {
	}

	public GroupMembers(List<GroupMember> employees, List<GroupMember> students) {
		super();
		this.employees = employees;
		this.students = students;
	}

	public List<GroupMember> getEmployees() {
		return employees;
	}

	public void setEmployees(List<GroupMember> employees) {
		this.employees = employees;
	}

	public List<GroupMember> getStudents() {
		return students;
	}

	public void setStudents(List<GroupMember> students) {
		this.students = students;
	}

	public void addStudent(GroupMember student) {
		if (this.students == null) {
			this.students = new ArrayList<GroupMember>();
		}
		this.students.add(student);
	}

	public void addEmployee(GroupMember employee) {
		if (this.employees == null) {
			this.employees = new ArrayList<GroupMember>();
		}
		this.employees.add(employee);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
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
		GroupMembers other = (GroupMembers) obj;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}
}
