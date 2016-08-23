package skola.model.scim2.extension.element;

import static skola.model.scim2.extension.element.Constant.URN_DATUMINTERVALL;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ URN_DATUMINTERVALL, "schoolUnitId", "schoolType", "schoolYear", "programCode" })
public class SchoolNode {

	private String schoolUnitId;
	private String schoolType;
	private String schoolYear;
	private String programCode;

	public SchoolNode() {
	}

	@JsonProperty(URN_DATUMINTERVALL)
	private DateRange dateInterval;

	public String getSchoolUnitId() {
		return schoolUnitId;
	}

	public void setSchoolUnitId(String schoolUnitId) {
		this.schoolUnitId = schoolUnitId;
	}

	public String getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	public DateRange getDateInterval() {
		return dateInterval;
	}

	public void setDateInterval(DateRange dateInterval) {
		this.dateInterval = dateInterval;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateInterval == null) ? 0 : dateInterval.hashCode());
		result = prime * result + ((programCode == null) ? 0 : programCode.hashCode());
		result = prime * result + ((schoolType == null) ? 0 : schoolType.hashCode());
		result = prime * result + ((schoolUnitId == null) ? 0 : schoolUnitId.hashCode());
		result = prime * result + ((schoolYear == null) ? 0 : schoolYear.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchoolNode other = (SchoolNode) obj;
		if (dateInterval == null) {
			if (other.dateInterval != null)
				return false;
		} else if (!dateInterval.equals(other.dateInterval))
			return false;
		if (programCode == null) {
			if (other.programCode != null)
				return false;
		} else if (!programCode.equals(other.programCode))
			return false;
		if (schoolType != other.schoolType)
			return false;
		if (schoolUnitId == null) {
			if (other.schoolUnitId != null)
				return false;
		} else if (!schoolUnitId.equals(other.schoolUnitId))
			return false;
		if (schoolYear == null) {
			if (other.schoolYear != null)
				return false;
		} else if (!schoolYear.equals(other.schoolYear))
			return false;
		return true;
	}
}