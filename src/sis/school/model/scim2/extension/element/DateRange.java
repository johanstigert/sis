package sis.school.model.scim2.extension.element;

import static sis.school.model.scim2.extension.element.Constant.DATE_FORMAT;
import static sis.school.model.scim2.extension.element.Constant.TIMEZONE;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * ©TimeEdit 2016
 *
 */
@JsonPropertyOrder({ "beginDate", "endDate" })
public class DateRange {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT, timezone = TIMEZONE)
	private Date beginDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT, timezone = TIMEZONE)
	private Date endDate;

	public DateRange() {
	}

	public DateRange(Date start, Date end) {
		this.beginDate = start;
		this.endDate = end;
	}

	public DateRange(String startYyyymmdd, String endYyyymmdd) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		if (startYyyymmdd != null) {
			this.beginDate = sdf.parse(startYyyymmdd);
		}
		if (endYyyymmdd != null) {
			this.endDate = sdf.parse(endYyyymmdd);
		}
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date start) {
		this.beginDate = start;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date end) {
		this.endDate = end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((beginDate == null) ? 0 : beginDate.hashCode());
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
		DateRange other = (DateRange) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (beginDate == null) {
			if (other.beginDate != null)
				return false;
		} else if (!beginDate.equals(other.beginDate))
			return false;
		return true;
	}
}