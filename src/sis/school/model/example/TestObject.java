package sis.school.model.example;

import static sis.school.model.scim2.extension.element.Constant.BASE_URI;
import static sis.school.model.scim2.extension.element.Constant.URN_ACTIVITY;
import static sis.school.model.scim2.extension.element.Constant.URN_CALENDAREVENT;
import static sis.school.model.scim2.extension.element.Constant.URN_COURSE;
import static sis.school.model.scim2.extension.element.Constant.URN_DATERANGE;
import static sis.school.model.scim2.extension.element.Constant.URN_EMPLOYMENT;
import static sis.school.model.scim2.extension.element.Constant.URN_GROUP_CORE;
import static sis.school.model.scim2.extension.element.Constant.URN_RESOURCE;
import static sis.school.model.scim2.extension.element.Constant.URN_ROOM;
import static sis.school.model.scim2.extension.element.Constant.URN_SUBJECT;
import static sis.school.model.scim2.extension.element.Constant.URN_USER;
import static sis.school.model.scim2.extension.element.Constant.URN_USER_EXTENDED;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import sis.school.model.scim2.core.Meta;
import sis.school.model.scim2.core.Resource.ResourceTypeStr;
import sis.school.model.scim2.core.element.Email;
import sis.school.model.scim2.core.element.Name;
import sis.school.model.scim2.core.element.Reference;
import sis.school.model.scim2.extension.Activity;
import sis.school.model.scim2.extension.CalendarEvent;
import sis.school.model.scim2.extension.CalendarResource;
import sis.school.model.scim2.extension.Course;
import sis.school.model.scim2.extension.Employment;
import sis.school.model.scim2.extension.GroupExtended;
import sis.school.model.scim2.extension.Room;
import sis.school.model.scim2.extension.Subject;
import sis.school.model.scim2.extension.UserExtended;
import sis.school.model.scim2.extension.code.Code.ActivityType;
import sis.school.model.scim2.extension.code.Code.Gender;
import sis.school.model.scim2.extension.code.Code.SchoolType;
import sis.school.model.scim2.extension.code.Code.StudentGroupType;
import sis.school.model.scim2.extension.element.Assignment;
import sis.school.model.scim2.extension.element.ContactPerson;
import sis.school.model.scim2.extension.element.DateRange;
import sis.school.model.scim2.extension.element.DateTimeRange;
import sis.school.model.scim2.extension.element.Exception;
import sis.school.model.scim2.extension.element.GroupMember;
import sis.school.model.scim2.extension.element.TeacherAssignment;
import sis.school.model.scim2.extension.element.TeacherException;
import sis.school.model.scim2.extension.extension.Enrolment;
import sis.school.model.scim2.extension.extension.UserNode;
import sis.school.model.scim2.extension.extension.group.GroupNode;
import sis.school.model.scim2.extension.extension.group.StudentGroup;

/**
 * 
 * ©TimeEdit 2016
 *
 */
public class TestObject {

	public static void main(String[] args) {
		try {
			System.out.println(toPlainJson(getTestStudent1()));
			System.out.println(toPlainJson(getTestGroup1()));
			System.out.println(toPlainJson(getTestActivity1()));
			System.out.println(toPlainJson(getTestCalendarEvent1()));
			System.out.println(toPlainJson(getTestEmployment()));
			System.out.println(toPlainJson(getTestSubject()));
			System.out.println(toPlainJson(getTestCourse()));
			System.out.println(toPlainJson(getTestRoom()));
			System.out.println(toPlainJson(getTestResource()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
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

	public static UserExtended getTestStudent1() throws ParseException {
		UserExtended student = new UserExtended("2819c223-7f76-453a-919d-413861904646");
		String[] schemas = { URN_USER, URN_USER_EXTENDED };
		student.setSchemas(schemas);
		student.setUserName("barb@skola.se");
		student.setName(new Name("Ms. Barbara J Jensen, III", "Jensen", "Barbara", "Jane", null, null));
		student.addMail(new Email("barbar@skola.se", "work", true));
		student.addMail(new Email("barbar@home.se", "home", false));
		student.addGroup(new Reference("e9e30dba-f08f-4109-8486-d5c6a331660a",
				BASE_URI + "/Groups/e9e30dba-f08f-4109-8486-d5c6a331660a", "Klass 5A"));
		List<ContactPerson> contactPersons = new ArrayList<ContactPerson>();
		contactPersons.add(new ContactPerson("26118915-6090-4610-87e4-49d8ca9f808d",
				BASE_URI + "/Users/26118915-6090-4610-87e4-49d8ca9f808d", "John Smith", "Guardian"));
		contactPersons.add(new ContactPerson("26118915-6090-4610-87e4-4f1234234223",
				BASE_URI + "/Users/26118915-6090-4610-87e4-4f1234234223", "Gullan Olsson", "Guardian"));
		List<Enrolment> enrolments = new ArrayList<Enrolment>();
		enrolments.add(new Enrolment("14122127283", SchoolType.gymnasieskola, "NA", 11, "2014-08-20", "2015-06-14"));
		enrolments.add(new Enrolment("14122127283", SchoolType.gymnasieskola, "NA", 12, "2015-08-20", "2016-06-14"));
		student.setUser(new UserNode("200710042710", true, Gender.MALE, contactPersons, enrolments));
		student.setMeta(new Meta(ResourceTypeStr.USER.toString(), "2010-01-23T04:56:22Z", "2011-05-13T04:42:34Z",
				BASE_URI + "/Users/2819c223-7f76-453a-919d-413861904646", student.hashCode() + ""));
		return student;
	}

	// public static UserExtended getTestEmployee1() throws ParseException {
	// Employee employee = new Employee("e9e30dba-f08f-4109-8486-d5c6a331660a");
	// String[] schemas = { URN_USER, URN_USER_EXTENDED, URN_EMPLOYEE };
	// employee.setSchemas(schemas);
	// employee.setName(new Name("Ms. Barbara J Jensen, III", "Jensen",
	// "Barbara", "Jane", null, null));
	// employee.addMail(new Email("barbar@home.se", "work", true));
	// GroupReference schoolUnit = new
	// GroupReference("{asd56-dfgdrt-asd7e-wea234}",
	// BASE_URI + "/Groups/e9e30dba-f08f-4109-8486-d5c6a331660a", "SkolnamnX",
	// "SchoolUnit");
	// employee.addEmployment(new Employment(100, new DateRange("2016-01-01",
	// null), true, schoolUnit, "barb"));
	// List<Phone> phones = new ArrayList<Phone>();
	// phones.add(new Phone("0754-853345", "sms"));
	// phones.add(new Phone("031547895", ""));
	// employee.setPerson(new UserNode("200710042710", true, phones));
	// employee.setMeta(new Meta(ResourceTypeStr.EMPLOYEE.toString(),
	// "2010-01-23T04:56:22Z", "2011-05-13T04:42:34Z",
	// BASE_URI + "/Employee/2819c223-7f76-453a-919d-413861904646",
	// employee.hashCode() + ""));
	// return employee;
	// }

	public static GroupExtended getTestGroup1() throws ParseException {
		GroupExtended group = new GroupExtended("e9e30dba-f08f-4109-8486-d5c6a331660a");
		String[] schemas = { URN_GROUP_CORE, URN_DATERANGE };
		group.setSchemas(schemas);
		group.setDisplayName("7A");

		GroupMember member1 = new GroupMember();
		member1.setValue("2819c223-7f76-453a-919d-413861904646");
		member1.setRef(BASE_URI + "/Users/2819c223-7f76-453a-919d-413861904646");
		member1.setDisplay("Barbara Jensen");
		member1.setBeginDate("2015-01-01");
		member1.setEndDate("2016-05-01");
		group.getGroupMembers().addEmployee(member1);

		GroupMember member2 = new GroupMember();
		member2.setValue("902c246b-6245-4190-8e05-00816be7344a");
		member2.setRef(BASE_URI + "/Users/902c246b-6245-4190-8e05-00816be7344a");
		member2.setDisplay("Mandy Pepperidge");
		member2.setBeginDate("2015-01-01");
		member2.setEndDate("2015-12-31");
		group.getGroupMembers().addEmployee(member2);

		GroupNode groupNode = new GroupNode();
		groupNode.setDateRange(new DateRange("2015-01-01", "2015-12-31"));
		groupNode.setParentGroup(new Reference("2819c223-7f76-453a-919d-413861904646",
				BASE_URI + "/Groups/2819c223-7f76-453a-919d-413861904646", "Rudbäcksskolan"));
		group.setGroup(groupNode);
		group.setStudentGroup(new StudentGroup(StudentGroupType.Klass, 7, null, null));
		group.setMeta(new Meta(ResourceTypeStr.GROUP.toString(), "2010-01-23T04:56:22Z", "2011-05-13T04:42:34Z",
				BASE_URI + "/Group/e9e30dba-f08f-4109-8486-d5c6a331660a", group.hashCode() + ""));
		return group;
	}

	public static Activity getTestActivity1() throws ParseException {
		Activity activity = new Activity("e9e30dba-f08f-4109-8486-d5c6a331660a");
		String[] schemas = { URN_ACTIVITY };
		activity.setSchemas(schemas);
		activity.setActivityType(ActivityType.Undervisning);
		activity.setCalendarEventRequired(true);
		activity.setMinutesPlanned(4000);
		activity.setDateRange(new DateRange("2016-02-25", "2016-04-15"));
		activity.addStudentGroupAssignment(new Assignment("e9e30dba-f08f-4109-8486-d5c6a331660a",
				BASE_URI + "/Groups/e9e30dba-f08f-4109-8486-d5c6a331660a", "MATMAT01 N3A",
				new DateRange("2016-02-25", "2016-04-15")));
		activity.addStudentAssignment(new Assignment("2819c223-7f76-453a-919d-413861904646",
				BASE_URI + "/Users/2819c223-7f76-453a-919d-413861904646", "Barbara Jensen",
				new DateRange("2016-02-25", "2016-04-15")));
		activity.addStudentAssignment(new Assignment("902c246b-6245-4190-8e05-00816be7344a",
				BASE_URI + "/Users/902c246b-6245-4190-8e05-00816be7344a", "Mandy Pepperidge",
				new DateRange("2016-02-25", "2016-04-15")));
		activity.addTeacherAssignment(new TeacherAssignment("87dda8fa-7f76-453a-919d-413861904646",
				"https://example.com/v2/Users/87dda8fa-7f76-453a-919d-413861904646", "Palle Girgensohn",
				new DateRange("2016-02-25", "2016-04-15"), 3600));
		activity.setCourse(new Reference("87dda8fa-7f76-453a-919d-413861904646",
				"https://example.com/v2/Courses/87dda8fa-7f76-453a-919d-413861904646", "Matematik A"));
		activity.setParentActivity(new Reference("87dda8fa-7f76-453a-919d-413861904646",
				"https://example.com/v2/Courses/87dda8fa-7f76-453a-919d-413861904646", "Matematik"));
		activity.setMeta(new Meta(ResourceTypeStr.ACTIVITY.toString(), "2010-01-23T04:56:22Z", "2011-05-13T04:42:34Z",
				BASE_URI + "/Activities/e9e30dba-f08f-4109-8486-d5c6a331660a", activity.hashCode() + ""));
		return activity;
	}

	public static CalendarEvent getTestCalendarEvent1() {
		CalendarEvent calendarEvent = new CalendarEvent("e9e30dba-f08f-4109-8486-d5c6a331660a");
		String[] schemas = { URN_CALENDAREVENT };
		calendarEvent.setSchemas(schemas);
		calendarEvent.setCancelled(false);
		calendarEvent.setComment("kommentar...");
		calendarEvent.setDateTimeRange(new DateTimeRange("2016-05-24T14:00", "2016-05-24T15:00"));
		calendarEvent.setTeachingLengthTeacher(45);
		calendarEvent.setTeachingLengthStudent(60);
		calendarEvent.addRoom(new Reference("87dda8fa-7f76-453a-919d-413861904646",
				"https://example.com/v2/Rooms/87dda8fa-7f76-453a-919d-413861904646", "Safiren"));
		calendarEvent.addRoom(new Reference("87dda8fa-7f76-453a-919d-413861904646",
				"https://example.com/v2/Rooms/87dda8fa-7f76-453a-919d-413861904646", "Pionen"));
		calendarEvent.addResource(new Reference("87dda8fa-7f76-453a-919d-413861904646",
				"https://example.com/v2/Resources/87dda8fa-7f76-453a-919d-413861904646", "projektor13"));
		calendarEvent.addResource(new Reference("87dda8fa-7f76-453a-919d-413861904646",
				"https://example.com/v2/Resources/87dda8fa-7f76-453a-919d-413861904646", "ipad2"));
		Exception e1 = new Exception(true, 30, new DateTimeRange("2016-05-24T14:45", "2016-05-24T15:00"));
		e1.setValue("87dda8fa-7f76-453a-919d-413861904646");
		e1.setRef("https://example.com/v2/Users/87dda8fa-7f76-453a-919d-413861904646");
		e1.setDisplay("Bosse Larsson");
		calendarEvent.addStudentExceptions(e1);
		calendarEvent.addGroupExceptions(e1);
		TeacherException e2 = new TeacherException(true, 30, new DateTimeRange("2016-05-24T14:45", "2016-05-24T15:00"));
		e2.setValue("87dda8fa-7f76-453a-919d-413861904646");
		e2.setRef("https://example.com/v2/Users/87dda8fa-7f76-453a-919d-413861904646");
		e2.setDisplay("Bosse Larsson");
		calendarEvent.addTeacherExceptions(e2);
		calendarEvent.setActivity(new Reference("87dda8fa-7f76-453a-919d-413861904646",
				"https://example.com/v2/Courses/87dda8fa-7f76-453a-919d-413861904646", "Matematik A"));
		calendarEvent.setMeta(new Meta(ResourceTypeStr.CALENDAREVENT.toString(), "2010-01-23T04:56:22Z",
				"2011-05-13T04:42:34Z", BASE_URI + "/CalendarEvents/e9e30dba-f08f-4109-8486-d5c6a331660a",
				calendarEvent.hashCode() + ""));
		return calendarEvent;
	}

	public static Employment getTestEmployment() throws ParseException {
		Employment employment = new Employment("e9e30dba-f08f-4109-8486-d5c6a331660a");
		String[] schemas = { URN_EMPLOYMENT };
		employment.setSchemas(schemas);
		employment.setEmploymentTime(new DateRange("1970-01-23", "2013-06-30"));
		employment.setEmploymentPercent(100);
		employment.setHoursPerYear(1340);
		employment.setTeacher(true);
		employment.setSignature("PAK");
		employment.setEmployedAt(new Reference("e9ddadba-f08f-4109-8486-d5c6a331660a",
				"https://example.com/v2/Groups/e9e30dba-f08f-4109-8486-d5c6a331660a", "SkolenhetA"));
		employment
				.setMeta(new Meta(ResourceTypeStr.EMPLOYMENT.toString(), "2010-01-23T04:56:22Z", "2011-05-13T04:42:34Z",
						BASE_URI + "/Employments/e9e30dba-f08f-4109-8486-d5c6a331660a", employment.hashCode() + ""));
		return employment;
	}

	public static Subject getTestSubject() throws ParseException {
		Subject subject = new Subject("e9e30dba-f08f-4109-8486-d5c6a331660a");
		String[] schemas = { URN_SUBJECT };
		subject.setSchemas(schemas);
		subject.setSubjectCode("MA");
		subject.setName("Matematik");
		subject.setSubjectShortName("Matte");
		subject.setOfficial(true);
		subject.setMeta(new Meta(ResourceTypeStr.SUBJECT.toString(), "2010-01-23T04:56:22Z", "2011-05-13T04:42:34Z",
				BASE_URI + "/Subjects/e9e30dba-f08f-4109-8486-d5c6a331660a", subject.hashCode() + ""));
		return subject;
	}

	public static Course getTestCourse() throws ParseException {
		Course course = new Course("e9e30dba-f08f-4109-8486-d5c6a331660a");
		String[] schemas = { URN_COURSE };
		course.setSchemas(schemas);
		course.setCourseCode("MA");
		course.setName("Matematik");
		course.setSubjectShortName("Matte");
		course.setOfficial(true);
		course.setPoints(100);
		course.setMeta(new Meta(ResourceTypeStr.COURSE.toString(), "2010-01-23T04:56:22Z", "2011-05-13T04:42:34Z",
				BASE_URI + "/Subjects/e9e30dba-f08f-4109-8486-d5c6a331660a", course.hashCode() + ""));
		return course;
	}

	public static Room getTestRoom() throws ParseException {
		Room room = new Room("e9e30dba-f08f-4109-8486-d5c6a331660a");
		String[] schemas = { URN_ROOM };
		room.setSchemas(schemas);
		room.setName("Aulan");
		room.setSeats(52);
		room.setSchoolGroup(new Reference("87dda8fa-7f76-453a-919d-413861904646",
				"https://example.com/v2/Groups/87dda8fa-7f76-453a-919d-413861904646", "Skolnamn"));
		room.setMeta(new Meta(ResourceTypeStr.ROOM.toString(), "2010-01-23T04:56:22Z", "2011-05-13T04:42:34Z",
				BASE_URI + "/Rooms/e9e30dba-f08f-4109-8486-d5c6a331660a", room.hashCode() + ""));
		return room;
	}

	public static CalendarResource getTestResource() throws ParseException {
		CalendarResource resource = new CalendarResource("e9e30dba-f08f-4109-8486-d5c6a331660a");
		String[] schemas = { URN_RESOURCE };
		resource.setSchemas(schemas);
		resource.setName("Aulan");
		resource.setDescription("projektor 13, Kenwood 2000");
		resource.setSchoolGroup(new Reference("87dda8fa-7f76-453a-919d-413861904646",
				"https://example.com/v2/Groups/87dda8fa-7f76-453a-919d-413861904646", "Skolnamn"));
		resource.setMeta(new Meta(ResourceTypeStr.RESOURCE.toString(), "2010-01-23T04:56:22Z", "2011-05-13T04:42:34Z",
				BASE_URI + "/Resources/e9e30dba-f08f-4109-8486-d5c6a331660a", resource.hashCode() + ""));
		return resource;
	}
}
