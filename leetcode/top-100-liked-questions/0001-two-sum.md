# 【Leetcode】001 Two Sum

2017-08

## 题目
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].


## 思路

使用Map

## 实现
```
import java.util.*;
public class Solution {
    // public int[] twoSum(int[] nums, int target) {
    //     int[] result = new int[2];
    //     List<Integer> remainders = new ArrayList(nums.length);
    //     for(int i = 0; i < nums.length; i ++){
    //         int remainder = target - nums[i];
    //         for (int j = 0; j < remainders.size(); j ++){
    //             if (remainders.get(j) == nums[i]){
    //                 result[0] = j;
    //                 result[1] = i;
    //             }
    //         }
    //         remainders.add(remainder);
    //     }
    //     return result;
    // }
    
    /**
     * You may assume that each input would have exactly one solution
     *
     * use Map
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++){
            int remainder = target - nums[i];
            if(map.containsKey(nums[i]))
                return new int[]{map.get(nums[i]), i};
            map.put(remainder, i);
        }
        throw new IllegalArgumentException("no solution.");
    }
}
```
