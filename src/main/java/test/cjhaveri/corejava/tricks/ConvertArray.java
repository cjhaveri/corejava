package test.cjhaveri.corejava.tricks;

import java.util.Arrays;
import java.util.jar.Pack200;

/**
 * Created by chetanjhaveri on 10/8/16.
 *
 * http://www.ardendertat.com/2011/10/18/programming-interview-questions-9-convert-array/
 *
 * Given an array:

 [a_1, a_2, ..., a_N, b_1, b_2, ..., b_N, c_1, c_2, ..., c_N ]

 convert it to:

 [a_1, b_1, c_1, a_2, b_2, c_2, ..., a_N, b_N, c_N]

 in-place using constant extra space.
 */
public class ConvertArray {

    public void convert(int [] input, int numberInEachSeries) {

        //go through the array only once
        //keep swapping
        System.out.println(Arrays.toString(input));

        int [] newInput = new int[input.length];
        int numberInSeries = 0;
        int numberOperation = 0;
//        int totalNumberOfSeries = input.length / numberInEachSeries;

        for (int k=0; k < numberInEachSeries; k++) {
            for (int i=k; i < input.length ; i= i + numberInEachSeries) {
                System.out.println(i + ":" + numberInSeries);
                newInput[numberInSeries] = input[i];
                numberInSeries ++;
                numberOperation++;
            }
        }

        System.out.println(Arrays.toString(newInput));
        System.out.println("Number of operations: " + numberOperation);

    }

    public static void main(String[] args) {
        ConvertArray a = new ConvertArray();
        a.convert(new int [] {1,2,3,11,12,13,21,22,23,31,32,33}, 3);
        //  {1,2,3,11,12,13}
        //  {1,11,2,12,3,13}
        //(0,3,1,4,2,5)
    }
}
