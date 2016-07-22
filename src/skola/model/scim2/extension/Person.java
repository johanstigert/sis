package skola.model.scim2.extension;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import skola.model.scim2.extension.element.Phone;

public class Person {

	private String pnr;

	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@JsonProperty("protected")
	private boolean protect;

	private List<Phone> phones;

	public Person() {
	}

	public Person(String yyyymmddXXXX, boolean protect, List<Phone> phones) {
		super();
		this.pnr = yyyymmddXXXX;
		this.protect = protect;
		this.phones = phones;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String yyyymmddXXXX) {
		this.pnr = yyyymmddXXXX;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public boolean isProtect() {
		return protect;
	}

	public void setProtect(boolean protect) {
		this.protect = protect;
	}
}
