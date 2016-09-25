package test.cjhaveri.corejava.concurrency.tricks;

import java.util.HashMap;

/**
 * Created by chetanjhaveri on 9/24/16.
 * <p>
 * https://leetcode.com/problems/two-sum/
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {


    public int[] twoSum(int[] nums, int target) {

        if (nums == null) {
            return null;
        }

        //create a map to store the numbers
        HashMap<Integer, Integer> allInput = new HashMap<Integer, Integer>(nums.length);

        //read all the numbers into a map
        for (int i = 0; nums != null && i < nums.length; i++) {
            if (allInput.get(nums[i]) != null) {
                allInput.put(nums[i], allInput.get(nums[i]) + 1);
            } else {
                allInput.put(nums[i], 1);
            }
        }

        //go through each number, and remote from target
        for (int i = 0; nums != null && i < nums.length; i++) {
            int currentNumber = nums[i];
            int remainder = target - currentNumber;


            //see if the remainder number is available
            if (allInput.get(remainder) != null) {
                if (currentNumber == remainder) {
                    //assert that there are at least two
                    if (allInput.get(remainder) < 2) {
                        return null;
                    }

                }

                return new int[]{currentNumber, remainder};
            }

        }


        return null;

    }


}
