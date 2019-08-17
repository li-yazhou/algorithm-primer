# 198. House Robber

2017-08


## Level

Easy


---


## [House Robber](https://leetcode.com/problems/house-robber/description/)

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.


---


## Thought

两种状态，抢或不抢，使用列长为2的二维数组表示。


---


## Solution

```
class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length+1][2];
        // dp[i][1] means we rob the current house and dp[i][0] means we don't,
        
        for (int i = 1; i < dp.length; i ++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);  // 不抢
            dp[i][1] = dp[i-1][0] + nums[i-1];   // 抢
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}
```


**声明：题目来自Leetcode.**