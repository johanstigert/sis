package sis.school.model.scim2.core;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "resourceType", "created", "lastModified", "version", "location" })
public class Meta {

	private String resourceType;
	private String created;
	private String lastModified;
	private String location;
	private String version;

	public Meta() {
	}

	public Meta(String resourceType, String created, String lastModified, String location, String version) {
		this.resourceType = resourceType;
		this.created = created;
		this.lastModified = lastModified;
		this.location = location;
		setVersion(version);
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		if (version == null) {
			return;
		}
		if (version.contains("W")) {
			this.version = version;
		} else {
			this.version = "W/\"" + version + "\"";
		}
	}
}