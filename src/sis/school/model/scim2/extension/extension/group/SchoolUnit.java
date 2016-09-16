package sis.school.model.scim2.extension.extension.group;

import java.util.List;

import sis.school.model.scim2.extension.code.Code.SchoolType;

/**
 * 
 * ©TimeEdit 2016
 *
 */
public class SchoolUnit {

	private String schoolUnitCode;
	private List<SchoolType> schoolTypes;
	private String ownerType;
	private String ownerName;
	private String municipalityCode;

	public SchoolUnit() {
	}

	public SchoolUnit(String schoolUnitCode, List<SchoolType> schoolTypes, String ownerType, String ownerName,
			String municipalityCode) {
		super();
		this.schoolUnitCode = schoolUnitCode;
		this.schoolTypes = schoolTypes;
		this.ownerType = ownerType;
		this.ownerName = ownerName;
		this.municipalityCode = municipalityCode;
	}

	public String getSchoolUnitCode() {
		return schoolUnitCode;
	}

	public void setSchoolUnitCode(String schoolUnitCode) {
		this.schoolUnitCode = schoolUnitCode;
	}

	public List<SchoolType> getSchoolTypes() {
		return schoolTypes;
	}

	public void setSchoolTypes(List<SchoolType> schoolTypes) {
		this.schoolTypes = schoolTypes;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((municipalityCode == null) ? 0 : municipalityCode.hashCode());
		result = prime * result + ((ownerName == null) ? 0 : ownerName.hashCode());
		result = prime * result + ((ownerType == null) ? 0 : ownerType.hashCode());
		result = prime * result + ((schoolTypes == null) ? 0 : schoolTypes.hashCode());
		result = prime * result + ((schoolUnitCode == null) ? 0 : schoolUnitCode.hashCode());
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
		SchoolUnit other = (SchoolUnit) obj;
		if (municipalityCode == null) {
			if (other.municipalityCode != null)
				return false;
		} else if (!municipalityCode.equals(other.municipalityCode))
			return false;
		if (ownerName == null) {
			if (other.ownerName != null)
				return false;
		} else if (!ownerName.equals(other.ownerName))
			return false;
		if (ownerType == null) {
			if (other.ownerType != null)
				return false;
		} else if (!ownerType.equals(other.ownerType))
			return false;
		if (schoolTypes == null) {
			if (other.schoolTypes != null)
				return false;
		} else if (!schoolTypes.equals(other.schoolTypes))
			return false;
		if (schoolUnitCode == null) {
			if (other.schoolUnitCode != null)
				return false;
		} else if (!schoolUnitCode.equals(other.schoolUnitCode))
			return false;
		return true;
	}
}
