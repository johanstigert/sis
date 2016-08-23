package skola.model.scim2.extension.element;

import skola.model.scim2.group.IGroupType;

/**
 * 
 * ©TimeEdit 2016
 *
 */
public class GroupNode {

	private IGroupType groupType;
	private GroupReference parentGroup;

	public GroupNode() {
	}

	public IGroupType getGroupType() {
		return groupType;
	}

	public void setGroupType(IGroupType groupType) {
		this.groupType = groupType;
	}

	public GroupReference getParentGroup() {
		return parentGroup;
	}

	public void setParentGroup(GroupReference parentGroup) {
		this.parentGroup = parentGroup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupType == null) ? 0 : groupType.hashCode());
		result = prime * result + ((parentGroup == null) ? 0 : parentGroup.hashCode());
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
		GroupNode other = (GroupNode) obj;
		if (groupType == null) {
			if (other.groupType != null)
				return false;
		} else if (!groupType.equals(other.groupType))
			return false;
		if (parentGroup == null) {
			if (other.parentGroup != null)
				return false;
		} else if (!parentGroup.equals(other.parentGroup))
			return false;
		return true;
	}
}
