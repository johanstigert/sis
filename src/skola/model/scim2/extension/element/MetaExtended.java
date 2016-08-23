package skola.model.scim2.extension.element;

import skola.model.scim2.core.Meta;

/**
 * 
 * ©TimeEdit 2016
 *
 */
public class MetaExtended extends Meta {

	private String creatingSystem;

	public MetaExtended() {
	}

	public MetaExtended(String resourceType, String created, String lastModified, String location, String version,
			String creatingSystem) {
		super(resourceType, created, lastModified, location, version);
		this.creatingSystem = creatingSystem;
	}

	public String getCreatingSystem() {
		return creatingSystem;
	}

	public void setCreatingSystem(String creatingSystem) {
		this.creatingSystem = creatingSystem;
	}
}
