package skola.model.scim2.group;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static skola.model.scim2.extension.element.Constant.URN_GROUP_COURSE;
import static skola.model.scim2.extension.element.Constant.URN_GROUP_SCHOOL;
import static skola.model.scim2.extension.element.Constant.URN_GROUP_SCHOOLUNIT;
import static skola.model.scim2.extension.element.Constant.URN_GROUP_CLASS;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({ @Type(value = Course.class, name = URN_GROUP_COURSE),
		@Type(value = School.class, name = URN_GROUP_SCHOOL),
		@Type(value = SchoolUnit.class, name = URN_GROUP_SCHOOLUNIT),
		@Type(value = Class.class, name = URN_GROUP_CLASS) })
public interface IGroupType {

}
