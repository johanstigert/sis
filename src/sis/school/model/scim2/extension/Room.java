package sis.school.model.scim2.extension;

<<<<<<< HEAD
import static sis.school.model.scim2.extension.element.Constant.BASE_URI;
import static sis.school.model.scim2.extension.element.Constant.URN_ROOM;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.Meta;
import sis.school.model.scim2.core.Resource;
import sis.school.model.scim2.core.element.Reference;
import sis.school.model.scim2.core.schema.ResourceType;

@JsonPropertyOrder({ "schemas", "id", "name", "seats", "schoolGroup", "meta" })
public class Room extends Resource {

	private String name;
	private int seats;
	private Reference schoolGroup;

	public Room() {
	}

	public Room(String id) {
		super(id);
	}

	public Room(String name, int seats) {
		super();
		this.name = name;
		this.seats = seats;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Reference getSchoolGroup() {
		return schoolGroup;
	}

	public void setSchoolGroup(Reference schoolGroup) {
		this.schoolGroup = schoolGroup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + seats;
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
		Room other = (Room) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (seats != other.seats)
			return false;
		return true;
	}

	public static ResourceType getResourceType() {
		ResourceType type = new ResourceType("Room", "/Rooms", "Room", URN_ROOM, null);
		type.setMeta(new Meta("ResourceType", null, null, BASE_URI + "/ResourceTypes/Room", null));
		return type;
=======
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sis.school.model.scim2.core.Resource;

@JsonPropertyOrder({ "schemas", "id", "name", "seats", "meta" })
public class Room extends Resource {

	private String name;
	private int seats;

	public Room() {
	}

	public Room(String id) {
		super(id);
	}

	public Room(String name, int seats) {
		super();
		this.name = name;
		this.seats = seats;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + seats;
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
		Room other = (Room) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (seats != other.seats)
			return false;
		return true;
>>>>>>> branch 'master' of https://github.com/johanstigert/sis.git
	}
}
