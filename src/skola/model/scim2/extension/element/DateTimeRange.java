package skola.model.scim2.extension.element;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import static skola.model.scim2.extension.element.Constant.DATE_TIME_FORMAT;
import static skola.model.scim2.extension.element.Constant.TIMEZONE;

public class DateTimeRange {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_FORMAT, timezone = TIMEZONE)
	private Date start;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_FORMAT, timezone = TIMEZONE)
	private Date end;

	public DateTimeRange() {
	}

	public DateTimeRange(Date start, Date end) {
		this.start = start;
		this.end = end;
	}

	/**
	 * @param start
	 *            yyyy-MM-ddThh:mm
	 * @param end
	 *            yyyy-MM-ddThh:mm
	 * @param yearWorkTime
	 */
	public DateTimeRange(String startYyyymmddhhmm, String endYyyymmddhhmm) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
		try {
			this.start = sdf.parse(startYyyymmddhhmm);
			this.end = sdf.parse(endYyyymmddhhmm);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
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
		DateTimeRange other = (DateTimeRange) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}
}