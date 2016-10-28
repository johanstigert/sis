package sis.school.model.scim2.extension.extension.group;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.element.Reference;
import sis.school.model.scim2.extension.element.DateRange;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "startDate", "endDate", "parentgroup" })
public class GroupNode extends DateRange {

	private Reference parentGroup;

	public GroupNode() {
	}

	public GroupNode(Reference parentGroup) {
		super();
		this.parentGroup = parentGroup;
	}

	public Reference getParentGroup() {
		return parentGroup;
	}

	public void setParentGroup(Reference parentGroup) {
		this.parentGroup = parentGroup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((parentGroup == null) ? 0 : parentGroup.hashCode());
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
		GroupNode other = (GroupNode) obj;
		if (parentGroup == null) {
			if (other.parentGroup != null)
				return false;
		} else if (!parentGroup.equals(other.parentGroup))
			return false;
		return true;
	}
}
