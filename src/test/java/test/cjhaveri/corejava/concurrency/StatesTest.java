package test.cjhaveri.corejava.concurrency;

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
				{ 2, Arrays.asList("CA", "TX", "NH", "IN"),
						Arrays.asList("CA", "NH"), },
				// size = 3 (odd)
				{ 1, Arrays.asList("CA", "TX", "NH"),
						Arrays.asList("CA", "TX", "NH") },
				// // size = 1
				{ 5, Arrays.asList("CA"), Arrays.asList("CA") },
				// null
				{ 1, null, Arrays.asList() },
				// empty
				{ 1, Arrays.asList(), Arrays.asList() }

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
