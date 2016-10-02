package test.cjhaveri.corejava.tricks;

import junit.framework.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by chetanjhaveri on 9/24/16.
 */
public class TwoSumTest {


    @DataProvider
    public Object[][] testData() {

        //arrays to be used
        int[] oneTwoThree = {1, 2, 3};
        int[] oneTwoThreeTarget5 = {2, 3};
        int[] twoFourSix = {2, 4, 6};
        int[] oneTwoThreeFour = {1, 2, 3, 4};
        int[] twoFourSixFour = {2, 4, 6, 4};
        int unitialized = 0;

        return new Object[][]{
                //equal size list
                {oneTwoThree, 5, oneTwoThreeTarget5},
                //two of the same numbers, expect them to be found
                {new int [] {2, 2}, 4, new int [] {2, 2}},
                //bad input - only passing in one 2, target is 4. expect no list to be found
                {new int [] {2}, 4, null},
                {null, unitialized, null},
                {new int [] {2, 4}, 8, null},
                {new int [] {1, 3}, 8, null}

        };


    }


    private boolean sameArrays(int[] a, int[] b) {

        return ArrayUtil.sameArrays(a, b);
    }

    @Test (dataProvider = "testData")
    public void testTwoSum(int[] numbers, int target, int[] expected) throws Exception {

        TwoSum driver = new TwoSum();
        int[] result = driver.twoSum(numbers, target);

        Assert.assertTrue(sameArrays(result, expected));


    }

}