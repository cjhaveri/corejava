package test.cjhaveri.corejava;

import java.util.Arrays;

import org.testng.annotations.Test;

import junit.framework.Assert;
import test.cjhaveri.corejava.sort.QuickSort;

public class QuickSortTest extends SortTestBase {
	
	@Test (invocationCount = 100)
	public void testQuickSort() {
		Integer[] numbers = createRandomNumberArrays();
		//the test
		QuickSort qs = new QuickSort();
		Integer[] sortedNumbers = qs.quickSort(numbers);
		Arrays.sort(numbers);
		Assert.assertEquals(Arrays.toString(sortedNumbers), Arrays.toString(numbers));
	}

	@Test
	public void testQuickSortWithNullNumbers() {
		Integer[] numbers = null;
		//the test
		QuickSort qs = new QuickSort();
		Integer[] sortedNumbers = qs.quickSort(numbers);
		Assert.assertEquals(Arrays.toString(sortedNumbers), Arrays.toString(numbers));
	}

}
