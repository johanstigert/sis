package skola.model.scim2.extension.element;

/**
 * 
 * ©TimeEdit 2016
 *
 */
public class Enum {

	public enum NativeLanguage {
		SV("sv"), EN("en");

		private final String language;

		private NativeLanguage(String language) {
			this.language = language;
		}

		public String toString() {
			return language;
		}
	};

	public enum SchoolType {
		GRUNDSKOLA("Grundskola"), GYMNASIESKOLA("Gymnasieskola"), VUXENUTBILDNING("Vuxenutbildning"), FÖRSKOLA(
				"Förskola"), HÖGRE_UTBILDNING("Högre utbildning"), FRITIDS("Fritids");

		private final String schoolType;

		private SchoolType(String schoolType) {
			this.schoolType = schoolType;
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