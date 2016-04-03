package test.cjhaveri.corejava;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StatesTest {

	@DataProvider
	public Object[][] testData() {
		return new Object[][] {
				// size = 4 (even)
				{ 2, Arrays.asList(new String[] { "CA", "TX", "NH", "IN" }),
						Arrays.asList(new String[] { "CA", "NH" }), },
				// size = 3 (odd)
				{ 1, Arrays.asList(new String[] { "CA", "TX", "NH" }),
						Arrays.asList(new String[] { "CA", "TX", "NH" }) },
				// // size = 1
				{ 5, Arrays.asList(new String[] { "CA" }), Arrays.asList(new String[] { "CA" }) },
				// null
				{ 1, null, Arrays.asList(new String[] {}) },
				// empty
				{ 1, Arrays.asList(new String[] {}), Arrays.asList(new String[] {}) }

		};
	}

	@Test(dataProvider = "testData")
	public void testSkipIterator(int skipDigit, List<String> input, List<String> expectedOutput) {
		States state = new States(input, skipDigit);

		Iterator<String> it = state.iterator();
		Iterator<String> itExpected = expectedOutput.iterator();

		while (it.hasNext()) {
			String gotNext = it.next();
			String nextExpected = itExpected.next();
			Assert.assertEquals(gotNext, nextExpected);
		}

		// confirm you have been through all the expected
		Assert.assertFalse(itExpected.hasNext());

	}
}
