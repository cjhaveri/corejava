package test.cjhaveri.corejava.sort;

import java.util.Arrays;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class QuickSortTest extends SortTestBase {
	
	@Test (invocationCount = 100)
	public void testQuickSort() {
		Integer[] numbers = createRandomNumberArrays();
		//the test
		QuickSort qs = new QuickSort();
		Integer[] sortedNumbers = qs.quickSort(numbers);
		Arrays.sort(numbers);
		Assert.assertEquals(Arrays.toString(sortedNumbers), Arrays.toString(numbers));
		System.out.println("sorted numbers:" + Arrays.toString(sortedNumbers));
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
