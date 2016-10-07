package sis.school.model.scim2.extension.extension.group;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.element.Reference;
import sis.school.model.scim2.extension.element.DateRange;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "dateRange", "parentgroup" })
public class GroupNode {

	private DateRange dateRange;
	private Reference parentGroup;

	public GroupNode() {
	}

	public GroupNode(DateRange dateRange, Reference parentGroup) {
		super();
		this.dateRange = dateRange;
		this.parentGroup = parentGroup;
	}

	public DateRange getDateRange() {
		return dateRange;
	}

	public void setDateRange(DateRange dateRange) {
		this.dateRange = dateRange;
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
		int result = 1;
		result = prime * result + ((dateRange == null) ? 0 : dateRange.hashCode());
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
		if (dateRange == null) {
			if (other.dateRange != null)
				return false;
		} else if (!dateRange.equals(other.dateRange))
			return false;
		if (parentGroup == null) {
			if (other.parentGroup != null)
				return false;
		} else if (!parentGroup.equals(other.parentGroup))
			return false;
		return true;
	}
}
