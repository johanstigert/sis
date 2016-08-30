package sis.school.model.scim2.core.schema;

import java.util.List;

/**
 * 
 * ©TimeEdit 2016
 *
 */
public class Attribute {

	private String name;
	private String type;
	private boolean multiValued;
	private String description;
	private boolean required;
	private boolean caseExact;
	private String mutablility;
	private String returned;
	private String uniqueness;
	private String[] canonicalValues;
	private List<Attribute> subAttributes;

	public Attribute() {
	}

	public Attribute(String name, String type, boolean multiValued, String description, boolean required,
			List<Attribute> subAttributes, boolean caseExact, String[] canonicalValues, String mutablility,
			String returned, String uniqueness) {
		super();
		this.name = name;
		this.type = type;
		this.multiValued = multiValued;
		this.description = description;
		this.required = required;
		this.subAttributes = subAttributes;
		this.caseExact = caseExact;
		this.canonicalValues = canonicalValues;
		this.mutablility = mutablility;
		this.returned = returned;
		this.uniqueness = uniqueness;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isMultiValued() {
		return multiValued;
	}

	public void setMultiValued(boolean multiValued) {
		this.multiValued = multiValued;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public boolean isCaseExact() {
		return caseExact;
	}

	public void setCaseExact(boolean caseExact) {
		this.caseExact = caseExact;
	}

	public String getMutablility() {
		return mutablility;
	}

	public void setMutablility(String mutablility) {
		this.mutablility = mutablility;
	}

	public String getReturned() {
		return returned;
	}

	public void setReturned(String returned) {
		this.returned = returned;
	}

	public String getUniqueness() {
		return uniqueness;
	}

	public void setUniqueness(String uniqueness) {
		this.uniqueness = uniqueness;
	}

	public List<Attribute> getSubAttributes() {
		return subAttributes;
	}

	public void setSubAttributes(List<Attribute> subAttributes) {
		this.subAttributes = subAttributes;
	}

	public String[] getCanonicalValues() {
		return canonicalValues;
	}

	public void setCanonicalValues(String[] canonicalValues) {
		this.canonicalValues = canonicalValues;
	}
}
