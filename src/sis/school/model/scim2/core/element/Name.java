package sis.school.model.scim2.core.element;

/**
 * 
 * ©TimeEdit 2016
 *
 */
public class Name {

	private String formatted;
	private String familyName;
	private String givenName;
	private String middleName;
	private String honorificPrefix;
	private String honorificSuffix;

	public Name() {
	}

	public Name(String formatted, String familyName, String givenName, String middleName, String honorificPrefix,
			String honorificSuffix) {
		this.formatted = formatted;
		this.familyName = familyName;
		this.givenName = givenName;
		this.middleName = middleName;
		this.honorificPrefix = honorificPrefix;
		this.honorificSuffix = honorificSuffix;
	}

	public String getFormatted() {
		return formatted;
	}

	public void setFormatted(String formatted) {
		this.formatted = formatted;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getHonorificPrefix() {
		return honorificPrefix;
	}

	public void setHonorificPrefix(String honorificPrefix) {
		this.honorificPrefix = honorificPrefix;
	}

	public String getHonorificSuffix() {
		return honorificSuffix;
	}

	public void setHonorificSuffix(String honorificSuffix) {
		this.honorificSuffix = honorificSuffix;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((familyName == null) ? 0 : familyName.hashCode());
		result = prime * result + ((formatted == null) ? 0 : formatted.hashCode());
		result = prime * result + ((givenName == null) ? 0 : givenName.hashCode());
		result = prime * result + ((honorificPrefix == null) ? 0 : honorificPrefix.hashCode());
		result = prime * result + ((honorificSuffix == null) ? 0 : honorificSuffix.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
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
		Name other = (Name) obj;
		if (familyName == null) {
			if (other.familyName != null)
				return false;
		} else if (!familyName.equals(other.familyName))
			return false;
		if (formatted == null) {
			if (other.formatted != null)
				return false;
		} else if (!formatted.equals(other.formatted))
			return false;
		if (givenName == null) {
			if (other.givenName != null)
				return false;
		} else if (!givenName.equals(other.givenName))
			return false;
		if (honorificPrefix == null) {
			if (other.honorificPrefix != null)
				return false;
		} else if (!honorificPrefix.equals(other.honorificPrefix))
			return false;
		if (honorificSuffix == null) {
			if (other.honorificSuffix != null)
				return false;
		} else if (!honorificSuffix.equals(other.honorificSuffix))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		return true;
	}
}
