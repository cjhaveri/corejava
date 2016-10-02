package test.cjhaveri.corejava.sort;

import java.util.Arrays;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class InsertionSortTest extends SortTestBase {
	
	@Test (invocationCount = 100)
	public void testInsertionSort() {
		Integer[] numbers = createRandomNumberArrays();
		//the test
		InsertionSort is = new InsertionSort();
		Integer[] sortedNumbers = is.insertionSort(numbers);
		is.printNumberOfOperations();
		Arrays.sort(numbers);
		Assert.assertEquals(Arrays.toString(sortedNumbers), Arrays.toString(numbers));
	}

	@Test
	public void testQuickSortWithNullNumbers() {
		Integer[] numbers = null;
		//the test
		InsertionSort is = new InsertionSort();
		Integer[] sortedNumbers = is.insertionSort(numbers);
		is.printNumberOfOperations();
		Assert.assertEquals(Arrays.toString(sortedNumbers), Arrays.toString(numbers));
	}

}
