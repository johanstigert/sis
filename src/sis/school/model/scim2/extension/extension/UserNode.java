package sis.school.model.scim2.extension.extension;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.extension.code.Code.Gender;
import sis.school.model.scim2.extension.element.ContactPerson;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonIgnoreProperties({ "nativeLanguage" })
@JsonPropertyOrder({ "civicNo", "securityMarking", "gender", "contactPersons", "enrolment" })
public class UserNode {

	/**
	 * format: yyyy-MM-dd?
	 */
	private String civicNo;

	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private boolean securityMarking;

	private String gender;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	// @JsonProperty(URN_CONTACT_PERSON)
	private List<ContactPerson> contactPersons;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	// @JsonProperty(URN_ENROLMENT)
	private List<Enrolment> enrolments;

	public UserNode() {
	}

	public UserNode(String civicNo, boolean securityMarking, String gender, List<ContactPerson> contactPersons,
			List<Enrolment> enrolments) {
		this.civicNo = civicNo;
		this.securityMarking = securityMarking;
		this.gender = gender;
		this.contactPersons = contactPersons;
		this.enrolments = enrolments;
	}

	public String getCivicNo() {
		return civicNo;
	}

	public void setCivicNo(String civicNo) {
		this.civicNo = civicNo;
	}

	public boolean isSecurityMarking() {
		return securityMarking;
	}

	public void setSecurityMarking(boolean securityMarking) {
		this.securityMarking = securityMarking;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<ContactPerson> getContactPersons() {
		return contactPersons;
	}

	public void setContactPersons(List<ContactPerson> contactPersons) {
		this.contactPersons = contactPersons;
	}

	public List<Enrolment> getEnrolments() {
		return enrolments;
	}

	public void setEnrolments(List<Enrolment> enrolments) {
		this.enrolments = enrolments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((civicNo == null) ? 0 : civicNo.hashCode());
		result = prime * result + ((contactPersons == null) ? 0 : contactPersons.hashCode());
		result = prime * result + ((enrolments == null) ? 0 : enrolments.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + (securityMarking ? 1231 : 1237);
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
		UserNode other = (UserNode) obj;
		if (civicNo == null) {
			if (other.civicNo != null)
				return false;
		} else if (!civicNo.equals(other.civicNo))
			return false;
		if (contactPersons == null) {
			if (other.contactPersons != null)
				return false;
		} else if (!contactPersons.equals(other.contactPersons))
			return false;
		if (enrolments == null) {
			if (other.enrolments != null)
				return false;
		} else if (!enrolments.equals(other.enrolments))
			return false;
		if (gender != other.gender)
			return false;
		if (securityMarking != other.securityMarking)
			return false;
		return true;
	}

	public void addContactPersons(ContactPerson contactPerson) {
		if (this.contactPersons == null)
			this.contactPersons = new ArrayList<ContactPerson>();
		this.contactPersons.add(contactPerson);
	}

	public void addEnrolment(Enrolment enrolment) {
		if (this.enrolments == null)
			this.enrolments = new ArrayList<Enrolment>();
		this.enrolments.add(enrolment);
=======
import static sis.school.model.scim2.extension.element.Constant.URN_CONTACT_PERSON;
import static sis.school.model.scim2.extension.element.Constant.URN_ENROLMENT;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.extension.code.Code.Gender;
import sis.school.model.scim2.extension.element.ContactPerson;
import sis.school.model.scim2.extension.element.Reference;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "civicNo", "securityMarking", "gender", "contactPersons" })
public class UserNode {

	/**
	 * format: yyyy-MM-dd?
	 */
	private String civicNo;

	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private boolean securityMarking;

	private Gender gender;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty(URN_CONTACT_PERSON)
	private List<ContactPerson> contactPersons;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty(URN_ENROLMENT)
	private List<Enrolment> enrolments;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Reference> employments;

	public UserNode() {
	}

	public UserNode(String civicNo, boolean securityMarking, Gender gender, List<ContactPerson> contactPersons,
			List<Enrolment> enrolments, List<Reference> employments) {
		this.civicNo = civicNo;
		this.securityMarking = securityMarking;
		this.gender = gender;
		this.contactPersons = contactPersons;
		this.enrolments = enrolments;
		this.employments = employments;
	}

	public String getCivicNo() {
		return civicNo;
	}

	public void setCivicNo(String civicNo) {
		this.civicNo = civicNo;
	}

	public boolean isSecurityMarking() {
		return securityMarking;
	}

	public void setSecurityMarking(boolean securityMarking) {
		this.securityMarking = securityMarking;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<ContactPerson> getContactPersons() {
		return contactPersons;
	}

	public void setContactPersons(List<ContactPerson> contactPersons) {
		this.contactPersons = contactPersons;
	}

	public List<Enrolment> getEnrolments() {
		return enrolments;
	}

	public void setEnrolments(List<Enrolment> enrolments) {
		this.enrolments = enrolments;
	}

	public List<Reference> getEmployments() {
		return employments;
	}

	public void setEmployments(List<Reference> employments) {
		this.employments = employments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((civicNo == null) ? 0 : civicNo.hashCode());
		result = prime * result + ((contactPersons == null) ? 0 : contactPersons.hashCode());
		result = prime * result + ((employments == null) ? 0 : employments.hashCode());
		result = prime * result + ((enrolments == null) ? 0 : enrolments.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + (securityMarking ? 1231 : 1237);
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
		UserNode other = (UserNode) obj;
		if (civicNo == null) {
			if (other.civicNo != null)
				return false;
		} else if (!civicNo.equals(other.civicNo))
			return false;
		if (contactPersons == null) {
			if (other.contactPersons != null)
				return false;
		} else if (!contactPersons.equals(other.contactPersons))
			return false;
		if (employments == null) {
			if (other.employments != null)
				return false;
		} else if (!employments.equals(other.employments))
			return false;
		if (enrolments == null) {
			if (other.enrolments != null)
				return false;
		} else if (!enrolments.equals(other.enrolments))
			return false;
		if (gender != other.gender)
			return false;
		if (securityMarking != other.securityMarking)
			return false;
		return true;
	}

	public void addContactPersons(ContactPerson contactPerson) {
		if (this.contactPersons == null)
			this.contactPersons = new ArrayList<ContactPerson>();
		this.contactPersons.add(contactPerson);
	}

	public void addEnrolment(Enrolment enrolment) {
		if (this.enrolments == null)
			this.enrolments = new ArrayList<Enrolment>();
		this.enrolments.add(enrolment);
	}

	public void addEmployment(Reference employment) {
		if (this.employments == null)
			this.employments = new ArrayList<Reference>();
		this.employments.add(employment);
>>>>>>> branch 'master' of https://github.com/johanstigert/sis.git
	}
}
