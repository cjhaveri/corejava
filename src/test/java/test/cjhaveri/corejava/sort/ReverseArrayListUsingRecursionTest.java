package test.cjhaveri.corejava.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.cjhaveri.corejava.concurrency.sort.ReverseArrayListUsingRecursion;

public class ReverseArrayListUsingRecursionTest {

	@DataProvider
	public Object[][] testData() {
		return new Object[][] {
				// size = 4 (even)
				{ Arrays.asList("CA", "TX", "NH", "IN"),
						Arrays.asList("IN", "NH", "TX", "CA") },
				// size = 3 (odd)
				{ Arrays.asList("CA", "TX", "NH"), Arrays.asList("NH", "TX", "CA") },
				// size = 1
				{ Arrays.asList("CA"), Arrays.asList("CA") },
				// null
				{ null, null },
				// empty
				{ Arrays.asList(), Arrays.asList() },
				// list of objects
				{ Arrays.asList(new ZipCode(94538, 7004), new ZipCode(94555, 7909)),
						Arrays.asList(new ZipCode(94555, 7909), new ZipCode(94538, 7004)) }

		};
	}

	@Test(dataProvider = "testData")
	public void testReverse(List<Object> input, List<Object> expectedOutput) {
		ReverseArrayListUsingRecursion object = new ReverseArrayListUsingRecursion();
		// create an empty list to pass through
		ArrayList<Object> output = new ArrayList<>();
		// method call
		object.reverse(input, output);
		if (input != null) {
			// verify the sizes
			Assert.assertEquals(output.size(), input.size(), "Sizes of input and output should match");
			// verify the contents
			Assert.assertEquals(output, expectedOutput);
		} else {
			// verify handling of null
			Assert.assertEquals(output.size(), 0, "Size expected to be zero");
		}
	}

	@Test(dataProvider = "testData")
	public void testReverse2(List<Object> input, List<Object> expectedOutput) {
		ReverseArrayListUsingRecursion object = new ReverseArrayListUsingRecursion();
		// create an empty list to pass through
		List<Object> output = null;
		// method call
		output = object.reverse(input);
		if (input != null && output != null) {
			// verify the sizes
			Assert.assertEquals(output.size(), input.size(), "Sizes of input and output should match");
			// verify the contents
			Assert.assertEquals(output, expectedOutput);
		} else if (input == null) {
			// verify when output is null
			Assert.assertNull(output, "Output expected to be zero");
		}
	}

	@Test
	public void testReverseExceptionHandling() {
		ReverseArrayListUsingRecursion object = new ReverseArrayListUsingRecursion();
		try {
			object.reverse(null, null);
			Assert.fail("Exception should have been thrown!");
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalArgumentException);

		}
	}

	/**
	 * Test class to verify that object handling is fine
	 * 
	 * @author chetanjhaveri
	 *
	 */
	class ZipCode {

		private int firstFive;
		private int lastFour;

		public ZipCode(int firstFive, int lastFour) {
			this.firstFive = firstFive;
			this.lastFour = lastFour;
		}

		public int getFirstFive() {
			return firstFive;
		}

		public void setFirstFive(int firstFive) {
			this.firstFive = firstFive;
		}

		public int getLastFour() {
			return lastFour;
		}

		public void setLastFour(int lastFour) {
			this.lastFour = lastFour;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + firstFive;
			result = prime * result + lastFour;
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
			ZipCode other = (ZipCode) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (firstFive != other.firstFive)
				return false;
			return lastFour == other.lastFour;
		}

		private ReverseArrayListUsingRecursionTest getOuterType() {
			return ReverseArrayListUsingRecursionTest.this;
		}

	}

}
