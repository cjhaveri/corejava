package test.cjhaveri.corejava.tricks;

/**
 * Created by chetanjhaveri on 9/25/16.
 * https://leetcode.com/problems/median-of-two-sorted-arrays
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int lengthNums1 = nums1.length;
        int lengthNums2 = nums2.length;

        double totalNums1Nums2 = lengthNums2 + lengthNums1;

        int [] medianIndex = null;

        if (totalNums1Nums2 % 2 == 0) {
            //even total count, find two indexes
            medianIndex = new int[2];
            medianIndex[0] = (int) (totalNums1Nums2/2.0);
            medianIndex[1] = medianIndex[0] + 1;
        }  else {
            //odd number, find the center point
            medianIndex = new int[1];
            medianIndex [0] = (int) Math.ceil(totalNums1Nums2 / 2.0);
        }

        int [] mergedArray = mergeTwoSortedArrays(nums1, nums2);

        //median is halfway point

        //maybe you need to merge only half of the entire total array to find

        return -1.0;
    }

    public int [] mergeTwoSortedArrays(int[] nums1, int[] nums2) {
        int [] mergedArray = new int[nums1.length + nums2.length];

        //merge the two arrays into one
        int i=0, j=0, k=0;

        while (i < nums1.length && j < nums2.length) {

            //index in nums1 has a greater value
            if (nums1[i] > nums2[j]) {
                mergedArray[k] = nums2[j];
                j++;
            }  else {
                mergedArray[k] = nums1[i];
                i++;
            }
            k++;
        }
        //handle the additional
        while (i < nums1.length) {
            mergedArray[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length)  {
            mergedArray[k] = nums2[j];
            j++;
            k++;
        }

        return mergedArray;
    }


    public void merge(int A[], int m, int B[], int n) {

        while(m > 0 && n > 0){
            if(A[m-1] > B[n-1]){
                A[m+n-1] = A[m-1];
                m--;
            }else{
                A[m+n-1] = B[n-1];
                n--;
            }
        }

        while(n > 0){
            A[m+n-1] = B[n-1];
            n--;
        }
    }
}
