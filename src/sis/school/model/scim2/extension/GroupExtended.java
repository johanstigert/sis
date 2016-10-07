package sis.school.model.scim2.extension;

import static sis.school.model.scim2.extension.element.Constant.URN_GROUP_EXTENSION;
import static sis.school.model.scim2.extension.element.Constant.URN_GROUP_MEMBERS;
import static sis.school.model.scim2.extension.element.Constant.URN_GROUP_SCHOOLUNIT;
import static sis.school.model.scim2.extension.element.Constant.URN_GROUP_STUDENT;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.Group;
import sis.school.model.scim2.extension.element.GroupMembers;
import sis.school.model.scim2.extension.extension.group.GroupNode;
import sis.school.model.scim2.extension.extension.group.SchoolUnit;
import sis.school.model.scim2.extension.extension.group.StudentGroup;

@JsonPropertyOrder({ "schemas", "id", "displayName", "members", URN_GROUP_MEMBERS, URN_GROUP_EXTENSION,
		URN_GROUP_STUDENT, URN_GROUP_SCHOOLUNIT, "meta" })
public class GroupExtended extends Group {

	@JsonProperty(URN_GROUP_EXTENSION)
	private GroupNode group;

	@JsonProperty(URN_GROUP_STUDENT)
	private StudentGroup studentGroup;

	@JsonProperty(URN_GROUP_SCHOOLUNIT)
	private SchoolUnit schoolunit;

	@JsonProperty(URN_GROUP_MEMBERS)
	private GroupMembers groupMembers;

	public GroupExtended() {
	}

	public GroupExtended(String id) {
		super(id);
	}

	public GroupExtended(GroupNode group, StudentGroup studentGroup, SchoolUnit schoolunit) {
		super();
		this.group = group;
		this.studentGroup = studentGroup;
		this.schoolunit = schoolunit;
	}

	public GroupNode getGroup() {
		return group;
	}

	public void setGroup(GroupNode group) {
		this.group = group;
	}

	public StudentGroup getStudentGroup() {
		return studentGroup;
	}

	public void setStudentGroup(StudentGroup studentGroup) {
		this.studentGroup = studentGroup;
	}

	public SchoolUnit getSchoolunit() {
		return schoolunit;
	}

	public void setSchoolunit(SchoolUnit schoolunit) {
		this.schoolunit = schoolunit;
	}

	public GroupMembers getGroupMembers() {
		return groupMembers;
	}

	public void setGroupMembers(GroupMembers groupMembers) {
		this.groupMembers = groupMembers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((schoolunit == null) ? 0 : schoolunit.hashCode());
		result = prime * result + ((studentGroup == null) ? 0 : studentGroup.hashCode());
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
		GroupExtended other = (GroupExtended) obj;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (schoolunit == null) {
			if (other.schoolunit != null)
				return false;
		} else if (!schoolunit.equals(other.schoolunit))
			return false;
		if (studentGroup == null) {
			if (other.studentGroup != null)
				return false;
		} else if (!studentGroup.equals(other.studentGroup))
			return false;
		return true;
	}
}