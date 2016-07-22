package skola.model.scim2.extension.element;

public class Constant {

	public static final String SCIM_CONTENT_TYPE = "application/json+scim; charset=UTF-8";

	public static final String BASE_URI = "http://localhost:8080/skolapi/v1";

	public static final String URN_USER = "urn:ietf:params:scim:schemas:core:2.0:User";
	public static final String URN_PERSON = "urn:scim:schemas:extension:skola:person:1.0";
	public static final String URN_STUDENT = "urn:scim:schemas:extension:skola:student:1.0";
	public static final String URN_ANSTALLD = "urn:scim:schemas:extension:skola:anstalld:1.0";

	public static final String URN_GROUP_CORE = "urn:ietf:params:scim:schemas:core:2.0:Group";
	public static final String URN_GROUP_EXTENSION = "urn:scim:schemas:extension:skola:group:1.0";
	public static final String URN_GROUP_SCHOOL = "urn:scim:schemas:extension:skola:grouptype:school:1.0";
	public static final String URN_GROUP_SCHOOLUNIT = "urn:scim:schemas:extension:skola:grouptype:schoolunit:1.0";
	public static final String URN_GROUP_COURSE = "urn:scim:schemas:extension:skola:grouptype:coursegroup:1.0";
	public static final String URN_GROUP_CLASS = "urn:scim:schemas:extension:skola:grouptype:class:1.0";

	public static final String URN_ACTIVITY = "urn:scim:schemas:extension:skola:activity:1.0";
	public static final String URN_CALENDAREVENT = "urn:scim:schemas:extension:skola:calendarevent:1.0";

	public static final String URN_DATUMINTERVALL = "urn:scim:schemas:extension:skola:datumintervall:1.0";
	public static final String URN_ERROR = "urn:ietf:params:scim:api:messages:2.0:Error";

	public static final String DATE_TIME_SEC_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String TIMEZONE = "CET";

}
