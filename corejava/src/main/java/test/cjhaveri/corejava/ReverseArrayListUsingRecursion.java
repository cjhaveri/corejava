package test.cjhaveri.corejava;

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
		
		//safety check for null on the reversed list
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

}
