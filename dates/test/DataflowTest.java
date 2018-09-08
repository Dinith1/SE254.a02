package dates.test;

import static org.junit.Assert.fail;
import org.junit.Test;
import dates.Dates;

/**
 * @author Dinith Wannigama
 * 
 * This test class tests an invalid day (less than 1), which is a du-path for the dayOfWeek() method's input parameter 
 * day. day is defined when the method is called, and used when creating the string message for the IllegalArgumentException. 
 * day is def-clear on this path. The path between the entry and exit vertices makes use of day in a predicate, checking
 * whether or not it is valid (day <= 0) (line 61). This increases the test suite quality as it full covers the predicate
 * (month <= 0 || day <= 0) on line 61, which was not covered in dates.test.BranchTests.
 */ 
public class DataflowTest {
	
	@Test
	public void testInvalidDay() {
		try {
			Dates.dayOfWeek(2100, 1, 0);
			fail("Day not greater than 0");
		} catch(IllegalArgumentException e) {
			// Do nothing
		}
	}
	
}
