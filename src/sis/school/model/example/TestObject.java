package sis.school.model.example;

import static sis.school.model.scim2.extension.element.Constant.BASE_URI;
import static sis.school.model.scim2.extension.element.Constant.URN_ACTIVITY;
import static sis.school.model.scim2.extension.element.Constant.URN_CALENDAREVENT;
import static sis.school.model.scim2.extension.element.Constant.URN_DATUMINTERVALL;
import static sis.school.model.scim2.extension.element.Constant.URN_EMPLOYEE;
import static sis.school.model.scim2.extension.element.Constant.URN_GROUP_CORE;
import static sis.school.model.scim2.extension.element.Constant.URN_PERSON;
import static sis.school.model.scim2.extension.element.Constant.URN_STUDENT;
import static sis.school.model.scim2.extension.element.Constant.URN_USER;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import sis.school.model.scim2.core.Group;
import sis.school.model.scim2.core.Group.GroupType;
import sis.school.model.scim2.core.Meta;
import sis.school.model.scim2.core.Resource.ResourceTypeStr;
import sis.school.model.scim2.core.element.Email;
import sis.school.model.scim2.core.element.Name;
import sis.school.model.scim2.extension.Activity;
import sis.school.model.scim2.extension.CalendarEvent;
import sis.school.model.scim2.extension.Person;
import sis.school.model.scim2.extension.element.Assignment;
import sis.school.model.scim2.extension.element.Code.ActivityType;
import sis.school.model.scim2.extension.element.ContactPerson;
import sis.school.model.scim2.extension.element.DateRange;
import sis.school.model.scim2.extension.element.DateTimeRange;
import sis.school.model.scim2.extension.element.Enum.NativeLanguage;
import sis.school.model.scim2.extension.element.Enum.SchoolForm;
import sis.school.model.scim2.extension.element.Enum.SchoolType;
import sis.school.model.scim2.extension.element.Equipment;
import sis.school.model.scim2.extension.element.Exception;
import sis.school.model.scim2.extension.element.GroupNode;
import sis.school.model.scim2.extension.element.GroupReference;
import sis.school.model.scim2.extension.element.Member;
import sis.school.model.scim2.extension.element.MetaExtended;
import sis.school.model.scim2.extension.element.Phone;
import sis.school.model.scim2.extension.element.Room;
import sis.school.model.scim2.extension.element.SchoolNode;
import sis.school.model.scim2.extension.element.StudentNode;
import sis.school.model.scim2.extension.element.TeacherAssignment;
import sis.school.model.scim2.group.Course;
import sis.school.model.scim2.group.IGroupType;
import sis.school.model.scim2.user.Employee;
import sis.school.model.scim2.user.Student;
import sis.school.model.scim2.user.element.Employment;

/**
 * 
 * ©TimeEdit 2016
 *
 */
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
		student.setMeta(new Meta(ResourceTypeStr.STUDENT.toString(), "2010-01-23T04:56:22Z", "2011-05-13T04:42:34Z",
				BASE_URI + "/Users/2819c223-7f76-453a-919d-413861904646", student.hashCode() + ""));
		return student;
	}

	public static Employee getTestEmployee1() {
		Employee employee = new Employee("e9e30dba-f08f-4109-8486-d5c6a331660a");
		String[] schemas = { URN_USER, URN_PERSON, URN_EMPLOYEE };
		employee.setSchemas(schemas);
		employee.setName(new Name("Ms. Barbara J Jensen, III", "Jensen", "Barbara", "Jane", null, null));
		employee.addMail(new Email("barbar@home.se", "work", true));
		GroupReference schoolUnit = new GroupReference("{asd56-dfgdrt-asd7e-wea234}",
				BASE_URI + "/Groups/e9e30dba-f08f-4109-8486-d5c6a331660a", "SkolnamnX", "SchoolUnit");
		employee.addEmployment(new Employment(100, new DateRange("2016-01-01", null), true, schoolUnit, "barb"));
		List<Phone> phones = new ArrayList<Phone>();
		phones.add(new Phone("0754-853345", "sms"));
		phones.add(new Phone("031547895", ""));
		employee.setPerson(new Person("200710042710", true, phones));
		employee.setMeta(new Meta(ResourceTypeStr.EMPLOYEE.toString(), "2010-01-23T04:56:22Z", "2011-05-13T04:42:34Z",
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
				BASE_URI + "/Group/2819c223-7f76-453a-919d-413861904646", "Askolan", GroupType.SCHOOLUNIT.toString()));
		IGroupType course = new Course(SchoolForm.GY.toString(), "MATMAT01", null);
		groupNode.setGroupType(course);
		group.setGroup(groupNode);
		group.setMeta(new MetaExtended(ResourceTypeStr.GROUP.toString(), "2010-01-23T04:56:22Z", "2011-05-13T04:42:34Z",
				BASE_URI + "/Group/e9e30dba-f08f-4109-8486-d5c6a331660a", group.hashCode() + "", "TimeEdit"));
		return group;
	}

	public static Activity getTestActivity1() {
		Activity activity = new Activity("e9e30dba-f08f-4109-8486-d5c6a331660a");
		String[] schemas = { URN_ACTIVITY };
		activity.setSchemas(schemas);
		activity.setDisplayName("MATMAT01 N3A");
		activity.setSchoolUnit("32c231ff-7f76-453a-919d-413861904646");
		activity.setCourse("MATMAT01");
		activity.setActivityType(ActivityType.Övrigt);
		activity.setDateInterval(new DateRange("2016-02-25", "2016-04-15"));
		activity.addGroupAssignment(new Assignment("e9e30dba-f08f-4109-8486-d5c6a331660a",
				BASE_URI + "/Groups/e9e30dba-f08f-4109-8486-d5c6a331660a", "MATMAT01 N3A", null));
		activity.addStudentAssignment(new Assignment("2819c223-7f76-453a-919d-413861904646",
				BASE_URI + "/Users/2819c223-7f76-453a-919d-413861904646", "Barbara Jensen", null));
		activity.addStudentAssignment(new Assignment("902c246b-6245-4190-8e05-00816be7344a",
				BASE_URI + "/Users/902c246b-6245-4190-8e05-00816be7344a", "Mandy Pepperidge", null));
		activity.addTeacherAssignment(new TeacherAssignment("87dda8fa-7f76-453a-919d-413861904646",
				"https://example.com/v2/Users/87dda8fa-7f76-453a-919d-413861904646", "Palle Girgensohn",
				new DateRange("2016-02-25", "2016-04-15"), 600));
		activity.setParentactivity("9823a472-7f76-453a-919d-413861904646");
		activity.setMeta(new Meta(ResourceTypeStr.ACTIVITY.toString(), "2010-01-23T04:56:22Z", "2011-05-13T04:42:34Z",
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
		calendarEvent.addRoom(new Room(null, "Sal 13", 22));
		calendarEvent.addRoom(new Room("{123asd-asdewq1-23243-asd2e}", "Pionen", 10));
		calendarEvent.addResource(new Equipment("{123asd-asdewq1-23243-asd2}", "Projector13", "Med hdmi+vga"));
		calendarEvent.addStudentExceptions(new Exception("2819c223-7f76-453a-919d-413861904646",
				new DateTimeRange("2016-05-24T14:00", "2016-05-24T15:00"), 0, "foobar"));
		calendarEvent.addTeacherExceptions(new Exception("2819c223-7f76-453a-919d-413861904646",
				new DateTimeRange("2016-05-24T14:00", "2016-05-24T15:00"), 30, "foobar"));
		calendarEvent.addGroupExceptions(new Exception("2819c223-7f76-453a-919d-413861904646",
				new DateTimeRange("2016-05-24T14:00", "2016-05-24T15:00"), 30, "foobar"));
		calendarEvent.setMeta(new MetaExtended(ResourceTypeStr.CALENDAREVENT.toString(), "2010-01-23T04:56:22Z",
				"2011-05-13T04:42:34Z", BASE_URI + "/CalendarEvents/e9e30dba-f08f-4109-8486-d5c6a331660a",
				calendarEvent.hashCode() + "", "TimeEdit"));
		return calendarEvent;
	}
}
