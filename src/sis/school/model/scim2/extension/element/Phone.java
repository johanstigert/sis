package sis.school.model.scim2.extension.element;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 
 * ©TimeEdit 2016
 *
 */
public class Phone {

	private String number;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String type;

	public Phone(String number, String type) {
		super();
		this.number = number;
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
