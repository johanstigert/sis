package skola.model.scim2.core;

import java.util.Arrays;

/**
 * 
 * ©TimeEdit 2016
 *
 */
public abstract class Resource {

	private String[] schemas;
	private String id;
	private String externalId;
	private Meta meta;

	public Resource() {
	}

	public Resource(String id) {
		this.id = id;
	}

	public String[] getSchemas() {
		return schemas;
	}

	public void setSchemas(String[] schemas) {
		this.schemas = schemas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public enum ResourceTypeStr {
		GROUP("Group"), EMPLOYEE("Employee"), STUDENT("Student"), ACTIVITY("Activity"), CALENDAREVENT("CalendarEvent");

		private final String type;

		private ResourceTypeStr(String type) {
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
		result = prime * result + ((externalId == null) ? 0 : externalId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((meta == null) ? 0 : meta.hashCode());
		result = prime * result + Arrays.hashCode(schemas);
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
		Resource other = (Resource) obj;
		if (externalId == null) {
			if (other.externalId != null)
				return false;
		} else if (!externalId.equals(other.externalId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (meta == null) {
			if (other.meta != null)
				return false;
		} else if (!meta.equals(other.meta))
			return false;
		if (!Arrays.equals(schemas, other.schemas))
			return false;
		return true;
	};
}
