package test.cjhaveri.corejava.concurrency.tricks;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by chetanjhaveri on 9/24/16.
 */
public class AddTwoNumbersTest {


    @DataProvider
    public Object[][] testData() {

        //arrays to be used
        int[] oneTwoThree = {1, 2, 3};
        int[] twoFourSix = {2, 4, 6};
        int[] oneTwoThreeFour = {1, 2, 3, 4};
        int[] twoFourSixFour = {2, 4, 6, 4};


        return new Object[][]{
                //equal size list
                {createListNode(oneTwoThree), createListNode(oneTwoThree), createListNode(twoFourSix)},
                //mismatched size list
                {createListNode(oneTwoThreeFour), createListNode(oneTwoThree), createListNode(twoFourSixFour)},
                {createListNode(oneTwoThree), createListNode(oneTwoThreeFour), createListNode(twoFourSixFour)},
                //one of the null
                {null, createListNode(oneTwoThree), createListNode(oneTwoThree)},
                {createListNode(oneTwoThree), null, createListNode(oneTwoThree)},
                //all nulls
                {null, null, null}
        };
    }

    //helper method to take in some string input and create a list node out of it
    private ListNode createListNode(int... numbers) {

        if (numbers == null || numbers.length == 0) {
            return null;
        }
        ListNode current = new ListNode(numbers[0]);

        current.next = createListNode(Arrays.copyOfRange(numbers, 1, numbers.length));
        return current;
    }

    //helper method to test that the given ListNode object are equal
    private boolean checkIfListAreEquals(ListNode gotThis, ListNode expected) {

        if (gotThis == null && expected == null) {
            return true;
        }

        if (gotThis == null && expected != null) {
            return false;
        }

        if (gotThis != null && expected == null) {
            return false;
        }

        if (gotThis.val != expected.val) {
            return false;
        }

        return checkIfListAreEquals(gotThis.next, expected.next);
    }


    @Test(dataProvider = "testData")
    public void testAddTwoNumbers(ListNode l1, ListNode l2, ListNode expected) {

        AddTwoNumbers driver = new AddTwoNumbers();
        ListNode result = driver.addTwoNumbers(l1, l2);

        if (expected == null) {
            Assert.assertNull(result);
        } else {


            System.out.println(result.toString());
            System.out.println(expected.toString());


            Assert.assertTrue(checkIfListAreEquals(result, expected));
        }


    }
}
