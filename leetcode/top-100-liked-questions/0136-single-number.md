# 136. Single Number

2017-08


## Level

Easy


---


## [Single Number](https://leetcode.com/problems/single-number/description/)

Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


---


## Thought

位运算——异或运算
只有一个1则结果为1，也即是“有1则1”。

则可以推出：

- 任何整数和0异或结果是它本身。
- 一个整数异或它本身结果等于0。

可以进一步推出：

- 一个整数异或另一个整数两次结果是它本身。


---


## Solution

```
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums)
            result ^= num;
        return result;
    }
}
```


---


**声明：题目来自Leetcode。**










