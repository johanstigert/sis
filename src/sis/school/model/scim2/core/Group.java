package sis.school.model.scim2.core;

import static sis.school.model.scim2.extension.element.Constant.BASE_URI;
import static sis.school.model.scim2.extension.element.Constant.URN_DATUMINTERVALL;
import static sis.school.model.scim2.extension.element.Constant.URN_GROUP_CORE;
import static sis.school.model.scim2.extension.element.Constant.URN_GROUP_EXTENSION;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.schema.ResourceType;
import sis.school.model.scim2.extension.element.DateRange;
import sis.school.model.scim2.extension.element.GroupNode;
import sis.school.model.scim2.extension.element.Member;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "schemas", "id", "externalId", "displayName", "members", "dateInterval", "group", "meta" })
public class Group extends Resource {

	private String displayName;
	private List<Member> members;

	@JsonProperty(URN_DATUMINTERVALL)
	private DateRange dateInterval;

	@JsonProperty(URN_GROUP_EXTENSION)
	private GroupNode group;

	public Group() {
	}

	public Group(String id) {
		super(id);
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public void addMember(Member member) {
		if (this.members == null)
			this.members = new ArrayList<Member>();
		this.members.add(member);
	}

	public DateRange getDateInterval() {
		return dateInterval;
	}

	public void setDateInterval(DateRange dateInterval) {
		this.dateInterval = dateInterval;
	}

	public GroupNode getGroup() {
		return group;
	}

	public void setGroup(GroupNode group) {
		this.group = group;
	}

	public enum GroupType {
		SCHOOLUNIT("Schoolunit"), COURSE("Course"), CLASS("Class"), GROUP("Group"), UNKNOWN("Unknown");

		private final String type;

		private GroupType(String type) {
			this.type = type;
		}

		public String toString() {
			return type;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateInterval == null) ? 0 : dateInterval.hashCode());
		result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((members == null) ? 0 : members.hashCode());
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
		Group other = (Group) obj;
		if (dateInterval == null) {
			if (other.dateInterval != null)
				return false;
		} else if (!dateInterval.equals(other.dateInterval))
			return false;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (members == null) {
			if (other.members != null)
				return false;
		} else if (!members.equals(other.members))
			return false;
		return true;
	};

	public static ResourceType getResourceType() {
		ResourceType type = new ResourceType("Group", "/Groups", "Grupp", URN_GROUP_CORE);
		type.setMeta(new Meta("ResourceType", null, null, BASE_URI + "/Groups", null));
		return type;
	}
}
