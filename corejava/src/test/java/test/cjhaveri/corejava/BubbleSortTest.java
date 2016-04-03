package test.cjhaveri.corejava;

import java.util.Arrays;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class BubbleSortTest extends SortTestBase {
	
	@Test (invocationCount = 100)
	public void testQuickSort() {
		Integer[] numbers = createRandomNumberArrays();
		//the test
		BubbleSort bs = new BubbleSort();
		Integer[] sortedNumbers = bs.bubbleSort(numbers);
		bs.printNumberOfOperations();
		Arrays.sort(numbers);
		Assert.assertEquals(Arrays.toString(sortedNumbers), Arrays.toString(numbers));
	}

	@Test
	public void testQuickSortWithNullNumbers() {
		Integer[] numbers = null;
		//the test
		BubbleSort bs = new BubbleSort();
		Integer[] sortedNumbers = bs.bubbleSort(numbers);
		Assert.assertEquals(Arrays.toString(sortedNumbers), Arrays.toString(numbers));
	}

}
