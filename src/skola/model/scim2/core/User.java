package skola.model.scim2.core;

import java.util.ArrayList;
import java.util.List;

import skola.model.scim2.core.element.Email;
import skola.model.scim2.core.element.Name;
import skola.model.scim2.extension.element.GroupReference;

public class User extends Resource {

	private String userName;
	private Name name;
	private List<Email> emails;
	private List<GroupReference> groups;

	public User() {
	}

	public User(String id) {
		super(id);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public void addMail(Email mail) {
		if (this.emails == null)
			this.emails = new ArrayList<Email>();
		this.emails.add(mail);
	}

	public List<GroupReference> getGroups() {
		return groups;
	}

	public void setGroups(List<GroupReference> groups) {
		this.groups = groups;
	}

	public void addGroup(GroupReference group) {
		if (this.groups == null)
			this.groups = new ArrayList<GroupReference>();
		this.groups.add(group);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((emails == null) ? 0 : emails.hashCode());
		result = prime * result + ((groups == null) ? 0 : groups.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		User other = (User) obj;
		if (emails == null) {
			if (other.emails != null)
				return false;
		} else if (!emails.equals(other.emails))
			return false;
		if (groups == null) {
			if (other.groups != null)
				return false;
		} else if (!groups.equals(other.groups))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
}