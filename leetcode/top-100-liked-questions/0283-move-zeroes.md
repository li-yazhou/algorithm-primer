# 283. Move Zeroes

2017-08


## Level

Easy


---


## [Move Zeroes](https://leetcode.com/problems/move-zeroes/description/)

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.


---


## Thought


---


## Solution

```
class Solution {
    // public void moveZeroes(int[] nums) {
    //     int numOfZero = 0;
    //     for (int i = 0; i < nums.length; i ++){
    //         if (nums[i] != 0) continue;
    //         for (int j = i+1; j < nums.length; j ++){
    //             if (nums[j] != 0) {
    //                 nums[i] = nums[j];
    //                 nums[j] = 0;
    //                 break;
    //             }
    //         }
    //     }
    // }
    
    
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for (int num : nums){
            if (num != 0) nums[pos++] = num;
        }
        
        while (pos < nums.length){
            nums[pos++] = 0;
        }
    }
}
```