package skola.model.example;

import skola.model.scim2.extension.Activity;
import skola.model.scim2.extension.CalendarEvent;
import skola.model.scim2.extension.Person;
import skola.model.scim2.extension.element.ContactPerson;
import skola.model.scim2.extension.element.DateRange;
import skola.model.scim2.extension.element.DateRangeSpan;
import skola.model.scim2.extension.element.DateTimeRange;
import skola.model.scim2.extension.element.GroupNode;
import skola.model.scim2.extension.element.GroupReference;
import skola.model.scim2.extension.element.Member;
import skola.model.scim2.extension.element.MetaExtended;
import skola.model.scim2.extension.element.Phone;
import skola.model.scim2.extension.element.Reference;
import skola.model.scim2.extension.element.SchoolNode;
import skola.model.scim2.extension.element.StudentNode;
import skola.model.scim2.extension.element.TeacherAssignment;
import skola.model.scim2.extension.element.Enum.NativeLanguage;
import skola.model.scim2.extension.element.Enum.SchoolForm;
import skola.model.scim2.extension.element.Enum.SchoolType;
import skola.model.scim2.extension.element.Exception;
import skola.model.scim2.group.Course;
import skola.model.scim2.group.IGroupType;
import skola.model.scim2.user.Employee;
import skola.model.scim2.user.Student;
import skola.model.scim2.core.Group;
import skola.model.scim2.core.Group.GroupType;
import skola.model.scim2.core.Resource.ResourceType;
import skola.model.scim2.core.Meta;
import skola.model.scim2.core.element.Email;
import skola.model.scim2.core.element.Name;
import static skola.model.scim2.extension.element.Constant.*;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TestObject {

	public static void main(String[] args) {
		System.out.println(toPlainJson(getTestStudent1()));
		System.out.println(toPlainJson(getTestEmployee1()));
		System.out.println(toPlainJson(getTestGroup1()));
		System.out.println(toPlainJson(getTestActivity1()));
		System.out.println(toPlainJson(getTestCalendarEvent1()));
	}

	public static String toPlainJson(Object jsonable) {
		if (jsonable == null) {
			return "";
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			return mapper.writeValueAsString(jsonable);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static Student getTestStudent1() {
		Student student = new Student("2819c223-7f76-453a-919d-413861904646");
		String[] schemas = { URN_USER, URN_PERSON, URN_STUDENT };
		student.setSchemas(schemas);
		student.setUserName("barb@skola.se");
		student.setName(new Name("Ms. Barbara J Jensen, III", "Jensen", "Barbara", "Jane", null, null));
		student.addMail(new Email("barbar@skola.se", "work", true));
		student.addMail(new Email("barbar@home.se", "home", false));
		student.addGroup(new GroupReference("e9e30dba-f08f-4109-8486-d5c6a331660a",
				BASE_URI + "/Groups/e9e30dba-f08f-4109-8486-d5c6a331660a", "Klass 5A", GroupType.CLASS.toString()));
		List<Phone> phones = new ArrayList<Phone>();
		phones.add(new Phone("0754-853345", "sms"));
		phones.add(new Phone("031547895", ""));
		student.setPerson(new Person("200710042710", true, phones));
		StudentNode s = new StudentNode();
		SchoolNode school = new SchoolNode();
		school.setSchoolType(SchoolType.GRUNDSKOLA.toString());
		DateRange date = new DateRange("2017-08-01", "2018-07-31");
		school.setDateInterval(date);
		school.setSchoolYear("2017");
		school.setSchoolUnitId("123");
		school.setProgramCode("ABC123");
		s.addSchool(school);
		s.setNativeLanguage(NativeLanguage.SV.toString());
		s.addContactPersons(new ContactPerson("26118915-6090-4610-87e4-49d8ca9f808d",
				BASE_URI + "/Users/26118915-6090-4610-87e4-49d8ca9f808d", "John Smith", "Guardian"));
		student.setStudent(s);
		student.setMeta(new Meta(ResourceType.STUDENT.toString(), "2010-01-23T04:56:22Z", "2011-05-13T04:42:34Z",
				BASE_URI + "/Users/2819c223-7f76-453a-919d-413861904646", student.hashCode() + ""));
		return student;
	}

	public static Employee getTestEmployee1() {
		Employee employee = new Employee("e9e30dba-f08f-4109-8486-d5c6a331660a");
		String[] schemas = { URN_USER, URN_PERSON, URN_ANSTALLD };
		employee.setSchemas(schemas);
		employee.setName(new Name("Ms. Barbara J Jensen, III", "Jensen", "Barbara", "Jane", null, null));
		employee.addMail(new Email("barbar@home.se", "work", true));
		employee.addDateSpan(new DateRangeSpan("1970-01-23", "2013-06-30", 1200));
		employee.addDateSpan(new DateRangeSpan("2014-01-23", null, 600));
		employee.setParentGroup(new GroupReference("e9e30dba-f08f-4109-8486-d5c6a331660a",
				BASE_URI + "/Groups/e9e30dba-f08f-4109-8486-d5c6a331660a", "Jönköpings kommun",
				GroupType.SCHOOLUNIT.toString()));
		employee.setSignature("PAK");
		List<Phone> phones = new ArrayList<Phone>();
		phones.add(new Phone("0754-853345", "sms"));
		phones.add(new Phone("031547895", ""));
		employee.setPerson(new Person("200710042710", true, phones));
		employee.setMeta(new Meta(ResourceType.EMPLOYEE.toString(), "2010-01-23T04:56:22Z", "2011-05-13T04:42:34Z",
				BASE_URI + "/Employee/2819c223-7f76-453a-919d-413861904646", employee.hashCode() + ""));
		return employee;
	}

	public static Group getTestGroup1() {
		Group group = new Group("e9e30dba-f08f-4109-8486-d5c6a331660a");
		String[] schemas = { URN_GROUP_CORE, URN_DATUMINTERVALL };
		group.setSchemas(schemas);
		group.setDisplayName("Tour Guides");
		Member member = new Member();
		member.setValue("2819c223-7f76-453a-919d-413861904646");
		member.setRef(BASE_URI + "/Users/2819c223-7f76-453a-919d-413861904646");
		member.setDisplay("Barbara Jensen");
		member.addDateInterval(new DateRange("2015-01-01", "2015-10-30"));
		member.addDateInterval(new DateRange("2016-05-01", "2016-11-30"));
		member.setValue("902c246b-6245-4190-8e05-00816be7344a");
		member.setRef(BASE_URI + "/Users/902c246b-6245-4190-8e05-00816be7344a");
		member.setDisplay("Mandy Pepperidge");
		group.addMember(member);
		group.setDateInterval(new DateRange("2015-01-01", "2015-12-31"));
		GroupNode groupNode = new GroupNode();
		groupNode.setParentGroup(new GroupReference("2819c223-7f76-453a-919d-413861904646",
				BASE_URI + "/Group/2819c223-7f76-453a-919d-413861904646", "Rudbäcksskolan",
				GroupType.SCHOOLUNIT.toString()));
		IGroupType course = new Course(SchoolForm.GY.toString(), "MATMAT01", null);
		groupNode.setGroupType(course);
		group.setGroup(groupNode);
		group.setMeta(new MetaExtended(ResourceType.GROUP.toString(), "2010-01-23T04:56:22Z", "2011-05-13T04:42:34Z",
				BASE_URI + "/Group/e9e30dba-f08f-4109-8486-d5c6a331660a", group.hashCode() + "", "TimeEdit"));
		return group;
	}

	public static Activity getTestActivity1() {
		Activity activity = new Activity("e9e30dba-f08f-4109-8486-d5c6a331660a");
		String[] schemas = { URN_ACTIVITY };
		activity.setSchemas(schemas);
		activity.setDisplayName("MATMAT01 N3A");
		activity.setSchool("32c231ff-7f76-453a-919d-413861904646");
		activity.setCourse("MATMAT01");
		activity.setType("course");
		activity.setDateInterval(new DateRange("2016-02-25", "2016-04-15"));
		activity.addGroup(new GroupReference("e9e30dba-f08f-4109-8486-d5c6a331660a",
				BASE_URI + "/Groups/e9e30dba-f08f-4109-8486-d5c6a331660a", "MATMAT01 N3A", GroupType.GROUP.toString()));
		activity.addStudent(new Reference("2819c223-7f76-453a-919d-413861904646",
				BASE_URI + "/Users/2819c223-7f76-453a-919d-413861904646", "Barbara Jensen"));
		activity.addStudent(new Reference("902c246b-6245-4190-8e05-00816be7344a",
				BASE_URI + "/Users/902c246b-6245-4190-8e05-00816be7344a", "Mandy Pepperidge"));
		activity.addTeacherAssignment(new TeacherAssignment("87dda8fa-7f76-453a-919d-413861904646",
				"https://example.com/v2/Users/87dda8fa-7f76-453a-919d-413861904646", "Palle Girgensohn",
				new DateRange("2016-02-25", "2016-04-15"), 3600));
		activity.setParentactivity("9823a472-7f76-453a-919d-413861904646");
		activity.setMeta(new Meta(ResourceType.ACTIVITY.toString(), "2010-01-23T04:56:22Z", "2011-05-13T04:42:34Z",
				BASE_URI + "/Activities/e9e30dba-f08f-4109-8486-d5c6a331660a", activity.hashCode() + ""));
		return activity;
	}

	public static CalendarEvent getTestCalendarEvent1() {
		CalendarEvent calendarEvent = new CalendarEvent("e9e30dba-f08f-4109-8486-d5c6a331660a");
		String[] schemas = { URN_CALENDAREVENT };
		calendarEvent.setSchemas(schemas);
		calendarEvent.setActivity("e9e30dba-f08f-4109-8486-d5c6a331660a");
		calendarEvent.setCancelled(false);
		calendarEvent.setComment("kommentar...");
		calendarEvent.setDateTimeRange(new DateTimeRange("2016-05-24T14:00", "2016-05-24T15:00"));
		calendarEvent.setTeachingLengthTeacher(45);
		calendarEvent.setTeachingLengthGroup(60);
		calendarEvent.addRoom("Sal 13");
		calendarEvent.addRoom("Pionen");
		calendarEvent.addResource("projektor13");
		calendarEvent.addStudentExceptions(new Exception("2819c223-7f76-453a-919d-413861904646",
				new DateTimeRange("2016-05-24T14:00", "2016-05-24T15:00"), 0, "foobar"));
		calendarEvent.addTeacherExceptions(new Exception("2819c223-7f76-453a-919d-413861904646",
				new DateTimeRange("2016-05-24T14:00", "2016-05-24T15:00"), 30, "foobar"));
		calendarEvent.addGroupExceptions(new Exception("2819c223-7f76-453a-919d-413861904646",
				new DateTimeRange("2016-05-24T14:00", "2016-05-24T15:00"), 30, "foobar"));
		calendarEvent.setMeta(new MetaExtended(ResourceType.CALENDAREVENT.toString(), "2010-01-23T04:56:22Z",
				"2011-05-13T04:42:34Z", BASE_URI + "/CalendarEvents/e9e30dba-f08f-4109-8486-d5c6a331660a",
				calendarEvent.hashCode() + "", "TimeEdit"));
		return calendarEvent;
	}
}
