# 494. Target Sum

2017-08


## Level

Medium


---


## [Target Sum](https://leetcode.com/problems/target-sum/description/)

You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.


---


## Thought

递归求解，加上当前数或者减去当前数

![这里写图片描述](https://imgconvert.csdnimg.cn/aHR0cDovL2ltZy5ibG9nLmNzZG4ubmV0LzIwMTcxMDE5MTk1MjUzNjY2)

[更为详细的讲解](https://leetcode.com/problems/target-sum/solution/)


---


## Solution

```
class Solution {
    int counter = 0;
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, S, 0, 0);
        return counter;
    }
    
    private void calculate(int[] nums, int target, int i, int sum){
        if (i == nums.length){ 
            if (sum == target) counter ++;
        } else { // 有条件的递归
            calculate(nums, target, i+1, sum+nums[i]);  // 加上当前数字
            calculate(nums, target, i+1, sum-nums[i]);  // 减去当前数字
        }
    }
}
```
