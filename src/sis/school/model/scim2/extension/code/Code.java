package sis.school.model.scim2.extension.code;

public class Code {

	public enum ActivityType {
		Undervisning, Elevaktivitet, // Frånvaro, närvaro
		Läraraktivitet, // Arbetstid
		Övrigt; // Läxhjälp, lunch, bokning
	}

	public class Gender {
		public static final String MALE = "Male";
		public static final String FEMALE = "Female";
		// Male, Female;
	}

	public enum StudentGroupType {
		Undervisning, Klass, Mentor, Övrigt;
	}

	public enum SchoolType {
		grundskola("Grundskola"), gymnasieskola("Gymnasieskola"), vuxenutbildning("Vuxenutbildning"), förskola("Förskola"), högre_utbildning("Högre utbildning"), fritids("Fritids");

		private final String schoolType;

		private SchoolType(String schoolType) {
			this.schoolType = schoolType;
		}

		public static SchoolType create(String schoolType) {
			switch (schoolType) {
			case "Grundskola":
				return SchoolType.grundskola;
			case "Gymnasieskola":
				return SchoolType.gymnasieskola;
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
