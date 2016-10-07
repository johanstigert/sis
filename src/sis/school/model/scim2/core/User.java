package sis.school.model.scim2.core;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import sis.school.model.scim2.core.element.Email;
import sis.school.model.scim2.core.element.Name;
import sis.school.model.scim2.core.element.Reference;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonIgnoreProperties({ "nickName", "profileUrl", "title", "userType", "preferredLanguage", "locale", "timezone",
		"active", "phoneNumbers", "ims", "photos", "addresses", "entitlements", "roles", "x509Certificates" })
public class User extends Resource {

	private String userName;
	private Name name;
	private String displayName;
	private List<Email> emails;
	private List<Reference> groups;

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

	public List<Reference> getGroups() {
		return groups;
	}

	public void setGroups(List<Reference> groups) {
		this.groups = groups;
	}

	public void addGroup(Reference group) {
		if (this.groups == null)
			this.groups = new ArrayList<Reference>();
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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
=======
import sis.school.model.scim2.core.element.Email;
import sis.school.model.scim2.core.element.Name;
import sis.school.model.scim2.extension.element.Reference;

/**
 * 
 * ©TimeEdit 2016
 *
 */
public class User extends Resource {

	private String userName;
	private Name name;
	private List<Email> emails;
	private List<Reference> groups;

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

	public List<Reference> getGroups() {
		return groups;
	}

	public void setGroups(List<Reference> groups) {
		this.groups = groups;
	}

	public void addGroup(Reference group) {
		if (this.groups == null)
			this.groups = new ArrayList<Reference>();
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
>>>>>>> branch 'master' of https://github.com/johanstigert/sis.git
	}
}