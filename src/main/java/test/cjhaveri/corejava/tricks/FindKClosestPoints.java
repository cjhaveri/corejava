package test.cjhaveri.corejava.tricks;

import java.util.Arrays;

/**
 * Created by chetanjhaveri on 10/14/16.
 * <p>
 * Find k closest elements to a given value
 * Given a sorted array arr[] and a value X, find the k closest elements to X in arr[].
 * Examples:
 * <p>
 * Input: K = 4, X = 35
 * arr[] = {12, 16, 22, 30, 35, 39, 42,
 * 45, 48, 50, 53, 55, 56}
 * Output: 30 39 42 45
 */
public class FindKClosestPoints {


    public void findKClosestPoints(int k, int x, int[] input) {

        int crossOverPoint = 0;

        int[] closestNumbers = new int[k];

        //go and find the cross over points
        for (int i = 0; i < input.length && crossOverPoint == 0; i++) {
            if (input[i] == x) {
                crossOverPoint = i;
            }
        }

        int beforeXPointer = crossOverPoint - 1;
        int afterXPointer = crossOverPoint + 1;

        //start to search around it to find the k closest points

        for (int i = 0; i < k; i++) {
            int currentBeforeX = 0;
            int currentAfterX = 0;

            if (beforeXPointer <= 0) {
                //set to x so it's always 0 and never greater than input
                currentBeforeX = x;
            } else {
                currentBeforeX = input[beforeXPointer];
            }

            if (afterXPointer >= input.length) {
                currentAfterX = x;
            } else {
                currentAfterX = input[afterXPointer];
            }


            if ((currentAfterX - x) == 0 || ((currentAfterX - x) > (x - currentBeforeX))) {
                //push current before x and reset pointer
                closestNumbers[i] = currentBeforeX;
                beforeXPointer--;
            } else {
                closestNumbers[i] = currentAfterX;
                afterXPointer++;
            }


        }

        System.out.println(Arrays.toString(closestNumbers));


    }


    //method to find the crossover point

    //method to go around the crossover point and return you the k elements

    public static void main(String[] args) {
        int[] input = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int k = 4;
        int x = 35;

        int [] input1 = {12, 16, 22, 30, 35};
        FindKClosestPoints driver = new FindKClosestPoints();
//        driver.findKClosestPoints(k, x, input);

        driver.findKClosestPoints(k, x, input1);

    }
}
