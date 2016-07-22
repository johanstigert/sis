package skola.model.scim2.extension.element;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentNode implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nativeLanguage;
	private List<SchoolNode> schools;
	private List<ContactPerson> contactPersons;

	public StudentNode() {
	}
	
	public String getNativeLanguage() {
		return nativeLanguage;
	}

	public void setNativeLanguage(String nativeLanguage) {
		this.nativeLanguage = nativeLanguage;
	}

	public List<SchoolNode> getSchools() {
		return schools;
	}

	public void setSchools(List<SchoolNode> schools) {
		this.schools = schools;
	}

	public void addSchool(SchoolNode school) {
		if (this.schools == null) {
			this.schools = new ArrayList<SchoolNode>();
		}
		this.schools.add(school);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<ContactPerson> getContactPersons() {
		return contactPersons;
	}

	public void setContactPersons(List<ContactPerson> contactPersons) {
		this.contactPersons = contactPersons;
	}

	public void addContactPersons(ContactPerson contactPerson) {
		if (this.contactPersons == null)
			this.contactPersons = new ArrayList<ContactPerson>();
		this.contactPersons.add(contactPerson);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactPersons == null) ? 0 : contactPersons.hashCode());
		result = prime * result + ((nativeLanguage == null) ? 0 : nativeLanguage.hashCode());
		result = prime * result + ((schools == null) ? 0 : schools.hashCode());
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
		StudentNode other = (StudentNode) obj;
		if (contactPersons == null) {
			if (other.contactPersons != null)
				return false;
		} else if (!contactPersons.equals(other.contactPersons))
			return false;
		if (nativeLanguage == null) {
			if (other.nativeLanguage != null)
				return false;
		} else if (!nativeLanguage.equals(other.nativeLanguage))
			return false;
		if (schools == null) {
			if (other.schools != null)
				return false;
		} else if (!schools.equals(other.schools))
			return false;
		return true;
	}
}