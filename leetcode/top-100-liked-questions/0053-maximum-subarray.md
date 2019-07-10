# 53. Maximum Subarray

2017-08

## Level
Easy


---


## [Description](https://leetcode.com/problems/maximum-subarray/description/)
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

click to show more practice.


---


## Thought
连续子串最大和


---


## Solution

```
class Solution {
    public int maxSubArray(int[] nums) {
        
        int maxSum = nums[0];
        int currSum = 0;
        
        for (int num : nums){
            if (currSum < 0) currSum = 0;
            currSum += num;
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
        
    }
}
```


---


**Note**: The subject is from leetcode.

