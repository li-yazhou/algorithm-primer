package org.alpha.coding;

import java.util.Arrays;

/**
 * 给定1个正整数数组array和1个正整数n，从array中寻找和值大于等于n的最短子数组长度。
 *
 * 如果存在，则返回最短子数组长度；如果不存在返回0。
 *
 * 例如：array = 1, 3, 4, 3, 9, 1, n = 12,
 *
 * 那么子数组3, 9满足条件且长度最短为2。
 */
public class ShortestSubarray {


    public static int shortestLen(int[] nums, int threshold) {
        if (nums == null) {
            return 0;
        }
        
        int L = 0;
        int R = 0;
        int sum = nums[0];
        int minLen = nums.length;
        
        while (R <= nums.length) {
            
            if (sum >= threshold)  {
                minLen = Math.min(R-L+1, minLen);
            }
            
            R ++;
            if (R < nums.length && L <= R) {
                sum += nums[R];
                while (sum >= threshold) {
                    minLen = Math.min(R-L+1, minLen);
                    System.out.println("L, R = " + L + ", " + R);
                    sum -= nums[L];
                    L ++;
                }
            }
        }
        
        if (minLen == nums.length) {
            minLen = 0;
        }

        System.out.println("L, R = " + L + ", " + (L+minLen-1));
        return minLen;
    }


    public static void main(String[] args) {

        int[][] arrays = {
                {1, 3, 4, 3, 9, 1}
        };
        int[] thresholds = {14};

        for (int i = 0; i < arrays.length; i ++) {
            int[] nums = arrays[i];
            int threshold = thresholds[i];
            System.out.println("nums = " + Arrays.toString(nums) + ", threshold = " + threshold);
            int minLen = shortestLen(nums, threshold);
            System.out.println("minLen = " + minLen);
        }


    }


}