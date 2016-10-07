package sis.school.model.scim2.extension;

import static sis.school.model.scim2.extension.element.Constant.BASE_URI;
import static sis.school.model.scim2.extension.element.Constant.URN_USER;
import static sis.school.model.scim2.extension.element.Constant.URN_USER_EXTENDED;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.Meta;
import sis.school.model.scim2.core.User;
import sis.school.model.scim2.core.element.Reference;
import sis.school.model.scim2.core.element.SchemaExtension;
import sis.school.model.scim2.core.schema.Attribute;
import sis.school.model.scim2.core.schema.ResourceType;
import sis.school.model.scim2.core.schema.Schema;
import sis.school.model.scim2.extension.extension.UserNode;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "schemas", "id", "externalId", "userName", "name", "emails", "groups", URN_USER_EXTENDED,
		"employments", "meta" })
public class UserExtended extends User {

	@JsonProperty(URN_USER_EXTENDED)
	private UserNode user;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Reference> employments;

	public UserExtended() {
	}

	public UserExtended(String id) {
		super(id);
	}

	public UserNode getUser() {
		return user;
	}

	public void setUser(UserNode user) {
		this.user = user;
	}

	public static Schema getSchema() {
		Schema schema = new Schema();
		schema.setId(URN_USER_EXTENDED);
		schema.setName("UserExtended");
		schema.setDescription("Schema representation of a user");

		schema.addAttribute(new Attribute("id", "string", false, "Unique identifier for the user.", false, null, false,
				null, "immutable", "default", "global"));
		schema.addAttribute(new Attribute("externalId", "string", false, "Unique identifier for the user.", false, null,
				false, null, "immutable", "default", "global"));
		schema.addAttribute(new Attribute("userName", "string", false, "", true, null, false, null, "readWrite",
				"default", "none"));

		List<Attribute> sub1 = new ArrayList<Attribute>();
		sub1.add(new Attribute("formatted", "string", false, "", true, null, false, null, "readWrite", "default",
				"none"));
		sub1.add(new Attribute("familyName", "string", false, "", true, null, false, null, "readWrite", "default",
				"none"));
		sub1.add(new Attribute("givenName", "string", false, "", true, null, false, null, "readWrite", "default",
				"none"));
		sub1.add(new Attribute("middleName", "string", false, "", true, null, false, null, "readWrite", "default",
				"none"));
		sub1.add(new Attribute("honorificPrefix", "string", false, "", true, null, false, null, "readWrite", "default",
				"none"));
		sub1.add(new Attribute("honorificSuffix", "string", false, "", true, null, false, null, "readWrite", "default",
				"none"));
		schema.addAttribute(
				new Attribute("name", "complex", false, "", true, sub1, false, null, "readWrite", "default", "none"));

		List<Attribute> sub2 = new ArrayList<Attribute>();
		sub2.add(
				new Attribute("value", "string", false, "", true, null, false, null, "readWrite", "default", "global"));
		sub2.add(new Attribute("type", "string", false, "", true, null, false, null, "readWrite", "default", "none"));
		sub2.add(new Attribute("primary", "boolean", false, "", true, null, false, null, "readWrite", "default",
				"none"));
		schema.addAttribute(
				new Attribute("emails", "complex", true, "", true, sub2, false, null, "readWrite", "default", "none"));

		List<Attribute> sub3 = new ArrayList<Attribute>();
		sub3.add(new Attribute("value", "string", false, "", true, null, false, null, "immutable", "default", "none"));
		sub3.add(
				new Attribute("$ref", "reference", false, "", true, null, false, null, "immutable", "default", "none"));
		sub3.add(
				new Attribute("display", "string", false, "", true, null, false, null, "immutable", "default", "none"));
		sub3.add(new Attribute("type", "string", false, "", true, null, false, null, "immutable", "default", "none"));
		schema.addAttribute(new Attribute("groups", "complex", true, "A list of groups to which the student belongs",
				true, sub3, false, null, "readWrite", "default", "none"));

		List<Attribute> sub4 = new ArrayList<Attribute>();
		sub4.add(new Attribute("schoolUnitId", "string", false, "", true, null, false, null, "readWrite", "default",
				"none"));
		sub4.add(new Attribute("schoolType", "string", false, "", true, null, false, null, "readWrite", "default",
				"none"));

		List<Attribute> sub5 = new ArrayList<Attribute>();
		sub5.add(
				new Attribute("school", "complex", false, "", true, sub4, false, null, "immutable", "default", "none"));

		schema.addAttribute(new Attribute(URN_USER_EXTENDED, "complex", true, "", true, sub5, false, null, "immutable",
				"default", "none"));

		List<Attribute> sub6 = new ArrayList<Attribute>();
		sub6.add(new Attribute("pnr", "string", false, "", true, null, false, null, "readWrite", "default", "global"));
		List<Attribute> sub7 = new ArrayList<Attribute>();
		sub7.add(new Attribute("number", "string", false, "", true, null, false, null, "readWrite", "default",
				"global"));
		sub7.add(new Attribute("type", "string", false, "", true, null, false, null, "readWrite", "default", "global"));
		sub6.add(
				new Attribute("phones", "complex", false, "", true, sub7, false, null, "readWrite", "default", "none"));
		sub6.add(new Attribute("protected", "boolean", false, "", true, null, false, null, "readWrite", "default",
				"none"));
		schema.addAttribute(new Attribute(URN_USER_EXTENDED, "complex", true, "", true, sub6, false, null, "immutable",
				"default", "none"));

		return schema;
	}

	public static ResourceType getResourceType() {
		ResourceType type = new ResourceType("User", "/Users", "User", URN_USER, null);
		type.addSchemaExtension(new SchemaExtension(URN_USER_EXTENDED, false));
		type.setMeta(new Meta("ResourceType", null, null, BASE_URI + "/ResourceTypes/User", null));
		return type;
	}

	public boolean hasEnrolments() {
		return getUser() != null && getUser().getEnrolments() != null && !getUser().getEnrolments().isEmpty();
	}

	public boolean hasEmployments() {
		return getUser() != null && getEmployments() != null && !getEmployments().isEmpty();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		UserExtended other = (UserExtended) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public void addEmployment(Reference employment) {
		if (this.employments == null)
			this.employments = new ArrayList<Reference>();
		this.employments.add(employment);
	}

	public List<Reference> getEmployments() {
		return employments;
	}

	public void setEmployments(List<Reference> employments) {
		this.employments = employments;
	}
}
