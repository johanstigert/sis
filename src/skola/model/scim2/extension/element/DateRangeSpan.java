package skola.model.scim2.extension.element;

import java.util.Date;

/**
 * 
 * ©TimeEdit 2016
 *
 */
public class DateRangeSpan extends DateRange {

	private int yearWorkTime;

	public DateRangeSpan() {
	}

	public DateRangeSpan(Date start, Date end, int yearWorkTime) {
		super(start, end);
		this.yearWorkTime = yearWorkTime;
	}

	/**
	 * @param start
	 *            yyyy-mm-dd
	 * @param end
	 *            yyyy-mm-dd
	 * @param yearWorkTime
	 */
	public DateRangeSpan(String start, String end, int yearWorkTime) {
		super(start, end);
		this.yearWorkTime = yearWorkTime;
	}

	public int getYearWorkTime() {
		return yearWorkTime;
	}

	public void setYearWorkTime(int yearWorkTime) {
		this.yearWorkTime = yearWorkTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + yearWorkTime;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateRangeSpan other = (DateRangeSpan) obj;
		if (yearWorkTime != other.yearWorkTime)
			return false;
		return true;
	}
}
