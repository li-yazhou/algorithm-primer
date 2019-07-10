# 70. Climbing Stairs

2017-08

## Level
Easy


---


## [Description](https://leetcode.com/problems/climbing-stairs/)

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

---


## Thought
斐波那契数列


---


## Solution

```
class Solution {
    
    // public int climbStairs(int n) {
    //     if (n <= 2) return n;
    //     return climbStairs(n-1) + climbStairs(n-2);
    // }
    
    
    // public int climbStairs(int n) {
    //     if (n <= 0) return 0;
    //     if (n == 1) return 1;
    //     if (n == 2) return 2;
    //     return climbStairs(n-1) + climbStairs(n-2);
    // }
    
    
    public int climbStairs(int n) {
        if (n <= 2) return n;
        
        int result = 0;
        
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i ++) {
            result = first + second;
            
            int temp = first;
            first = second;
            second = second + temp;
            
        }
        return result;
    }    
}
```


