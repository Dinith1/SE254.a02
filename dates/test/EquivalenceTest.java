package dates.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import dates.Dates;

/**
 * @author Dinith Wannigama
 *
 * This test class tests a valid date with a leap year, and a month that is after February. This is an equivalence class
 * for all dates in months after February in leap years divisible by 4 but not 400. This test also covers the predicate
 * (isLeapYear && month <= 2) on line 96, having isLeapYear being true and month <= 2 being false. This increases the 
 * test suite quality as it increases the clause coverage.    
 */
public class EquivalenceTest {
	
	// Valid, leap year, GREATER THAN February
	@Test
	public void test() {
		assertEquals(Dates.Day.Sunday, Dates.dayOfWeek(2004, 7, 25));
	}
	 
} 
