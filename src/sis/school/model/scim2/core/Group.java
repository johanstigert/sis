package sis.school.model.scim2.core;

import static sis.school.model.scim2.extension.element.Constant.BASE_URI;
import static sis.school.model.scim2.extension.element.Constant.URN_GROUP_CORE;
<<<<<<< HEAD
import static sis.school.model.scim2.extension.element.Constant.URN_GROUP_EXTENSION;
import static sis.school.model.scim2.extension.element.Constant.URN_GROUP_SCHOOLUNIT;
import static sis.school.model.scim2.extension.element.Constant.URN_GROUP_STUDENT;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import sis.school.model.scim2.core.element.SchemaExtension;
import sis.school.model.scim2.core.schema.ResourceType;
import sis.school.model.scim2.extension.element.Member;

/**
 * 
 * ©TimeEdit 2016
 *
 */
public class Group extends Resource {

	private String displayName;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Member> members;

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

	public static ResourceType getResourceType() {
		ResourceType type = new ResourceType("Group", "/Groups", "Grupp", URN_GROUP_CORE, null);
		type.addSchemaExtension(new SchemaExtension(URN_GROUP_EXTENSION, false));
		type.addSchemaExtension(new SchemaExtension(URN_GROUP_SCHOOLUNIT, false));
		type.addSchemaExtension(new SchemaExtension(URN_GROUP_STUDENT, false));
		type.setMeta(new Meta("ResourceType", null, null, BASE_URI + "/ResourceTypes/Group", null));
=======

import java.util.ArrayList;
import java.util.List;

import sis.school.model.scim2.core.schema.ResourceType;
import sis.school.model.scim2.extension.element.Member;

/**
 * 
 * ©TimeEdit 2016
 *
 */
public class Group extends Resource {

	private String displayName;
	private List<Member> members;

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

	// public enum GroupType {
	// SCHOOLUNIT("Schoolunit"), COURSE("Course"), CLASS("Class"),
	// GROUP("Group"), UNKNOWN("Unknown");
	//
	// private final String type;
	//
	// private GroupType(String type) {
	// this.type = type;
	// }
	//
	// public String toString() {
	// return type;
	// }
	// }

	public static ResourceType getResourceType() {
		ResourceType type = new ResourceType("Group", "/Groups", "Grupp", URN_GROUP_CORE);
		type.setMeta(new Meta("ResourceType", null, null, BASE_URI + "/Groups", null));
>>>>>>> branch 'master' of https://github.com/johanstigert/sis.git
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + ((members == null) ? 0 : members.hashCode());
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
		Group other = (Group) obj;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (members == null) {
			if (other.members != null)
				return false;
		} else if (!members.equals(other.members))
			return false;
		return true;
	}
}
