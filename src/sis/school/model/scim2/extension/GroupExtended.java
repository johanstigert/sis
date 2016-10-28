package sis.school.model.scim2.extension;

import static sis.school.model.scim2.extension.element.Constant.URN_GROUP_EXTENSION;
import static sis.school.model.scim2.extension.element.Constant.URN_GROUP_STUDENT;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.Group;
import sis.school.model.scim2.extension.extension.group.GroupNode;
import sis.school.model.scim2.extension.extension.group.StudentGroup;

@JsonIgnoreProperties({ "urn:scim:schemas:extension:sis:school:schoolunit:1.0" })
@JsonPropertyOrder({ "schemas", "id", "displayName", "members", URN_GROUP_EXTENSION, URN_GROUP_STUDENT, "meta" })
public class GroupExtended extends Group {

	@JsonProperty(URN_GROUP_EXTENSION)
	private GroupNode group;

	@JsonProperty(URN_GROUP_STUDENT)
	private StudentGroup studentGroup;

	public GroupExtended() {
	}

	public GroupExtended(String id) {
		super(id);
	}

	public GroupExtended(GroupNode group, StudentGroup studentGroup) {
		super();
		this.group = group;
		this.studentGroup = studentGroup;
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

	// public List<GroupMember> getGroupMembers() {
	// return groupMembers;
	// }
	//
	// public void setGroupMembers(List<GroupMember> groupMembers) {
	// this.groupMembers = groupMembers;
	// }
	//
	// public void addGroupMember(GroupMember member) {
	// if (this.groupMembers == null) {
	// this.groupMembers = new ArrayList<GroupMember>();
	// }
	// this.groupMembers.add(member);
	// }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		// result = prime * result + ((groupMembers == null) ? 0 :
		// groupMembers.hashCode());
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
		// if (groupMembers == null) {
		// if (other.groupMembers != null)
		// return false;
		// } else if (!groupMembers.equals(other.groupMembers))
		// return false;
		if (studentGroup == null) {
			if (other.studentGroup != null)
				return false;
		} else if (!studentGroup.equals(other.studentGroup))
			return false;
		return true;
	}
}