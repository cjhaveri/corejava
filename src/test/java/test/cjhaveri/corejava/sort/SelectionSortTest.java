package test.cjhaveri.corejava.sort;

import java.util.Arrays;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class SelectionSortTest extends SortTestBase {

	@Test (invocationCount = 100)
	public void testQuickSort() {
		Integer[] numbers = createRandomNumberArrays();
		//the test
		SelectionSort ss = new SelectionSort();
		Integer[] sortedNumbers = ss.selectionSort(numbers);
		Arrays.sort(numbers);
		Assert.assertEquals(Arrays.toString(sortedNumbers), Arrays.toString(numbers));
	}

	@Test
	public void testQuickSortWithNullNumbers() {
		Integer[] numbers = null;
		//the test
		SelectionSort ss = new SelectionSort();
		Integer[] sortedNumbers = ss.selectionSort(numbers);
		Assert.assertEquals(Arrays.toString(sortedNumbers), Arrays.toString(numbers));
	}
	
}
