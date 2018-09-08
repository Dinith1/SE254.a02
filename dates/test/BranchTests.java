package dates.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import dates.Dates;

/**
 * @author Dinith Wannigama
 *
 * This test class tests the branches of Dates.dayOfWeek(). 100% branch coverage is not possible for this method as
 * the for-loop on line 92 must run at least once (You cannot branch off and bypass it). This is because the for-loop
 * iterates through the predefined 2D array doomsdayByMonth in the Dates class.
 */
public class BranchTests {
	
	/**
	 * This method tests a valid date that falls on a non leap year. The year used allows the execution of line 54 and
	 * 55, where isLeapYear remains false. 
	 */
	@Test
	public void testNonLeapYearValid() {
		assertEquals(Dates.Day.Tuesday, Dates.dayOfWeek(2005, 3, 15));
	}
	
	
	/**
	 * This method tests a valid date that falls on a leap year that is divisible by 400, meaning isLeapYear becomes 
	 * true in line 49.
	 */
	@Test  
	public void testLeapYearFebValid() {
		assertEquals(Dates.Day.Monday, Dates.dayOfWeek(2000, 2, 14));
	}
	
	
	/**
	 * This method will equate the predicate (year < 1753) on line 59 to true, allowing the code to reach line 60. This
	 * means valid is set to false, and an IllegalArgumentException will be thrown.
	 */
	@Test
	public void testInvalidYear() {
		try {
			Dates.dayOfWeek(1700, 1, 1);
			fail("Invalid year");
		} catch(IllegalArgumentException e) {
			// Do nothing
		}
	}
	
	
	/**
	 * This method will equate the predicate (month <= 0 || day <= 0) on line 61 to true, as month <= 0. The second 
	 * clause in the predicate (day <= 0) is not reached in this test class, but is reached in the DataflowTest class. 
	 * Line 62 is then reached, and valid is set to false. An IllegalArgumentException will be thrown. The year used
	 * (2100) allows isLeapYear to be set to false in line 51.
	 */
	@Test
	public void testInvalidMonthLow() {
		try {
			Dates.dayOfWeek(2100, 0, 1);
			fail("Month not greater than 1");
		} catch(IllegalArgumentException e) {
			// Do nothing
		}
	}
	
	
	/**
	 * This method will equate the predicate (month > 12) on line 63 to true, thereby allowing the code to reach 
	 * line 64, where valid is set to false, and an IllegalArgumentException will be thrown.
	 */
	@Test
	public void testInvalidMonthHigh() {
		try {
			Dates.dayOfWeek(2100, 13, 15);
			fail("Month greater than 12");
		} catch(Exception e) {
			// Do nothing
		}
	 }
	
	
	/**
	 * This method tests a leap year invalid day of month in February. The predicate (isLeapYear && month == 2) on
	 * line 65 equates to true, allowing the code to reach line 66. The predicate (day > (months[month-1]+1)) on this
	 * line also equates to true, meaning that valid is set to false on line 67. An IllegalArgumentException can then
	 * be thrown. The leap year used in this method is divisible by 4, but not 400, meaning it equates the predicate
	 * on line 52 (year % 4 == 0) to true, so isLeapYear becomes true in line 53.
	 */
	@Test
	public void testInvalidDayOfMonthLeapYearFeb() {
		try {
			Dates.dayOfWeek(2004, 2, 30);
			fail("Invalid day");
		} catch(IllegalArgumentException e) {
			// Do nothing
		}
	}
	
	
	/**
	 * This method tests a non leap year invalid day of month. The else statement on line 69 is executed, thereby 
	 * allowing the code to reach line 70, where the predicate (day > (months[month-1])) will equate to true. Line 71 
	 * is reached and valid is set to false, and an IllegalArguemntException will be thrown.
	 */
	@Test
	public void testInvalidDayOfMonthNonLeapYear() {
		try {
			Dates.dayOfWeek(2100, 1, 35);
			fail("Day of month invalid");
		} catch(Exception e) {
			// Do nothing
		}
	}
	
}