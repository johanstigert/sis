package sis.school.model.scim2.extension.element;

public class Code {

	public enum ActivityType {
		Undervisning, Elevaktivitet, // Frånvaro, närvaro
		Läraraktivitet, // Arbetstid
		Övrigt; // Läxhjälp, lunch, bokning
	}
}
