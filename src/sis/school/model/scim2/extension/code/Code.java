package sis.school.model.scim2.extension.code;

public class Code {

	public enum ActivityType {
		Undervisning, Elevaktivitet, // Frånvaro, närvaro
		Läraraktivitet, // Arbetstid
		Övrigt; // Läxhjälp, lunch, bokning
	}

	public enum Gender {
		male, female;
	}

	public enum SchoolGroupType {
		Undervisning, Klass, Mentor, Övrigt;
	}

	public enum SchoolType {
		GRUNDSKOLA("Grundskola"), GYMNASIESKOLA("Gymnasieskola"), VUXENUTBILDNING("Vuxenutbildning"), FÖRSKOLA(
				"Förskola"), HÖGRE_UTBILDNING("Högre utbildning"), FRITIDS("Fritids");

		private final String schoolType;

		private SchoolType(String schoolType) {
			this.schoolType = schoolType;
		}

		public static SchoolType create(String schoolType) {
			switch (schoolType) {
			case "Grundskola":
				return SchoolType.GRUNDSKOLA;
			case "Gymnasieskola":
				return SchoolType.GYMNASIESKOLA;
			}
			return null;
		}

		public String toString() {
			return schoolType;
		}
	}

	public enum SchoolForm {
		GR("gr"), GY("gy");

		private final String form;

		private SchoolForm(String form) {
			this.form = form;
		}

		public String toString() {
			return form;
		}
	};
}
