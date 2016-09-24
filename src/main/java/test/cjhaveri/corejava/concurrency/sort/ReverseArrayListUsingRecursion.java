package test.cjhaveri.corejava.concurrency.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Purpose of this class is to reverse an array list using recursion for example
 * input is: a,b,c then output should be c,b,a
 * 
 * @author chetanjhaveri
 *
 */
public class ReverseArrayListUsingRecursion {

	/**
	 * Method that uses recursion and two arguments to reverse a list
	 * 
	 * @param toReverse
	 *            the original list
	 * @param reversedList
	 *            the reversed list
	 */
	public void reverse(List<Object> toReverse, List<Object> reversedList) {

		// safety check for null on the reversed list
		if (reversedList == null) {
			throw new IllegalArgumentException("Target list should be populated");
		}

		// if there's nothing to reverse then return
		if (toReverse == null || toReverse.isEmpty()) {
			return;
		}

		// add the last item to the reversed list
		reversedList.add(toReverse.get(toReverse.size() - 1));
		// recursively call to reverse the rest of the list
		reverse(toReverse.subList(0, toReverse.size() - 1), reversedList);
	}

	/**
	 * Method that uses recursion and single arguments and return type to
	 * reverse a list
	 * 
	 * @param toReverse
	 *            the original list
	 * @return reversed sub list or null if nothing is to be reversed
	 */
	public List<Object> reverse(List<Object> toReverse) {
		// if there's nothing to reverse then return
		if (toReverse == null || toReverse.isEmpty()) {
			return null;
		}

		// grab the last item
		Object lastItem = toReverse.get(toReverse.size() - 1);

		// sub list
		List<Object> everythingButLastItem = toReverse.subList(0, toReverse.size() - 1);

		List<Object> reversedList = new ArrayList<>(Arrays.asList(new Object[] { lastItem }));
		List<Object> recursiveList = reverse(everythingButLastItem);
		if (recursiveList != null) {
			reversedList.addAll(recursiveList);
		}
		return reversedList;

	}

}
