package sis.school.model.scim2.extension;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.Resource;

@JsonIgnoreProperties({ "startDate", "endDate" })
@JsonPropertyOrder({ "schemas", "id", "name", "municipalityCode", "ownerName", "ownerType", "meta" })
public class School extends Resource {

	private String name;
	private String municipalityCode;
	private String ownerName;
	private String ownerType;

	public School() {
	}

	public School(String id) {
		super(id);
	}

	public School(String name, String ownerType, String ownerName, String municipalityCode) {
		this.name = name;
		this.ownerType = ownerType;
		this.ownerName = ownerName;
		this.municipalityCode = municipalityCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getMunicipalityCode() {
		return municipalityCode;
	}

	public void setMunicipalityCode(String municipalityCode) {
		this.municipalityCode = municipalityCode;
	}
}
