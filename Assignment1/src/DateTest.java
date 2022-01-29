
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

public class DateTest {

	Date date = new Date();
	private int testDay = 25, testMonth = 1, testYear = 2022;
	private String test_month = "January";

	@Test
	public void testSetDate1() {
		Date date = new Date(testMonth, testDay, testYear);
		Assert.assertEquals(testMonth, date.getMonth());
		Assert.assertTrue(testDay == date.getDay());
		Assert.assertTrue(testYear == date.getYear());
	}

	@Test
	public void testSetDate2() {
		Date date = new Date(test_month, testDay, testYear);
		Assert.assertEquals(testMonth, date.getMonth());
		Assert.assertTrue(testDay == date.getDay());
		Assert.assertTrue(testYear == date.getYear());
	}

	@Test
	public void testGetMonth() {
		Assert.assertEquals(testMonth, date.getMonth());
	}

	@Test
	public void testMonthString() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method method = date.getClass().getDeclaredMethod("monthString", int.class);
		method.setAccessible(true);
		String result = (String) method.invoke(date, testMonth);

		Assert.assertEquals(test_month, result);
	}

	@Test
	public void testMonthOK() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method method = date.getClass().getDeclaredMethod("monthOK", String.class);
		method.setAccessible(true);
		boolean result = (boolean) method.invoke(date, test_month);

		Assert.assertEquals(true, result);
	}

}
